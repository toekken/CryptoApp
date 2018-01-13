package crypto.binance;

import com.fasterxml.jackson.databind.ObjectMapper;
import crypto.ExchangeHandler;
import crypto.binance.ticker.BinanceTickerItem;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class BinanceHandler implements ExchangeHandler
{
  private static final String TICKER = "https://api.binance.com/api/v1/ticker/24hr?symbol=";
  
  public BinanceHandler() {}
  
  public BinanceTickerItem getTicker(String market, String baseCurrency, boolean convertToUSD)
  {
    BinanceTickerItem result = null;
    HttpClient client = HttpClients.createDefault();
    HttpGet getMethod = new HttpGet("https://api.binance.com/api/v1/ticker/24hr?symbol=" + market + baseCurrency);
    try {
      HttpResponse getResponse = client.execute(getMethod);
      ObjectMapper mapper = new ObjectMapper();
      result = (BinanceTickerItem)mapper.readValue(getResponse.getEntity().getContent(), BinanceTickerItem.class);
      if (("BTC".equals(baseCurrency)) || ("ETH".equals(baseCurrency))) {
        result.setLast(String.valueOf(result.getLastPrice() * (convertToUSD ? convertToUSD(baseCurrency) : 1.0D)));
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
    String market = "BTCUSDT";
    if ("ETH".equals(baseCurrency)) {
      market = "ETHUSDT";
    }
    HttpClient client = HttpClients.createDefault();
    HttpGet getMethod = new HttpGet("https://api.binance.com/api/v1/ticker/24hr?symbol=" + market);
    HttpResponse getResponse = client.execute(getMethod);
    ObjectMapper mapper = new ObjectMapper();
    BinanceTickerItem tickerResult = (BinanceTickerItem)mapper.readValue(getResponse.getEntity().getContent(), BinanceTickerItem.class);
    result = tickerResult.getLastPrice();
    return result;
  }
}
