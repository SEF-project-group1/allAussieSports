package allAussieSports;

import java.util.*;
import java.util.HashMap;

public class customer
{
   private final static String custConst="cus";
   private static final String cardConst="car";
   
   private String customerID,cardID,name;
   private int loyaltyPoints;
   private static int custTotal=0;
   
   public static HashMap<String, customer>  
   customers = new HashMap<String, customer>();
   
   customer(String name){
      customerID=String.format("%s%03d", custConst,custTotal);
      cardID=String.format("%s%03d", custConst,custTotal++);
      this.name=name;
      loyaltyPoints=0;
      customers.put(customerID, this);
   }
   
   /*Accessors*/
   public static String getConst(){
      return custConst;
   }
   
   public static String getCardConst(){
      return cardConst;
   }
   
   public static int getCustTotal(){
      return custTotal;
   }
   
   public static String getcardConst(){
      return cardConst;
   }
   
   public String getUserID(){
      return customerID;
   }
   
   public String getName(){
      return name;
   }
   
   public String getCardNumber(){
      return cardID;
   }
   public int getLoyaltyPoints(){
      return loyaltyPoints;
   }
      
   /*Mutators*/
   public void setUserID(String id){
      this.customerID=id;
   }
   
   public void setCardNumber(String cnum){
      this.cardID=String.format("%s%3d",custConst,cnum);
   }
   
   public void setLoyaltyPoints(int points){
      this.loyaltyPoints=points;
   }
   
   public void setName(String name){
      this.name=name;
   }
   
   /*Methods*/
   
   
   
}
