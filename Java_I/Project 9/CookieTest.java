import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
/**
 * This program will test the Cookie class.
 *
 * @author Omar Barazanji
 * @version 4/10/17
 */
public class CookieTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Tests the priceTest method. **/
   @Test public void priceTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("Should be 4.20", 4.20, c.price(), .001);
   }
   
   /** Tests the getName method.**/
   @Test public void getNameTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("should be Chips Delight",
                          "Chips Delight", c.getName());
   }
   
   /** Tests the getFlavor method.**/
   @Test public void getFlavorTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("should be Chocolate Chip",
                          "Chocolate Chip", c.getFlavor());
   }
   
   /** Tests the getQuantity method.**/
   @Test public void getQuantityTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("should be 12", 12, c.getQuantity());
   }
   
   /** Tests the getIngredients method.**/
   @Test public void getIngredientsTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      String result = c.getIngredients()[1];
      Assert.assertEquals("should be sugar", "sugar", result);
   }
   
   /** Tests the getCount method.**/
   @Test public void getCountTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("should be 1", 1, c.getCount());
   }
   
   /** Tests the setName method.**/
   @Test public void setNameTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("should be Chips Delight",
                          "Chips Delight", c.getName());
      c.setName("Test");
      Assert.assertEquals("should be Test", "Test", c.getName());
   }
   
   /** Tests the setFlavor method. **/
   @Test public void setFlavorTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("", "Chocolate Chip", c.getFlavor());
      c.setFlavor("Test");
      Assert.assertEquals("should be Test", "Test", c.getFlavor());
   }
   
   /** Tests the setQuantity method.**/
   @Test public void setQuantityTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 1,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertTrue("", 1 == c.getQuantity());
      c.setQuantity(12);
      Assert.assertTrue("should be true", 12 == c.getQuantity());
   }
   
   /** Tests the setIngredients method.**/
   @Test public void setIngredientsTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour");
      String[] ingredientsIn = {"flour", "sugar", "dark chocolate chips",
         "butter", "baking soda", "salt"};
      c.setIngredients(ingredientsIn);
      Assert.assertEquals("should be butter", "butter", c.getIngredients()[3]);
   }
   
   /** Tests the resetCount method. **/
   @Test public void resetCountTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      BakedItem.resetCount();
      Assert.assertEquals("should be 0", 0, c.getCount());
   }
   
   /** Tests toString method. **/
   @Test public void toStringTest() {
      Cookie cook = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      boolean result1 = cook.toString().contains("baking soda,");
      boolean result2 = cook.toString().contains("salt)");
   }
   
   /** After. **/
   @After public void after() {
      BakedItem.resetCount();
   }
}