import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * This program will accept coded space ticket information
   and sort it by price, category, time, date, and seat.
 *
 * @author Omar Barazanji
 * @version 2/5/17
 */

public class SpaceTicket {
       
   // defines constants for discounts
   static final double STUDENT_DISCOUNT = .25;
   static final double CHILD_DISCOUNT = .35;
   
   /**
    * SpaceTicket class conains all of the code.
    *
    * @param args - not used
    */
   public static void main(String[] args) { // main code
   
      // ceates scanner and stores ticket code
      String ticketCode = "";
      Scanner userInput = new Scanner(System.in);
      System.out.print("Enter ticket code: ");
      ticketCode = userInput.nextLine();
      ticketCode = ticketCode.trim();
      int length = ticketCode.length();
      
      if (length >= 25) { // proceed if length at least 25 characters long
         
         // outputs ticket, date, time, and seat number
         System.out.println("\nSpace Ticket: "
            + ticketCode.substring(24));
         System.out.print("Date: " + ticketCode.substring(13, 15) + "/"
            + ticketCode.substring(15, 17) + "/"
            + ticketCode.substring(17, 21) + "   ");
         System.out.print("Time: " + ticketCode.substring(9, 11)
            + ":" + ticketCode.substring(11, 13) + "   ");
         System.out.println("Seat: " + ticketCode.substring(21, 24));
         
         // defines string price and converts to double to use decimal formatter
         String price = ticketCode.substring(0, 6);
         double priceDouble = Double.parseDouble(price);
         DecimalFormat priceFormatted = new DecimalFormat("$#,###.00");
         
         // prints formatted price
         System.out.print("Price: "
            + priceFormatted.format(priceDouble) + "   ");
         
         // defines category letter as a char
         char categoryChar = ticketCode.charAt(8);
         char student = 's';
         char child = 'c';
         
         // prints category type
         System.out.print("Category: " + categoryChar + "   ");
     
         if (categoryChar == student) { // cost for student
            double cost = priceDouble - (priceDouble * STUDENT_DISCOUNT);
            DecimalFormat costFormatted = new DecimalFormat("$#,###.##");
            System.out.println("Cost: " + costFormatted.format(cost));
         }
         else if (categoryChar == child) { // cost for child
            double cost = priceDouble - (priceDouble * CHILD_DISCOUNT);
            DecimalFormat costFormatted = new DecimalFormat("$#,###.##");
            System.out.println("Cost: " + costFormatted.format(cost));
         }
         else { // cost for anyone other than a student or a child
            DecimalFormat costFormatted = new DecimalFormat("$#,###.##");
            System.out.println("Cost: "
               + priceFormatted.format(priceDouble));
         }
         
         // generates random number from 1-999999
         int prize;
         prize = (int) (Math.random() * 999999) + 1;
         DecimalFormat prizeFormatted = new DecimalFormat("000000");
         System.out.print("Prize Number: " + prizeFormatted.format(prize));
       
      }
      else { // if ticket code is less than 25 characters
         System.out.println("\n*** Invalid ticket code ***");
         System.out.println("Ticket code must have at least 25 characters.");
      }
   }   
   
}