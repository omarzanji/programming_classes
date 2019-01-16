import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
/**
 * This program will test the BakeryPart2 class.
 *
 * @author Omar Barazanji
 * @version 4/17/17
 */
public class BakeryPart2Test {

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
      BakeryPart2 test = new BakeryPart2();
      BakedItemList.resetListCount();
      String[] argsEmpty = { };
      BakeryPart2.main(argsEmpty);
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
      String[] argsFile = {"baked_item_data.csv"};
      BakeryPart2.main(argsFile);
      Assert.assertEquals("BakeryItemList equal to 1",
         1, BakedItemList.getListCount());  
   }
}
