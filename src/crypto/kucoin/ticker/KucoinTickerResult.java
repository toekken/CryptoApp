package crypto.kucoin.ticker;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success",
    "code",
    "msg",
    "timestamp",
    "data"
})
public class KucoinTickerResult implements Serializable {

    @JsonProperty("success")
    private boolean success;
    @JsonProperty("code")
    private String code;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("data")
    private KucoinTickerItem tickerItem;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4457446960596309675L;

    @JsonProperty("success")
    public boolean isSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public KucoinTickerResult withSuccess(boolean success) {
        this.success = success;
        return this;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public KucoinTickerResult withCode(String code) {
        this.code = code;
        return this;
    }

    @JsonProperty("msg")
    public String getMsg() {
        return msg;
    }

    @JsonProperty("msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public KucoinTickerResult withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @JsonProperty("timestamp")
    public long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public KucoinTickerResult withTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @JsonProperty("data")
    public KucoinTickerItem getTickerItem() {
        return tickerItem;
    }

    @JsonProperty("data")
    public void setTickerItem(KucoinTickerItem data) {
        this.tickerItem = data;
    }

    public KucoinTickerResult withTickerItem(KucoinTickerItem data) {
        this.tickerItem = data;
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

    public KucoinTickerResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
