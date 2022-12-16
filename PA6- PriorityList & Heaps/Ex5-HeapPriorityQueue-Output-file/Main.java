/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/03/2022
    Description: – Modify your exercise 4 to output data to an output file as well with 5 values per line (at least one space between the 2 values). You can submit one version here to include exercise 4. Just provide the first screenshot of each data file for the submission.


    Modified from textbook- HeapPriority Queue
      Data Structures and Algorithms in Java, Sixth Edition
      Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
      John Wiley & Sons, 2014
    I certify the code below is my own: Main, maxComparator, minComparator
    Exception(s):
*/
import java.util.Comparator;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Iterator;
import java.lang.Iterable;

import java.util.ArrayList;


class Main {
  
  public static void sortRuntime(String fileName, String outputFile, HeapPriorityQueue<Integer,Integer> PQ){
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
  
    print(PQ); //print first and last five
    outputFile(outputFile, PQ); // create output file
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

  public static void outputFile(String fileName,HeapPriorityQueue<Integer,Integer> PQ){
      
      ArrayList<Entry<Integer,Integer>> heap  = PQ.getHeap();
      
      try{
        FileWriter myWriter = new FileWriter(fileName);
      
        int size = PQ.size();
        int counter = 0;
        for(int i=0; i< size;i++){
          myWriter.write(heap.get(i).getKey()+ " ");
          counter ++;
          if(counter ==5){
            myWriter.write("\n");
            counter= 0;
          }
        }
        myWriter.close();
      } catch (IOException e){
        System.out.println("Error");
        e.printStackTrace();
      }
  }
  
  public static void main(String[] args) {

    minComparator minComp = new minComparator();

    HeapPriorityQueue<Integer,Integer> PQ = new HeapPriorityQueue<>(minComp);
    sortRuntime("small1k.txt", "fileA.txt", PQ);
    
    HeapPriorityQueue<Integer,Integer> PQ2 = new HeapPriorityQueue<>(minComp);
    sortRuntime("large100k.txt","fileB.txt", PQ2);

  }
}