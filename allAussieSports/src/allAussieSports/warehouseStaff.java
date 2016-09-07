package allAussieSports;

import java.util.*;
import java.util.HashMap;

public class warehouseStaff extends employee
{
   warehouseStaff(String id,String pword){
      super(id,pword);
   }
   
   public String getPassword(){
      return super.getPassword();
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
