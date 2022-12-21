/*  Java Class: Main Driver w/ polynomial hashcode
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/12/2022
    Description: – Perform P-9.9 (pages 420-421 of C++ book). Use 0 (not a good value), 37, 40, and 41 for parameter a with polynomial hash codes or a shift of 0 (not a good value), 1, 5, and 13 for cyclic shift hash codes (only need to pick one method). Test it on the text file, US Declaration of Independence, and you can assume that words are separated by white space characters. Output number of words and number of collisions for each case. Make sure the results are reasonable (one of the 4 values should give a much higher number of collisions).

P-9.9 Perform a comparative analysis that studies the collision rates for various hash codes for character strings, such as various polynomial hash codes for different values of the parameter a. Use a hash table to determine collisions, but only count collisions where different strings map to the same hash code (not if they map to the same location in this hash table). Test these hash codes on text files found on the Internet.
    Implementation of ChainHashMap is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/
import java.util.HashMap;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.lang.Iterable;
import java.util.Iterator;
class Main {
 
  public static String[] getWords(String fileName){
    String[] holder = new String[1339];  //Create array to hold value from file
    
    try{
      File myObj = new File(fileName);
      Scanner doc = new Scanner(myObj).useDelimiter("[^a-zA-Z]+");
      
      
      int count = 0;                //Holds index value for array
      while (doc.hasNext()) {   //Read file
        String word = doc.next().toLowerCase();  //Scan file for integer
        holder[count] = word;       //Insert value into holder array
        count++;
      }
      doc.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return holder;
  }
  
  public static void wordMap_0(String[] words){
   
    ChainHashMap_0<String,Integer> freq = new ChainHashMap_0<>(); 
  
    for(int i=0; i<words.length;i++){
      Integer count = freq.get(words[i]);

      // get the previous count for this word
      if (count == null){
        count = 0;  
      }
                          // if not in map, previous count is zero
      freq.put(words[i], 1 + count);      // (re)assign new count for this word
    }
    System.out.println("Number of words: "+ freq.size());
    
    System.out.println("Number of collisions: "+ freq.getNumCollisions());
  
  }

  public static void wordMap_1(String[] words){
   
    ChainHashMap_1<String,Integer> freq = new ChainHashMap_1<>(); //use different cyclic shift
  
    for(int i=0; i<words.length;i++){
      Integer count = freq.get(words[i]);

      // get the previous count for this word
      if (count == null){
        count = 0;  
      }
                          // if not in map, previous count is zero
      freq.put(words[i], 1 + count);      // (re)assign new count for this word
    }
    System.out.println("Number of words: "+ freq.size());
    
    System.out.println("Number of collisions: "+ freq.getNumCollisions());
  
  }

  public static void wordMap_5(String[] words){
   
    ChainHashMap_5<String,Integer> freq = new ChainHashMap_5<>(); 
  
    for(int i=0; i<words.length;i++){
      Integer count = freq.get(words[i]);

      // get the previous count for this word
      if (count == null){
        count = 0;  
      }
                          // if not in map, previous count is zero
      freq.put(words[i], 1 + count);      // (re)assign new count for this word
    }
    System.out.println("Number of words: "+ freq.size());
    
    System.out.println("Number of collisions: "+  freq.getNumCollisions());
  
  }

  public static void wordMap_13(String[] words){
   
    ChainHashMap_13<String,Integer> freq = new ChainHashMap_13<>(); 
  
    for(int i=0; i<words.length;i++){
      Integer count = freq.get(words[i]);

      // get the previous count for this word
      if (count == null){
        count = 0;  
      }
                          // if not in map, previous count is zero
      freq.put(words[i], 1 + count);      // (re)assign new count for this word
    }
    System.out.println("Number of words: "+ freq.size());
    
    System.out.println("Number of collisions: "+  freq.getNumCollisions());
  
  }
  
  public static void main(String[] args) {
       
    
    String[] words = getWords("usdeclarPC.txt");
    
    //Testcase cyclic shift 0
    System.out.println("\nTestcase cyclic shift 0");
    wordMap_0(words);

    //Testcase cyclic shift 1
    System.out.println("\nTestcase cyclic shift 1");
    wordMap_1(words);

    //Testcase cyclic shift 5
    System.out.println("\nTestcase cyclic shift 5");
    wordMap_5(words);

    //Testcase cyclic shift 13
     System.out.println("\nTestcase cyclic shift 13");
    wordMap_13(words);
  }
}