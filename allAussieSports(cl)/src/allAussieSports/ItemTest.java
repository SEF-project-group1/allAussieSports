package allAussieSports;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemTest
{

   @BeforeClass
   public static void setUpBeforeClass() throws Exception
   {
      item itm1 = new item("Football");
      supplier supp = new supplier("Bob's balls");
   }

   @AfterClass
   public static void tearDownAfterClass() throws Exception
   {
      
   }

   @Before
   public void setUp() throws Exception
   {
      
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void iCodetest()
   {
      /*Test default iCode assignment - compare to name given earlier*/
      assertEquals((item.getItemByCode("itm000")).getItemName(),"Football");
      
   }
   
   @Test
   public void bulkDiscQuanTest(){
      /*Default test*/
      assertEquals((item.getItemByCode("itm000")).getBulkDiscQuan(),0);
      /*Set value*/
      item.getItemByCode("itm000").setBulkDiscQuan(42);
      /*Test set*/
      assertEquals((item.getItemByCode("itm000")).getBulkDiscQuan(),42);
   }

   
   @Test
   public void supplierRelationTest(){
      /*Default test*/
      assertNull(item.getItemByCode("itm000").getSupplier());
      /*Set supplier*/
      item.getItemByCode("itm000")
         .setSupplier(supplier.getSupplierByName("Bob's Balls"));
      /*Test set*/
      assertEquals(item.getItemByCode("itm000").getSupplier(),
                   supplier.getSupplierByName("Bob's Balls"));
   }
}
