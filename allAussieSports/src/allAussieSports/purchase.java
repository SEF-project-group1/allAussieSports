package allAussieSports;

public class purchase
{
   private String purchaseID;
   
   purchase(String id){
      this.purchaseID=id;
   }
   
   /*Accessors*/
   public String getPurchaseID(){
      return purchaseID;
   }
   
   /*Mutators*/
   public void setPurchaseID(String id){
      this.purchaseID=id;
   }
   
}
