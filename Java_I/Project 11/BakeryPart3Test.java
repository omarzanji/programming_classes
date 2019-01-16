import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
/**
 * This program will test the BakeryPart3 class.
 *
 * @author Omar Barazanji
 * @version 4/17/17
 */
public class BakeryPart3Test {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /**
    * Test that reads empty main.
    *
    * @throws IOException - used for args file reading.
    */
   @Test public void zeroInputTest() throws IOException {
      BakeryPart3 test = new BakeryPart3();
      BakedItemList.resetListCount();
      String[] argsEmpty = { };
      BakeryPart3.main(argsEmpty);
      Assert.assertEquals("BakeryItemList equal to 0",
         0, BakedItemList.getListCount());  
   }
   
   /**
    * Test that reads a file in main.
    *
    * @throws IOException - used for args file reading.
    */
   @Test public void inputTest() throws IOException {
      BakedItemList.resetListCount();
      String[] argsFile = {"baked_item_data2.csv"};
      BakeryPart3.main(argsFile);
      Assert.assertEquals("BakeryItemList equal to 1",
         1, BakedItemList.getListCount());  
   }
   
   /**
    * Test that reads invalid file.
    *
    * @throws Exception - used.
    *
   @Test public void inputTestInvalid() throws Exception {
      BakeryPart3 e = new BakeryPart3();
      String[] args = {null};
      BakeryPart3.main(args);
      Assert.assertEquals(0, BakedItemList.getListCount());
   }
   
   /**
    * Tests file that does not exist in directory.
    *
    * @throws Exception - used.
    *
   @Test public void inputTestNo() throws Exception {
      BakeryPart3 e = new BakeryPart3();
      String[] args = {""};
      BakeryPart3.main(args);
      Assert.assertEquals(0, BakedItemList.getListCount());
   } */
}