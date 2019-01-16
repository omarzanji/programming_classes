import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This program will scan a given file and output a summary.
 *
 * @author Omar Barazanji
 * @version 2/26/17
 */
 
public class DodecahedronListApp {
   
   /**
    * Scans a given file and outputs the name of the list and the summary.
    *
    * @param args - not used.
    * @throws IOException from scanning input file.
    */
   public static void main(String[] args) throws IOException
   {
      ArrayList<Dodecahedron> myList = new ArrayList<Dodecahedron>();
      String dodecahedronListName = "";
      String label = "";
      String color = "";
      double edge = 0.0;
      
      
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      System.out.println();
      
      Scanner scanFile = new Scanner(new File(fileName));
   
      dodecahedronListName = scanFile.nextLine();

      while (scanFile.hasNext()) {
         label = String.valueOf(scanFile.nextLine());
         color = String.valueOf(scanFile.nextLine());
         edge = Double.parseDouble(scanFile.nextLine());
         
         Dodecahedron d = new Dodecahedron(label, color, edge);
         myList.add(d);           
      }
      
      DodecahedronList myDodecahedronList
         = new DodecahedronList(dodecahedronListName, myList);
   
      System.out.println(myDodecahedronList);
      
      System.out.println(myDodecahedronList.summaryInfo());
   }
}
