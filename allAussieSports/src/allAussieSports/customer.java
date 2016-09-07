package allAussieSports;

import java.util.*;
import java.util.HashMap;

public class customer
{
   private String userID,cardNumber;
   private int loyaltyPoints;
   
   public static HashMap<String, customer>  
   customers = new HashMap<String, customer>();
   
   customer(String id,String cardNumber){
      this.userID=id;
      this.cardNumber=cardNumber;
      loyaltyPoints=0;
      customers.put(id, this);
   }
   
   /*Accessors*/
   public String getUserID(){
      return userID;
   }
   
   public String getCardNumber(){
      return cardNumber;
   }
   public int getLoyaltyPoints(){
      return loyaltyPoints;
   }
      
   /*Mutators*/
   public void setUserID(String id){
      this.userID=id;
   }
   
   public void setCardNumber(String cNumber){
      this.cardNumber=cNumber;
   }
   
   public void setLoyaltyPoints(int points){
      this.loyaltyPoints=points;
   }
   
   /*Methods*/
   
   
   
}
