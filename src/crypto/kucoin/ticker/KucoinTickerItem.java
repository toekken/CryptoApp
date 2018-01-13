package crypto.kucoin.ticker;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import crypto.TickerHandler;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coinType",
    "trading",
    "symbol",
    "lastDealPrice",
    "buy",
    "sell",
    "change",
    "coinTypePair",
    "sort",
    "feeRate",
    "volValue",
    "high",
    "datetime",
    "vol",
    "low",
    "changeRate"
})
public class KucoinTickerItem implements Serializable, TickerHandler {

    @JsonProperty("coinType")
    private String coinType;
    @JsonProperty("trading")
    private boolean trading;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("lastDealPrice")
    private double lastDealPrice;
    @JsonProperty("buy")
    private double buy;
    @JsonProperty("sell")
    private double sell;
    @JsonProperty("change")
    private double change;
    @JsonProperty("coinTypePair")
    private String coinTypePair;
    @JsonProperty("sort")
    private int sort;
    @JsonProperty("feeRate")
    private double feeRate;
    @JsonProperty("volValue")
    private double volValue;
    @JsonProperty("high")
    private double high;
    @JsonProperty("datetime")
    private long datetime;
    @JsonProperty("vol")
    private double vol;
    @JsonProperty("low")
    private double low;
    @JsonProperty("changeRate")
    private double changeRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3258676111883873733L;

    @JsonProperty("coinType")
    public String getCoinType() {
        return coinType;
    }

    @JsonProperty("coinType")
    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    @Override
    public double getLastPrice() {
        return this.getLastDealPrice();
    }

    public KucoinTickerItem withCoinType(String coinType) {
        this.coinType = coinType;
        return this;
    }

    @JsonProperty("trading")
    public boolean isTrading() {
        return trading;
    }

    @JsonProperty("trading")
    public void setTrading(boolean trading) {
        this.trading = trading;
    }

    public KucoinTickerItem withTrading(boolean trading) {
        this.trading = trading;
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

    public KucoinTickerItem withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @JsonProperty("lastDealPrice")
    public double getLastDealPrice() {
        return lastDealPrice;
    }

    @JsonProperty("lastDealPrice")
    public void setLastDealPrice(double lastDealPrice) {
        this.lastDealPrice = lastDealPrice;
    }

    public KucoinTickerItem withLastDealPrice(double lastDealPrice) {
        this.lastDealPrice = lastDealPrice;
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

    public KucoinTickerItem withBuy(double buy) {
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

    public KucoinTickerItem withSell(double sell) {
        this.sell = sell;
        return this;
    }

    @JsonProperty("change")
    public double getChange() {
        return change;
    }

    @JsonProperty("change")
    public void setChange(double change) {
        this.change = change;
    }

    public KucoinTickerItem withChange(double change) {
        this.change = change;
        return this;
    }

    @JsonProperty("coinTypePair")
    public String getCoinTypePair() {
        return coinTypePair;
    }

    @JsonProperty("coinTypePair")
    public void setCoinTypePair(String coinTypePair) {
        this.coinTypePair = coinTypePair;
    }

    public KucoinTickerItem withCoinTypePair(String coinTypePair) {
        this.coinTypePair = coinTypePair;
        return this;
    }

    @JsonProperty("sort")
    public int getSort() {
        return sort;
    }

    @JsonProperty("sort")
    public void setSort(int sort) {
        this.sort = sort;
    }

    public KucoinTickerItem withSort(int sort) {
        this.sort = sort;
        return this;
    }

    @JsonProperty("feeRate")
    public double getFeeRate() {
        return feeRate;
    }

    @JsonProperty("feeRate")
    public void setFeeRate(double feeRate) {
        this.feeRate = feeRate;
    }

    public KucoinTickerItem withFeeRate(double feeRate) {
        this.feeRate = feeRate;
        return this;
    }

    @JsonProperty("volValue")
    public double getVolValue() {
        return volValue;
    }

    @JsonProperty("volValue")
    public void setVolValue(double volValue) {
        this.volValue = volValue;
    }

    public KucoinTickerItem withVolValue(double volValue) {
        this.volValue = volValue;
        return this;
    }

    @JsonProperty("high")
    public double getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(double high) {
        this.high = high;
    }

    public KucoinTickerItem withHigh(double high) {
        this.high = high;
        return this;
    }

    @JsonProperty("datetime")
    public long getDatetime() {
        return datetime;
    }

    @JsonProperty("datetime")
    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public KucoinTickerItem withDatetime(long datetime) {
        this.datetime = datetime;
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

    public KucoinTickerItem withVol(double vol) {
        this.vol = vol;
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

    public KucoinTickerItem withLow(double low) {
        this.low = low;
        return this;
    }

    @JsonProperty("changeRate")
    public double getChangeRate() {
        return changeRate;
    }

    @JsonProperty("changeRate")
    public void setChangeRate(double changeRate) {
        this.changeRate = changeRate;
    }

    public KucoinTickerItem withChangeRate(double changeRate) {
        this.changeRate = changeRate;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public KucoinTickerItem withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
