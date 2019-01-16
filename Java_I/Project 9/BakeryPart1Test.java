import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * This program will test the BakeryPart1 class.
 *
 * @author Omar Barazanji
 * @version 4/10/17
 */
public class BakeryPart1Test {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      BakedItem.resetCount();
   }


   /** A test that checks the default constructor. **/
   @Test public void mainTest() {
      BakeryPart1 bp1 = new BakeryPart1();
      BakeryPart1.main(null);
      Assert.assertEquals("BakedItem.count should be 6.",
                           6, BakedItem.getCount()); 
   }
   
   /** After. **/
   @After public void afterTest() {
      BakedItem.resetCount();
   }
}
