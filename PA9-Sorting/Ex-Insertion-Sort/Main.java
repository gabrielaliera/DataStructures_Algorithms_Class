/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/03/2022
    Description: Implement Insertion Sort and collect data regarding number of key comparisons and data moves for a small list of 10 integer values: 4 3 1 0 9 8 6 7 5 2. You must try the given random list, sorted list, and a descending list. In addition, collect data and running time in milliseconds for data file small1k.txt containing 1,000 values in
random order. 
For each small list, output original list, sorted list, number of comparisons, and data moves. For 1000 values, output number of comparisons, data moves, and running time.

    Implementation of Insertion is modify from:
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

class Main {
  //Global integer array for small1k file
  public static int[] nums = new int[1000];

  //Print helper 
  public static void printList(int[] list){
    for(int x : list ){
      System.out.print(x +" ");
    }
  }

  //Read file and insert data into nums
  public static void insertFile(String fileName){
    int counter = 0;
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
      while (scan.hasNextInt()) {
       int data = scan.nextInt();   //Read number from file
       nums[counter] = data;
       counter++;
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) {
   
    //Create insertion sort object
    InsertionSort sort = new InsertionSort();
    System.out.println("\n******Insertion Sort******");
    //Testcase 1
    System.out.print("\nOriginal list: ");
    int[] orignal = {4,3,1,0,9,8,6,7,5,2};
    printList(orignal);
    sort.insertionSort(orignal);
    System.out.print("Sorted Original list: ");
    printList(orignal);
    System.out.println();

    //Testcase 2
    System.out.print("\nRandom list: ");
    int[] random = new int[10];
    Random rand = new Random();
    for(int i=0; i<10;i++){
      random[i] = rand.nextInt(100);
    }
    printList(random);
    sort.insertionSort(random);
    System.out.print("Sorted Random list: ");
    printList(random);
    System.out.println();

    //Testcase 3
    System.out.print("\nSorted-list:");
    int[] sorted = {1,2,3,4,5,6,7,8,9,10};
    printList(sorted);
    sort.insertionSort(sorted);
    System.out.print("Sorted Sorted-list: ");
    printList(sorted);
    System.out.println();

    //Testcase 4
    System.out.print("\nDescending list:");
    int[] desc = {10,9,8,7,6,5,4,3,2,1};
    printList(desc);
    sort.insertionSort(desc);
    System.out.print("Sorted Descending list: ");
    printList(desc);
    System.out.println();

    //Testcase 5
    System.out.print("\nSmall 1k File:");
    insertFile("small1k.txt");
    sort.insertionSort(nums);
  }
}