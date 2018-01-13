package crypto.cryptopia.ticker;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import crypto.TickerHandler;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;















@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"TradePairId", "Label", "AskPrice", "BidPrice", "Low", "High", "Volume", "LastPrice", "BuyVolume", "SellVolume", "Change", "Open", "Close", "BaseVolume", "BuyBaseVolume", "SellBaseVolume"})
public class CryptopiaTickerItem
  implements Serializable, TickerHandler
{
  @JsonProperty("TradePairId")
  private int tradePairId;
  @JsonProperty("Label")
  private String label;
  @JsonProperty("AskPrice")
  private double askPrice;
  @JsonProperty("BidPrice")
  private double bidPrice;
  @JsonProperty("Low")
  private double low;
  @JsonProperty("High")
  private double high;
  @JsonProperty("Volume")
  private double volume;
  @JsonProperty("LastPrice")
  private double lastPrice;
  @JsonProperty("BuyVolume")
  private double buyVolume;
  @JsonProperty("SellVolume")
  private double sellVolume;
  @JsonProperty("Change")
  private double change;
  @JsonProperty("Open")
  private double open;
  @JsonProperty("Close")
  private double close;
  @JsonProperty("BaseVolume")
  private double baseVolume;
  @JsonProperty("BuyBaseVolume")
  private double buyBaseVolume;
  @JsonProperty("SellBaseVolume")
  private double sellBaseVolume;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap();
  private static final long serialVersionUID = -864847306113824428L;
  
  public CryptopiaTickerItem() {}
  
  @JsonProperty("TradePairId")
  public int getTradePairId() { return tradePairId; }
  
  @JsonProperty("TradePairId")
  public void setTradePairId(int tradePairId)
  {
    this.tradePairId = tradePairId;
  }
  
  public CryptopiaTickerItem withTradePairId(int tradePairId) {
    this.tradePairId = tradePairId;
    return this;
  }
  
  @JsonProperty("Label")
  public String getLabel() {
    return label;
  }
  
  @JsonProperty("Label")
  public void setLabel(String label) {
    this.label = label;
  }
  
  public CryptopiaTickerItem withLabel(String label) {
    this.label = label;
    return this;
  }
  
  @JsonProperty("AskPrice")
  public double getAskPrice() {
    return askPrice;
  }
  
  @JsonProperty("AskPrice")
  public void setAskPrice(double askPrice) {
    this.askPrice = askPrice;
  }
  
  public CryptopiaTickerItem withAskPrice(double askPrice) {
    this.askPrice = askPrice;
    return this;
  }
  
  @JsonProperty("BidPrice")
  public double getBidPrice() {
    return bidPrice;
  }
  
  @JsonProperty("BidPrice")
  public void setBidPrice(double bidPrice) {
    this.bidPrice = bidPrice;
  }
  
  public CryptopiaTickerItem withBidPrice(double bidPrice) {
    this.bidPrice = bidPrice;
    return this;
  }
  
  @JsonProperty("Low")
  public double getLow() {
    return low;
  }
  
  @JsonProperty("Low")
  public void setLow(double low) {
    this.low = low;
  }
  
  public CryptopiaTickerItem withLow(double low) {
    this.low = low;
    return this;
  }
  
  @JsonProperty("High")
  public double getHigh() {
    return high;
  }
  
  @JsonProperty("High")
  public void setHigh(double high) {
    this.high = high;
  }
  
  public CryptopiaTickerItem withHigh(double high) {
    this.high = high;
    return this;
  }
  
  @JsonProperty("Volume")
  public double getVolume() {
    return volume;
  }
  
  @JsonProperty("Volume")
  public void setVolume(double volume) {
    this.volume = volume;
  }
  
  public CryptopiaTickerItem withVolume(double volume) {
    this.volume = volume;
    return this;
  }
  
  @JsonProperty("LastPrice")
  public double getLastPrice() {
    return lastPrice;
  }
  
  @JsonProperty("LastPrice")
  public void setLastPrice(double lastPrice) {
    this.lastPrice = lastPrice;
  }
  
  public CryptopiaTickerItem withLastPrice(double lastPrice) {
    this.lastPrice = lastPrice;
    return this;
  }
  
  @JsonProperty("BuyVolume")
  public double getBuyVolume() {
    return buyVolume;
  }
  
  @JsonProperty("BuyVolume")
  public void setBuyVolume(double buyVolume) {
    this.buyVolume = buyVolume;
  }
  
  public CryptopiaTickerItem withBuyVolume(double buyVolume) {
    this.buyVolume = buyVolume;
    return this;
  }
  
  @JsonProperty("SellVolume")
  public double getSellVolume() {
    return sellVolume;
  }
  
  @JsonProperty("SellVolume")
  public void setSellVolume(double sellVolume) {
    this.sellVolume = sellVolume;
  }
  
  public CryptopiaTickerItem withSellVolume(double sellVolume) {
    this.sellVolume = sellVolume;
    return this;
  }
  
  @JsonProperty("Change")
  public double getChange() {
    return change;
  }
  
  @JsonProperty("Change")
  public void setChange(double change) {
    this.change = change;
  }
  
  public CryptopiaTickerItem withChange(double change) {
    this.change = change;
    return this;
  }
  
  @JsonProperty("Open")
  public double getOpen() {
    return open;
  }
  
  @JsonProperty("Open")
  public void setOpen(double open) {
    this.open = open;
  }
  
  public CryptopiaTickerItem withOpen(double open) {
    this.open = open;
    return this;
  }
  
  @JsonProperty("Close")
  public double getClose() {
    return close;
  }
  
  @JsonProperty("Close")
  public void setClose(double close) {
    this.close = close;
  }
  
  public CryptopiaTickerItem withClose(double close) {
    this.close = close;
    return this;
  }
  
  @JsonProperty("BaseVolume")
  public double getBaseVolume() {
    return baseVolume;
  }
  
  @JsonProperty("BaseVolume")
  public void setBaseVolume(double baseVolume) {
    this.baseVolume = baseVolume;
  }
  
  public CryptopiaTickerItem withBaseVolume(double baseVolume) {
    this.baseVolume = baseVolume;
    return this;
  }
  
  @JsonProperty("BuyBaseVolume")
  public double getBuyBaseVolume() {
    return buyBaseVolume;
  }
  
  @JsonProperty("BuyBaseVolume")
  public void setBuyBaseVolume(double buyBaseVolume) {
    this.buyBaseVolume = buyBaseVolume;
  }
  
  public CryptopiaTickerItem withBuyBaseVolume(double buyBaseVolume) {
    this.buyBaseVolume = buyBaseVolume;
    return this;
  }
  
  @JsonProperty("SellBaseVolume")
  public double getSellBaseVolume() {
    return sellBaseVolume;
  }
  
  @JsonProperty("SellBaseVolume")
  public void setSellBaseVolume(double sellBaseVolume) {
    this.sellBaseVolume = sellBaseVolume;
  }
  
  public CryptopiaTickerItem withSellBaseVolume(double sellBaseVolume) {
    this.sellBaseVolume = sellBaseVolume;
    return this;
  }
  
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }
  
  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    additionalProperties.put(name, value);
  }
  
  public CryptopiaTickerItem withAdditionalProperty(String name, Object value) {
    additionalProperties.put(name, value);
    return this;
  }
}
