import java.io.IOException;
/**
* This program will generate a report of all objects.
*
* @author Omar Barazanji
* @version 4/17/2017
*/
public class BakeryPart2 {
   /**
    * Main method for class.
    *
    * @param args Command Line baked_item_data.csv. 
    * @throws IOException - used for reading file.
    */
   public static void main(String[] args) throws IOException {
      if (args.length == 0) {
         System.out.println("File name expected as command line argument."
            + "\nProgram ending.");
      }
      else {
         BakedItemList bList = new BakedItemList();
         bList.readItemFile(args[0]);
         System.out.println(bList.generateReport());
         System.out.println(bList.generateReportByClass());
         System.out.println(bList.generateReportByPrice());
         System.out.println(bList.generateReportByFlavor());
         System.out.println(bList.generateExcludedRecordsReport());
      }
   }

}