import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * This program will test the Cake class.
 *
 * @author Omar Barazanji
 * @version 4/10/17
 */
public class CakeTest {

   //objects
   private Cake c1 = new Cake("Birthday", "Chocolate", 1, 1,
                        "flour", "sugar", "cocoa powder", "vanilla", "eggs",
                        "butter", "baking soda", "baking powder", "salt");
   private Cake c2 = new Cake("2-Layer", "Red Velvet", 1, 2,
                        "flour", "sugar", "cocoa powder", "food coloring",
                        "eggs", "butter", "baking soda", "baking powder",
                        "salt");

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Tests the getLayers method. **/
   @Test public void getLayersTest() {
      int result1 = c1.getLayers();
      Assert.assertEquals("should be 1", 1, result1);
      int result2 = c2.getLayers();
      Assert.assertFalse("should be false", 0 == result2);
   }

   /** Tests the setLayers method. **/
   @Test public void setLayersTest() {
      c1.setLayers(4);
      int result1 = c1.getLayers();
      Assert.assertEquals("should be 4", 4, result1);
      c2.setLayers(1);
      int result2 = c1.getLayers();
      Assert.assertFalse("should be false", 0 == result2);
   }

   /** Tests the price method. **/
   @Test public void priceTest() {
      Assert.assertEquals("should be 8", 8, c1.price(), .001);
      Assert.assertFalse("should be false", 12 == c2.price());
   }
}