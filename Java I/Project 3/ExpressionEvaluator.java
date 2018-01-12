import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * This program will ask the user to input a value
   of x. The program will then solve an equation
   for x when it is inputted into the equation.
   Then, a formatted result will be displayed.
 *
 * @author Omar Barazanji
 * @version 1/30/17
 */

public class ExpressionEvaluator {
   /**
    * Asks the user for a value of x, and then 
      inputs that value of x into an equation and 
      calculates the result. This is done by using the Math 
      Class.
    *
    * @param args - not used.
    */
    
   public static void main(String[] args) { // main code
      
      // scaner created, and doubles defined
      Scanner userInput = new Scanner(System.in);
      double x, resultNum, resultDen, result;
      
      // prompts user to input value of x
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      // sets x into the equation below and solves result
      resultNum = Math.pow((3 * Math.pow(x, 5) - 2 * Math.pow(x, 3)), 2);
      resultDen = Math.sqrt(Math.abs((16 * Math.pow(x, 7)))) + 1;
      result = (resultNum / resultDen);
      System.out.println("Result: " + result);
      
      // formats result as a string and finds #'s left and right of decimal
      String resultString = Double.toString(result);
      int leftDecimal, rightDecimal;
      leftDecimal = resultString.indexOf('.');
      rightDecimal = resultString.length() - leftDecimal - 1;
      
      // prints #'s left and right of decimal
      System.out.println("# digits to left of decimal point: "
         + leftDecimal);
      System.out.println("# digits to right of decimal point: "
         + rightDecimal);
      
      // formats result in specified decimal format
      DecimalFormat resultFormatted = new DecimalFormat("#,##0.0####");
      System.out.println("Formatted Result: " + resultFormatted.format(result));
   }
}