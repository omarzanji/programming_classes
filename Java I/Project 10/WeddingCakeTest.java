import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * This program will test the WeddingCake class.
 *
 * @author Omar Barazanji
 * @version 4/10/17
 */
public class WeddingCakeTest {
   
   //objects
   private WeddingCake c1 = new WeddingCake("3-Layer/1-Tier", "Red Velvet", 1, 
                           3, 1, "flour", "sugar", "buttermilk", "coffee", 
                           "eggs", "butter", "baking soda", "baking powder", 
                           "salt");
   private WeddingCake c2 = new WeddingCake("3-Layer/2-Tier", "Chocolate", 1, 
                           3, 2, "flour", "sugar", "buttermilk", "coffee", 
                           "eggs", "butter", "baking soda", "baking powder", 
                           "salt");
   private WeddingCake c3 = new WeddingCake("3-Layer/3-Tier", "Vanilla", 1, 
                           3, 3, "flour", "sugar", "buttermilk", "coffee", 
                           "eggs", "butter", "baking soda", "baking powder", 
                           "salt");

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Tests the getTiers method. **/
   @Test public void getTiersTest() {
      int result1 = c1.getTiers();
      Assert.assertEquals("should be 1", 1, result1);
      int result2 = c2.getTiers();
      Assert.assertFalse("should be false", 0 == result2);
      int result3 = c3.getTiers();
      Assert.assertTrue("should be true", 3 == result3);
   }

   /** Tests the setTiers method. **/
   @Test public void setTiersTest() {
      c1.setTiers(4);
      int result1 = c1.getTiers();
      Assert.assertEquals("should be 4", 4, result1);
      c2.setTiers(1);
      int result2 = c2.getTiers();
      Assert.assertFalse("should be false", 0 == result2);
      c3.setTiers(3);
      int result3 = c3.getTiers();
      Assert.assertTrue("should be true", 3 == result3);
   }
   
   /** Tests the price method. **/
   @Test public void priceTest() {
      Assert.assertEquals("should be 45", 45, c1.price(), .001);
      Assert.assertFalse("should be false", 12 == c2.price());
      Assert.assertTrue("should be true", 135 == c3.price());
   }
}