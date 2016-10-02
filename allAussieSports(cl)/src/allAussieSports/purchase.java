package allAussieSports;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.HashMap;

public class purchase
{
   public HashMap<item,Integer> 
      cart= new HashMap<item,Integer>();
   public static ArrayList<purchase> 
      purchases= new ArrayList<purchase>();
   static int totalPurchases;
   private int cartQuantity;
   String purchaseCode;
   private customer buyer;
   private LocalTime purchaseTime;
   private LocalDate purchaseDate;
   double total;
   
   purchase(customer buyer){
      this.buyer=buyer;
      purchaseCode=String.format("pur%3d", totalPurchases++);
   }
   
   /*Accessors*/
   public String getPurchaseCode(){
      return purchaseCode;
   }
   
   public LocalTime getPurchaseTime(){
      return this.purchaseTime;
   }
   
   public LocalDate getPurchaseDate(){
      return this.purchaseDate;
   }
   /*Mutators*/
   
   /*Methods*/
   public void addToCart(item item){
      int quan;
      if(cart.get(item)==null){
         cart.put(item,1);
      }else{
         quan=cart.get(item);
         cart.remove(item);
         cart.put(item,quan+1);
      }
      total+=item.getPrice();
   }
   
   public void removeFromCart(item item){
      int quan;
      quan=cart.get(item)-1;
      cart.remove(item);
      if(quan!=0){
         cart.put(item, quan);
      }
      total-=item.getPrice();
   }
   
   public void completePurchase(){
      purchaseTime=LocalTime.now();
      purchaseDate=LocalDate.now();
      purchases.add(this);
      
   }
   
   public void completeSale(){
      purchaseTime=LocalTime.now();
      purchaseDate=LocalDate.now();
   }
  
   
   public static HashMap<item,Integer> getSales(LocalDate startDate,LocalDate endDate,String sport){
      purchase pArray[]=new purchase[purchases.size()];
      item iArray[]=new item[item.items.size()];
      HashMap<item,Integer> hReturn=new HashMap<item,Integer>();
      int quan;
      
      pArray=(purchase[]) purchases.toArray();
      for(int i=0;i<pArray.length;i++){
            for(int k=0;k<iArray.length;k++){
               if((iArray[k].getSport().equalsIgnoreCase(sport)|| sport.equals("none"))
                     && ((pArray[i].getPurchaseDate().isAfter(startDate) && 
                           pArray[i].getPurchaseDate().isBefore(endDate)) || 
                           pArray[i].getPurchaseDate().isEqual(startDate) ||
                           pArray[i].getPurchaseDate().isEqual(endDate))){
                  if(!hReturn.containsKey(iArray[k])){
                     hReturn.put(iArray[k], 1);
                  }else{
                     quan=hReturn.get(iArray[k])+1;
                     hReturn.remove(iArray[k]);
                     hReturn.put(iArray[k], quan);
                  }
            }
         }
      }
      return hReturn;
   }
}
