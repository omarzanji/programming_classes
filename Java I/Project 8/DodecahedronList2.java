import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
/**
 * This program will make a list for every Dodecahedron
   inputted into the program by the user. This list 
   will also make some calculations.
 *
 * @author Omar Barazanji
 * @version 3/5/17
 */
 
public class DodecahedronList2 {
   
   private String listName;
   private Dodecahedron[] dList;
   private int numDod;
   
   /**
    * Constructor for Dodecahedron List.
    *
    * @param listNameIn - used for list's name.
    * @param dListIn - used for array list.
    * @param numDodIn - used to count number of dodecahedrons.
    */   
   public DodecahedronList2(String listNameIn, Dodecahedron[] dListIn,
                            int numDodIn) {
      listName = listNameIn;
      dList = dListIn;
      numDod = numDodIn;
   }
   
   /**
    * String that gets the name of the list.
    *
    * @return tag - used to return the list's name.
    */
   public String getName() {
      return listName;
   }
   
   /**
    * Int that counts numbers of dodecahedrons entered.
    *
    * @return tag - used to return the number of dodecahedrons.
    */
   public int numberOfDodecahedrons() {
      return numDod;
   }
   
   /**
    * Double that adds total surface areas.
    *
    * @return tag - used to return the total surface areas.
    */
   public double totalSurfaceArea() {
      double output = 0.0;
      int index = 0;
      
      while (index < numDod) {
         output += dList[index].surfaceArea();
         index++;
      }
      
      return output;
   }
   
   /**
    * Double that adds the total volumes.
    *
    * @return tag - used to return the total volumes added.
    */
   public double totalVolume() {
      double output = 0.0;
      int index = 0;
      
      while (index < numDod) {
         output += dList[index].volume();
         index++;
      }
      
      return output;
   }
   
   /**
    * Double that gets the average of the surface areas.
    *
    * @return tag - used to return the average surface area.
    */
   public double averageSurfaceArea() {
      double output = 0.0;
      int index = 0;
      
      if (numDod != 0) {
         while (index < numDod) {
            output += dList[index].surfaceArea();
            index++;
         }
   
         return (output / numDod);
      }
      else {
         return output;
      }
   }
   
   /**
    * Double that calculates the average of the volumes.
    *
    * @return tag - used to return the average volumes.
    */
   public double averageVolume() {
      
      double output = 0.0;
      int index = 0;
      
      if (numDod != 0) {
         while (index < numDod) {
            output += dList[index].volume();
            index++;
         }

         return (output / numDod);
      }
      else {
         return output;
      }
   }
   
   /**
    * Double that calculates average SA to V ratio.
    *
    * @return tag - used to return average SA to V ratio.
    */
   public double averageSurfaceToVolumeRatio() {
      
      double output = 0.0;
      int index = 0;
      
      if (numDod != 0) {
         while (index < numDod) {
            output
               += dList[index].surfaceToVolumeRatio();
            index++;
         }
      
         return (output / numDod);
      }
      else {
         return output;
      }
   }
   
   /**
    * String that gets the result of the code.
    *
    * @return tag - used to return the result.
    */
   public String toString() {
      
      String result = listName + "\n";
      int index = 0;
      while (index < numDod) {
         result += "\n" + dList[index] + "\n";
         index++;
      }
      return result;
   }
   
   /**
    * String that summarizes the result.
    *
    * @return tag - used to return the result's summary.
    */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String result = "";
      result += "----- Summary for " + getName() + " -----";
      result += "\nNumber of Dodecahedrons: " + numberOfDodecahedrons();
      result += "\nTotal Surface Area: " + df.format(totalSurfaceArea()); 
      result += "\nTotal Volume: "  + df.format(totalVolume());
      result += "\nAverage Surface Area: "  + df.format(averageSurfaceArea());
      result += "\nAverage Volume: " + df.format(averageVolume());
      result += "\nAverage Surface/Volume Ratio: "
         + df.format(averageSurfaceToVolumeRatio());
      
      return result;
   }
   
   //********BEGIN NEW METHODS********
   //*********************************
   
   /**
    * Method for getting the list.
    *
    * @return tag - used to return list.
    */
   public Dodecahedron[] getList() {
      return dList;
   }
   
   /**
    * Method that reads the file.
    *
    * @param fileNameIn = used to read file.
    * @return tag - used to return list.
    * @throws IOException - used for file reading.
    */
   public DodecahedronList2 readFile(String fileNameIn) throws IOException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      Dodecahedron[] fileList = new Dodecahedron[20];
      String dogListName = "";
      String label = "";
      String color = "";
      double edge = 0;
      
      dogListName = scanFile.nextLine();   
      while (scanFile.hasNext()) {
         
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         
         Dodecahedron dodObj = new Dodecahedron(label, color, edge);
         fileList[numDod] = dodObj;
         numDod++;
      }
      
      DodecahedronList2 dodList = new DodecahedronList2(dogListName, fileList,
                                                         numDod);
      return dodList;
   }
   
   /**
    * Method for adding Dodecahedron.
    *
    * @param labelIn - used for adding label.
    * @param colorIn - used for adding color.
    * @param edgeIn - used for adding edge.
    */
   public void addDodecahedron(String labelIn, String colorIn, double edgeIn) {
      Scanner scan = new Scanner(System.in);
      
      Dodecahedron dodObj = new Dodecahedron(labelIn, colorIn, edgeIn);
      dList[numDod] = dodObj;
      numDod++;
   }   
   /**
    * Method that finds a dodecahedron.
    *
    * @param labelIn - used for finding label.
    * @return tag - used for returning the found dodecahedron.
    */
   public Dodecahedron findDodecahedron(String labelIn) {
      Dodecahedron result = null;
      for (int i = 0; i < numDod; i++) {
         if (dList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = dList[i];
            break;
         }
      }
      return result;
   }
     
   /**
    * Method that deletes a dodecahedron.
    *
    * @param deleteLabel - takes a label inputted.
    * @return tag - used to return deleted dodecahedron.
    */
   public Dodecahedron deleteDodecahedron(String deleteLabel) {
      Dodecahedron result = null;
      for (int i = 0; i < numDod; i++) {
         if (dList[i].getLabel().equalsIgnoreCase(deleteLabel)) {
            result = dList[i];
            for (int j = i; j < numDod - 1; j++) {
               dList[j] = dList[j + 1];
            }
            dList[numDod - 1] = null;
            numDod--;
            break;
         }
      }
      return result;
   }  
   
   /**
    * Method that edits the dodecahedron.
    *
    * @param labelIn - used to input a label.
    * @param colorIn - used to input a color.
    * @param edgeIn - used to input an edge.
    * @return tag - used to return a true or false statement.
    */
   public boolean editDodecahedron(String labelIn,
                                    String colorIn, double edgeIn) {
      boolean result = false;
      for (Dodecahedron dodObj : dList) {
         if (dodObj.getLabel().equalsIgnoreCase(labelIn)) {
            dodObj.setColor(colorIn);
            dodObj.setEdge(edgeIn);
            result = true;
            break;
         }
      }
      return result;
   }
}