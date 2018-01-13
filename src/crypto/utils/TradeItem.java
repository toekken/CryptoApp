package crypto.utils;


public class TradeItem
{
  private double cost;
  
  private double quantity;
  
  public TradeItem() {}
  
  public double getCost()
  {
    return cost;
  }
  
  public void setCost(double cost) {
    this.cost = cost;
  }
  
  public double getQuantity() {
    return quantity;
  }
  
  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }
  
  public String toString()
  {
    return cost + "_" + quantity;
  }
}
