import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashSet;

/**
 * Provides an implementation of the WordLadderGame interface. The lexicon
 * is stored as a TreeSet of Strings.
 *
 * @author Omar Barazanji (osb0002@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-11-16
 */
public class Doublets implements WordLadderGame {

   // The word list used to validate words.
   // Must be instantiated and populated in the constructor.
   private TreeSet<String> lexicon;


   /**
    * Instantiates a new instance of Doublets with the lexicon populated with
    * the strings in the provided InputStream. The InputStream can be formatted
    * in different ways as long as the first string on each line is a word to be
    * stored in the lexicon.
    */
   public Doublets(InputStream in) {
      try {
         lexicon = new TreeSet<String>();
         Scanner s =
             new Scanner(new BufferedReader(new InputStreamReader(in)));
         while (s.hasNext()) {
            String str = s.next();
            lexicon.add(str.toLowerCase());
            s.nextLine();
         }
         in.close();
      }
      catch (java.io.IOException e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }
   
   /**
    * Returns the Hamming distance between two strings, str1 and str2. The
    * Hamming distance between two strings of equal length is defined as the
    * number of positions at which the corresponding symbols are different. The
    * Hamming distance is undefined if the strings have different length, and
    * this method returns -1 in that case. See the following link for
    * reference: https://en.wikipedia.org/wiki/Hamming_distance
    *
    * @param  str1 the first string
    * @param  str2 the second string
    * @return      the Hamming distance between str1 and str2 if they are the
    *                  same length, -1 otherwise
    */
   @Override
   public int getHammingDistance(String str1, String str2) {
      if (str1 == null || str2 == null) {
         return -1;
      }
      if (str1.length() != str2.length()) {
         return -1;
      }
      int result = 0;
      for (int i = 0; i < str1.length(); i++) {
         if (str1.charAt(i) != str2.charAt(i)) {
            result++;
         }
      }
      return result;
   }
   
   /**
    * Returns a word ladder from start to end. If multiple word ladders exist,
    * no guarantee is made regarding which one is returned. If no word ladder exists,
    * this method returns an empty list.
    *
    * Depth-first search with backtracking must be used in all implementing classes.
    *
    * @param  start  the starting word
    * @param  end    the ending word
    * @return        a word ladder from start to end
    */
   @Override
   public List<String> getLadder(String start, String end) {
      List<String> result = new ArrayList<String>();
        
      if (start.equals(end)) {
         result.add(start);
         return result;
      }
                
      TreeSet<String> one = new TreeSet<>();
      Deque<String> stack = new ArrayDeque<>();
       
      stack.addLast(start);
      one.add(start);
      while (!stack.isEmpty()) {
       
         String current = stack.peekLast();
         if (current.equals(end)) {
            break;
         }
         List<String> neighbors1 = getNeighbors(current);
         List<String> neighbors = new ArrayList<>();
          
         for (String word : neighbors1) {
            if (!one.contains(word)) {
               neighbors.add(word);
            }
         }
         if (!neighbors.isEmpty()) {
            stack.addLast(neighbors.get(0));
            one.add(neighbors.get(0));
         }
         else {
            stack.removeLast();
         }
      }
      result.addAll(stack);
      return result;
   }


   /**
    * Returns a minimum-length word ladder from start to end. If multiple
    * minimum-length word ladders exist, no guarantee is made regarding which
    * one is returned. If no word ladder exists, this method returns an empty
    * list.
    *
    * Breadth-first search must be used in all implementing classes.
     *
    * @param  start  the starting word
    * @param  end    the ending word
    * @return        a minimum length word ladder from start to end
    */
   @Override
   public List<String> getMinLadder(String start, String end) {
      if (start.length() != end.length()) {
         return emptyLadder();
      }
      if (!isWord(start) || !isWord(end)) {
         return emptyLadder();
      }
      List<String> ladder = new ArrayList<String>();
      if (start.equals(end)) {
         ladder.add(start);
         return ladder;
      }
      if (getHammingDistance(start, end) == 1) {
         ladder.add(start);
         ladder.add(end);
         return ladder;
      }
      breadthFirst(start, end, ladder);
      if (ladder.size() == 0) {
         return emptyLadder();
      }
      ladder.add(start);
      Collections.reverse(ladder);
      return ladder;
   }

   /**
    * Returns all the words that have a Hamming distance of one relative to the
    * given word.
    *
    * @param  word the given word
    * @return      the neighbors of the given word
    */
   @Override
   public List<String> getNeighbors(String word) {
      if (!isWord(word)) {
         return emptyLadder();
      }
      if (word.length() == 0) {
         return emptyLadder();
      }
      List<String> neighbors = new ArrayList<String>();
      char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'
         + 'q','r','s','t','u','v','w','x','y','z'};
      for (int i = 0; i < word.length(); i++) {
         for (int j = 0; j < letters.length; j++) {
            StringBuilder copy = new StringBuilder(word); 
            copy.setCharAt(i, letters[j]); 
            String copy2 = new String(copy); 
            if (isWord(copy2) && !neighbors.contains(copy2)) { 
               neighbors.add(copy2); 
               if (neighbors.contains(word)) {
                  neighbors.remove(word);
               }
            }
         }
      }
      return neighbors;
   }

