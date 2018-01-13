package crypto.hitbtc;

import com.fasterxml.jackson.databind.ObjectMapper;
import crypto.ExchangeHandler;
import crypto.binance.BinanceHandler;
import crypto.hitbtc.ticker.HitbtcTickerItem;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class HitbtcHandler
  implements ExchangeHandler
{
  private static final String TICKER = "https://api.hitbtc.com/api/2/public/ticker/";
  
  public HitbtcHandler() {}
  
  public HitbtcTickerItem getTicker(String market, String baseCurrency, boolean convertToUSD)
  {
    HitbtcTickerItem result = null;
    HttpClient client = HttpClients.createDefault();
    baseCurrency = "USDT".equals(baseCurrency) ? "USD" : baseCurrency;
    HttpGet getMethod = new HttpGet("https://api.hitbtc.com/api/2/public/ticker/" + market + baseCurrency);
    try {
      HttpResponse getResponse = client.execute(getMethod);
      ObjectMapper mapper = new ObjectMapper();
      result = (HitbtcTickerItem)mapper.readValue(getResponse.getEntity().getContent(), HitbtcTickerItem.class);
      if (("BTC".equals(baseCurrency)) || ("ETH".equals(baseCurrency))) {
        result.setLast(String.valueOf(result.getLastPrice() * (convertToUSD ? convertToUSD(baseCurrency) : 1.0D)));
      }
    } catch (Exception ex) {
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
    HttpGet getMethod = new HttpGet("https://api.hitbtc.com/api/2/public/ticker/" + market);
    HttpResponse getResponse = client.execute(getMethod);
    ObjectMapper mapper = new ObjectMapper();
    HitbtcTickerItem tickerResult = (HitbtcTickerItem)mapper.readValue(getResponse.getEntity().getContent(), HitbtcTickerItem.class);
    result = tickerResult.getLastPrice();
    return result;
  }
}
