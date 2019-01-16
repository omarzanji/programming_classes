import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArraySet.java.
 *
 * Provides an implementation of the Set interface using an
 * array as the underlying data structure. Values in the array
 * are kept in ascending natural order and, where possible,
 * methods take advantage of this. Many of the methods with parameters
 * of type ArraySet are specifically designed to take advantage
 * of the ordered array implementation.
 *
 * @author Omar Barazanji (osb0002@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-10-02
 *
 */
public class ArraySet<T extends Comparable<? super T>> implements Set<T> {

   ////////////////////////////////////////////
   // DO NOT CHANGE THE FOLLOWING TWO FIELDS //
   ////////////////////////////////////////////
   T[] elements;
   int size;

   ////////////////////////////////////
   // DO NOT CHANGE THIS CONSTRUCTOR //
   ////////////////////////////////////
   /**
    * Instantiates an empty set.
    */
   @SuppressWarnings("unchecked")
   public ArraySet() {
      elements = (T[]) new Comparable[1];
      size = 0;
   }
    
   /**
    * Private constructor that is already sorted.
    * Useful to code other methods, delete this when done.
    */
 // private ArraySet(int[] a, int start, int end) {
      
 //  }

   ///////////////////////////////////
   // DO NOT CHANGE THE SIZE METHOD //
   ///////////////////////////////////
   /**
    * Returns the current size of this collection.
    *
    * @return  the number of elements in this collection.
    */
   @Override
   public int size() {
      return size;
   }

   //////////////////////////////////////
   // DO NOT CHANGE THE ISEMPTY METHOD //
   //////////////////////////////////////
   /**
    * Tests to see if this collection is empty.
    *
    * @return  true if this collection contains no elements,
    *               false otherwise.
    */
   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   ///////////////////////////////////////
   // DO NOT CHANGE THE TOSTRING METHOD //
   ///////////////////////////////////////
   /**
    * Return a string representation of this ArraySet.
    *
    * @return a string representation of this ArraySet
    */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }

   /**
    * Ensures the collection contains the specified element. Elements are
    * maintained in ascending natural order at all times. Neither duplicate nor
    * null values are allowed.
    *
    * @param  element  The element whose presence is to be ensured.
    * @return true if collection is changed, false otherwise.
    */
   @Override
   public boolean add(T element) {
      if (isFull() && !contains(element)) {
         resize(elements.length * 2);
      }
      if (element == null || contains(element)) {
         return false;
      }
      if (isEmpty()) {
         elements[0] = element;
         size++;
         return true;
      }
      int elementLocation = size;
      for (int i = 0; i < size; i++) {
         if (elements[i].compareTo(element) > 0) {
            elementLocation = i;
            break;
         }
      }
      if (elementLocation == size) {
         elements[elementLocation] = element;
         size++;
         return true;
      }
      for (int i = size - 1; i >= elementLocation; i--) {
         elements[i + 1] = elements[i];
      }
      elements[elementLocation] = element;
      size++;
      return true;
   }
   
   /**
    * Ensures the collection does not contain the specified element.
    * If the specified element is present, this method removes it
    * from the collection. Elements are maintained in ascending natural
    * order at all times.
    *
    * @param   element  The element to be removed.
    * @return  true if collection is changed, false otherwise.
    */
   @Override
   public boolean remove(T element) {
      if (isEmpty()) {
         return false;
      }
      if (!contains(element)) {
         throw new NoSuchElementException();
      }
      int loc = locate(element);
      if (loc < 0) {
         return false;
      }
      while (loc < size) {
         elements[loc] = elements[loc + 1];
         loc++;
      }
      size--;
      if (size > 0 && size < elements.length / 4) {
         resize(elements.length / 2);
      }
      return true;
   }

   /**
    * Searches for specified element in this collection.
    *
    * @param   element  The element whose presence in this collection
    *                   is to be tested.
    * @return  true if this collection contains the specified element,
    *               false otherwise.
    */
   @Override
   public boolean contains(T element) {
      if (isEmpty()) {
         return false;
      }
      int low = 0;
      int high = size() - 1;
      while (high >= low) {
         int mid = low + (high - low) / 2;
         if (elements[mid] != null && elements[mid].compareTo(element) == 0) {
            return true;
         }
         else if (elements[mid] != null && elements[mid].compareTo(element) < 0) {
            low = mid + 1;
         }
         else if (elements[mid] != null && elements[mid].compareTo(element) > 0) {
            high = mid - 1;
         }
         else {
            high--;
         }
      }
      return false;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements
    *               as the parameter set, false otherwise
    */
   @Override
   public boolean equals(Set<T> s) {
      if (s == null) {
         throw new NullPointerException();
      }
      if (size() != s.size()) {
         return false;
      }
      int count = 0;
      Iterator<T> itr = s.iterator();
      while (itr.hasNext()) {
         T t = itr.next();
         if (contains(t)) {
            count++;
         }
      }
      if (size() == count) {
         return true;
      }
      return false;
   }

   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * @return  true if this set contains exactly the same elements
    *               as the parameter set, false otherwise
    */
   public boolean equals(ArraySet<T> s) {
      if (s == null) {
         throw new NullPointerException();
      }
      if (size() != s.size()) {
         return false;
      }
      int count = 0;
      Iterator<T> itr = s.iterator();
      while (itr.hasNext()) {
         T t = itr.next();
         if (contains(t)) {
            count++;
         }
      }
      if (size() == count) {
         return true;
      }
      return false;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and
    *            the parameter set
    */
   @Override
   public Set<T> union(Set<T> s) {
      Set<T> union = new ArraySet<T>();
      if (isEmpty()) {
         return s;
      }
      for (int i = 0; i < size; i++) {
         union.add(elements[i]);
      }
      Iterator<T> itr = s.iterator();
      for (T item : s) {
         union.add(item);
      }
      return union;
   }

   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * @return  a set that contains all the elements of this set and
    *            the parameter set
    */
   public Set<T> union(ArraySet<T> s) {
      Set<T> union = new ArraySet<T>();
      if (isEmpty()) {
         return s;
      }
      for (int i = 0; i < size; i++) {
         union.add(elements[i]);
      }
      Iterator<T> itr = s.iterator();
      for (T item : s) {
         union.add(item);
      }
      return union;
   }


   /**
    * Returns a set that is the intersection of this set
    * and the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   @Override
   public Set<T> intersection(Set<T> s) {
      Set<T> intersection = new ArraySet<T>();
      Iterator<T> itr = s.iterator();
      for (int i = 0; i < size; i++) {
         T current = elements[i];
         int found = 0;
         for (T item : s) {
            if (current.compareTo(item) == 0) {
               found++;
            }
         }
         if (found > 0) {
            intersection.add(current);
         }
      }
      return intersection;
   }

   /**
    * Returns a set that is the intersection of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   public Set<T> intersection(ArraySet<T> s) {
      Set<T> intersection = new ArraySet<T>();
      Iterator<T> itr = s.iterator();
      for (int i = 0; i < size; i++) {
         T current = elements[i];
         int found = 0;
         for (T item : s) {
            if (current.compareTo(item) == 0) {
               found++;
            }
         }
         if (found > 0) {
            intersection.add(current);
         }
      }
      return intersection;
   }

   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   @Override
   public Set<T> complement(Set<T> s) {
      Set<T> complement = new ArraySet<T>();
      Iterator<T> itr = s.iterator();
      for (int i = 0; i < size; i++) {
         T current = elements[i];
         int found = 0;
         for (T item : s) {
            if (current.compareTo(item) == 0) {
               found++;
            }
         }
         if (found <= 0) {
            complement.add(current);
         }
      }
      return complement;
   }

   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   public Set<T> complement(ArraySet<T> s) {
      Set<T> complement = new ArraySet<T>();
      Iterator<T> itr = s.iterator();
      for (int i = 0; i < size; i++) {
         T current = elements[i];
         int found = 0;
         for (T item : s) {
            if (current.compareTo(item) == 0) {
               found++;
            }
         }
         if (found <= 0) {
            complement.add(current);
         }
      }
      return complement;
   }


   /**
    * Returns an iterator over the elements in this ArraySet.
    * No specific order can be assumed.
    *
    * @return  an iterator over the elements in this ArraySet
    */
   @Override
   public Iterator<T> iterator() {
         
      class ArrayIterator implements Iterator<T> {
         private T[] items;
         private int count;
         private int current;
         
         public ArrayIterator(T[] elem, int size) {
            items = elem;
            count = size;
            current = 0;
         }
         
         public boolean hasNext() {
            return (current < count);
         }
         
         public T next() {
            if (!hasNext()) {
               throw new NoSuchElementException();
            }
            return items[current++];
         }
         
         public void remove() {
            throw new UnsupportedOperationException();
         }
      }
      
      return new ArrayIterator(elements, size);
   }
   
   /**
    * Returns an iterator over the elements in this ArraySet.
    * The elements are returned in descending order.
    *
    * @return  an iterator over the elements in this ArraySet
    */
   public Iterator<T> descendingIterator() {
      class ArrayIterator implements Iterator<T> {
         private T[] items;
         private int count;
         private int current;
         
         public ArrayIterator(T[] elem, int size) {
            items = elem;
            count = size;
            current = size - 1;
         }
         
         public boolean hasNext() {
            return (current >= 0);
         }
         
         public T next() {
            if (!hasNext()) {
               throw new NoSuchElementException();
            }
            return items[current--];
         }
         
         public void remove() {
            throw new UnsupportedOperationException();
         }
      }
      
      return new ArrayIterator(elements, size);
   }

   /**
    * Returns an iterator over the members of the power set
    * of this ArraySet. No specific order can be assumed.
    *
    * @return  an iterator over members of the power set
    */
   public Iterator<Set<T>> powerSetIterator() {
      
      return null;
   }
   
   /////////////////////////////////
   //      PRIVATE METHODS        //
   //                             //
   /////////////////////////////////
   
   /**
    * Returns boolean if this array is full.
    *
    * @return true if full and false if otherwise.
    */
   private boolean isFull() {
      return size == elements.length;
   }
   
   /**
    * Resizes this array.
    */
   private void resize(int capacity) {
      assert capacity > 0;
      @SuppressWarnings("unchecked")
      T[] a = (T[]) new Comparable[capacity];
      System.arraycopy(elements, 0, a, 0, size);
      elements = a;
   }
   
   /**
    * Returns element location if located, and -1 if not.
    *
    * @return element location or -1 if not located.
    */
   private int locate(T element) {
      for (int i = 0; i < size; i++) {
         if (elements[i].equals(element)) {
            return i;
         }
      }
      return -1;
   }
}