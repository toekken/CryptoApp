package crypto.bittrex.ticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import crypto.TickerHandler;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Bid", "Ask", "Last"})
public class BittrexTickerItem implements Serializable, TickerHandler
{
  @JsonProperty("Bid")
  private double bid;
  @JsonProperty("Ask")
  private double ask;
  @JsonProperty("Last")
  private double last;
  private static final long serialVersionUID = -5129685001943087736L;
  
  public BittrexTickerItem() {}
  
  @JsonProperty("Bid")
  public double getBid()
  {
    return bid;
  }
  
  @JsonProperty("Bid")
  public void setBid(double bid) {
    this.bid = bid;
  }
  
  public double getLastPrice()
  {
    return getLast();
  }
  
  public BittrexTickerItem withBid(double bid) {
    this.bid = bid;
    return this;
  }
  
  @JsonProperty("Ask")
  public double getAsk() {
    return ask;
  }
  
  @JsonProperty("Ask")
  public void setAsk(double ask) {
    this.ask = ask;
  }
  
  public BittrexTickerItem withAsk(double ask) {
    this.ask = ask;
    return this;
  }
  
  @JsonProperty("Last")
  public double getLast() {
    return last;
  }
  
  @JsonProperty("Last")
  public void setLast(double last) {
    this.last = last;
  }
  
  public BittrexTickerItem withLast(double last) {
    this.last = last;
    return this;
  }
}
