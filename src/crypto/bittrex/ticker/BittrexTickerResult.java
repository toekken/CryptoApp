package crypto.bittrex.ticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"success", "message", "result"})
public class BittrexTickerResult implements Serializable
{
  @JsonProperty("success")
  private String success;
  @JsonProperty("message")
  private String message;
  @JsonProperty("result")
  private BittrexTickerItem result;
  private static final long serialVersionUID = 1189243446304702190L;
  
  public BittrexTickerResult() {}
  
  @JsonProperty("success")
  public String getSuccess()
  {
    return success;
  }
  
  @JsonProperty("success")
  public void setSuccess(String success) {
    this.success = success;
  }
  
  public BittrexTickerResult withSuccess(String success) {
    this.success = success;
    return this;
  }
  
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  
  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }
  
  public BittrexTickerResult withMessage(String message) {
    this.message = message;
    return this;
  }
  
  @JsonProperty("result")
  public BittrexTickerItem getResult() {
    return result;
  }
  
  @JsonProperty("result")
  public void setResult(BittrexTickerItem result) {
    this.result = result;
  }
  
  public BittrexTickerResult withResult(BittrexTickerItem result) {
    this.result = result;
    return this;
  }
}
