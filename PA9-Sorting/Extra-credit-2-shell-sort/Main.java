/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/06/2022
    Description: Modify exercise 4 and collect data for either heap sort or Shell sort (pick one).

    Implementation of ShellSortt is modify from: https://www.geeksforgeeks.org/shellsort/

    I certify the code below is my own: Main, 
    Exception(s):
*/

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;

class Main {
  //Global queue for files
  public static Pair[] listA = new Pair[1000];
  public static Pair[] listB = new Pair[1000]; 
  public static Pair[] listC = new Pair[100000];
  public static Pair[] listD = new Pair[100000];


  //Print helper 
  public static void printList(Pair[] list){
    int size = list.length;
    
    for(int i =0;i<5;i++){
       System.out.println( "    "+ (i+1) + " Key: " + list[i].getK() +" Value: "+list[i].getV());
    }

    for(int i =size-5;i<size;i++){
       System.out.println( "    "+ (i+1) + " Key: " + list[i].getK() +" Value: "+list[i].getV());
    }
  }
  
  //Read file and insert data into nums
  public static void insertFileAB(String fileName){
    int counter =0;
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
      while (scan.hasNextInt()) {
        int data = scan.nextInt();   //Read number from file
       
        Pair a = new Pair(data,String.valueOf(data));
        Pair b = new Pair(String.valueOf(data),data);
  
       // listA.enqueue(a);
       // listB.enqueue(b);
        listA[counter] = a;
        listB[counter] = b;
        counter++;
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }

  public static void insertFileCD(String fileName){
    
    try{
      int counter =0;
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
      while (scan.hasNextInt()) {
        int data = scan.nextInt();   //Read number from file
       
        Pair a = new Pair(data,String.valueOf(data));
        Pair b = new Pair(String.valueOf(data),data);
  
        //listC.enqueue(a);
       // listD.enqueue(b);
        listC[counter] = a;
        listD[counter] = b;
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
    
    ShellSort sort  = new ShellSort();
  
    
       /************************************Testcase Small1k File*******************************************/
    System.out.print("\nSmall 1k File:");
    insertFileAB("small1k.txt"); //Read file and insert data into list and queue

    //Testcase  A : Integer key, String Value
    System.out.println("\n  1.Number of values: "+ listA.length);
    System.out.println("  2.Key Data Type: " + listA[0].getK().getClass().getName());
    //Start timer, Sort, end timer
    double start = System.currentTimeMillis(); //Start time
    sort.shellsort(listA);
    double finish = System.currentTimeMillis(); //End time
    double time = finish -start;                //Calculate time and print 
    System.out.println("  3.Data Moves: "+ sort.getDataMoves() +" \n    Comparisons: "+ sort.getComparisons()); 
    System.out.printf("  4.Sorting Runtime: %.3f ms \n", time);
    System.out.println("  5.First 5 and Last 5 entries:");
    printList(listA);
    sort.resetComparisons(); sort.resetDataMoves();
    
    //Testcase B String Key, Integer Value
    System.out.println("\n  1.Number of values: "+ listB.length);
    System.out.println("  2.Key Data Type: " + listB[0].getK().getClass().getName());
    start = System.currentTimeMillis(); //Start time
    sort.shellsortS(listB);
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    
    System.out.println("  3.Data Moves: "+ sort.getDataMoves()+ " \n    Comparisons: "+ sort.getComparisons()); 
    System.out.printf("  4.Sorting Runtime: %.3f ms \n", time);
    System.out.println("  5.First 5 and Last 5 entries:");
    printList(listB);
    sort.resetComparisons(); sort.resetDataMoves();

    

    /************************************Testcase large100k File*******************************************/
    System.out.print("\nLarge 100k File:");
    insertFileCD("large100k.txt"); //Read file and insert data into list and queue

    //Integer key, String Value
    System.out.println("\n  1.Number of values: "+ listC.length);
    System.out.println("  2.Key Data Type: " + listC[0].getK().getClass().getName());
    
    //Start timer, Sort, end timer
    start = System.currentTimeMillis(); //Start time
    sort.shellsort(listC);
    
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    
    //Output
    System.out.println("  3.Data Moves: "+ sort.getDataMoves() +" \n    Comparisons: "+ sort.getComparisons()); 
    System.out.printf("  4.Sorting Runtime: %.3f ms \n", time);
    System.out.println("  5.First 5 and Last 5 entries:");
    printList(listC);
    sort.resetComparisons(); sort.resetDataMoves();
    
    //String Key, Integer Value
    System.out.println("\n  1.Number of values: "+ listD.length);
    System.out.println("  2.Key Data Type: " + listD[0].getK().getClass().getName());
    
    start = System.currentTimeMillis(); //Start time
    sort.shellsortS(listD);
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    
    //Outputs
    System.out.println("  3.Data Moves: "+ sort.getDataMoves()+ " \n    Comparisons: "+ sort.getComparisons()); 
    System.out.printf("  4.Sorting Runtime: %.3f ms \n", time);
    System.out.println("  5.First 5 and Last 5 entries:");
    printList(listD);
    sort.resetComparisons(); sort.resetDataMoves();
  
  }
}