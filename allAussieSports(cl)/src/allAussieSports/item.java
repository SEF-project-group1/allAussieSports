package allAussieSports;

import java.util.*;

public class item
{
   private final static String itemConst="itm";
   public static ArrayList<item> items= new ArrayList<item>();
   private String itemCode,sport;
   private int stock=0,bulkDiscQuan=99999999,reOrderQuan=0;
   private double price=0.00,discPrice=0.00,bulkDiscPrice=0.00;
   private String itemName;
   private supplier supplier;
   private static int itemsTotal=0;
   
   item(String itemName){
      itemCode=String.format("%s%03d",itemConst,itemsTotal);
      this.itemName=itemName;
      items.add(this);
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
   
   public supplier getSupplier(){
      return supplier;
   }
   
   public String getSport(){
      return this.sport;
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
   
   public void setSupplier(supplier sup){
      this.supplier=sup;
   }
   
   public void setSport(String sport){
      this.sport=sport;
   }
   
   /*Methods*/
   public void addStock(int add){
      setStock(add+getStock());
   }
   
   public static item getItemByCode(String iCode){
      item iList[]=new item[items.size()];
      item returnI = null;
      
      for(int i=0;i<iList.length;i++){
         if(iList[i].itemCode.equals(iCode)){
            returnI=iList[i];
            break;
         }
      }
      return returnI;
   }
   
   public static ArrayList getItemByName(String name){
      ArrayList<item> itemMatch=new ArrayList<item>();
      item iList[]=new item[items.size()];
      
      iList=(item[]) items.toArray();
      for(int i=0;i<iList.length;i++){
         if(iList[i].itemName.compareToIgnoreCase(name)<3){
            itemMatch.add(iList[i]);
         }
      }
      
      return itemMatch;
   }
   
}
