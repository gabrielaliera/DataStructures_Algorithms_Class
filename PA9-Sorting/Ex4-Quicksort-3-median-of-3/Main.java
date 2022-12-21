/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/03/2022
    Description: Implement Quick Sort and collect data regarding number of key comparisons and data moves for a small list of 10 integer values: 4 3 1 0 9 8 6 7 5 2. You must try the given random list, sorted list, and a descending list. In addition, collect data and running time in milliseconds for data file small1k.txt containing 1,000 values in
random order. 

For each small list, output original list, sorted list, number of comparisons, and data
moves. For 1000 values, output number of comparisons, data moves, and running time.

    Implementation of Quick Sort is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
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
  // public static LinkedQueue<Pair> listA = new LinkedQueue<>();
  // public static LinkedQueue<Pair> listB = new LinkedQueue<>();
  // public static LinkedQueue<Pair> listC = new LinkedQueue<>();
  // public static LinkedQueue<Pair> listD = new LinkedQueue<>();
  public static Pair[] listA = new Pair[1000];
  public static Pair[] listB = new Pair[1000];
  public static Pair[] listC = new Pair[100000];
  public static Pair[] listD = new Pair[100000];
  
  //Print helper 
  public static void printQueue(LinkedQueue<Pair> q){
    int size = q.size();
    int count = 1;
    
    while(!q.isEmpty()){
      Pair entry = q.dequeue();
      
      if(count <= 5){
        System.out.println( "    "+ count + " Key: " + entry.getK() +" Value: "+entry.getV());
      }
      if(count>size-5 ){
        System.out.println("    "+count + " Key: " + entry.getK() +" Value: "+entry.getV());
      }
      count++;    
    }
 
  }
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
  
        // listC.enqueue(a);
        // listD.enqueue(b);
        listC[counter] =a;
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
    QuickSort sort = new QuickSort();
    DefaultComparator<Integer> comp = new DefaultComparator<>();
    StringComparator compS = new StringComparator();
    

    /************************************Testcase Small1k File*******************************************/
    System.out.print("\nSmall 1k File:");
    insertFileAB("small1k.txt"); //Read file and insert data into list and queue

    //Integer key, String Value
    System.out.println("\n  1.Number of values: "+ listA.length);
    System.out.println("  2.Key Data Type: " + listA[0].getK().getClass().getName());
    //Start timer, Sort, end timer
    double start = System.currentTimeMillis(); //Start time
    //sort.quickSort_Int(listA, comp);
    sort.quickSortInPlace(listA,comp);
    double finish = System.currentTimeMillis(); //End time
    double time = finish -start;                //Calculate time and print 
    System.out.println("  3.Data Moves: "+ sort.getDataMoves() +" \n    Comparisons: "+ sort.getComparsions()); 
    System.out.printf("  4.Sorting Runtime: %.3f ms \n", time);
    System.out.println("  5.First 5 and Last 5 entries:");
    //printQueue(listA);
    printList(listA);
    sort.resetComparsions(); sort.resetDataMoves();
    
    //String Key, Integer Value
    System.out.println("\n  1.Number of values: "+ listB.length);
    System.out.println("  2.Key Data Type: " + listB[0].getK().getClass().getName());
    start = System.currentTimeMillis(); //Start time
    //sort.quickSort_String(listB, compS);
    sort.quickSortInPlace_S(listB, compS);
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    
    System.out.println("  3.Data Moves: "+ sort.getDataMoves()+ " \n    Comparisons: "+ sort.getComparsions()); 
    System.out.printf("  4.Sorting Runtime: %.3f ms \n", time);
    System.out.println("  5.First 5 and Last 5 entries:");
    //printQueue(listB);
    printList(listB);
    sort.resetComparsions(); sort.resetDataMoves();

    // /************************************Testcase large100k File*******************************************/
    System.out.print("\nLarge 100k File:");
    insertFileCD("large100k.txt"); //Read file and insert data into list and queue

    //Integer key, String Value
    System.out.println("\n  1.Number of values: "+ listC.length);
    System.out.println("  2.Key Data Type: " + listC[0].getK().getClass().getName());
    
    //Start timer, Sort, end timer
    start = System.currentTimeMillis(); //Start time
    //sort.quickSort_Int(listC, comp);
    sort.quickSortInPlace(listC,comp);
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    
    //Output
    System.out.println("  3.Data Moves: "+ sort.getDataMoves() +" \n    Comparisons: "+ sort.getComparsions()); 
    System.out.printf("  4.Sorting Runtime: %.3f ms \n", time);
    System.out.println("  5.First 5 and Last 5 entries:");
    //printQueue(listC);
    printList(listC);
    sort.resetComparsions(); sort.resetDataMoves();
    
    //String Key, Integer Value
    System.out.println("\n  1.Number of values: "+ listD.length);
    System.out.println("  2.Key Data Type: " + listD[0].getK().getClass().getName());
    
    start = System.currentTimeMillis(); //Start time
    //sort.quickSort_String(listD, compS);
    sort.quickSortInPlace_S(listD, compS);
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    
    //Outputs
    System.out.println("  3.Data Moves: "+ sort.getDataMoves()+ " \n    Comparisons: "+ sort.getComparsions()); 
    System.out.printf("  4.Sorting Runtime: %.3f ms \n", time);
    System.out.println("  5.First 5 and Last 5 entries:");
    //printQueue(listD);
    printList(listD);
    sort.resetComparsions(); sort.resetDataMoves();
    
  }
}