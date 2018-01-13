package crypto.cryptopia.ticker;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Success", "Message", "Data", "Error"})
public class CryptopiaTickerResult
  implements Serializable
{
  @JsonProperty("Success")
  private boolean success;
  @JsonProperty("Message")
  private Object message;
  @JsonProperty("Data")
  private CryptopiaTickerItem data;
  @JsonProperty("Error")
  private Object error;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap();
  private static final long serialVersionUID = -6596243890234005579L;
  
  public CryptopiaTickerResult() {}
  
  @JsonProperty("Success")
  public boolean isSuccess() { return success; }
  
  @JsonProperty("Success")
  public void setSuccess(boolean success)
  {
    this.success = success;
  }
  
  public CryptopiaTickerResult withSuccess(boolean success) {
    this.success = success;
    return this;
  }
  
  @JsonProperty("Message")
  public Object getMessage() {
    return message;
  }
  
  @JsonProperty("Message")
  public void setMessage(Object message) {
    this.message = message;
  }
  
  public CryptopiaTickerResult withMessage(Object message) {
    this.message = message;
    return this;
  }
  
  @JsonProperty("Data")
  public CryptopiaTickerItem getData() {
    return data;
  }
  
  @JsonProperty("Data")
  public void setData(CryptopiaTickerItem data) {
    this.data = data;
  }
  
  public CryptopiaTickerResult withData(CryptopiaTickerItem data) {
    this.data = data;
    return this;
  }
  
  @JsonProperty("Error")
  public Object getError() {
    return error;
  }
  
  @JsonProperty("Error")
  public void setError(Object error) {
    this.error = error;
  }
  
  public CryptopiaTickerResult withError(Object error) {
    this.error = error;
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
  
  public CryptopiaTickerResult withAdditionalProperty(String name, Object value) {
    additionalProperties.put(name, value);
    return this;
  }
}
