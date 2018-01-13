package crypto.bitstamp.ticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import crypto.TickerHandler;
import java.io.Serializable;






@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"high", "last", "timestamp", "bid", "vwap", "volume", "low", "ask", "open"})
public class BitstampTickerItem
  implements Serializable, TickerHandler
{
  @JsonProperty("high")
  private String high;
  @JsonProperty("last")
  private String last;
  @JsonProperty("timestamp")
  private String timestamp;
  @JsonProperty("bid")
  private String bid;
  @JsonProperty("vwap")
  private String vwap;
  @JsonProperty("volume")
  private String volume;
  @JsonProperty("low")
  private String low;
  @JsonProperty("ask")
  private String ask;
  @JsonProperty("open")
  private String open;
  private static final long serialVersionUID = 9027312550671838506L;
  
  public BitstampTickerItem() {}
  
  @JsonProperty("high")
  public String getHigh()
  {
    return high;
  }
  
  @JsonProperty("high")
  public void setHigh(String high) {
    this.high = high;
  }
  
  public double getLastPrice()
  {
    return Double.parseDouble(last);
  }
  
  public BitstampTickerItem withHigh(String high) {
    this.high = high;
    return this;
  }
  
  @JsonProperty("last")
  public String getLast() {
    return last;
  }
  
  @JsonProperty("last")
  public void setLast(String last) {
    this.last = last;
  }
  
  public BitstampTickerItem withLast(String last) {
    this.last = last;
    return this;
  }
  
  @JsonProperty("timestamp")
  public String getTimestamp() {
    return timestamp;
  }
  
  @JsonProperty("timestamp")
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
  
  public BitstampTickerItem withTimestamp(String timestamp) {
    this.timestamp = timestamp;
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
  
  public BitstampTickerItem withBid(String bid) {
    this.bid = bid;
    return this;
  }
  
  @JsonProperty("vwap")
  public String getVwap() {
    return vwap;
  }
  
  @JsonProperty("vwap")
  public void setVwap(String vwap) {
    this.vwap = vwap;
  }
  
  public BitstampTickerItem withVwap(String vwap) {
    this.vwap = vwap;
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
  
  public BitstampTickerItem withVolume(String volume) {
    this.volume = volume;
    return this;
  }
  
  @JsonProperty("low")
  public String getLow() {
    return low;
  }
  
  @JsonProperty("low")
  public void setLow(String low) {
    this.low = low;
  }
  
  public BitstampTickerItem withLow(String low) {
    this.low = low;
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
  
  public BitstampTickerItem withAsk(String ask) {
    this.ask = ask;
    return this;
  }
  
  @JsonProperty("open")
  public String getOpen() {
    return open;
  }
  
  @JsonProperty("open")
  public void setOpen(String open) {
    this.open = open;
  }
  
  public BitstampTickerItem withOpen(String open) {
    this.open = open;
    return this;
  }
}
