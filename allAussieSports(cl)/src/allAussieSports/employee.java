package allAussieSports;

import java.util.*;
import java.util.HashMap;

public class employee
{
   private static int empTotal =0;
   private String password;
   private String employeeID;
   
   public static HashMap<String, employee>  
   employees = new HashMap<String, employee>();
   
   employee(String id,String pword){
      this.password=pword;
      this.employeeID=String.format("%s%03d", id,empTotal++);
      employees.put(this.employeeID,this);
   }
   
   /*Accessors*/
   public String getPassword(){
      return password;
   }
   
   public String getID(){
      return employeeID;
   }
   
   /*Mutators*/
   public void setID(String id){
      this.employeeID=id;
   }
   
   public void setPassword(String pword){
      this.password=pword;
   }
   
   /*Methods*/
   public static employee getEmployeeById(String id){
      return employees.get(id);
   }
}
