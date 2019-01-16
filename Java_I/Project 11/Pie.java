/**
 * This program will hold information for a cookie object.
 *
 * @author Omar Barazanji
 * @version 4/6/17
 */
public class Pie extends BakedItem {
   private double crustCost;
   
   /** variable for base rate. **/
   public static final double BASE_RATE = 12.0;
   
   /**
    * Constructor for Pie class.
    *
    * @param nameIn - used to set name.
    * @param flavorIn - used to set flavor.
    * @param quantityIn - used to set quantity.
    * @param crustCostIn - used to set crust cost.
    * @param ingredientsIn - used to set ingredients.
    */
   public Pie(String nameIn, String flavorIn,
                  int quantityIn, double crustCostIn, String ... ingredientsIn)
   {
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
      crustCost = crustCostIn;
   }
   
   /**
    * This method will get the crust cost.
    *
    * @return - used to return crust cost.
    */
   public double getCrustCost() {
      return crustCost;
   }
   
   /**
    * This method will set the crust cost.
    *
    * @param crustCostIn - used to set crust cost.
    */
   public void setCrustCost(double crustCostIn) {
      crustCost = crustCostIn;
   }
   
   /**
    * This method will calculate price.
    *
    * @return - used to return price.
    */
   public double price() {
      return (BASE_RATE + crustCost) * quantity;
   }
}