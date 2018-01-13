package crypto.gdax;

import com.fasterxml.jackson.databind.ObjectMapper;
import crypto.ExchangeHandler;
import crypto.binance.BinanceHandler;
import crypto.gdax.ticker.GdaxTickerItem;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class GdaxHandler implements ExchangeHandler
{
  private static final String TICKER = "https://api.gdax.com/products/";
  
  public GdaxHandler() {}
  
  public GdaxTickerItem getTicker(String market, String baseCurrency, boolean convertToUSD)
  {
    GdaxTickerItem result = null;
    HttpClient client = HttpClients.createDefault();
    baseCurrency = "USDT".equals(baseCurrency) ? "USD" : baseCurrency;
    HttpGet getMethod = new HttpGet("https://api.gdax.com/products/" + market + "-" + baseCurrency + "/ticker");
    try {
      HttpResponse getResponse = client.execute(getMethod);
      ObjectMapper mapper = new ObjectMapper();
      result = (GdaxTickerItem)mapper.readValue(getResponse.getEntity().getContent(), GdaxTickerItem.class);
      if (("BTC".equals(baseCurrency)) || ("ETH".equals(baseCurrency))) {
        result.setPrice(String.valueOf(result.getLastPrice() * (convertToUSD ? convertToUSD(baseCurrency) : 1.0D)));
      }
    } catch (Exception ex) {
      System.err.println(ex);
      Logger.getLogger(BinanceHandler.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      getMethod.releaseConnection();
    }
    return result;
  }
  





  private double convertToUSD(String baseCurrency)
    throws IOException
  {
    double result = 0.0D;
    String market = "BTC-USD";
    if ("ETH".equals(baseCurrency)) {
      market = "ETH-USD";
    }
    HttpClient client = HttpClients.createDefault();
    HttpGet getMethod = new HttpGet("https://api.gdax.com/products/" + market + "/ticker");
    HttpResponse getResponse = client.execute(getMethod);
    ObjectMapper mapper = new ObjectMapper();
    GdaxTickerItem tickerResult = (GdaxTickerItem)mapper.readValue(getResponse.getEntity().getContent(), GdaxTickerItem.class);
    result = tickerResult.getLastPrice();
    return result;
  }
}
