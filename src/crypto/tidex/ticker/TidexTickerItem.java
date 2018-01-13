package crypto.tidex.ticker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"high", "low", "avg", "vol", "vol_cur", "last", "buy", "sell", "updated"})
public class TidexTickerItem implements crypto.TickerHandler, java.io.Serializable
{
  @JsonProperty("high")
  private double high;
  @JsonProperty("low")
  private double low;
  @JsonProperty("avg")
  private double avg;
  @JsonProperty("vol")
  private double vol;
  @JsonProperty("vol_cur")
  private double volCur;
  
  public TidexTickerItem() {}
  
  public double getLastPrice()
  {
    return getLast();
  }
  


  @JsonProperty("last")
  private double last;
  

  @JsonProperty("buy")
  private double buy;
  

  @JsonProperty("sell")
  private double sell;
  
  @JsonProperty("updated")
  private int updated;
  
  private static final long serialVersionUID = 334626178472297973L;
  
  @JsonProperty("high")
  public double getHigh()
  {
    return high;
  }
  
  @JsonProperty("high")
  public void setHigh(double high) {
    this.high = high;
  }
  
  public TidexTickerItem withHigh(double high) {
    this.high = high;
    return this;
  }
  
  @JsonProperty("low")
  public double getLow() {
    return low;
  }
  
  @JsonProperty("low")
  public void setLow(double low) {
    this.low = low;
  }
  
  public TidexTickerItem withLow(double low) {
    this.low = low;
    return this;
  }
  
  @JsonProperty("avg")
  public double getAvg() {
    return avg;
  }
  
  @JsonProperty("avg")
  public void setAvg(double avg) {
    this.avg = avg;
  }
  
  public TidexTickerItem withAvg(double avg) {
    this.avg = avg;
    return this;
  }
  
  @JsonProperty("vol")
  public double getVol() {
    return vol;
  }
  
  @JsonProperty("vol")
  public void setVol(double vol) {
    this.vol = vol;
  }
  
  public TidexTickerItem withVol(double vol) {
    this.vol = vol;
    return this;
  }
  
  @JsonProperty("vol_cur")
  public double getVolCur() {
    return volCur;
  }
  
  @JsonProperty("vol_cur")
  public void setVolCur(double volCur) {
    this.volCur = volCur;
  }
  
  public TidexTickerItem withVolCur(double volCur) {
    this.volCur = volCur;
    return this;
  }
  
  @JsonProperty("last")
  public double getLast() {
    return last;
  }
  
  @JsonProperty("last")
  public void setLast(double last) {
    this.last = last;
  }
  
  public TidexTickerItem withLast(double last) {
    this.last = last;
    return this;
  }
  
  @JsonProperty("buy")
  public double getBuy() {
    return buy;
  }
  
  @JsonProperty("buy")
  public void setBuy(double buy) {
    this.buy = buy;
  }
  
  public TidexTickerItem withBuy(double buy) {
    this.buy = buy;
    return this;
  }
  
  @JsonProperty("sell")
  public double getSell() {
    return sell;
  }
  
  @JsonProperty("sell")
  public void setSell(double sell) {
    this.sell = sell;
  }
  
  public TidexTickerItem withSell(double sell) {
    this.sell = sell;
    return this;
  }
  
  @JsonProperty("updated")
  public int getUpdated() {
    return updated;
  }
  
  @JsonProperty("updated")
  public void setUpdated(int updated) {
    this.updated = updated;
  }
  
  public TidexTickerItem withUpdated(int updated) {
    this.updated = updated;
    return this;
  }
}
