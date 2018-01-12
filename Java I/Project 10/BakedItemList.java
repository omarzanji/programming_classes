import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
/**
 * This program will generate reports from list of items.
 *
 * @author Omar Barazanji
 * @version 4/15/17
 */
public class BakedItemList {
   private String listName;
   private BakedItem[] itemList = new BakedItem[100];
   private int itemCount;
   private String[] excludedRecords = new String[30];
   private int excludedCount;
   private static int listCount = 0; //tracks BakedItem[]
   
   /**
    * Constructor for BakedItemList.
    */
   public BakedItemList() {
      listName = "";
      itemCount = 0;
      excludedCount = 0;
      listCount++;
   }
   
   /**
    * Method that gets the list name.
    *
    * @return - used to return the list name.
    */
   public String getListName() {
      return listName;
   }
   
   /**
    * Method that sets the list name.
    *
    * @param listNameIn - used to set the list name.
    */
   public void setListName(String listNameIn) {
      listName = listNameIn;
   }
   
   /**
    * Method that gets the item list.
    *
    * @return itemList - used to return item list.
    */
   public BakedItem[] getItemList() {
      return itemList;
   }
   
   /**
    * Method that sets the item list.
    *
    * @param itemIn - used to set item list.
    */
   public void setItemList(BakedItem ... itemIn) {
      itemList = itemIn;
   }
   
   /**
    * Method that gets the item count.
    *
    * @return itemCount - used to return item count.
    */
   public int getItemCount() {
      return itemCount;
   }
   
   /**
    * Method that sets the item count.
    *
    * @param countIn - used to set item count.
    */
   public void setItemCount(int countIn) {
      itemCount = countIn;
   }
   
   /**
    * Method that gets excluded records.
    *
    * @return - used to return excluded records.
    */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   
   /**
    * Method that sets excluded records.
    *
    * @param exRecordsIn - used to set excluded records.
    */
   public void setExcludedRecords(String ... exRecordsIn) {
      excludedRecords = exRecordsIn;
   }
   
   /**
    * Method that gets excluded count.
    *
    * @return - used to return excluded count.
    */
   public int getExcludedCount() {
      return excludedCount;
   }
   
   /**
    * Method that sets excluded count.
    *
    * @param exCountIn - used to set excluded count.
    */
   public void setExcludedCount(int exCountIn) {
      excludedCount = exCountIn;
   }
   
   /**
    * Method that gets list count.
    *
    * @return - used to return list count.
    */
   public static int getListCount() {
      return listCount;
   }
   
   /**
    * Method that sets list count.
    *
    * @param listCountIn - used to set list count.
    */
   public static void setListCount(int listCountIn) {
      listCount = listCountIn;
   }
   
   /**
    * Method that resets list count.
    */
   public static void resetListCount() {
      listCount = 0;
   }
   
