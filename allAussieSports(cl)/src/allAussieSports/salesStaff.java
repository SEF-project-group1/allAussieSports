package allAussieSports;

import java.util.*;
import java.util.HashMap;

public class salesStaff extends employee
{
   private final static String salesConst = "ess";
   
   salesStaff(String pword){
      super(salesConst,pword);
   }
   
   /*Accessors*/
   public String getPassword(){
      return super.getPassword();
   }
   
   public String getID(){
      return super.getID();
   }
   
   /*Mutators*/
   public void setID(String id){
      super.setID(id);
   }
   
   public void setPassword(String pword){
      super.setPassword(pword);
   }
   
   /*Methods*/

   
}
