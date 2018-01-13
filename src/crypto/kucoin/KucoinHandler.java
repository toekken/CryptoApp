package crypto.kucoin;

import com.fasterxml.jackson.databind.ObjectMapper;
import crypto.Constants;
import crypto.ExchangeHandler;
import crypto.TickerHandler;
import crypto.bittrex.BittrexHandler;
import crypto.kucoin.ticker.KucoinTickerItem;
import crypto.kucoin.ticker.KucoinTickerResult;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

/**
 * Handler for the Kucoin exchange.
 */
public class KucoinHandler implements ExchangeHandler {

    public static final String TICKER = "https://api.kucoin.com/v1/open/tick?symbol=";

    @Override
    public TickerHandler getTicker(String market, String baseCurrency, boolean convertToUSD) {
        KucoinTickerItem result = null;
        HttpClient client = HttpClients.createDefault();
        HttpGet getMethod = new HttpGet(TICKER + market + Constants.DASH + baseCurrency);
        try {
            HttpResponse getResponse = client.execute(getMethod);
            ObjectMapper mapper = new ObjectMapper();
            KucoinTickerResult tickerResult = (KucoinTickerResult) mapper.readValue(getResponse.getEntity().getContent(), KucoinTickerResult.class);
            if (tickerResult.isSuccess()) {
                result = tickerResult.getTickerItem();
                if ((Constants.BTC.equals(baseCurrency)) || (Constants.ETH.equals(baseCurrency))) {
                    result.setLastDealPrice(result.getLastPrice() * (convertToUSD ? convertToUSD(baseCurrency) : 1.0D));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(BittrexHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            getMethod.releaseConnection();
        }
        return result;
    }

    private double convertToUSD(String baseCurrency)
            throws IOException {
        double result = 0.0D;
        String market = "BTC-USDT";
        if (Constants.ETH.equals(baseCurrency)) {
            market = "ETH-USDT";
        }
        HttpClient client = HttpClients.createDefault();
        HttpGet getMethod = new HttpGet(TICKER + market);
        HttpResponse getResponse = client.execute(getMethod);
        ObjectMapper mapper = new ObjectMapper();
        KucoinTickerResult tickerResult = (KucoinTickerResult) mapper.readValue(getResponse.getEntity().getContent(), KucoinTickerResult.class);
        if (tickerResult.isSuccess()) {
            result = tickerResult.getTickerItem().getLastPrice();
        }
        return result;
    }

}
