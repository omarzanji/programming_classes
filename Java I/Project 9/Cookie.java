/**
 * This program will hold information for a cookie object.
 *
 * @author Omar Barazanji
 * @version 4/6/17
 */
public class Cookie extends BakedItem {
   
   /** variable for base rate. **/
   public static final double BASE_RATE = 0.35;
   
   /**
    * Constructor for BakedItem class.
    *
    * @param nameIn - used to set name.
    * @param flavorIn - used to set flavor.
    * @param quantityIn - used to set quantity.
    * @param ingredientsIn - used to set ingredients.
    */
   public Cookie(String nameIn, String flavorIn,
                  int quantityIn, String ... ingredientsIn)
   {
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
   }
   
   /**
    * This method will calculate price.
    *
    * @return - used to return price.
    */
   public double price() {
      return BASE_RATE * quantity;
   }
}