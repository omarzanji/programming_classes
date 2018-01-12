import java.util.Comparator;
/**
* Comparator class that will sort based on item flavor.
*
* @author Omar Barazanji
* @version 4/16/2017
*/
public class FlavorComparator implements Comparator<BakedItem>
{
   /**
    * Method that will use string values to determine order.
    *
    * @param b1 - used for first object.
    * @param b2 - used for second object.
    * @return - used for object comparison.
    */
   public int compare(BakedItem b1, BakedItem b2) {
      String bakedItem1 =
         b1.getFlavor().toUpperCase();
      String bakedItem2 =
         b2.getFlavor().toUpperCase();
      
      return bakedItem1.compareTo(bakedItem2);
   }
}