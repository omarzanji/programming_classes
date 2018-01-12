import java.text.DecimalFormat;
/**
 * This program will be the abstract parent class for a collection of
   baked goods.
 *
 * @author Omar Barazanji
 * @version 4/6/17
 */
public abstract class BakedItem implements Comparable<BakedItem> {
   protected String name, flavor;
   protected int quantity;
   protected String[] ingredients;
   protected static int count = 0;
   
   /**
    * Constructor for this class.
    *
    * @param nameIn - used to get name of item.
    * @param flavorIn - used to get flavor of item.
    * @param quantityIn - used to get quantity of items.
    * @param ingredientsIn - used to get ingredients of item.
    */
   public BakedItem(String nameIn, String flavorIn,
                     int quantityIn, String ... ingredientsIn)
   {
      name = nameIn;
      flavor = flavorIn;
      quantity = quantityIn;
      ingredients = ingredientsIn;
      count++;
   }
   
   /**
    * This method will get the name.
    *
    * @return - used to return name.
    */
   public String getName() {
      return name;
   }
      
   /**
    * This method will set the name.
    *
    * @param nameIn - used to input name.
    */
   public void setName(String nameIn) {
      name = nameIn;
   }
      
   /**
    * This method will get the flavor.
    *
    * @return - used to return flavor.
    */
   public String getFlavor() {
      return flavor;
   }
      
   /**
    * This method will set the flavor.
    *
    * @param flavorIn - used to set flavor.
    */
   public void setFlavor(String flavorIn) {
      flavor = flavorIn;
   }
   
         
   /**
    * This method will get the quantity.
    *
    * @return - used to return flavor.
    */
   public int getQuantity() {
      return quantity;
   }
      
   /**
    * This method will set the quantity.
    *
    * @param quantityIn - used to set the quantity.
    */
   public void setQuantity(int quantityIn) {
      quantity = quantityIn;
   }
   
   /**
    * This method will get the ingredients.
    *
    * @return - used to return ingredients.
    */
   public String[] getIngredients() {
      return ingredients;
   }
   
   /**
    * This method will set the ingredients.
    *
    * @param ingredientsIn - used to set ingredients.
    */
   public void setIngredients(String ... ingredientsIn) {
      ingredients = ingredientsIn;
   }
   
   /**
    * This method will get the count.
    *
    * @return - used to return count.
    */
   public static int getCount() {
      return count;
   }
   
   /**
    * This method will reset the count to zero.
    */
   public static void resetCount() {
      count = 0;
   }
   
   /**
    * This method will summarize the program.
    *
    * @return - used to return output.
    */
   public final String toString() {
      String listIngredients = "";
      DecimalFormat df = new DecimalFormat("$#,##0.00");
      
      int j = 0;
      for (int i = 0; i < ingredients.length; i++) {
         listIngredients += ingredients[i];
         j++;
         if (i < ingredients.length - 1) {
            listIngredients += ", ";
         }
         if (j % 5 == 0) {
            listIngredients += "\n";
         }
      }
      
      String output = this.getClass().toString().substring(6)
         + ": " + name + " - " + flavor + "   " + "Quantity: " + quantity
         + "   " + "Price: " + df.format(price()) + "\n" + "(Ingredients: "
         + listIngredients + ")";
      return output;
   }
   
   /**
    * This abstract method will reserve the price method.
    * @return - not used.
    */
   public abstract double price();
   
   /**
    * Comparable interface CompareTo.
    *
    * @param itemIn - used to input an item.
    * @return - used to return value.
    */
   public int compareTo(BakedItem itemIn) {
      return this.toString().toLowerCase().compareTo(itemIn.toString()
            .toLowerCase());
   }
}