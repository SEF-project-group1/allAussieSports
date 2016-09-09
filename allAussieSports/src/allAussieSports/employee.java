package allAussieSports;

import java.util.*;
import java.util.HashMap;

public class employee
{
   private String password;
   private String employeeID;
   
   public static HashMap<String, employee>  
   employees = new HashMap<String, employee>();
   
   employee(String id,String pword){
      this.password=pword;
      this.employeeID=id;
      employees.put(id,this);
   }
   
   public String getPassword(){
      return password;
   }
   
   public String getID(){
      return employeeID;
   }
   
   public void setID(String id){
      this.employeeID=id;
   }
   
   public void setPassword(String pword){
      this.password=pword;
   }
}
