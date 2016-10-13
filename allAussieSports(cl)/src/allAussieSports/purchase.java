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
      boolean sportMatch;
      int quan;
      
      iArray=item.items.toArray(iArray);
      pArray= purchases.toArray(pArray);
      for(int i=0;i<pArray.length;i++){
            for(int k=0;k<iArray.length;k++){
               sportMatch=false;
               if(iArray[k].getSport()!=null){
                  if(iArray[k].getSport().equalsIgnoreCase(sport)){
                     sportMatch=true;
                  }
               }
               if((sportMatch==true|| sport.equals("none"))
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
   
   public static HashMap<item,Integer> getHighestItem(HashMap<item,Integer> checkItems){
      double highest=0;
      HashMap<item,Integer> highestItem=new HashMap<item,Integer>();
      item[] iList = new item[item.items.size()];
      
      iList=item.items.toArray(iList);
      
      for(int i=0;i<item.items.size();i++){
         if(checkItems.get(iList[i])*iList[i].getPrice()>highest){
            highestItem.clear();
            highest=checkItems.get(iList[i])*iList[i].getPrice();
            highestItem.put(iList[i],checkItems.get(iList[i]));
         }
      }
      return highestItem;
   }
}
