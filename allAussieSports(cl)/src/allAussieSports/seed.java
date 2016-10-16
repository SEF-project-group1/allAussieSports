package allAussieSports;

public class seed
{
   public static void seedProgram(){
      
      /*Suppliers*/
      supplier sup1=new supplier("Gary's gear");
      sup1.setAddress("14 Bork Road, Elsternwick, Victoria");
      sup1.setContactName("Gary La'trel");
      sup1.setContactNumber("(03)12345678");
      
      supplier sup2=new supplier("Bob's balls");
      sup1.setAddress("1 Happy lane, Happyville,South Australia");
      sup1.setContactName("Robert Duncan");
      sup1.setContactNumber("(08)59306739");
      
      supplier sup3=new supplier("Big bat warehouse");
      sup1.setAddress("183 Sadness Street, Glumtown, Victoria");
      sup1.setContactName("Sally Creed");
      sup1.setContactNumber("(03)58305768");
      
      supplier sup4=new supplier("Protect products co");
      sup1.setAddress("578 Neutral Avenue, Nihilism, N.S.W");
      sup1.setContactName("John Smith");
      sup1.setContactNumber("(02)76038563");
      
      /*Items*/
      /*Inames*/
      item itm;
      String[] itemNames={"Baseball Bat","Baseball","Catchers mitt","Faceguard",
            "Cricket bat","Stumps","Leg Pads","Cricket ball",
            "Afl Football","Headguard","Goal posts","Guernsey",
            "Soccer ball","Practice cones","Shin guards","Cleats",
            "Boxing gloves","Mouthguard","Tape","Punching bag"};
      /*ISuppliers*/
      supplier[] supps={sup3,sup2,sup1,sup4,
            sup3,sup1,sup4,sup2,
            sup2,sup4,sup1,sup1,
            sup2,sup1,sup4,sup1,
            sup4,sup4,sup1,sup1};
      /*IPrices*/
      double[] prices={28.00,9.75,24.80,26.45,
            46.30,8.65,19.80,16.95,
            19.65,12.80,16.45,12.40,
            24.70,12.80,16.00,13.25,
            36.20,8.75,3.00,140.00};
      /*IreOrderQuans*/
      int[] reOrderAmount={6,12,6,5,
            8,16,8,12,
            12,6,4,16,
            8,24,8,6,
            6,14,24,2};
      /*IbulkDiscQuans*/
      int[] bulkDiscQuan={10,25,10,6,
           8,12,8,16,
           4,4,3,12,
            6,25,8,4,
            6,12,24,3};
      /*IbulkDiscPrices*/
      double[] bulkDiscPrices={24.00,97.50,22.50,24.00,
            42.50,7.50,18.00,15.00,
            18.50,12.00,15.95,11.85,
            22.90,11.50,14.80,12.00,
            35.00,7.25,2.60,125.00};
      /*creating and setting loop*/
      for(int i=0;i<20;i++){
         itm=new item(itemNames[i]);
         itm.setPrice(prices[i]);
         itm.setStock(reOrderAmount[i]*3);
         itm.setReOrderQuan(reOrderAmount[i]);
         itm.setBulkDiscQuan(bulkDiscQuan[i]);
         itm.setBulkDiscPrice(bulkDiscPrices[i]);
         itm.setSupplier(supps[i]);
         /*ISports*/
         if(i<5){
            itm.setSport("Baseball");
         }else if(i<=5 && i<10){
            itm.setSport("AFL");
         }else if(i<=10 && i<15){
            itm.setSport("Soccer");
         }else if(i<=15 && i<20){
            itm.setSport("Boxing");
         }
      }
      
      /*Employees*/
      new manager("password");
      new salesStaff("abc123");
      new warehouseStaff("qwerty");
      
      /*Customers*/
      customer cus;
      cus=new customer("Jan Smith");
      cus.setLoyaltyPoints(42);
      cus=new customer("Borris Patel");
      cus.setLoyaltyPoints(19);
      cus=new customer("James Johnson");
      
      /*Purchases*/
      /*Purchase 1*/
      purchase sale=new purchase(customer.getCustomerById("cus000"));
      for(int i=0;i<3;i++){
         sale.addToCart(item.getItemByCode("itm000"));
      }
      for(int i=0;i<6;i++){
         sale.addToCart(item.getItemByCode("itm001"));
      }
      sale.addToCart(item.getItemByCode("itm003"));
      sale.addToCart(item.getItemByCode("itm002"));
      sale.completePurchase();
      
      /*Purchase 2*/
      sale=new purchase(customer.getCustomerById("cus001"));
      for(int i=0;i<4;i++){
         sale.addToCart(item.getItemByCode("itm016"));
      }
      for(int i=0;i<2;i++){
         sale.addToCart(item.getItemByCode("itm004"));
      }
      sale.addToCart(item.getItemByCode("itm009"));
      sale.addToCart(item.getItemByCode("itm016"));
      sale.completePurchase();
      
      /*Purchase 3*/
      sale=new purchase(customer.getCustomerById("cus001"));
      for(int i=0;i<7;i++){
         sale.addToCart(item.getItemByCode("itm009"));
      }
      for(int i=0;i<6;i++){
         sale.addToCart(item.getItemByCode("itm004"));
      }
      sale.addToCart(item.getItemByCode("itm017"));
      sale.addToCart(item.getItemByCode("itm002"));
      sale.completePurchase();
      
      /*Purchase 4*/
      /*Purchase 3*/
      sale=new purchase(customer.getCustomerById("cus003"));
      for(int i=0;i<3;i++){
         sale.addToCart(item.getItemByCode("itm009"));
      }
      for(int i=0;i<8;i++){
         sale.addToCart(item.getItemByCode("itm002"));
      }
      sale.addToCart(item.getItemByCode("itm011"));
      sale.addToCart(item.getItemByCode("itm008"));
      sale.completePurchase();
   }
}
