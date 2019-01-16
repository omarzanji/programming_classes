import java.util.Scanner;
/**
 * This program will take the user's inputs for the characteristics
   of a dodecahedron and will calculate surface area and volume.
 *
 * @author Omar Barazanji 
 * @version 2/12/17
 */
public class DodecahedronApp {

   /**
   * main code for the Dodecahedron class.
   *
   * @param args - not used.
   */
   public static void main(String[] args) {
      
      // defines Strings to use for code.
      String labelApp = "";
      String colorApp = "";
      String edgeApp = "";
      
      // creates Scanner.
      Scanner userInput = new Scanner(System.in);
      
      System.out.println("Enter label, color, and "
         + "edge length for a dodecahedron.");
      
      System.out.print("\t" + "label: ");
      labelApp = userInput.nextLine();
      
      System.out.print("\t" + "color: ");
      colorApp = userInput.nextLine();
      
      System.out.print("\t" + "edge: ");
      edgeApp = userInput.nextLine();
      
      // defines double.
      double edgeAppToDouble = Double.parseDouble(edgeApp);
      
      if (edgeAppToDouble <= 0) { // displays error when less than 0.
         System.out.print("Error: edge must be greater than 0.");
      }
      else { // edge must be greater than 0.
         System.out.println();
         Dodecahedron a = new Dodecahedron(labelApp, colorApp, edgeAppToDouble);
         System.out.print(a);
      }
   }
}