   /**
    * Method that reads in a file and organizes data.
    *
    * @param fileIn - used to input a file name.
    * @throws IOException - used to read a file.
    */
   public void readItemFile(String fileIn) throws IOException {
      Scanner scanFile = new Scanner(new File(fileIn));
      listName = scanFile.nextLine();
      String item = "";
      int newItem = 0;
      int excludedItem = 0;
      String itemClass = "";
      String itemName = "";
      String itemFlavor = "";
      int itemQuantity = 0;
      double itemCrustCost = 0;
      int itemLayers = 0;
      int itemTiers = 0;
      String[] itemIngredients = new String[50];
      int ingredient = 0;
      int numIngredients = 0;

      while (scanFile.hasNext()) {
         item = scanFile.nextLine();
         Scanner scanItem = new Scanner(item).useDelimiter(",");
         itemClass = scanItem.next();

         if (itemClass.contains("C")) {
            itemName = scanItem.next();
            itemFlavor = scanItem.next();
            itemQuantity = Integer.parseInt(scanItem.next());
            while (scanItem.hasNext()) {
               itemIngredients[ingredient] = scanItem.next();
               ingredient++;
            }
            String[] itemIngredientsLine = 
               Arrays.copyOf(itemIngredients, ingredient);
            Cookie itemCookie = new Cookie(itemName, itemFlavor,
                                           itemQuantity, itemIngredientsLine);
            itemList[newItem] = itemCookie;
            newItem++;
            itemCount++;
            ingredient = 0;
         }

         else if (itemClass.contains("P")) {
            itemName = scanItem.next();
            itemFlavor = scanItem.next();
            itemQuantity = Integer.parseInt(scanItem.next());
            itemCrustCost = Double.parseDouble(scanItem.next());
            while (scanItem.hasNext()) {
               itemIngredients[ingredient] = scanItem.next();
               ingredient++;
            }
            String[] itemIngredientsLine = 
               Arrays.copyOf(itemIngredients, ingredient);
            Pie itemPie = new Pie(itemName, itemFlavor,
                                  itemQuantity, itemCrustCost, 
                                  itemIngredientsLine);
            itemList[newItem] = itemPie;
            newItem++;
            itemCount++;
            ingredient = 0;
         }

         else if (itemClass.contains("K")) {
            itemName = scanItem.next();
            itemFlavor = scanItem.next();
            itemQuantity = Integer.parseInt(scanItem.next());
            itemLayers = Integer.parseInt(scanItem.next());
            while (scanItem.hasNext()) {
               itemIngredients[ingredient] = scanItem.next();
               ingredient++;
            }
            String[] itemIngredientsLine = 
               Arrays.copyOf(itemIngredients, ingredient);
            Cake itemCake = new Cake(itemName, itemFlavor,
                                     itemQuantity, itemLayers,
                                     itemIngredientsLine);
            itemList[newItem] = itemCake;
            newItem++;
            itemCount++;
            ingredient = 0; 
         }

         else if (itemClass.contains("W")) {
            itemName = scanItem.next();
            itemFlavor = scanItem.next();
            itemQuantity = Integer.parseInt(scanItem.next());
            itemLayers = Integer.parseInt(scanItem.next());
            itemTiers = Integer.parseInt(scanItem.next());
            while (scanItem.hasNext()) {
               itemIngredients[ingredient] = scanItem.next();
               ingredient++;
            }
            String[] itemIngredientsLine =
               Arrays.copyOf(itemIngredients, ingredient);
            WeddingCake itemW = new WeddingCake(itemName,
                                                itemFlavor, itemQuantity,
                                                itemLayers,
                                                itemTiers, itemIngredientsLine);
            itemList[newItem] = itemW;
            newItem++;
            itemCount++;
            ingredient = 0; 
         }
         else {
            excludedRecords[excludedItem] = "*** invalid category *** "
               + "for line:\n" + item;
            excludedItem++;
            excludedCount++;
            scanItem.nextLine();
         }
      }
   }
   
   /**
    * Method that generates a report.
    *
    * @return - used to return a string report.
    */
   public String generateReport() {
      String result = "";
      result = "\n---------------------------------------"
          + "\nReport for " + getListName()
          + "\n---------------------------------------\n";
      
      BakedItem[] bList = Arrays.copyOf(itemList, itemCount);
      
      int i = 0;
      while (bList.length > i) {
         result = result + "\n" + bList[i] + "\n";
         i++;
      }
      return result;
   }
   
   /**
    * Method that generates a report by class.
    *
    * @return - used to return a string report organized by class.
    */
   public String generateReportByClass() {
      String result = "";
      result = "\n---------------------------------------"
         + "\nReport for " + getListName() + " (by Class)"
         + "\n---------------------------------------\n";
      BakedItem[] bList = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(bList);
      
      for (BakedItem temp: bList) {
         result += "\n" + temp + "\n";
      }
      
      return result;
   }
   
   /**
    * Method that generates a report by price.
    *
    * @return - used to return a string report organized by price.
    */

   public String generateReportByPrice() {
      String result = "";   
      result = "\n---------------------------------------"
         + "\nReport for " + getListName() + " (by Price)"
         + "\n---------------------------------------\n";
      BakedItem[] bList = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(bList, new PriceComparator());   
      
      int i = 0;
      while (bList.length > i) {
         result += "\n" + bList[i] + "\n";
         i++;
      }
      return result; 
   }
   
   /**
    * Method that generates a report by flavor.
    *
    * @return - used to return a string report organized by flavor.
    */
   public String generateReportByFlavor() {
      String result = "";
      result = "\n---------------------------------------"
         + "\nReport for " + getListName() + " (by Flavor)"
         + "\n---------------------------------------\n";
      BakedItem[] bList = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(bList, new FlavorComparator());
      
      int i = 0;
      while (bList.length > i) {
         result += "\n" + bList[i] + "\n";
         i++;
      }
      
      return result;
   }
   
   /**
    * Method that generates a report of excluded items.
    *
    * @return - used to return a string report organized by excluded items.
    */
   public String generateExcludedRecordsReport() {
      String result = "";
      result = "\n---------------------------------------"
             + "\nExcluded Records Report"
             + "\n---------------------------------------\n"; 
      for (int i = 0; i < excludedCount; i++) {
         result += "\n" + excludedRecords[i];
      }
      return result;
   }
}