/**
 * This program will be a user defined exception
 * that will be thrown and caught in the readItemFile method.
 *
 * @author Omar Barazanji
 * @version 4/24/17
 */
public class InvalidCategoryException extends Exception {
   
   /**
    * Constructor for exception message.
    *
    * @param category - used for storing category.
    */
   public InvalidCategoryException(String category) {
      super("For category: " + "\"" + category + "\"");
   }
}