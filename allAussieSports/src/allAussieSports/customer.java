package allAussieSports;

public class customer
{
   private String userID,cardNumber;
   private int loyaltyPoints;
   
   customer(String id,String cardNumber){
      this.userID=id;
      this.cardNumber=cardNumber;
      loyaltyPoints=0;
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
   
}
