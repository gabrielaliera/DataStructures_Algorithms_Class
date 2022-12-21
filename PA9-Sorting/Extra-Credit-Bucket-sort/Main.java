/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/03/2022
    Description:Implement bucket sort algorithm in the book and test it on the large data file large100k.txt (integer keys in the range [0, 99999]). Output the time in milliseconds, the first 5 values, and last values. You might want to compare the running time to the collected running time for quick sort in exercise 4 for large data file with
integer key.
    Implementation of BucketSort is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/
import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;

class Main {
  //Global queue for files
  public static int[] listA = new int[100000];
  public static int[] listB = new int[100000];

  //Print helper 
  public static void printList(int[] list){
    int size = list.length;
    
    for(int i =0;i<5;i++){
       System.out.println( "    "+ (i+1) + " Value: " + list[i]);
    }

    for(int i =size-5;i<size;i++){
       System.out.println( "    "+ (i+1) + " Value: " + list[i]);
    }
  }
  
  //Read file and insert data into nums
  public static void insertFileCD(String fileName){
    
    try{
      int counter = 0;
      
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
      while (scan.hasNextInt()) {
        int data = scan.nextInt();   //Read number from file
       
        listA[counter] = data;
        listB[counter] = data;
        counter++;
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }

  
  public static void main(String[] args) {
   
    // //Create insertion sort object
    QuickSort sort = new QuickSort();
    DefaultComparator<Integer> comp = new DefaultComparator<>();
    BucketSort sortB = new BucketSort();
  

    /**********Testcase large100k File*********************/
    System.out.print("\nLarge 100k File:");
    insertFileCD("large100k.txt"); //Read file and insert data into list and queue

   //QuickSort
    double start = System.currentTimeMillis(); //Start time
    sort.quickSortInPlace(listA, comp);
    double finish = System.currentTimeMillis(); //End time
    double time = finish -start;               //Calculate time  
    
    //Output
    System.out.printf("\n\nQuick Sort InPlace Runtime: %.3f ms \n", time);
    System.out.println("  First 5 and Last 5 entries:");
    printList(listA);
    sort.resetComparsions(); sort.resetDataMoves();
    
    //BucketSort
    start = System.currentTimeMillis(); //Start time
    sortB.bucketSort(listB);
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time 
    
    //Outputs
    System.out.printf("\nBucket Sort Runtime: %.3f ms \n", time);
    System.out.println("First 5 and Last 5 entries:");
    printList(listB);
  }
}