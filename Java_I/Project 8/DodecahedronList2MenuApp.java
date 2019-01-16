import java.util.Scanner;
import java.io.IOException;
/**
 * This program will give a menu of commands to execute.
 *
 * @author Omar Barazanji
 * @version 3/5/17
 */
 
public class DodecahedronList2MenuApp {
   
   /**
    * Scans a given file and outputs the name of the list and the summary.
    *
    * @param args - not used.
    * @throws IOException from scanning input file.
    */
   public static void main(String[] args) throws IOException {
      String choice = "";
      String label = "";
      String color = "";
      String delLabel = "";
      String labelFind = "";
      double edge = 0.0;
      String fileName = "";
      String input = "";
      
      String listName = "*** no list name assigned ***";
      Dodecahedron[] dodObj = new Dodecahedron[20];
      DodecahedronList2 dList
         = new DodecahedronList2(listName, dodObj, 0);
      Scanner scanIn = new Scanner(System.in);
      
      System.out.println("Dodecahedron List System Menu"
         + "\nR - Read File and Create Dodecahedron List"
         + "\nP - Print Dodecahedron List"
         + "\nS - Print Summary"
         + "\nA - Add Dodecahedron"
         + "\nD - Delete Dodecahedron"
         + "\nF - Find Dodecahedron"
         + "\nE - Edit Dodecahedron"
         + "\nQ - Quit");
   
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         input = scanIn.nextLine();
         choice = input.toUpperCase();
      
         switch (choice) {
            case "R":
               System.out.print("\tFile name: ");
               fileName = scanIn.nextLine();
               
               dList = dList.readFile(fileName);
               System.out.println("\tFile read"
                  + " in and Dodecahedron List created\n");
               
               break;
            
            case "P":
               System.out.println(dList);
               break;
               
            case "S":
               System.out.println(dList.summaryInfo());
               break;
               
            case "A":
               System.out.print("\tLabel: ");
               label = scanIn.nextLine();
               System.out.print("\tColor: ");
               color = scanIn.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scanIn.nextLine());
               
               dList.addDodecahedron(label, color, edge);
               
               System.out.println("\t*** Dodecahedron added ***\n");
               break;  
                            
            case "D":
               System.out.print("\tLabel: ");
               delLabel = scanIn.nextLine();
               
               
               if (dList.deleteDodecahedron(delLabel) == null) {
                  System.out.println("\t\"" + delLabel + "\" not found\n");
               } else {
                  dList.deleteDodecahedron(delLabel);
                  System.out.println("\t\"" + delLabel + "\" deleted\n");
               }
               break;
                              
            case "F":
               System.out.print("\tLabel: ");
               labelFind = scanIn.nextLine();
               
               if (dList.findDodecahedron(labelFind) == null) {
                  System.out.println("\t\"" + labelFind + "\" not found\n");
               } 
               else {
                  System.out.println(dList.findDodecahedron(labelFind) + "\n");
               }
               break;
               
            case "E":
               System.out.print("\tLabel: ");
               label = scanIn.nextLine();
               System.out.print("\tColor: ");
               color = scanIn.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scanIn.nextLine());
               
               
               if (dList.findDodecahedron(label) == null) {
                  System.out.println("\t\"" + label + "\" not found\n");
               } else {
                  dList.editDodecahedron(label, color, edge);
                  System.out.println("\t\""
                     + label + "\" successfully edited\n");
                  break;
               }
               
               
            case "Q":
               
               break;
               
            default:
               System.out.println("\t*** invalid code ***\n");
         }
      }
      while (!choice.equalsIgnoreCase("Q"));
   }
}