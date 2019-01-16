/**
* LinkedStrand.java
* Provides a linked chunk list implementation of the DnaStrand interface.
*
* @author   Omar Barazanji (osb0002@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2017-10-17
*
*/
public class LinkedStrand implements DnaStrand {

   /**
    * Container for storing DNA information. A given DNA strand is
    * represented by a chain of nodes.
    *
    * D O   N O T   M A K E   A N Y   C H A N G E S   T O
    *
    * T H E   N O D E   C L A S S
    *
    */
   class Node {
      String dnaInfo;
      Node next;

      public Node() {
         dnaInfo = "";
         next = null;
      }

      public Node(String s, Node n) {
         dnaInfo = s;
         next = n;
      }
   }

   /** An empty strand. */
   public static final LinkedStrand EMPTY_STRAND = new LinkedStrand();

   /** The first and last node in this LinkedStrand. */
   // D O   N O T   C H A N G E   T H E S E   F I E L D S
   Node front;
   Node rear;


   /** The number of nucleotides in this strand. */
   long size;

   /**
    * Create a strand representing an empty DNA strand, length of zero.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    */
   public LinkedStrand() {
      front = null;
      rear = null;
      size = 0;
   }


   /**
    * Create a strand representing s. No error checking is done to see if s represents
    * valid genomic/DNA data.
    *
    * @param s is the source of cgat data for this strand
    */
   public LinkedStrand(String s) {
      front = rear = new Node(s, null);
      size = s.trim().length();
   }


   /**
    * Appends the parameter to this strand changing this strand to represent
    * the addition of new characters/base-pairs, e.g., changing this strand's
    * size.
    *
    * If possible implementations should take advantage of optimizations
    * possible if the parameter is of the same type as the strand to which data
    * is appended.
    *
    * @param dna is the strand being appended
    * @return this strand after the data has been added
    */
   @Override
   public DnaStrand append(DnaStrand dna) {
      if (dna == null || dna.size() == 0) {
         return this;
      }
      if (this.size() == 0) {
         LinkedStrand temp = new LinkedStrand(dna.toString());
         this.front = temp.front;
         this.rear = temp.rear;       
         size = temp.size();
         return temp; 
      }
      if (dna instanceof LinkedStrand) {
         LinkedStrand temp = (LinkedStrand) dna;
         rear.next = temp.front;
         rear = temp.rear;
         size += temp.size();
         return this;
      }
      else {
         return append(dna.toString());
      }
   }


   /**
    * Similar to append with a DnaStrand parameter in
    * functionality, but fewer optimizations are possible. Typically this
    * method will be called by the append method with an DNAStrand
    * parameter if the DnaStrand passed to that other append method isn't the same
    * class as the strand being appended to.
    *
    * @param dna is the string appended to this strand
    * @return this strand after the data has been added
    */
   @Override
   public DnaStrand append(String dna) {
      if (dna == null || dna.length() == 0) {
         return this;
      }
      if (this.size() == 0) {
         LinkedStrand temp = new LinkedStrand(dna);
         this.front = temp.front;
         this.rear = temp.rear; 
         size = temp.size();
         return temp;
      }
      Node temp = new Node(dna, null);
      rear.next = temp;
      rear = rear.next;
      size += dna.length();
      return this;
   }


   /**
    * Cut this strand at every occurrence of enzyme, replacing
    * every occurrence of enzyme with splice.
    *
    * @param enzyme is the pattern/strand searched for and replaced
    * @param splice is the pattern/strand replacing each occurrence of enzyme
    * @return the new strand leaving the original strand unchanged.
    */
   @Override
   public DnaStrand cutAndSplice(String enzyme, String splice) {
      if (front != rear) {
         throw new IllegalStateException();
      }
      LinkedStrand ret = new LinkedStrand(front.dnaInfo);
      int pos = 0;
      boolean isSpliced = false;
      Node p = ret.front;
      while (p.dnaInfo.contains(enzyme)) {
         pos = p.dnaInfo.indexOf(enzyme);
         if (pos == 0) {
            p.next = new Node(p.dnaInfo.substring(pos + enzyme.length()), null);
            p.dnaInfo = splice;
            if (p.next.dnaInfo.length() == 0) {
               p.next = null;
            }
            else {
               p = p.next;
            }
            ret.size = ret.size - enzyme.length() + splice.length();
         }
         else {
            p.next = new Node(p.dnaInfo.substring(pos), null);
            p.dnaInfo = p.dnaInfo.substring(0, pos);
            p = p.next;
         }
         isSpliced = true;
      }
      ret.rear = p;
      if (!isSpliced) {
         return EMPTY_STRAND;
      }
      return ret;
   }

   /**
    * Simulate a restriction enzyme cut by finding the first occurrence of
    * enzyme in this strand and replacing this strand with what comes before
    * the enzyme while returning a new strand representing what comes after the
    * enzyme. If the enzyme isn't found, this strand is unaffected and an empty
    * strand with size equal to zero is returned.
    *
    * @param enzyme is the string being searched for
    * @return the part of the strand that comes after the enzyme
    */
   @Override
   public DnaStrand cutWith(String enzyme) {
      if (front != rear) {
         throw new IllegalStateException();
      }
      if (enzyme == front.dnaInfo) {
         return EMPTY_STRAND;
      }
      int pos = front.dnaInfo.indexOf(enzyme);
      if (pos == -1) {
         return EMPTY_STRAND;
      }
      if (pos + enzyme.length() == front.dnaInfo.length()) {
         initializeFrom(front.dnaInfo.substring(0, pos));
         return EMPTY_STRAND;
      }
      DnaStrand ret = new LinkedStrand(front.dnaInfo.substring(pos + enzyme.length()));
      initializeFrom(front.dnaInfo.substring(0, pos));
      return ret;
   }


   /**
    * Initialize by copying DNA data from the string into this strand,
    * replacing any data that was stored. The parameter should contain only
    * valid DNA characters, no error checking is done by the this method.
    *
    * @param source is the string used to initialize this strand
    */
   @Override
   public void initializeFrom(String source) {
      if (source.length() == 0) {
         front = null;
         rear = null;
         size = 0;
      }
      else {
         Node n = new Node(source, null);
         front = n;
         rear = n;
         size = source.length();
      }
   }

   /**
    * Returns the number of elements/base-pairs/nucleotides in this strand.
    * @return the number of base-pairs in this strand
    */
   @Override
   public long size() {
      return size;
   }


   /**
    * Returns a string representation of this LinkedStrand.
    */
   @Override
   public String toString() {
      String s = "";
      Node n = front;
      if (n == null) {
         return "";
      }
      while (n != null) {
         s += n.dnaInfo;
         n = n.next;
      }
      return s;
   }

}
