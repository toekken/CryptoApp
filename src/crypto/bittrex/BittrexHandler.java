package crypto.bittrex;

import com.fasterxml.jackson.databind.ObjectMapper;
import crypto.ExchangeHandler;
import crypto.bittrex.ticker.BittrexTickerItem;
import crypto.bittrex.ticker.BittrexTickerResult;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class BittrexHandler
        implements ExchangeHandler {

    public static final String TICKER = "https://bittrex.com/api/v1.1/public/getticker?market=";

    public BittrexHandler() {
    }

    public BittrexTickerItem getTicker(String market, String baseCurrency, boolean convertToUSD) {
        BittrexTickerItem result = null;
        HttpClient client = HttpClients.createDefault();
        HttpGet getMethod = new HttpGet("https://bittrex.com/api/v1.1/public/getticker?market=" + baseCurrency + "-" + market);
        try {
            HttpResponse getResponse = client.execute(getMethod);
            ObjectMapper mapper = new ObjectMapper();
            BittrexTickerResult tickerResult = (BittrexTickerResult) mapper.readValue(getResponse.getEntity().getContent(), BittrexTickerResult.class);
            if ("true".equals(tickerResult.getSuccess())) {
                result = tickerResult.getResult();
                if (("BTC".equals(baseCurrency)) || ("ETH".equals(baseCurrency))) {
                    result.setLast(result.getLast() * (convertToUSD ? convertToUSD(baseCurrency) : 1.0D));
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
        String market = "USDT-BTC";
        if ("ETH".equals(baseCurrency)) {
            market = "USDT-ETH";
        }
        HttpClient client = HttpClients.createDefault();
        HttpGet getMethod = new HttpGet("https://bittrex.com/api/v1.1/public/getticker?market=" + market);
        HttpResponse getResponse = client.execute(getMethod);
        ObjectMapper mapper = new ObjectMapper();
        BittrexTickerResult tickerResult = (BittrexTickerResult) mapper.readValue(getResponse.getEntity().getContent(), BittrexTickerResult.class);
        if ("true".equals(tickerResult.getSuccess())) {
            result = tickerResult.getResult().getLast();
        }
        return result;
    }
}
