/**
 * This program will prompt the user to select
   an x, y, and z value to be used for the provided
   equation. The code will then calculate the result
   after inputting the x, y, and z value.
 *
 * Project 2
 * @author Omar Barazanji
 * @version 1/25/17
 */
import java.util.Scanner;
 /**
 * imports the Java utility scanner to use
   later for user inputs.
 */
public class FormulaCalculator {
 /**
 * This class will contain the code for the calculator.
 * @param args - not used.
 */
   public static void main(String[] args) {
      
      //x, y, and z are double variable types:
      double x = 0;
      double y = 0;
      double z = 0;
      
      //user given equation and asked to select values for x, y, and z:
      System.out.println("result = (2x - 7.4) (4y + 9.3) (6z - 11.2) / xyz");
      Scanner userInput = new Scanner(System.in);
      System.out.print("\tEnter x: ");
      x = userInput.nextDouble();
      System.out.print("\tEnter y: ");
      y = userInput.nextDouble();
      System.out.print("\tEnter z: ");
      z = userInput.nextDouble();
      
      if (x * y * z == 0) { //x, y, and z equal to zero results in 0.0:
         System.out.print("result = 0.0");
      }
      else { //result is calculated:
         System.out.print("result = ");
         System.out.print((2 * x - 7.4) * (4 * y + 9.3)
            * (6 * z - 11.2) / (x * y * z));
      }
   }
}