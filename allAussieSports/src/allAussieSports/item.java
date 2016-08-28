package allAussieSports;

public class item
{
   private String itemCode;
   private int stock,bulkDiscQuan,reOrderQuan;
   private double price,discPrice,bulkDiscPrice;
   
   item(String code){
      this.itemCode=code;
   }
   
   /*Accessors*/
   public String getItemCode(){
      return itemCode;
   }
   
   public int getStock(){
      return stock;
   }
   
   public int getBulkDiscountQuan(){
      return bulkDiscQuan;
   }
   
   public int getReOrderQuan(){
      return reOrderQuan;
   }
   
   public double getPrice(){
      return price;
   }
   
   public double getDiscountPrice(){
      return discPrice;
   }
   
   public double getBulkDiscPrice(){
      return bulkDiscPrice;
   }
   
   /*Mutators*/
   public void setItemCode(String code){
      this.itemCode=code;
   }
   
   public void setStock(int stock){
      this.stock=stock;
   }
   
   public void setBulkDiscountQuan(int quan){
      this.bulkDiscQuan=quan;
   }
   
   public void setReOrderQuan(int quan){
      this.reOrderQuan=quan;
   }
   
   public void setPrice(double price){
      this.price=price;
   }
   
   public void setDiscountPrice(double price){
      this.discPrice=price;
   }
   
   public void setBulkDiscPrice(double price){
      this.bulkDiscPrice=price;
   }
}
