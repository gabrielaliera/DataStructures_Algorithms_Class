/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/03/2022
    Description: – Use your priority queue from exercise 1 to sort data in ascending order. Sort the data file small1k.txt, containing a list of 1,000 integer values, and output the first 5 and last 5 values to the screen (5 values on one line and at least one space between the 2 values). Sort the data file large100k.txt, containing a list of 100,000 integer values, and output the first 5 and last 5 values to the screen (5 values on one line and at least one space between the 2 values). For each set of data, collect actual run times in milliseconds and display to the screen as well.
    Modified from textbook-  HeapPriorityQueue 
      Data Structures and Algorithms in Java, Sixth Edition
      Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
      John Wiley & Sons, 2014
    Exception(s):
*/
import java.util.Comparator;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Iterator;
import java.lang.Iterable;
import java.util.ArrayList;

class Main {
  
  public static void sortRuntime(String fileName, HeapPriorityQueue<Integer,Integer> PQ){
    double start = System.currentTimeMillis();

    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
      while (scan.hasNextInt()) {
       int data = scan.nextInt();
       PQ.insert(data, data);
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    double finish = System.currentTimeMillis();
    double time = finish -start;
    System.out.printf("\n\nRuntime: %.3f ms \n", time);
  
    print(PQ);
  }
    
  public static void print(HeapPriorityQueue<Integer,Integer> PQ){
  
    int size = PQ.size();
    ArrayList<Entry<Integer,Integer>> heap  = PQ.getHeap();
    
    System.out.print("First Five: ");
    for(int i=0;i<5;i++){
      System.out.print(heap.get(i).getKey()+ " ");
    }
    
    System.out.print("\nLast Five: ");
    for(int i=size-5;i<size;i++){
      System.out.print(heap.get(i).getKey()+ " ");
    }
  }
  
  public static void main(String[] args) {

    minComparator minComp = new minComparator();

    HeapPriorityQueue<Integer,Integer> PQ = new HeapPriorityQueue<>(minComp);
    sortRuntime("small1k.txt", PQ);
    
    HeapPriorityQueue<Integer,Integer> PQ2 = new HeapPriorityQueue<>(minComp);
    sortRuntime("large100k.txt",PQ2);

  }
}