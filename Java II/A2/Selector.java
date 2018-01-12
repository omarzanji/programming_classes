import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Omar Barazanji (osb0002@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2017-09-11
 *
 */
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }


   /**
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("Error, invalid argument");
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException("Error, empty collection");
      }
      Iterator<T> itr = coll.iterator(); //starts the iterator using Collection<T> coll as the iterable list.
      T min = (T) itr.next(); //makes the first object in coll the min.
      for (T t : coll) { //Populates a new array t of type T with the elements in coll and uses it to compare to min.
         if (comp.compare(min, t) > 0) { 
            min = t;
         }
      }
      return min;
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("Error, invalid argument");
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException("Error, empty collection");
      }
      Iterator<T> itr = coll.iterator();
      T max = (T) itr.next();
      for (T t : coll) {
         if (comp.compare(max, t) < 0) {
            max = t;
         }
      }
      return max;
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("Error, invalid argument");
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException("Error, empty collection");
      }
      ArrayList<T> noDuplicates = new ArrayList<T>();
      Iterator<T> itr = coll.iterator();
      for (T t : coll) {
         if (!noDuplicates.contains(t)) {
            noDuplicates.add(t);
         }
      }
      java.util.Collections.sort(noDuplicates, comp);
      if (k < 1 || k > coll.size() || k > noDuplicates.size()) {
         throw new NoSuchElementException("Error, invalid k");
      }
      T kmin = (T) noDuplicates.get(k - 1);
      return kmin;
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("Error, invalid argument");
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException("Error, empty collection");
      }
      ArrayList<T> noDuplicates = new ArrayList<T>();
      Iterator<T> itr = coll.iterator();
      for (T t : coll) {
         if (!noDuplicates.contains(t)) {
            noDuplicates.add(t);
         }
      }
      java.util.Collections.sort(noDuplicates, comp);
      ArrayList<T> noDuplicatesReversed = new ArrayList<T>();
      for (int i = 0; i < noDuplicates.size(); i++) {
         noDuplicatesReversed.add(noDuplicates.get(noDuplicates.size() - 1 - i));
      }
      if (k < 1 || k > coll.size() || k > noDuplicates.size()) {
         throw new NoSuchElementException("Error, invalid k");
      }
      T kmax = (T) noDuplicatesReversed.get(k - 1);
      return kmax;
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("Error, invalid argument");
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException("Error, empty collection");
      }
      ArrayList<T> range = new ArrayList<T>();
      Iterator<T> itr = coll.iterator();
      for (T t : coll) {
         if ((comp.compare(t, low) >= 0) && (comp.compare(t, high) <= 0)) {
            range.add(t);
         }
      }
      if (range.isEmpty()) {
         throw new NoSuchElementException("Error, no values qualify");
      }
      return range;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("Error, invalid argument");
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException("Error, empty collection");
      }
      Iterator<T> itr = coll.iterator();
      ArrayList<T> candidates = new ArrayList<T>();
      T result = (T) null;
      for (T t : coll) {
         if (comp.compare(t, key) >= 0) {
            candidates.add(t);
         }
      }
      result = Selector.min(candidates, comp);
      if (result == null) {
         throw new NoSuchElementException("Error, no vales qualify");
      }
      return result;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("Error, invalid argument");
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException("Error, empty collection");
      }
      Iterator<T> itr = coll.iterator();
      ArrayList<T> candidates = new ArrayList<T>();
      T result = (T) null;
      for (T t : coll) {
         if (comp.compare(t, key) <= 0) {
            candidates.add(t);
         }
      }
      result = Selector.max(candidates, comp);
      if (result == null) {
         throw new NoSuchElementException("Error, no vales qualify");
      }
      return result;
   }

}
