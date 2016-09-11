package allAussieSports;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class supplier
{
   private static final String supConst = "sup";
   
   private String supplierID,name,contactName,contactNumber,address;
   private static int supTotal=0;
   
   public static HashMap<String, supplier>  
   suppliers = new HashMap<String, supplier>();
   
   supplier(String name){
      this.supplierID=String.format("%s%03d", supConst,supTotal);
      this.name=name;
      suppliers.put(supplierID, this);
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
   
   /*Methods*/
   public static supplier getSupplierByID(String id){
      return suppliers.get(id);
   }
   
   public static supplier getSupplierByName(String name){
      supplier supMatch= new supplier("Invalid");
      for(Map.Entry<String, supplier> entry: suppliers.entrySet()){
         if(entry.getValue().getName().toLowerCase()
               .equals(name.toLowerCase())){
            supMatch=entry.getValue();
         }
      }
      return supMatch;
   }
   
}
