package crypto.tidex;

import com.fasterxml.jackson.databind.ObjectMapper;
import crypto.ExchangeHandler;
import crypto.tidex.ticker.TidexTickerItem;
import crypto.tidex.ticker.TidexTickerResult;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class TidexHandler implements ExchangeHandler
{
  private static final String TICKER = "https://api.tidex.com/api/3/ticker/";
  
  public TidexHandler() {}
  
  public TidexTickerItem getTicker(String market, String baseCurrency, boolean convertToUSD)
  {
    TidexTickerResult out = null;
    TidexTickerItem result = null;
    HttpClient client = HttpClients.createDefault();
    HttpGet getMethod = new HttpGet("https://api.tidex.com/api/3/ticker/" + market.toLowerCase() + "_" + baseCurrency.toLowerCase());
    try {
      HttpResponse getResponse = client.execute(getMethod);
      ObjectMapper mapper = new ObjectMapper();
      out = (TidexTickerResult)mapper.readValue(getResponse.getEntity().getContent(), TidexTickerResult.class);
      result = out.getTickerItem(market.toLowerCase() + "_" + baseCurrency.toLowerCase());
      if (("BTC".equals(baseCurrency)) || ("ETH".equals(baseCurrency))) {
        result.setLast(result.getLastPrice() * (convertToUSD ? convertToUSD(baseCurrency) : 1.0D));
      }
    } catch (Exception ex) {
      System.err.println(ex);
      Logger.getLogger(TidexTickerItem.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      getMethod.releaseConnection();
    }
    return result;
  }
  





  private double convertToUSD(String baseCurrency)
    throws IOException
  {
    double result = 0.0D;
    String market = "btc_usdt";
    if ("ETH".equals(baseCurrency)) {
      market = "eth_usdt";
    }
    HttpClient client = HttpClients.createDefault();
    HttpGet getMethod = new HttpGet("https://api.tidex.com/api/3/ticker/" + market);
    HttpResponse getResponse = client.execute(getMethod);
    ObjectMapper mapper = new ObjectMapper();
    TidexTickerResult tickerResult = (TidexTickerResult)mapper.readValue(getResponse.getEntity().getContent(), TidexTickerResult.class);
    result = tickerResult.getTickerItem(market).getLastPrice();
    return result;
  }
}
