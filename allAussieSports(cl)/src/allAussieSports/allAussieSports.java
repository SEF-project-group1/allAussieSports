package allAussieSports;

import java.util.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class allAussieSports{
   public static Scanner s=new Scanner(System.in);
   
   
   public static void main(String[] args)
   {
      String selection;
      boolean condition=false;

      seed.seedProgram();
      do{
         System.out.printf("Menu options:\n(n)ew object\n(c)ustomer\n" +
               "(w)arehouse staff\n(m)anager\ne(x)it\n");
         selection=s.nextLine();
      
         switch(selection.charAt(0)){
            case 'c':
               checkout();
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
         System.out.printf("Enter your employee ID or x to exit\n");
         id=s.nextLine();
         if(id.equalsIgnoreCase("x")){
            wCondition=true;
            return;
         }
         try
         {
            if(employee.getEmployeeById(id).isLoggedIn()!=true);
         }
         catch (Exception e)
         {
            System.out.println("Invalid entry");
         }
         
         {
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
         System.out.printf("Enter your employee ID or x to exit\n");
         id=s.nextLine();
         if(id.equalsIgnoreCase("x")){
            mCondition=true;
            return;
         }
         try
         {
            if(employee.getEmployeeById(id).isLoggedIn()==false);
         }
         catch (Exception e)
         {
            System.out.println("Invalid entry");
            continue;
         }
         
         {
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
         System.out.printf("(a)lter, (c)heck, (r)eports, (s)upplier options " +
               "(l)og out or e(x)it\n");
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
         case 's':
            managerSuppOptions();
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
         if (i == null){
            System.out.println("Item not found");
               return;
         }
         
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
         if (i == null) {
            System.out.println("Item not found");
            return;
         }
         
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
            System.out.printf("Price now equals: $%.2f\n", newDouble);
            break;
         case 2:
            i.setDiscPrice(newDouble);
            System.out.printf("DiscPrice now equals: $%.2f\n", newDouble);
            break;
         case 3:
            i.setBulkDiscPrice(newDouble);
            System.out.printf("BulkDiscPrice now equals: $%.2f\n", newDouble);
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
   
   public static void managerSuppOptions(){
      String inputStr;
      supplier supp=null;
      boolean condition=false;
      int selection;
      
      while(condition==false){
         System.out.println("Please enter the code of the supplier you wish" +
               " to alter or x to exit");
         inputStr=s.nextLine();
         
         if(inputStr.equalsIgnoreCase("x")){
            return;
         }
         supp=supplier.getSupplierByID(inputStr);
         if(supp == null){
            System.out.println("Invalid entry try again");
            continue;
         }
         condition=false;
         while(condition==false){
            System.out.println("What would you like to do?\n" +
                  "1.Get name\n2.Get contact number\n3.Get address\n" +
                  "4.Set name\n5.Set contact number\n6.Set address" +
                  "\n0.Exit");
            try{
            selection=Integer.parseInt(inputStr=s.nextLine());
            }catch(NumberFormatException e){
               System.out.println("Invalid entry, try again");
               continue;
            }
            switch(selection){
            case 1:
               System.out.printf("Supplier name is %s\n",supp.getName());
               continue;
            case 2:
               System.out.printf("Supplier contact number is %s\n",supp.getContactNumber());
               continue;
            case 3:
               System.out.printf("Supplier address is %s\n",supp.getAddress());
               continue;
            case 4:
               System.out.println("What is the new supplier name?");
               inputStr=s.nextLine();
               supp.setName(inputStr);
               System.out.printf("New supplier name is %s\n",supp.getName());
               continue;
            case 5:
               System.out.println("What is the new supplier contact number?");
               inputStr=s.nextLine();
               supp.setContactNumber(inputStr);
               System.out.printf("New supplier name is %s\n",supp.getName());
               continue;
            case 6:
               System.out.println("What is the new supplier address?");
               inputStr=s.nextLine();
               supp.setAddress(inputStr);
               System.out.printf("New supplier address is %s\n",supp.getAddress());
               continue;
            case 0:
               System.out.println("Exiting");
               return;
            default:
               System.out.println("Invalid entry, try again");
               continue;
            }
         }
      }
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
            System.out.printf("New sales staff created\n");
            System.out.printf("Your id is: %s%03d\n",salesStaff.getConst(),employee.getEmpTotal()-1);
            break;
         case 'w':
            new warehouseStaff(pWord);
            System.out.printf("New warehouse staff created\n");
            System.out.printf("Your id is: %s%03d\n",warehouseStaff.getConst(),employee.getEmpTotal()-1);
            break;
         case 'm':
            new manager(pWord);
            System.out.printf("New manager created\n");
            System.out.printf("Your id is: %s%03d\n",manager.getConst(),employee.getEmpTotal()-1);
            break;
         case 'c':
            new customer(pWord);
            System.out.printf("New customer created\n");
            System.out.printf("Your customer id is: %s%03d and you card id is: %s%03d\n",
                              customer.getConst(),customer.getCustTotal()-1,
                              customer.getCardConst(),customer.getCustTotal()-1);
            break;
         case 'i':
            new item(pWord);
            System.out.printf("New item created\n");
            System.out.printf("Item id is: %s%03d\n",item.getConst(),item.getItemsTotal()-1);
            break;
         case 'u':
            new supplier(pWord);
            System.out.printf("New supplier created\n");
            System.out.printf("Your id is: %s%03d\n",supplier.getConst(),supplier.getSupTotal()-1);
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
      
      iList=item.items.toArray(iList);
      
      System.out.printf("Generate sales report\n" +
            "What date would you like to start the report?\n");
      System.out.printf("What year?\n");
      year=s.nextLine();
      System.out.printf("What month (by number)?\n");
      month=s.nextLine();
      System.out.printf("What day?\n");
      day=s.nextLine();
      try {
      startDate=LocalDate.parse(String.format("%s-%s-%s", year,month,day));
      } catch (Exception e) {
         System.out.println("Invalid entry");
         return;
      }
      System.out.printf("What date would you like the report to end?\n");
      System.out.printf("What year?\n");
      year=s.nextLine();
      System.out.printf("What month (by number)?\n");
      month=s.nextLine();
      System.out.printf("What day?\n");
      day=s.nextLine();
      try {
      endDate=LocalDate.parse(String.format("%s-%s-%s", year,month,day));
      } catch (Exception e) {
         System.out.println("Invalid entry");
         return;
      }
      
      System.out.printf("Would you like to focus on a specific sport?\n" +
            "(Press enter or type \"none\" if not)\n");
      sport=s.nextLine();
      
      if(sport==""){
         sport="none";
      }
      try {
      sales=purchase.getSales(startDate, endDate, sport);
      highest=purchase.getHighestItem(sales);
      new salesReport(startDate,endDate,sport);
      } catch (Exception e) {
         System.out.println("Invalid date format. Please try again");
         return;
      }
      sport=sport.substring(0,1).toUpperCase() + sport.substring(1);
      System.out.printf("Sales report.\nDates: %s - %s.\nRelevant Sport: %s.\n\n",
            startDate.toString(),endDate.toString(),sport);
      System.out.printf("Item Code |     Name     |   Sport  |" +
            " Price | Quantity |  Total \n");
      for(int i=0;i<item.items.size();i++){
         itm=iList[i];
         if(sales.get(itm)!=null){
            total+=sales.get(itm)*itm.getPrice();
            System.out.printf(" $%s   | %s | %s | $%02.2f | %d     | $%03.2f",
                              itm.getItemCode(),itm.getItemName(),itm.getSport(),
                              itm.getPrice(),sales.get(itm),sales.get(itm)*itm.getPrice());
            if(highest.get(itm)!=null){
               System.out.print("*");
            }
            System.out.printf("\n");
         }
      }
      System.out.printf("                                  " +
            "       Total Sales:  $%03.2f\n", total);
      System.out.printf("\nHighest selling item marked with *\n");
      
   }
   
   public static void checkout(){
      purchase sale = null;
      boolean condition=false;
      String id,selection;
      
      
      
      System.out.printf("Welcome to All Aussie Sports!\n\n");
      do{
         System.out.printf("Enter your customer ID or scan your card\n");
         id=s.nextLine();
         
            if(customer.getCustomerById(id)!=null){
               sale=new purchase(customer.getCustomerById(id));
               condition=true;
            }else{
               System.out.printf("Invalid login\n");
            }
         
      }while(condition==false);
      
      
      condition=false;
      while(condition==false){
         System.out.printf("Would you like to:\n(s)earch item\n(a)dd item to cart\n" +
               "(f)inish purchase\ne(x)it\n--sales staff options--\n(r)emove item\n" +
               "(c)ancel purchase\n");
         selection=s.nextLine();
         if(selection.equals("")){
            System.out.println("No selection made");
            continue;
         }
         switch (selection.charAt(0)){
         case 's':
            searchItem();
            break;
         case 'a':
            addToCart(sale);
            printItems(sale);
            break;
         case 'f':
            sale.completePurchase();
            System.out.println("Purchase completed");
            condition=true;
            break;
         case 'x':
              condition=true;
              System.out.println("Purchase cancelled");
              purchase.purchases.remove(sale);
              sale=null;
              break;
         case 'r':
            removeItem(sale);
            break;
         case 'c':
            cancelPurchase(sale);
            condition=true;
            break;
         default:
            System.out.println("Invalid entry try again");
            break;
            
         }
      }
   }
   
   public static void searchItem(){
      item[] found=new item[item.items.size()];
      ArrayList<item> iList = new ArrayList<item>();
      String name;
      double price;
      
      System.out.println("Enter the name of the item you want to find\n");
      name=s.nextLine();
      iList=item.getItemByName(name);
      if(iList.isEmpty()!=true){
         found=iList.toArray(found);
         System.out.println("Items found\n| Itemcode | Name | Price\n");
         for(int i=0;i<found.length;i++){
            if(found[i]!=null){
               if(found[i].getDiscPrice()!=0.00){
                  price=found[i].getDiscPrice();
               }else{
                  price=found[i].getPrice();
               }
               System.out.printf("| %s | %s | $%.2f |\n",found[i].getItemCode(),
                              found[i].getItemName(),price);
              if(found[i].getBulkDiscPrice()!=0.00 && found[i].getBulkDiscQuan()!=0){
                 System.out.printf("Discount price of %.2f available at %d items\n",
                                   found[i].getBulkDiscPrice(),found[i].getBulkDiscQuan());
              }
            }else{
               break;
            }
         }
      }else{
         System.out.println("No items found");
      }
   }
   
   public static void addToCart(purchase sale){
      String selection;
      item toAdd;
      int quan;
      
      System.out.println("Please enter the item code of the item you wish to add");
      selection=s.nextLine();
      toAdd=item.getItemByCode(selection);
      System.out.println("How many would you like?");
      quan=s.nextInt();
      if(toAdd!=null){
         if(quan<=toAdd.getStock()){
            for(int i=0;i<quan;i++){
               sale.addToCart(toAdd);
            }
         }else{
               System.out.println("Not enough stock available");
               return;
            }
         
         System.out.printf("%s added to cart",toAdd.getItemName());
      }else{
         System.out.println("No item matching that code found");
      }
   }
   
   public static void printItems(purchase sale){
      Integer quan;
      item[] iList = new item[item.items.size()];
      double total=0;
      
      iList=item.items.toArray(iList);
      
      System.out.println("Cart contents:\n| ItemCode | Name | Quantity | Price");
      for(int i=0;i<iList.length;i++){
         quan=sale.cart.get(iList[i]);
         if(quan!=null){
            total+=quan*iList[i].getPrice();
            System.out.printf("| %s | %s |    %d    | %.2f |\n",iList[i].getItemCode(),
                              iList[i].getItemName(),quan,(quan*iList[i].getPrice()));
         }
         
      }
      System.out.printf("\nTotal cost: $%.2f\n",total);
   }
   
   public static void removeItem(purchase sale){
      String id,pWord,iCode;
      int quan=0;
      boolean condition=false;
      do{
         System.out.printf("Enter your employee ID or x to exit\n");
         id=s.nextLine();
         if(id.equalsIgnoreCase("x")){
            condition=true;
            return;
         }
         try
         {
            if(employee.getEmployeeById(id).isLoggedIn()==false);
         }
         catch (Exception e)
         {
            System.out.println("Invalid entry");
            continue;
         }
            System.out.printf("Enter your password\n");
            pWord=s.nextLine();
         
            if(pWord.equals(employee.getEmployeeById(id).getPassword())
                  && employee.getEmployeeById(id) instanceof salesStaff){
               condition=true;
            }else{
               System.out.printf("Invalid login\n");
            }
         
      }while(condition==false);
      
      System.out.println("What item would you like to remove?");
      iCode=s.nextLine();
      try{
         System.out.println("How man would you like to remove?");
         quan=s.nextInt();
      }catch(NumberFormatException e){
         System.out.println("Invalid entry");
      }
      if(quan>sale.cart.get(item.getItemByCode(iCode))){
         System.out.printf("Cart does not contain that many %s\n",item.getItemByCode(iCode));
         return;
      }
      for(int i=0;i<quan;i++){
         if(sale.cart.remove(item.getItemByCode(iCode)) != null){
            if(i==quan-1){
               System.out.printf("%s was removed\n",item.getItemByCode(iCode).getItemName());
            }
         }else{
         System.out.println("No such item exists");
         }
      }
   }
   
   public static void cancelPurchase(purchase sale){
      String id,pWord,iCode;
      boolean condition=false;
      do{
         System.out.printf("Enter your employee ID\n");
         id=s.nextLine();
         if(id.equalsIgnoreCase("x")){
            condition=true;
            return;
         }
         try
         {
            if(employee.getEmployeeById(id).isLoggedIn()==false);
         }
         catch (Exception e)
         {
            System.out.println("Invalid entry");
            continue;
         }
            System.out.printf("Enter your password\n");
            pWord=s.nextLine();
         
            if(pWord.equals(employee.getEmployeeById(id).getPassword())
                  && employee.getEmployeeById(id) instanceof salesStaff){
               condition=true;
            }else{
               System.out.printf("Invalid login\n");
            }
         
      }while(condition==false);
      
      purchase.purchases.remove(sale);
      sale=null;
      System.out.println("Purchase cancelled");
   }

}
