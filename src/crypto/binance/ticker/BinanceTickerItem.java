package crypto.binance.ticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import crypto.TickerHandler;
import java.io.Serializable;



















@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"symbol", "priceChange", "priceChangePercent", "weightedAvgPrice", "prevClosePrice", "lastPrice", "lastQty", "bidPrice", "bidQty", "askPrice", "askQty", "openPrice", "highPrice", "lowPrice", "volume", "quoteVolume", "openTime", "closeTime", "firstId", "lastId", "count"})
public class BinanceTickerItem
  implements Serializable, TickerHandler
{
  @JsonProperty("symbol")
  private String symbol;
  @JsonProperty("priceChange")
  private String priceChange;
  @JsonProperty("priceChangePercent")
  private String priceChangePercent;
  @JsonProperty("weightedAvgPrice")
  private String weightedAvgPrice;
  @JsonProperty("prevClosePrice")
  private String prevClosePrice;
  @JsonProperty("lastPrice")
  private String last;
  @JsonProperty("lastQty")
  private String lastQty;
  @JsonProperty("bidPrice")
  private String bidPrice;
  @JsonProperty("bidQty")
  private String bidQty;
  @JsonProperty("askPrice")
  private String askPrice;
  @JsonProperty("askQty")
  private String askQty;
  @JsonProperty("openPrice")
  private String openPrice;
  @JsonProperty("highPrice")
  private String highPrice;
  @JsonProperty("lowPrice")
  private String lowPrice;
  @JsonProperty("volume")
  private String volume;
  @JsonProperty("quoteVolume")
  private String quoteVolume;
  @JsonProperty("openTime")
  private String openTime;
  @JsonProperty("closeTime")
  private String closeTime;
  @JsonProperty("firstId")
  private String firstId;
  @JsonProperty("lastId")
  private String lastId;
  @JsonProperty("count")
  private String count;
  private static final long serialVersionUID = -7502678858748972895L;
  
  public BinanceTickerItem() {}
  
  public double getLastPrice()
  {
    return Double.parseDouble(last);
  }
  
  @JsonProperty("symbol")
  public String getSymbol() {
    return symbol;
  }
  
  @JsonProperty("symbol")
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }
  
  public BinanceTickerItem withSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }
  
  @JsonProperty("priceChange")
  public String getPriceChange() {
    return priceChange;
  }
  
  @JsonProperty("priceChange")
  public void setPriceChange(String priceChange) {
    this.priceChange = priceChange;
  }
  
  public BinanceTickerItem withPriceChange(String priceChange) {
    this.priceChange = priceChange;
    return this;
  }
  
  @JsonProperty("priceChangePercent")
  public String getPriceChangePercent() {
    return priceChangePercent;
  }
  
  @JsonProperty("priceChangePercent")
  public void setPriceChangePercent(String priceChangePercent) {
    this.priceChangePercent = priceChangePercent;
  }
  
  public BinanceTickerItem withPriceChangePercent(String priceChangePercent) {
    this.priceChangePercent = priceChangePercent;
    return this;
  }
  
  @JsonProperty("weightedAvgPrice")
  public String getWeightedAvgPrice() {
    return weightedAvgPrice;
  }
  
  @JsonProperty("weightedAvgPrice")
  public void setWeightedAvgPrice(String weightedAvgPrice) {
    this.weightedAvgPrice = weightedAvgPrice;
  }
  
  public BinanceTickerItem withWeightedAvgPrice(String weightedAvgPrice) {
    this.weightedAvgPrice = weightedAvgPrice;
    return this;
  }
  
  @JsonProperty("prevClosePrice")
  public String getPrevClosePrice() {
    return prevClosePrice;
  }
  
  @JsonProperty("prevClosePrice")
  public void setPrevClosePrice(String prevClosePrice) {
    this.prevClosePrice = prevClosePrice;
  }
  
  public BinanceTickerItem withPrevClosePrice(String prevClosePrice) {
    this.prevClosePrice = prevClosePrice;
    return this;
  }
  
  @JsonProperty("lastPrice")
  public String getLast() {
    return last;
  }
  
  @JsonProperty("lastPrice")
  public void setLast(String lastPrice) {
    last = lastPrice;
  }
  
  public BinanceTickerItem withLastPrice(String lastPrice) {
    last = lastPrice;
    return this;
  }
  
  @JsonProperty("lastQty")
  public String getLastQty() {
    return lastQty;
  }
  
  @JsonProperty("lastQty")
  public void setLastQty(String lastQty) {
    this.lastQty = lastQty;
  }
  
  public BinanceTickerItem withLastQty(String lastQty) {
    this.lastQty = lastQty;
    return this;
  }
  
  @JsonProperty("bidPrice")
  public String getBidPrice() {
    return bidPrice;
  }
  
  @JsonProperty("bidPrice")
  public void setBidPrice(String bidPrice) {
    this.bidPrice = bidPrice;
  }
  
  public BinanceTickerItem withBidPrice(String bidPrice) {
    this.bidPrice = bidPrice;
    return this;
  }
  
  @JsonProperty("bidQty")
  public String getBidQty() {
    return bidQty;
  }
  
  @JsonProperty("bidQty")
  public void setBidQty(String bidQty) {
    this.bidQty = bidQty;
  }
  
  public BinanceTickerItem withBidQty(String bidQty) {
    this.bidQty = bidQty;
    return this;
  }
  
  @JsonProperty("askPrice")
  public String getAskPrice() {
    return askPrice;
  }
  
  @JsonProperty("askPrice")
  public void setAskPrice(String askPrice) {
    this.askPrice = askPrice;
  }
  
  public BinanceTickerItem withAskPrice(String askPrice) {
    this.askPrice = askPrice;
    return this;
  }
  
  @JsonProperty("askQty")
  public String getAskQty() {
    return askQty;
  }
  
  @JsonProperty("askQty")
  public void setAskQty(String askQty) {
    this.askQty = askQty;
  }
  
  public BinanceTickerItem withAskQty(String askQty) {
    this.askQty = askQty;
    return this;
  }
  
  @JsonProperty("openPrice")
  public String getOpenPrice() {
    return openPrice;
  }
  
  @JsonProperty("openPrice")
  public void setOpenPrice(String openPrice) {
    this.openPrice = openPrice;
  }
  
  public BinanceTickerItem withOpenPrice(String openPrice) {
    this.openPrice = openPrice;
    return this;
  }
  
  @JsonProperty("highPrice")
  public String getHighPrice() {
    return highPrice;
  }
  
  @JsonProperty("highPrice")
  public void setHighPrice(String highPrice) {
    this.highPrice = highPrice;
  }
  
  public BinanceTickerItem withHighPrice(String highPrice) {
    this.highPrice = highPrice;
    return this;
  }
  
  @JsonProperty("lowPrice")
  public String getLowPrice() {
    return lowPrice;
  }
  
  @JsonProperty("lowPrice")
  public void setLowPrice(String lowPrice) {
    this.lowPrice = lowPrice;
  }
  
  public BinanceTickerItem withLowPrice(String lowPrice) {
    this.lowPrice = lowPrice;
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
  
  public BinanceTickerItem withVolume(String volume) {
    this.volume = volume;
    return this;
  }
  
  @JsonProperty("quoteVolume")
  public String getQuoteVolume() {
    return quoteVolume;
  }
  
  @JsonProperty("quoteVolume")
  public void setQuoteVolume(String quoteVolume) {
    this.quoteVolume = quoteVolume;
  }
  
  public BinanceTickerItem withQuoteVolume(String quoteVolume) {
    this.quoteVolume = quoteVolume;
    return this;
  }
  
  @JsonProperty("openTime")
  public String getOpenTime() {
    return openTime;
  }
  
  @JsonProperty("openTime")
  public void setOpenTime(String openTime) {
    this.openTime = openTime;
  }
  
  public BinanceTickerItem withOpenTime(String openTime) {
    this.openTime = openTime;
    return this;
  }
  
  @JsonProperty("closeTime")
  public String getCloseTime() {
    return closeTime;
  }
  
  @JsonProperty("closeTime")
  public void setCloseTime(String closeTime) {
    this.closeTime = closeTime;
  }
  
  public BinanceTickerItem withCloseTime(String closeTime) {
    this.closeTime = closeTime;
    return this;
  }
  
  @JsonProperty("firstId")
  public String getFirstId() {
    return firstId;
  }
  
  @JsonProperty("firstId")
  public void setFirstId(String firstId) {
    this.firstId = firstId;
  }
  
  public BinanceTickerItem withFirstId(String firstId) {
    this.firstId = firstId;
    return this;
  }
  
  @JsonProperty("lastId")
  public String getLastId() {
    return lastId;
  }
  
  @JsonProperty("lastId")
  public void setLastId(String lastId) {
    this.lastId = lastId;
  }
  
  public BinanceTickerItem withLastId(String lastId) {
    this.lastId = lastId;
    return this;
  }
  
  @JsonProperty("count")
  public String getCount() {
    return count;
  }
  
  @JsonProperty("count")
  public void setCount(String count) {
    this.count = count;
  }
  
  public BinanceTickerItem withCount(String count) {
    this.count = count;
    return this;
  }
}
