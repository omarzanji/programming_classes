import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
/**
 * This program will test the FlavorComparator class.
 *
 * @author Omar Barazanji
 * @version 4/17/17
 */
public class FlavorComparatorTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Tests. **/
   @Test public void flavorSortComparatorTest() 
   {
      BakedItem[] itemTest = new BakedItem[3];
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
                            "flour", "sugar", "dark chocolate chips",
                            "butter", "baking soda", "salt");
      Cake k = new Cake("Birthday", "Chocolate", 1, 1,
                        "flour", "sugar", "cocoa powder", "vanilla", "eggs",
                        "butter", "baking soda", "baking powder", "salt");
      WeddingCake p = new WeddingCake("3-Layer/1-Tier", "Red Velvet", 1, 
                                      3, 1, "flour", "sugar",
                                      "buttermilk", "coffee", 
                                      "eggs", "butter", "baking soda",
                                      "baking powder", 
                                      "salt");
      itemTest[0] = c;
      itemTest[1] = k;
      itemTest[2] = p;
      Arrays.sort(itemTest, new FlavorComparator());
      Assert.assertEquals("Flavor comparator test", k.toString(),
         itemTest[0].toString());
   }
}
