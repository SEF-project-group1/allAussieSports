package allAussieSports;

import java.util.*;
import java.util.HashMap;

public class warehouseStaff extends employee
{
   private final static String warehouseConst="wrh";
   
   warehouseStaff(String pword){
      super(warehouseConst,pword);
   }
   
   public String getPassword(){
      return super.getPassword();
   }
   
   public static String getConst(){
      return employee.getConst(warehouseConst);
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
