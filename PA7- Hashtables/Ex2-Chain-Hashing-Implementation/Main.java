/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/12/2022
    Description: –  Put together the C++ HashMap in the book (Chain Hashing ) or Java ChainHashing (Java book) with N = 11 and test it out with the same data and test cases from exercise 1.  You might want to come up with all relevant test cases to confirm that C++ HashMap or Java ChainHashing is working correctly. You do not need to work with the data files for this exercise

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
 
  public static void main(String[] args) {
    
    ChainHashMap<Integer,String> map = new ChainHashMap<Integer,String>(11);
    
    //Testcase 1
    System.out.println("Empty: " + map.isEmpty());
    map.put(13,"13");
    map.put(21,"21");
    map.put(5,"5");
    map.put(37,"37");
    map.put(15,"15");
    System.out.println(map.get(10));
    System.out.println(map.get(21));
    System.out.println("Removed: "+ map.remove(20));
    System.out.println("Removed: "+ map.remove(37));
    System.out.println("Find 37: "+ map.get(37));

    //Other Testcase
    map.put(10,"10");
    map.put(22,"22");
    map.put(7,"7");
    map.put(47,"47");
    map.put(35,"35");
    System.out.println("Size: "+ map.size());

    //Test entrySet() operator
    System.out.println("EntrySet:");
    Iterable mapIter = map.entrySet();
    Iterator iter = mapIter.iterator();
    
    while (iter.hasNext()){
      System.out.println(iter.next()+ " ");
    }
   
    System.out.println("Empty:" + map.isEmpty());
  }
}