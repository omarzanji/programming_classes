import java.util.Comparator;
/**
* Comparator class that will sort items by price.
*
* @author Omar Barazanji
* @version 4/16/17
*/
public class PriceComparator implements Comparator<BakedItem>
{
   /**
    * Method that uses price value to determine order.
    *
    * @param b1 - used for first object.
    * @param b2 - used for second object.
    * @return - used for object comparison.
    */
   public int compare(BakedItem b1, BakedItem b2) {
      double bakedItem1 = b1.price();
      double bakedItem2 = b2.price();
      
      if (bakedItem2 > bakedItem1) {
         return -1;
      }
      else if (bakedItem2 < bakedItem1) {
         return 1;
      }
      else {
         return 0;
      }
   }
}