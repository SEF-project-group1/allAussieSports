package allAussieSports;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class supplier
{
   private String supplierID,name,contactName,contactNumber,address;
   
   public static HashMap<String, supplier>  
   suppliers = new HashMap<String, supplier>();
   
   supplier(String id,String name){
      this.supplierID=id;
      this.name=name;
      suppliers.put(id, this);
   }
   
   /*Accessors*/
   public String getSupplierID(){
      return supplierID;
   }
   
   public String getName(){
      return name;
   }
   
   public String getContactName(){
      return contactName;
   }
   
   public String getContactNumber(){
      return contactNumber;
   }
   
   public String getAddress(){
      return address;
   }
   
   /*Mutators*/
   public void setSupplierID(String id){
      this.supplierID=id;
   }
   
   public void setName(String name){
      this.name=name;
   }
   
   public void setContactName(String name){
      this.contactName=name;
   }
   
   public void setContactNumber(String number){
      this.contactNumber=number;
   }
   
   public void setAddress(String address){
      this.address=address;
   }
   
}
