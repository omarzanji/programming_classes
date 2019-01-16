import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
/**
 * This program will test DodecahedronList2 Methods.
 *
 * @author Omar Barazanji
 * @version 3/27/17
 */
 
public class DodecahedronList2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests all getters. **/
   @Test public void gettersTest() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "white", 4.3);
      DodecahedronList2 d = new DodecahedronList2("Test List", dList, 2);
      Assert.assertEquals("getName Test", "Test List", d.getName());
      Assert.assertArrayEquals("getList test", dList, d.getList());
   }
   
   /** Tests the numberOfDodecahedrons() method. **/
   @Test public void numberOfDodecahedronsTest() {
      Dodecahedron[] dList = new Dodecahedron[20];
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 5);
      Assert.assertEquals("numberOfDodecahedrons Test",
                           5, d.numberOfDodecahedrons());      
   }
   
   /** Tests the totalSurfaceArea() method. **/
   @Test public void totalSurfaceAreaTest() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("totalSurfaceArea Test", 
                           369.352, d.totalSurfaceArea(), 0.001);
   }
   
   /** Tests the totalVolume() method. **/
   @Test public void totalVolumeTest() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("totalVolume Test", 
                           568.703, d.totalVolume(), 0.001);
   }
   
   /** Tests the averageSurfaceArea() method case 1. **/
   @Test public void averageSurfaceAreaTest1() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("averageSurfaceArea Test",
                           184.676, d.averageSurfaceArea(), 0.001);
   }
   
   /** Tests the averageSurfaceArea() method case 2. **/
   @Test public void averageSurfaceAreaTest2() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 0);
      Assert.assertEquals("averageSurfaceArea Test",
                           0.0, d.averageSurfaceArea(), 0.001);
   }
   
   /** Tests the averageVolume() method case 1. **/
   @Test public void averageVolumeTest1() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("averageVolume Test",
                           284.351, d.averageVolume(), 0.1);
   }
   
   /** Tests the averageVolume() method case 2. **/
   @Test public void averageVolumeTest2() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 0);
      Assert.assertEquals("averageVolume Test",
                           0.0, d.averageVolume(), 0.1);
   }
   
   /** Tests the averageSurfaceToVolumeRatio() method case 1. **/
   @Test public void averageSurfaceToVolumeRatioTest1() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("averageSurfaceToVolumeRatio Test",
                           3.015, d.averageSurfaceToVolumeRatio(), 0.001);
   }
   
   /** Tests the averageSurfaceToVolumeRatio() method case 2. **/
   @Test public void averageSurfaceToVolumeRatioTest2() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 0);
      Assert.assertEquals("averageSurfaceToVolumeRatio Test",
                           0.0, d.averageSurfaceToVolumeRatio(), 0.1);
   }
   
   /** Tests the toString() method. **/
   @Test public void toStringTest() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("toString Test",
                           true,
                           d.toString().contains("Dodecahedron \"Test\""));
   }
   
   /** Tests the summaryInfo() method. 
   * @throws IOException for reading files.
   */
   @Test public void summaryInfoTest() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("summaryInfo Test", true,
         d.summaryInfo().contains("Number of Dodecahedrons: 2"));
   }
   
   /** Tests the readFile() method.
   * @throws IOException for reading files.
   */
   @Test public void readFileTest() throws IOException {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      d = d.readFile("dodecahedron_data_1.txt");
      Assert.assertEquals("readFile Test",
                           "Dodecahedron Test List", d.getName());
   }
   
   /** Tests the addDodecahedron() method. **/
   @Test public void addDodecahedronTest() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Dodecahedron dod = new Dodecahedron("Hello", "green", 42.0);
      d.addDodecahedron("Hello", "green", 42.0);
      Dodecahedron[] dL = d.getList();
      Assert.assertEquals("addDodecahedron Test", dod, dL[2]);
   }
   
   /** Tests the findDodecahedron() method when true. **/
   @Test public void findDodecahedronTestTrue() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("findDodecahedron Test True", dList[0], 
                           d.findDodecahedron("Test"));
   }
   
   /** A Tests the findDodecahedron() method when false. **/
   @Test public void findDodecahedronTestFalse() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("findDodecahedron Test False", null, 
                           d.findDodecahedron("nope"));
   }

   /** Tests the deleteDodecahedron() method when true. **/
   @Test public void deleteDodecahedronTestTrue() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      d.deleteDodecahedron("Test");
      Assert.assertEquals("deleteDodecahedron Test", null, dList[1]);
   }
   
    /** Tests the deleteDodecahedron() method when false. **/
   @Test public void deleteDodecahedronFalseTestFalse() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      d.deleteDodecahedron("false");
      Assert.assertEquals("deleteDodecahedron Test False", dList[1], dList[1]);
   }
   
   /** Tests the editDodecahedron() method when true. **/
   @Test public void editDodecahedronTestTrue() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test List", dList, 2);
      d.editDodecahedron("test", "silver", 4.21);
      Assert.assertEquals("editDodecahedron Test True", "silver", 
                           dList[0].getColor());
   }
   
   /** Tests the editDodecahedron() method when false. **/
   @Test public void editDodecahedronTestFalse() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      d.editDodecahedron("nothere", "silver", 4.87);
      Assert.assertEquals("editDodecahedron Test False", "black", 
                           dList[0].getColor());
   }

   /** Tests the findDodecahedronWithShortestEdge() method when True. **/
   @Test public void findDodecahedronWithShortestEdgeTest() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 0.4);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("findDodecahedronWithShortestEdge Test True", 
                           dList[0], 
                           d.findDodecahedronWithShortestEdge());
   }
   
   /** Tests the findDodecahedronWithShortestEdge() method when false. **/
   @Test public void findDodecahedronWithShortestEdgeTestFalse() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 0);
      Assert.assertEquals("findDodecahedronWithShortestEdge Test False", 
                           null, 
                           d.findDodecahedronWithShortestEdge());
   }

   /** Tests the findDodecahedronWithLongestEdge() case 1. **/
   @Test public void findDodecahedronWithLongestEdgeTest1() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 0.4);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      dList[2] = new Dodecahedron("Test3", "blue", 6.9);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 3);
      Assert.assertEquals("findDodecahedronWithLongestEdge Test1", 
                           dList[2], 
                           d.findDodecahedronWithLongestEdge());
   }
   
   /** Tests the findDodecahedronWithLongestEdge() case 2. **/
   @Test public void findDodecahedronWithLongestEdgeTest2() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 0.4);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      dList[2] = new Dodecahedron("Test3", "blue", 6.9);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 0);
      Assert.assertEquals("findDodecahedronWithLongestEdge Test2", 
                           null, 
                           d.findDodecahedronWithLongestEdge());
   }
   
   /** Tests the findDodecahedronWithSmallestVolume() when true. **/
   @Test public void findDodecahedronWithSmallestVolumeTestTrue() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 0.4);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 2);
      Assert.assertEquals("findDodecahedronWithSmallestVolume Test", 
                           dList[0], 
                           d.findDodecahedronWithSmallestVolume());
   }
   
   /** Tests the findDodecahedronWithSmallestVolume() when false. **/
   @Test public void findDodecahedronWithSmallestVolumeTestFalse() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 0);
      Assert.assertEquals("findDodecahedronWithSmallestVolume Test", 
                           null, 
                           d.findDodecahedronWithSmallestVolume());
   }

   /** Tests the findDodecahedronWithLargestVolume() method when true. **/
   @Test public void findDodecahedronWithLargestVolumeTestTrue() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      dList[2] = new Dodecahedron("Test3", "blue", 6.9);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 3);
      Assert.assertEquals("findDodecahedronWithLargestVolume Test", 
                           dList[2], 
                           d.findDodecahedronWithLargestVolume());
   }
   
   /** Tests the findDodecahedronWithLargestVolume() method when false. **/
   @Test public void findDodecahedronWithLargestVolumeFalseTest() {
      Dodecahedron[] dList = new Dodecahedron[20];
      dList[0] = new Dodecahedron("Test", "black", 4.2);
      dList[1] = new Dodecahedron("Test2", "grey", 0.5);
      DodecahedronList2 d = new DodecahedronList2("Test", dList, 0);
      Assert.assertEquals("findDodecahedronWithLargestVolume Test", 
                           null, 
                           d.findDodecahedronWithLargestVolume());
   }
}