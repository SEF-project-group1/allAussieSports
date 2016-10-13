package allAussieSports;

import java.util.*;
import java.util.HashMap;

public class manager extends employee
{
   private final static String manConst="man";
   
   manager(String pword){
      super(manConst,pword);
   }
   
   public String getPassword(){
      return super.getPassword();
   }
   
   public static String getConst(){
      return employee.getConst(manConst);
   }
   
   public String getID(){
      return super.getID();
   }
   
   public void setID(String id){
      super.setID(id);
   }
   
   public void setPassword(String pword){
      super.setPassword(pword);
   }
}
