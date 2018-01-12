import java.util.ArrayList;
import java.text.DecimalFormat;
/**
 * This program will make a list for every Dodecahedron
   inputted into the program by the user. This list 
   will also make some calculations.
 *
 * @author Omar Barazanji
 * @version 2/26/17
 */
 
public class DodecahedronList {
   
   private String listName;
   private ArrayList<Dodecahedron> dList;
   
   /**
    * Constructor for Dodecahedron List.
    *
    * @param listNameIn - used for list's name.
    * @param dListIn - used for array list.
    */   
   public DodecahedronList(String listNameIn, ArrayList<Dodecahedron> dListIn) {
      listName = listNameIn;
      dList = dListIn; 
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
      int output = 0;
      
      if (dList.size() == 0) {
         return output;
      }
      else {
         return dList.size();
      }
   }
   
   /**
    * Double that adds total surface areas.
    *
    * @return tag - used to return the total surface areas.
    */
   public double totalSurfaceArea() {
      double output = 0.0;
      int index = 0;
      
      while (index < dList.size()) {
         output += dList.get(index).surfaceArea();
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
      
      while (index < dList.size()) {
         output += dList.get(index).volume();
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
      
      if (dList.size() != 0) {
         while (index < dList.size()) {
            output += dList.get(index).surfaceArea();
            index++;
         }
   
         return (output / dList.size());
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
      
      if (dList.size() != 0) {
         while (index < dList.size()) {
            output += dList.get(index).volume();
            index++;
         }

         return (output / dList.size());
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
      
      if (dList.size() != 0) {
         while (index < dList.size()) {
            output
               += dList.get(index).surfaceToVolumeRatio();
            index++;
         }
      
         return (output / dList.size());
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
      while (index < dList.size()) {
         result += "\n" + dList.get(index) + "\n";
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
}