   /**
    * Returns the total number of words in the current lexicon.
    *
    * @return number of words in the lexicon
    */
   @Override
   public int getWordCount() {
      int count = lexicon.size();
      return count;
   }
   
   /**
    * Checks to see if the given string is a word.
    *
    * @param str the string to check
    * @return true if str is a word, false otherwise
    */
   @Override
   public boolean isWord(String str) {
      if (str == null || str.length() == 0) {
         return false;
      }
      int isFound = 0;
      if (lexicon.contains(str)) {
         isFound++;
      }
      return (isFound == 1);
   }
   
   
   /**
    * Checks to see if the given string is a word.
    *
    * @param  str the string to check
    * @return     true if str is a word, false otherwise
    */
   /**
    * Checks to see if the given sequence of strings is a valid word ladder.
    *
    * @param  sequence the given sequence of strings
    * @return          true if the given sequence is a valid word ladder,
    *                       false otherwise
    */
   @Override
   public boolean isWordLadder(List<String> sequence) {
      if (sequence.isEmpty()) {
         return false;
      }
      if (sequence == null) {
         return false;
      }
      int count = 0;
      for (int i = 1; i < sequence.size(); i++) {
         if (isWord(sequence.get(count)) && isWord(sequence.get(i))) {
            if (getHammingDistance(sequence.get(count), sequence.get(i)) == 1) {
               count++;
            }
            else {
               return false;
            }
         }
         else {
            return false;
         }
      }
      return true;
   }
   
   /**
    * @return an empty lader.
    */
   private List<String> emptyLadder() {
      List<String> emptyLadder = new ArrayList<>();
      return emptyLadder;
   }
   
   /**
    * Breadth first search algorithm.
    *
    * @param start is the starting point.
    * @param end is the the ending point.
    * @param ladder is the ladder being searched.
    */
   private void breadthFirst(String start, String end, List<String> ladder) {
      Deque<String> queue = new ArrayDeque<>();
      HashSet<String> visited = new HashSet<String>();
      visited.add(start);
      queue.addLast(start);
      while (!queue.isEmpty()) {
         String position = queue.removeFirst();
         for (String s : getNeighbors(position)) {
            if (!visited.contains(s)) {
               visited.add(s);
               if (s.equals(end)) {
                  if (!ladder.contains(s)) {
                     ladder.add(s);
                  }
                  if (s.equals(start)) {
                     ladder.add(start);
                     return;
                  }
                  breadthFirst(start, position, ladder);
               }
               queue.addLast(s);
            }
         }
      }
   }
}
