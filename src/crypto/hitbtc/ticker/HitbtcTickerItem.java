package crypto.hitbtc.ticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import crypto.TickerHandler;
import java.io.Serializable;







@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"ask", "bid", "last", "open", "low", "high", "volume", "volumeQuote", "timestamp", "symbol"})
public class HitbtcTickerItem
  implements Serializable, TickerHandler
{
  @JsonProperty("ask")
  private String ask;
  @JsonProperty("bid")
  private String bid;
  @JsonProperty("last")
  private String last;
  @JsonProperty("open")
  private String open;
  @JsonProperty("low")
  private String low;
  @JsonProperty("high")
  private String high;
  @JsonProperty("volume")
  private String volume;
  @JsonProperty("volumeQuote")
  private String volumeQuote;
  @JsonProperty("timestamp")
  private String timestamp;
  @JsonProperty("symbol")
  private String symbol;
  private static final long serialVersionUID = -8687773016976837349L;
  
  public HitbtcTickerItem() {}
  
  @JsonProperty("ask")
  public String getAsk()
  {
    return ask;
  }
  
  @JsonProperty("ask")
  public void setAsk(String ask) {
    this.ask = ask;
  }
  
  public double getLastPrice()
  {
    return Double.parseDouble(last);
  }
  
  public HitbtcTickerItem withAsk(String ask) {
    this.ask = ask;
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
  
  public HitbtcTickerItem withBid(String bid) {
    this.bid = bid;
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
  
  public HitbtcTickerItem withLast(String last) {
    this.last = last;
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
  
  public HitbtcTickerItem withOpen(String open) {
    this.open = open;
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
  
  public HitbtcTickerItem withLow(String low) {
    this.low = low;
    return this;
  }
  
  @JsonProperty("high")
  public String getHigh() {
    return high;
  }
  
  @JsonProperty("high")
  public void setHigh(String high) {
    this.high = high;
  }
  
  public HitbtcTickerItem withHigh(String high) {
    this.high = high;
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
  
  public HitbtcTickerItem withVolume(String volume) {
    this.volume = volume;
    return this;
  }
  
  @JsonProperty("volumeQuote")
  public String getVolumeQuote() {
    return volumeQuote;
  }
  
  @JsonProperty("volumeQuote")
  public void setVolumeQuote(String volumeQuote) {
    this.volumeQuote = volumeQuote;
  }
  
  public HitbtcTickerItem withVolumeQuote(String volumeQuote) {
    this.volumeQuote = volumeQuote;
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
  
  public HitbtcTickerItem withTimestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }
  
  @JsonProperty("symbol")
  public String getSymbol() {
    return symbol;
  }
  
  @JsonProperty("symbol")
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }
  
  public HitbtcTickerItem withSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }
}
