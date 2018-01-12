/**
 * This program will hold information for a cookie object.
 *
 * @author Omar Barazanji
 * @version 4/6/17
 */
public class WeddingCake extends Cake {
   private int tiers;
   
   /** variable for base rate. **/
   public static final double BASE_RATE = 15.0;
   
   /**
    * Constructor for WeddingCake class.
    *
    * @param nameIn - used to set name.
    * @param flavorIn - used to set flavor.
    * @param quantityIn - used to set quantity.
    * @param layersIn - used to set layers.
    * @param tiersIn - used to set tiers.
    * @param ingredientsIn - used to set ingredients.
    */
   public WeddingCake(String nameIn, String flavorIn,
                  int quantityIn, int layersIn, int tiersIn,
                  String ... ingredientsIn)
   {
      super(nameIn, flavorIn, quantityIn, layersIn, ingredientsIn);
      tiers = tiersIn;
   }
   
   /**
    * This method will get the tiers.
    *
    * @return - used to return tiers.
    */
   public int getTiers() {
      return tiers;
   }
   
   /**
    * This method will set the tiers.
    *
    * @param tiersIn - used to set tiers.
    */
   public void setTiers(int tiersIn) {
      tiers = tiersIn;
   }
   
   /**
    * This method will calculate price.
    *
    * @return - used to return price.
    */
   public double price() {
      return (BASE_RATE * layers * tiers) * quantity;
   }
}