package crypto.gdax.ticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import crypto.TickerHandler;
import java.io.Serializable;





@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"trade_id", "price", "size", "bid", "ask", "volume", "time"})
public class GdaxTickerItem
  implements Serializable, TickerHandler
{
  @JsonProperty("trade_id")
  private String tradeId;
  @JsonProperty("price")
  private String price;
  @JsonProperty("size")
  private String size;
  @JsonProperty("bid")
  private String bid;
  @JsonProperty("ask")
  private String ask;
  @JsonProperty("volume")
  private String volume;
  @JsonProperty("time")
  private String time;
  private static final long serialVersionUID = 252495437525629783L;
  
  public GdaxTickerItem() {}
  
  public double getLastPrice()
  {
    return Double.parseDouble(price);
  }
  
  @JsonProperty("trade_id")
  public String getTradeId() {
    return tradeId;
  }
  
  @JsonProperty("trade_id")
  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }
  
  public GdaxTickerItem withTradeId(String tradeId) {
    this.tradeId = tradeId;
    return this;
  }
  
  @JsonProperty("price")
  public String getPrice() {
    return price;
  }
  
  @JsonProperty("price")
  public void setPrice(String price) {
    this.price = price;
  }
  
  public GdaxTickerItem withPrice(String price) {
    this.price = price;
    return this;
  }
  
  @JsonProperty("size")
  public String getSize() {
    return size;
  }
  
  @JsonProperty("size")
  public void setSize(String size) {
    this.size = size;
  }
  
  public GdaxTickerItem withSize(String size) {
    this.size = size;
    return this;
  }
  
  @JsonProperty("bid")
  public String getBid() {
    return bid;
  }
  
  @JsonProperty("bid")
  public void setBid(String bid) {
    this.bid = bid;
  }
  
  public GdaxTickerItem withBid(String bid) {
    this.bid = bid;
    return this;
  }
  
  @JsonProperty("ask")
  public String getAsk() {
    return ask;
  }
  
  @JsonProperty("ask")
  public void setAsk(String ask) {
    this.ask = ask;
  }
  
  public GdaxTickerItem withAsk(String ask) {
    this.ask = ask;
    return this;
  }
  
  @JsonProperty("volume")
  public String getVolume() {
    return volume;
  }
  
  @JsonProperty("volume")
  public void setVolume(String volume) {
    this.volume = volume;
  }
  
  public GdaxTickerItem withVolume(String volume) {
    this.volume = volume;
    return this;
  }
  
  @JsonProperty("time")
  public String getTime() {
    return time;
  }
  
  @JsonProperty("time")
  public void setTime(String time) {
    this.time = time;
  }
  
  public GdaxTickerItem withTime(String time) {
    this.time = time;
    return this;
  }
}
