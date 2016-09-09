package allAussieSports;

import java.util.*;

public class item
{
   private final static String itemConst="itm";
   
   private String itemCode;
   private int stock,bulkDiscQuan,reOrderQuan;
   private double price,discPrice,bulkDiscPrice;
   private String itemName;
   private static int itemsTotal=0;
   
   public static HashMap<String, item>  
   items = new HashMap<String, item>();
   
   item(String itemName){
      itemCode=String.format("%s%3d",itemConst,itemsTotal);
      this.itemName=itemName;
      items.put(itemCode,this);
   }
   
   /*Accessors*/
   public String getItemCode(){
      return itemCode;
   }
   
   public int getStock(){
      return stock;
   }
   
   public int getBulkDiscQuan(){
      return bulkDiscQuan;
   }
   
   public int getReOrderQuan(){
      return reOrderQuan;
   }
   
   public double getPrice(){
      return price;
   }
   
   public double getDiscPrice(){
      return discPrice;
   }
   
   public double getBulkDiscPrice(){
      return bulkDiscPrice;
   }
   
   public String getItemName(){
      return itemName;
   }
   
   /*Mutators*/
   public void setItemCode(String code){
      this.itemCode=String.format("%s%3d",itemConst,code);
   }
   
   public void setStock(int stock){
      this.stock=stock;
   }
   
   public void setBulkDiscQuan(int quan){
      this.bulkDiscQuan=quan;
   }
   
   public void setReOrderQuan(int quan){
      this.reOrderQuan=quan;
   }
   
   public void setPrice(double price){
      this.price=price;
   }
   
   public void setDiscPrice(double price){
      this.discPrice=price;
   }
   
   public void setBulkDiscPrice(double price){
      this.bulkDiscPrice=price;
   }
   
   public void setItemName(String name){
      itemName=name;
   }
   
   /*Methods*/
   public void addStock(int add){
      setStock(add+getStock());
   }
   
   public static item getItemByCode(String iCode){
      return items.get(iCode);
   }
   
   public static item getItemByName(String name){
      item itemMatch= new item("Invalid");
      for(Map.Entry<String, item> entry: items.entrySet()){
         if(entry.getValue().getItemName().toLowerCase()
               .equals(name.toLowerCase())){
            itemMatch=entry.getValue();
         }
      }
      return itemMatch;
   }
   
}
