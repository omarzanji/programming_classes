/**
 * This program will function as an ATM that
   splits an amount of money inputted into the code
   into amounts of $20, $10, $5, and $1. Then, the 
   code will display the amount by denomination.
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
public class ATM {
/**
 * This class will contain the code for the ATM.
 * @param args - not used.
 */
   public static void main(String[] args) {
   /**
    * Each bill will be understood as an integer
      determined by the userInput scanner.
    */
      int amount = 0;
      int twenty = 0;
      int ten = 0;
      int five = 0;
      int one = 0;
      
      //prompts user for the amount:
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter the amount: ");
      amount = userInput.nextInt();
      
      //determines what to do with the amount:
      if (amount > 500) { //amount cannot be greater than 500
         System.out.print("Limit of $500 exceeded!");
      }
      else { //if amount is less than 500:
         //sorts bills by denomination:
         System.out.println("Bills by denomination: ");
         twenty = (amount / 20);
         System.out.println("\t$20: " + twenty);
         ten = (amount % 20 / 10);
         System.out.println("\t$10: " + ten);
         five = (amount % 20 % 10 / 5);
         System.out.println("\t$5: " + five);
         one = (amount % 20 % 10 % 5 / 1);
         System.out.println("\t$1: " + one);
         
         //displays full calculation:
         System.out.print("$" + amount + " = ");
         System.out.print("(" + twenty + " * $20)");
         System.out.print(" + (" + ten + " * $10)");
         System.out.print(" + (" + five + " * $5)");
         System.out.print(" + (" + one + " * $1)");
      }
   }
}