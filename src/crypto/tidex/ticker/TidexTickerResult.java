package crypto.tidex.ticker;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public class TidexTickerResult implements Serializable
{
  @JsonIgnore
  private Map<String, TidexTickerItem> tickerItems = new HashMap();
  private static final long serialVersionUID = -1842840465405612770L;
  
  public TidexTickerResult() {}
  
  @JsonAnyGetter
  public Map<String, TidexTickerItem> getTickerItems() {
    return tickerItems;
  }
  
  @com.fasterxml.jackson.annotation.JsonAnySetter
  public void setTickerItems(String name, TidexTickerItem value) {
    tickerItems.put(name, value);
  }
  
  public TidexTickerItem getTickerItem(String key) {
    return (TidexTickerItem)tickerItems.get(key);
  }
}
