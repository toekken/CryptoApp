package crypto.bitstamp;

import com.fasterxml.jackson.databind.ObjectMapper;
import crypto.ExchangeHandler;
import crypto.binance.BinanceHandler;
import crypto.bitstamp.ticker.BitstampTickerItem;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class BitstampHandler implements ExchangeHandler
{
  private static final String TICKER = "https://www.bitstamp.net/api/v2/ticker/";
  
  public BitstampHandler() {}
  
  public BitstampTickerItem getTicker(String market, String baseCurrency, boolean convertToUSD)
  {
    BitstampTickerItem result = null;
    HttpClient client = HttpClients.createDefault();
    baseCurrency = "USDT".equals(baseCurrency) ? "USD" : baseCurrency;
    String get = "https://www.bitstamp.net/api/v2/ticker/" + market + baseCurrency;
    HttpGet getMethod = new HttpGet(get.toLowerCase());
    try {
      HttpResponse getResponse = client.execute(getMethod);
      ObjectMapper mapper = new ObjectMapper();
      result = (BitstampTickerItem)mapper.readValue(getResponse.getEntity().getContent(), BitstampTickerItem.class);
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
    String market = "BTCUSD";
    if ("ETH".equals(baseCurrency)) {
      market = "ETHUSD";
    }
    HttpClient client = HttpClients.createDefault();
    HttpGet getMethod = new HttpGet("https://www.bitstamp.net/api/v2/ticker/" + market);
    HttpResponse getResponse = client.execute(getMethod);
    ObjectMapper mapper = new ObjectMapper();
    BitstampTickerItem tickerResult = (BitstampTickerItem)mapper.readValue(getResponse.getEntity().getContent(), BitstampTickerItem.class);
    result = tickerResult.getLastPrice();
    return result;
  }
}
