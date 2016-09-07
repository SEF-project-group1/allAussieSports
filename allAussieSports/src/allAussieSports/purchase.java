package allAussieSports;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.HashMap;

public class purchase
{
   public HashMap<Integer, item> 
      cart= new HashMap<Integer,item>();
   static int totalPurchases;
   private int cartQuantity,purchaseNum;
   private customer buyer;
   LocalTime purchaseTime;
   LocalDate purchaseDate;
   double total;
   
   purchase(customer buyer){
      this.buyer=buyer;
      purchaseNum=totalPurchases++;
   }
   
   /*Accessors*/
   public int getPurchaseNum(){
      return purchaseNum;
   }
   
   /*Mutators*/
   
   /*Methods*/
   public void addToCart(item item){
      cart.put(cartQuantity++,item);
      total+=item.getPrice();
   }
   
   public void removeFromCart(int cartNum){
      cart.remove(cartNum);
   }
   
   public void completePurchase(){
      purchaseTime=LocalTime.now();
      purchaseDate=LocalDate.now();
      
   }
   
   
}
