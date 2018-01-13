package crypto.bitgrail.ticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import crypto.TickerHandler;
import java.io.Serializable;




@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"last", "high", "low", "volume", "coinVolume", "bid", "ask"})
public class BitGrailResponse
  implements Serializable, TickerHandler
{
  @JsonProperty("last")
  private double last;
  @JsonProperty("high")
  private String high;
  @JsonProperty("low")
  private String low;
  @JsonProperty("volume")
  private String volume;
  @JsonProperty("coinVolume")
  private String coinVolume;
  @JsonProperty("bid")
  private String bid;
  @JsonProperty("ask")
  private String ask;
  private static final long serialVersionUID = -668631109083156247L;
  
  public BitGrailResponse() {}
  
  @JsonProperty("last")
  public double getLast()
  {
    return last;
  }
  
  @JsonProperty("last")
  public void setLast(double last) {
    this.last = last;
  }
  
  public double getLastPrice()
  {
    return getLast();
  }
  
  public BitGrailResponse withLast(double last) {
    this.last = last;
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
  
  public BitGrailResponse withHigh(String high) {
    this.high = high;
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
  
  public BitGrailResponse withLow(String low) {
    this.low = low;
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
  
  public BitGrailResponse withVolume(String volume) {
    this.volume = volume;
    return this;
  }
  
  @JsonProperty("coinVolume")
  public String getCoinVolume() {
    return coinVolume;
  }
  
  @JsonProperty("coinVolume")
  public void setCoinVolume(String coinVolume) {
    this.coinVolume = coinVolume;
  }
  
  public BitGrailResponse withCoinVolume(String coinVolume) {
    this.coinVolume = coinVolume;
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
  
  public BitGrailResponse withBid(String bid) {
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
  
  public BitGrailResponse withAsk(String ask) {
    this.ask = ask;
    return this;
  }
}
