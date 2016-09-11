package allAussieSports;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class allAussieSports{
   public static Scanner s=new Scanner(System.in);
   
   
   public static void main(String[] args)
   {
      char selection;
      boolean condition=false;

      
      do{
         System.out.printf("Menu options:\n(n)ew object\n(c)ustomer\n" +
               "(s)ales staff\n(w)arehouse staff\n(m)anager\ne(x)it\n");
         selection=s.nextLine().charAt(0);
      
         switch(selection){
            case 'c':
               System.out.printf("See gui version\n");
               break;
            case 's':
               System.out.printf("Not yet implemented\n");
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
       
   }
   public static void warehouseOptions(){
      String iCode;
      int increase;
      boolean wCondition=false;
      
      do{
         System.out.printf("Enter code of item to be increased or x to exit\n");
         iCode=s.nextLine();
         if(iCode.equals("x")){
            wCondition=true;
            break;
         }
         System.out.printf("Enter amount to increase\n");
         increase=s.nextInt();
         s.nextLine();
         item.getItemByCode(iCode).addStock(increase);
      }while(wCondition==false);
   }
   
   public static void managerOptions(){
      char selection;
      boolean mCondition=false;
      
      do{
         System.out.printf("(a)lter (c)heck or e(x)it\n");
         selection=s.nextLine().charAt(0);
         switch(selection){
         case 'a':
            managerAlter();
            break;
         case 'c':
            managerCheck();
            break;
         case 'x':
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
               "4.BulkQuan\n5.ReOrderQuan\n6.Stock\n7.Name\n0.Exit\n");
         selection=s.nextInt();
         switch(selection){
         case 1:
            checkd=i.getPrice();
            System.out.printf("Price equals %f\n",checkd);
            break;
         case 2:
            checkd=i.getDiscPrice();
            System.out.printf("DiscPrice equals %f\n",checkd);
            break;
         case 3:
            checkd=i.getBulkDiscPrice();
            System.out.printf("BulkDiscPrice equals %f\n",checkd);
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
               "4.BulkQuan\n5.ReOrderQuan\n6.Stock\n0.Exit\n");
         selection=s.nextInt();
         if (selection!='x'){
         System.out.printf("Set new value to what\n");
            if(selection==7){
               
            }else if(4<=selection && selection<7){
               
            }else if (0<selection && selection<4){
               newDouble=s.nextDouble();
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
         case '0':
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
               "(m)anager, (i)tem or e(x)it\n");
         selection=s.nextLine().charAt(0);
         if(selection=='i'){
            System.out.printf("Please enter item name\n");
            pWord=s.nextLine();
         }else if(selection=='w'|| selection=='s' || selection=='m'){
            System.out.printf("Please enter password\n");
            pWord=s.nextLine();
         }else if(selection=='c'){
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
         case 'x':
            cCondition=true;
            break;
         default:
            System.out.printf("Invalid entry\n");
         }
      }while(cCondition==false);
   }

   public static void clearScan(){
      if(s.hasNext()==true){s.nextLine();}
   }
}
