/**
 * This program will hold information for a cookie object.
 *
 * @author Omar Barazanji
 * @version 4/6/17
 */
public class Cake extends BakedItem {
   protected int layers;
   
   /** variable for base rate. **/
   public static final double BASE_RATE = 8.0;
   
   /**
    * Constructor for Cake class.
    *
    * @param nameIn - used to set name.
    * @param flavorIn - used to set flavor.
    * @param quantityIn - used to set quantity.
    * @param layersIn - used to set the layers.
    * @param ingredientsIn - used to set ingredients.
    */
   public Cake(String nameIn, String flavorIn,
                  int quantityIn, int layersIn, String ... ingredientsIn)
   {
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
      layers = layersIn;
   }
   
   /**
    * This method will get the layers.
    *
    * @return - used to return layers.
    */
   public int getLayers() {
      return layers;
   }
   
   /**
    * This method will set the layers.
    *
    * @param layersIn - used to set layers.
    */
   public void setLayers(int layersIn) {
      layers = layersIn;
   }
   
   /**
    * This method will calculate price.
    *
    * @return - used to return price.
    */
   public double price() {
      return (BASE_RATE * layers) * quantity;
   }
}