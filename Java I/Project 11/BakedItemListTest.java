import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
/**
 * Tests the BakedItemList class.
 *
 * @author Omar Barazanji
 * @version 4/17/17
 */
public class BakedItemListTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Tests the getListName and setListName Methods. **/
   @Test public void getSetListNameTest() {
      BakedItemList testList = new BakedItemList();
      testList.setListName("Sleep Deprived");
      Assert.assertEquals("Tests the getListName and setListName Methods",
                          "Sleep Deprived", testList.getListName());
   }
   
   /** Tests the getItemList and setItemList Method. **/
   @Test public void getSetItemListTest() {
      BakedItemList testList = new BakedItemList();
      BakedItem[] testArray = new BakedItem[3];
      testList.setItemList(testArray);
      Assert.assertEquals("Tests the getItemList and setItemList Methods",
                          testArray, testList.getItemList());
   }

   /** Tests the getItemCount and setItemCount Methods. **/
   @Test public void getSetItemCountTest() {
      BakedItemList testList = new BakedItemList();
      testList.setItemCount(5);
      Assert.assertEquals("Tests the getItemCount and setItemCount Methods",
                          5, testList.getItemCount(), 0);
   }
   
   /** Tests the getExcludedRecords and setExcludedRecords Methods. **/
   @Test public void getSetExcludedRecordsTest() {
      BakedItemList testList = new BakedItemList();
      String[] testRecords = new String[3];
      testList.setExcludedRecords(testRecords);
      Assert.assertEquals("Tests the get and set", testRecords,
                        testList.getExcludedRecords());
   }

   /** Tests the getExcludedCount and setExcludedCount Methods. **/
   @Test public void getSetExcludedCountTest() {
      BakedItemList testList = new BakedItemList();
      testList.setExcludedCount(5);
      Assert.assertEquals("Tests the get and set Methods",
                          5, testList.getExcludedCount(), 0);
   }
   
   /** Tests the getListCount and setListCount Methods. **/
   @Test public void getSetListCountTest() {
      BakedItemList testList = new BakedItemList();
      testList.setListCount(5);
      Assert.assertEquals("Tests the getListCount and setListCount Methods",
                          5, testList.getListCount(), 0);
   }
   
   /** Tests the ResetListCountTest Method. **/  
   @Test public void resetListCountTest() {
      BakedItemList testList = new BakedItemList();
      testList.setListCount(5);
      testList.resetListCount();
      Assert.assertEquals("Tests the ResetListCountTest Method",
                          0, testList.getListCount(), 0);
   }

   /**
    * Tests the readItemFile Method.
    *
    * @throws IOException for reading files.
    */
   @Test public void readItemFileTest() throws IOException {
      BakedItemList.resetListCount();
      BakedItemList testList = new BakedItemList();
      testList.readItemFile("baked_item_data2.csv");
      
      Assert.assertEquals("read file test", 6, testList.getItemCount(), 0);
      Assert.assertEquals("read file test", "Auburn's Best Bakery", 
                          testList.getListName());
         
      BakedItemList test2List = new BakedItemList();
      test2List.readItemFile("baked_item_data2.csv");
      Assert.assertEquals("read file test", 2,
         BakedItemList.getListCount(), 0);
   }
   
   /**
    * Tests the generateReport Methods. 
    *
    * @throws IOException - used to read in a file.
    */  
   @Test public void generateReportTest() throws IOException {
      String naturalOrderTest = "Cookie: Chips Delight" 
         + " - Chocolate Chip   Quantity: 12   Price: $4.20";   
      String byClassTest = "Cake: 2-Layer - Red Velvet" 
         + "   Quantity: 1   Price: $16.00";           
      String byPriceTest = "Cookie: Chips Delight - Chocolate Chip" 
         + "   Quantity: 12   Price: $4.20";
      String byFlavorTest = "Pie: Weekly Special - Apple"
         + "   Quantity: 1   Price: $12.00";
      String excludedTest = "*** InvalidCategoryException: ";
      
      BakedItemList testList = new BakedItemList();
      testList.readItemFile("baked_item_data2.csv");
      
      String naturalOrderTestReport = testList.generateReport().toString();
      String byClassTestReport = testList.generateReportByClass().toString();
      String byPriceTestReport = testList.generateReportByPrice().toString();
      String byFlavorTestReport = testList.generateReportByFlavor().toString();
      String excludedTestReport = 
         testList.generateExcludedRecordsReport().toString();
      Assert.assertEquals("natural order test", true,
         naturalOrderTestReport.contains(naturalOrderTest));
      Assert.assertEquals("by class test", true,
         byClassTestReport.contains(byClassTest));
      Assert.assertEquals("by price test", true,
         byPriceTestReport.contains(byPriceTest));
      Assert.assertEquals("by flavor test", true,
         byFlavorTestReport.contains(byFlavorTest));
      Assert.assertEquals("excluded report test", true,
         excludedTestReport.contains(excludedTest));
   }
}