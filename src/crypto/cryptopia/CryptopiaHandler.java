package crypto.cryptopia;

import com.fasterxml.jackson.databind.ObjectMapper;
import crypto.ExchangeHandler;
import crypto.TickerHandler;
import crypto.cryptopia.ticker.CryptopiaTickerItem;
import crypto.cryptopia.ticker.CryptopiaTickerResult;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class CryptopiaHandler implements ExchangeHandler
{
  public static final String TICKER = "https://www.cryptopia.co.nz/api/GetMarket/";
  
  public CryptopiaHandler() {}
  
  public TickerHandler getTicker(String market, String baseCurrency, boolean convertToUSD)
  {
    CryptopiaTickerItem result = null;
    HttpClient client = HttpClients.createDefault();
    HttpGet getMethod = new HttpGet("https://www.cryptopia.co.nz/api/GetMarket/" + market + "_" + baseCurrency);
    try {
      HttpResponse getResponse = client.execute(getMethod);
      ObjectMapper mapper = new ObjectMapper();
      CryptopiaTickerResult tickerResult = (CryptopiaTickerResult)mapper.readValue(getResponse.getEntity().getContent(), CryptopiaTickerResult.class);
      if (tickerResult.isSuccess()) {
        result = tickerResult.getData();
        if (("BTC".equals(baseCurrency)) || ("ETH".equals(baseCurrency))) {
          result.setLastPrice(result.getLastPrice() * (convertToUSD ? convertToUSD(baseCurrency) : 1.0D));
        }
      }
    } catch (Exception ex) {
      System.err.println(ex);
      Logger.getLogger(CryptopiaHandler.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      getMethod.releaseConnection();
    }
    return result;
  }
  





  private double convertToUSD(String baseCurrency)
    throws IOException
  {
    double result = 0.0D;
    String market = "BTC_USDT";
    if ("ETH".equals(baseCurrency)) {
      market = "ETH_USDT";
    }
    HttpClient client = HttpClients.createDefault();
    HttpGet getMethod = new HttpGet("https://www.cryptopia.co.nz/api/GetMarket/" + market);
    HttpResponse getResponse = client.execute(getMethod);
    ObjectMapper mapper = new ObjectMapper();
    CryptopiaTickerResult tickerResult = (CryptopiaTickerResult)mapper.readValue(getResponse.getEntity().getContent(), CryptopiaTickerResult.class);
    if (tickerResult.isSuccess()) {
      result = tickerResult.getData().getLastPrice();
    }
    return result;
  }
}
