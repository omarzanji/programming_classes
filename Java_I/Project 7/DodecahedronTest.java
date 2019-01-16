import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * This program will test the Dodecahedron methods.
 *
 * @author Omar Barazanji
 * @version 3/27/17
 */

public class DodecahedronTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Tests all getters. **/
   @Test public void gettersTest() {
      Dodecahedron d = new Dodecahedron("Test", "black", 4.2);
      Assert.assertEquals("Test", d.getLabel());
      Assert.assertEquals("black", d.getColor());
      Assert.assertEquals(4.2, d.getEdge(), 1.0);
   }
   
   /** Tests all true setters. **/
   @Test public void settersTestTrue() {
      Dodecahedron d = new Dodecahedron("Test", "black", 4.2);
      d.setLabel("Test");
      d.setColor("black");
      d.setEdge(4.2);
      Assert.assertEquals("Test", d.getLabel());
      Assert.assertEquals("black", d.getColor());
      Assert.assertEquals(4.2, d.getEdge(), 0.1);
   }
   
   /** Tests all false setters. **/
   @Test public void settersTestFalse() {
      Dodecahedron d = new Dodecahedron(null, null, -2);
      d.setLabel(null);
      d.setColor(null);
      d.setEdge(-2);
      Assert.assertEquals("", d.getLabel());
      Assert.assertEquals("", d.getColor());
      Assert.assertEquals(0.0, d.getEdge(), 0.1);
   }
   
   /** Tests the surfaceArea() method. **/
   @Test public void surfaceAreaTest() {
      Dodecahedron d = new Dodecahedron("Test", "black", 4.2);
      Assert.assertEquals(364.191, d.surfaceArea(), 0.001);
   }
   
   /** Tests the volume() method. **/
   @Test public void volumeTest() {
      Dodecahedron d = new Dodecahedron("Test", "black", 4.2);
      Assert.assertEquals(567.745, d.volume(), 0.001);
   }
   
   /** Tests the surfaceToVolumeRatio() method. **/
   @Test public void surfaceToVolumeRatioTest() {
      Dodecahedron d = new Dodecahedron("Test", "black", 4.2);
      Assert.assertEquals(0.641, d.surfaceToVolumeRatio(), 0.001);
   }
   
   /** Tests count methods. **/
   @Test public void countTests() {
      Dodecahedron d0 = new Dodecahedron("Test", "black", 4.2);
      d0.resetCount();
      Dodecahedron d1 = new Dodecahedron("Test", "black", 4.2);
      Assert.assertEquals(1, d1.getCount());
   }
   
   /** Tests the equals() method. **/
   @Test public void equalsTest() {
      Dodecahedron d0 = new Dodecahedron("Test", "black", 4.2);
      Dodecahedron d1 = new Dodecahedron("Test", "black", 4.2);
      Assert.assertEquals("equals test true", true, d0.equals(d1));
      d1 = new Dodecahedron("Test1", "blue", 4.2);
      Assert.assertEquals("equals test false", false, d0.equals(d1));
      d1 = new Dodecahedron("Test", "blue", 4.2);
      Assert.assertEquals("equals test false", false, d0.equals(d1));
      d1 = new Dodecahedron("Test", "black", 3.2);
      Assert.assertEquals("equals test false", false, d0.equals(d1));
      Assert.assertEquals("equals test false", false, d0.equals("test"));
      Assert.assertEquals("equals test false", 0, d0.hashCode());      
   }
   
   /** Tests the hashCode() method. **/
   @Test public void hashCodeTest() {
      Dodecahedron d = new Dodecahedron("Test", "black", 4.2);
      Assert.assertEquals(0, d.hashCode());
   }
   
   /** Tests the toString() method. **/
   @Test public void toStringTest() {
      Dodecahedron d = new Dodecahedron("Test", "black", 4.2);
      Assert.assertEquals("toString test true", true, 
         d.toString().contains("Dodecahedron \"Test\""));
   }
}