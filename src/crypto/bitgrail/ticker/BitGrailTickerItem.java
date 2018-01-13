package crypto.bitgrail.ticker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"success", "response"})
public class BitGrailTickerItem implements Serializable
{
  @JsonProperty("success")
  private String success;
  @JsonProperty("response")
  private BitGrailResponse response;
  private static final long serialVersionUID = -4702122734740503812L;
  
  public BitGrailTickerItem() {}
  
  @JsonProperty("success")
  public String getSuccess()
  {
    return success;
  }
  
  @JsonProperty("success")
  public void setSuccess(String success) {
    this.success = success;
  }
  
  public BitGrailTickerItem withSuccess(String success) {
    this.success = success;
    return this;
  }
  
  @JsonProperty("response")
  public BitGrailResponse getResponse() {
    return response;
  }
  
  @JsonProperty("response")
  public void setResponse(BitGrailResponse response) {
    this.response = response;
  }
  
  public BitGrailTickerItem withResponse(BitGrailResponse response) {
    this.response = response;
    return this;
  }
}
