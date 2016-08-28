package allAussieSports;

public class employee
{
   private String password;
   private String employeeID;
   
   employee(String id,String pword){
      this.password=pword;
      this.employeeID=id;
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
