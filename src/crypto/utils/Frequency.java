package crypto.utils;



public enum Frequency
{
  TEN_SECONDS("10 seconds", 10000L),  THIRTY_SECONDS("30 seconds", 30000L),  ONE_MINUTE("1 minute", 60000L),  TEN_MINUTES("10 minutes", 600000L),  THIRTY_MINUTES("30 minutes", 1800000L);
  
  private String label;
  private long millis;
  
  private Frequency(String label, long millis) {
    this.label = label;
    this.millis = millis;
  }
  
  public static String[] getFrequencies() {
    String[] result = new String[values().length];
    for (int i = 0; i < values().length; i++) {
      result[i] = values()[i].getLabel();
    }
    return result;
  }
  
  public static Frequency valueOfLabel(String label) {
    Frequency rtn = null;
    for (Frequency frequency : values()) {
      if (frequency.getLabel().equals(label)) {
        rtn = frequency;
        break;
      }
    }
    return rtn;
  }
  
  public String getLabel() {
    return label;
  }
  
  public void setLabel(String label) {
    this.label = label;
  }
  
  public long getMillis() {
    return millis;
  }
  
  public void setMillis(long millis) {
    this.millis = millis;
  }
}
