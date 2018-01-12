import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * This program will test the Pie class.
 *
 * @author Omar Barazanji
 * @version 4/10/17
 */
public class PieTest {

   //objects
   private Pie p1 = new Pie("Weekly Special", "Apple", 1, 0,
                     "flour", "sugar", "apples", "cinnamon",
                     "butter", "baking soda", "salt");
   private Pie p2 = new Pie("Summer Special", "Key Lime", 1, 2.0,
                     "flour", "sugar", "lime juice", "lemon juice",
                     "graham crackers", "butter", "baking soda", "salt");
            
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Tests the getCrustCost method. **/
   @Test public void getCrustCostTest() {
      // assert equals
      double result1 = p1.getCrustCost();
      Assert.assertEquals("should be 0", 0.0, result1, .001);
      // assert false
      double result2 = p2.getCrustCost();
      Assert.assertFalse("should be false", 0.0 == result2);
   }
   
   /** Tests the setCrustCost method. **/
   @Test public void setCrustCostTest() {
      p1.setCrustCost(2);
      double result = p1.getCrustCost();
      Assert.assertEquals("should be 2.0", 2.0, result, .001);
   }
      
   /** Tests the price method. **/
   @Test public void priceTest() {
      Assert.assertEquals("should be 12", 12, p1.price(), .001);
      Assert.assertFalse("should be false", 12 == p2.price());
   }
}