/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/03/2022
    Description: – Use your priority queue from exercise 1 to sort data in ascending order. Sort the data file small1k.txt, containing a list of 1,000 integer values, and output the first 5 and last 5 values to the screen (5 values on one line and at least one space between the 2 values). Sort the data file large100k.txt, containing a list of 100,000 integer values, and output the first 5 and last 5 values to the screen (5 values on one line and at least one space between the 2 values). For each set of data, collect actual run times in milliseconds and display to the screen as well.


    Modified from textbook-  SortedPriorityQueue 
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

class Main {
  
  public static void sortRuntime(String fileName, SortedPriorityQueue<Integer,Integer> PQ){
    double start = System.currentTimeMillis(); //Start timer

    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
      while (scan.hasNextInt()) {
       int data = scan.nextInt();   //Read number from file
       PQ.insert(data, data);      //insert number into PQ
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    double finish = System.currentTimeMillis();  //End timer
    double time = finish -start;
    System.out.printf("\nRuntime: %.3f ms \n", time);  
  
    print(PQ);   //Print First and Last 5 numbers in sorted PQ
  }
  
    public static void print(SortedPriorityQueue<Integer,Integer> PQ){
      int count = 0;
      LinkedPositionalList<Entry<Integer,Integer>> list = PQ.getList();
      int size = list.size();
      
      Iterable<Position<Entry<Integer,Integer>>> iter = list.positions();  //Create position iterator
      Iterator<Position<Entry<Integer,Integer>>> myCursor = iter.iterator();   // Create cursor 
    
      while(myCursor.hasNext()){
        Position<Entry<Integer,Integer>> data = myCursor.next();
        count++;
        
        if( count <= 5){
          System.out.print(data.getElement().getKey()+ " ");
        } else if( count > size-5){
          if(count-1 == size -5){System.out.println();} 
          System.out.print(data.getElement().getKey()+ " ");
        }
      }    
  }
  
  public static void main(String[] args) {

    minComparator minComp = new minComparator();

    SortedPriorityQueue<Integer,Integer> PQ = new SortedPriorityQueue<>(minComp);
    sortRuntime("small1k.txt", PQ);
    
    SortedPriorityQueue<Integer,Integer> PQ2 = new SortedPriorityQueue<>(minComp);
    sortRuntime("large100k.txt",PQ2);

  }
}