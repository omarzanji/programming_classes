import java.text.DecimalFormat;
/**
 * This program will calculate the characteristics of a dodecahedron
   and use this code in another class called Dodecahedron.java.
 *
 * @author Omar Barazanji
 * @version 2/12/17
 */

public class Dodecahedron { 

   private String label = "";
   private String color = "";
   private double edge = 0;
   
   /**
    * Constructor for the class.
    *
    * @param labelIn - used for label.
    * @param colorIn - used for color.
    * @param edgeIn - used for edge.
    */
   public Dodecahedron(String labelIn,
                        String colorIn, double edgeIn)
   {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
   }
   
   /**
    * Method for label in the class.
    *
    * @return tag - used to return label.
    */
   public String getLabel() {
      return label;
   }
   
   /**
    * Method that sets the label.
    *
    * @param labelIn - used for label.
    * @return tag - used to return label.
    */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    * Method that gets the color.
    *
    * @return tag - used to return color.
    */
   public String getColor() {
      return color;
   }
   
   /**
    * Method that sets the color.
    *
    * @param colorIn - used for color.
    * @return tag - used to return color.
    */
   public boolean setColor(String colorIn) {
      if (colorIn != null) {
         color = colorIn.trim();
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    * Method that gets the edge.
    *
    * @return tag - used to return edge.
    */
   public double getEdge() {
      return edge;
   }
   
   /**
    * Method that sets the edge.
    *
    * @param edgeIn - used for edge.
    * @return tag - used to return edge.
    */
   public boolean setEdge(double edgeIn) {
      if (edgeIn > 0) {
         edge = edgeIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    * Method that calculates surface area.
    *
    * @return tag - used to return surface area.
    */
   public double surfaceArea() {
      double surfaceArea = (3 * Math.sqrt(25 + 10 * Math.sqrt(5))
         * Math.pow(edge, 2));
      return surfaceArea;
   }
   
   /**
    * Method that calculates volume.
    *
    * @return tag - used to return volume.
    */
   public double volume() {
      double volume = (((15 + 7 * Math.sqrt(5)) * Math.pow(edge, 3)) / (4));
      return volume;
   }
   
   /**
    * Method that calculates the surface area to volume ratio.
    *
    * @return tag - used to return ratio.
    */
   public double surfaceToVolumeRatio() {
      double surfaceToVolumeRatio = (surfaceArea() / volume());
      return surfaceToVolumeRatio;
   }
   
   /**
    * Method that returns the result of the code.
    *
    * @return tag - returns the result.
    */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      
      String result = "Dodecahedron " + "\"" + label + "\""
         + " is " + "\"" + color + "\""
         + " with 30 edges of length " + edge + " units." 
         + "\n" + "\t" + "surface area = " + df.format(surfaceArea())
         + " square units" + "\n" + "\t" + "volume = "
         + df.format(volume()) + " cubic units" + "\n" + "\t"
         + "surface/volume ratio = " + df.format(surfaceToVolumeRatio());
         
      return result;
   }
}