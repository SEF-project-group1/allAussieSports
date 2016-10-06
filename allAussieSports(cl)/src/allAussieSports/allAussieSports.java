package allAussieSports;

import java.util.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class allAussieSports{
   private static Scanner s=new Scanner(System.in);
   
   
   public static void main(String[] args)
   {
      String selection;
      boolean condition=false;

      
      do{
         System.out.printf("Menu options:\n(n)ew object\n(c)ustomer\n" +
               "(s)ales staff\n(w)arehouse staff\n(m)anager\ne(x)it\n");
         selection=s.nextLine();
      
         switch(selection.charAt(0)){
            case 'c':
               System.out.printf("See gui version\n");
               break;
            case 's':
               System.out.printf("Not yet implemented, due to customer options" +
                     " being required\n");
               break;
            case 'w':
               warehouseOptions();
               break;
            case 'm':
               managerOptions();
               break;
            case 'x':
               condition=true;
               break;
            case 'n':
               createNew();
               break;
            default:
               System.out.printf("Invalid input\n");
      
         }
      }while(condition==false);
     s.close();  
   }
   public static void warehouseOptions(){
      int increase;
      boolean wCondition=false;
      String iCode,id,pWord;
      
      do{
         System.out.printf("Enter your employee ID\n");
         id=s.nextLine();
         if(employee.getEmployeeById(id).isLoggedIn()!=true){
            System.out.printf("Enter your password\n");
            pWord=s.nextLine();
         
            if(pWord.equals(employee.getEmployeeById(id).getPassword())
                  && employee.getEmployeeById(id) instanceof warehouseStaff){
               wCondition=true;
            }else{
               System.out.printf("Invalid login\n");
            }
         }
      }while(wCondition==false);
      
      wCondition=false;
      do{
         System.out.printf("Enter code of item to be increased, l to log out," +
               " or x to exit\n");
         iCode=s.nextLine();
         if(iCode.equalsIgnoreCase("x")){
            wCondition=true;
            break;
         }else if(iCode.equalsIgnoreCase("l")){
            
         }
         System.out.printf("Enter amount to increase\n");
         increase=s.nextInt();
         s.nextLine();
         item.getItemByCode(iCode).addStock(increase);
      }while(wCondition==false);
   }
   
   public static void managerOptions(){
      String selection;
      boolean mCondition=false;
      String id,pWord;
      
      do{
         System.out.printf("Enter your employee ID\n");
         id=s.nextLine();
         if(employee.getEmployeeById(id).isLoggedIn()==false){
            System.out.printf("Enter your password\n");
            pWord=s.nextLine();
         
         
            if(pWord.equals(employee.getEmployeeById(id).getPassword())
                  && employee.getEmployeeById(id) instanceof manager){
               mCondition=true;
               employee.getEmployeeById(id).logIn();
            }else{
               System.out.printf("Invalid login\n");
            }
         }
      }while(mCondition==false);
      
      mCondition=false;
      do{
         System.out.printf("(a)lter, (c)heck, (r)eports, (l)og out or e(x)it\n");
         selection=s.nextLine();
         switch(selection.charAt(0)){
         case 'a':
            managerAlter();
            break;
         case 'c':
            managerCheck();
            break;
         case 'x':
            mCondition=true;
            break;
         case 'r':
            salesReport();
            break;
         case 'l':
            employee.getEmployeeById(id).logOut();
            mCondition=true;
            break;
         default:
            System.out.printf("Invalid entry\n");
         }
      }while(mCondition==false);
   }
   
   public static void managerCheck(){
      int selection,checki;
      boolean cCondition=false;
      double checkd=0.00;
      item i;
      
      
      do{
         System.out.printf("Enter code of item you wish to check\n");
         i=item.getItemByCode(s.nextLine());
         System.out.printf("Check\n1.Price\n2.DiscPrice\n3.BulkDiscPrice\n" +
               "4.BulkQuan\n5.ReOrderQuan\n6.Stock\n7.Name\n8.Supplier\n0.Exit\n");
         selection=Integer.parseInt(s.nextLine());
         switch(selection){
         case 1:
            checkd=i.getPrice();
            System.out.printf("Price equals %.2f\n",checkd);
            break;
         case 2:
            checkd=i.getDiscPrice();
            System.out.printf("DiscPrice equals %.2f\n",checkd);
            break;
         case 3:
            checkd=i.getBulkDiscPrice();
            System.out.printf("BulkDiscPrice equals %.2f\n",checkd);
            break;
         case 4:
            checki=i.getBulkDiscQuan();
            System.out.printf("BulkDiscQuan equals %d\n",checki);
            break;
         case 5:
            checki=i.getReOrderQuan();
            System.out.printf("ReOrderQuan equals %d\n",checki);
            break;
         case 6:
            checki=i.getStock();
            System.out.printf("Stock equals %d\n",checki);
            break;
         case 7:
            System.out.printf("Item name is: %s\n", i.getItemName());
            break;
         case 8:
            System.out.printf("Supplier is: %s\n", i.getSupplier().getName());
            break;
         case 0:
            cCondition=true;
            break;
         default:
            System.out.printf("Invalid entry\n");
         }
      }while(cCondition==false);
   }
   
   public static void managerAlter(){
      int selection=0,newInt=0;
      boolean aCondition=false;
      double newDouble=0.00;
      item i;
      String newName="";
      
      do{
         System.out.printf("Enter code of item you wish to alter\n");
         i=item.getItemByCode(s.nextLine());
         System.out.printf("Alter\n1.Price\n2.DiscPrice\n3.BulkDiscPrice\n" +
               "4.BulkQuan\n5.ReOrderQuan\n6.Stock\n7.Name\n8.Supplier\n0.Exit\n");
         selection=Integer.parseInt(s.nextLine());
         if (selection!='x'){
         System.out.printf("Set new value to what\n");
            if(selection==7){
               newName=s.nextLine();
            }else if(4<=selection && selection<7){
               newInt=s.nextInt();
            }else if (0<selection && selection<4){
               newDouble=Double.parseDouble(s.nextLine());
            }else if(selection==8){
               System.out.printf("Enter supplier id\n");
               newName=s.nextLine();
            }
         }
         switch(selection){
         case 1:
            i.setPrice(newDouble);
            System.out.printf("Price now equals: $%f\n", newDouble);
            break;
         case 2:
            i.setDiscPrice(newDouble);
            System.out.printf("DiscPrice now equals: $%f\n", newDouble);
            break;
         case 3:
            i.setBulkDiscPrice(newDouble);
            System.out.printf("BulkDiscPrice now equals: $%f\n", newDouble);
            break;
         case 4:
            i.setBulkDiscQuan(newInt);
            System.out.printf("BulkDiscQuan now equals: $%d\n", newInt);
            break;
         case 5:
            i.setReOrderQuan(newInt);
            System.out.printf("ReOrderQuan now equals: %d\n", newInt);
            break;
         case 6:
            i.setStock(newInt);
            System.out.printf("Stock now equals: %d\n", newInt);
            break;
         case 7:
            i.setItemName(newName);
            System.out.printf("Item name is %s\n", newName);
            break;
         case 8:
            i.setSupplier(supplier.getSupplierByID(newName));
            System.out.printf("Supplier is now name is %s\n", 
                              supplier.getSupplierByID(newName).getName());
            break;
         case 0:
            aCondition=true;
            break;
         default:
            System.out.printf("Invalid entry\n");
         }
      }while(aCondition==false);
   }
   
   public static void createNew(){
      char selection;
      boolean cCondition=false;
      String pWord=null;
      
      do{
         System.out.printf("Create (c)ustomer, (s)ales staff, (w)arehouse staff" +
               "(m)anager, (i)tem, s(u)pplier or e(x)it\n");
         selection=s.nextLine().charAt(0);
         if(selection=='i'){
            System.out.printf("Please enter item name\n");
            pWord=s.nextLine();
         }else if(selection=='w'|| selection=='s' || selection=='m'){
            System.out.printf("Please enter password\n");
            pWord=s.nextLine();
         }else if(selection=='c' || selection=='u'){
            System.out.printf("Please enter name\n");
            pWord=s.nextLine();
         }
         switch(selection){
         case 's':
            new salesStaff(pWord);
            System.out.printf("New manager created\n");
            break;
         case 'w':
            new warehouseStaff(pWord);
            System.out.printf("New warehouse staff created\n");
            break;
         case 'm':
            new manager(pWord);
            System.out.printf("New manager created\n");
            break;
         case 'c':
            new customer(pWord);
            System.out.printf("New customer created\n");
            break;
         case 'i':
            new item(pWord);
            System.out.printf("New item created\n");
            break;
         case 'u':
            new supplier(pWord);
            System.out.printf("New supplier created\n");
            break;
         case 'x':
            cCondition=true;
            break;
         default:
            System.out.printf("Invalid entry\n");
         }
      }while(cCondition==false);
   }
   
   public static void salesReport(){
      LocalDate startDate,endDate;
      String year,month,day,sport;
      HashMap<item,Integer> highest =new HashMap<item,Integer>();
      HashMap<item,Integer> sales =new HashMap<item,Integer>();
      item iList[]=new item[item.items.size()],itm;
      double total=0;
      
      iList=(item[])item.items.toArray();
      
      System.out.printf("Generate sales report\n" +
            "What date would you like to start the report?\n");
      System.out.printf("What year?\n");
      year=s.nextLine();
      System.out.printf("What month (by number)?\n");
      month=s.nextLine();
      System.out.printf("What year?\n");
      day=s.nextLine();
      startDate=LocalDate.parse(String.format("%s-%s-%s", year,month,day));
      
      System.out.printf("What date would you like the report to end?\n");
      System.out.printf("What year?\n");
      year=s.nextLine();
      System.out.printf("What month (by number)?\n");
      month=s.nextLine();
      System.out.printf("What year?\n");
      day=s.nextLine();
      endDate=LocalDate.parse(String.format("%s-%s-%s", year,month,day));
      
      
      System.out.printf("Would you like to focus on a specific sport?\n" +
            "(Press enter or type \"none\" if not\n");
      sport=s.nextLine();
      
      if(sport==""){
         sport="none";
      }
      
      sales=purchase.getSales(startDate, endDate, sport);
      highest=purchase.getHighestItem(sales);
      new salesReport(startDate,endDate,sport);
      
      sport=sport.substring(0,1).toUpperCase() + sport.substring(1);
      System.out.printf("Sales report.\nDates: %s - %s.\nRelevant Sport: %s.\n\n",
            startDate.toString(),endDate.toString(),sport);
      System.out.printf("Item Code | Name   | Sport| Price| Quantity | Total ");
      for(int i=0;i<item.items.size();i++){
         itm=iList[i];
         if(sales.get(itm)!=null){
            total+=sales.get(itm)*itm.getPrice();
            System.out.printf(" $s   | %s | %s | $%02.2f | %d     | $%03.2f",
                              itm.getItemCode(),itm.getItemName(),itm.getSport(),
                              itm.getPrice(),sales.get(itm),sales.get(itm)*itm.getPrice());
            if(highest.get(itm)!=null){
               System.out.print("*");
            }
            System.out.printf("\n");
         }
      }
      System.out.printf("                                            %03.2f\n", total);
      System.out.printf("\nHighest selling item marked with *");
      
   }

}
