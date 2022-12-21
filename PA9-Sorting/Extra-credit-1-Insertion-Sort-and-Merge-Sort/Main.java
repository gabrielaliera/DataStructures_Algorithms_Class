/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/03/2022
    Description: Collect actual running times for both insertion sort and merge sort for a random list of values of various sizes. Try the following random lists: 1000, 10000, and 100000 random integer values.

    Implementation of Mergesort and Insertion Sort are modified from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/
import java.util.Random;

class Main {
  
  public static void main(String[] args) {
   
    //Create sort object
    InsertionSort sortA = new InsertionSort();
    MergeSort sortB = new MergeSort();
    DefaultComparator<Integer> comp = new DefaultComparator<>();
    
    //Create random list of numbers
    int[] rand1000 = new int[1000];
    int[] rand10000 = new int[10000];
    int[] rand100000 = new int[100000];
    Random random = new Random();
    for(int i=0; i<1000;i++){
      rand1000[i] = random.nextInt(1000);
    }
    
    for(int i=0; i<10000;i++){
      rand10000[i] = random.nextInt(10000);
    }
   
    for(int i=0; i<100000;i++){
      rand100000[i] = random.nextInt(100000);
    }
    
    //Testcase 1
    System.out.print("\nRandom list 1000: ");
    double start = System.currentTimeMillis(); //Start time
    sortA.insertionSort(rand1000);              //Sort using insertionSort
    double finish = System.currentTimeMillis(); //End time
    double time = finish -start;                //Calculate time and print 
    System.out.printf("\nInsertion Sort Runtime: %.3f ms \n", time);
    
    start = System.currentTimeMillis(); //Start time
    sortB.mergeSort(rand1000,comp);              //Sort using mergeSort
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    System.out.printf("Merge Sort Runtime: %.3f ms \n", time);

    //Test case 2
    System.out.print("\nRandom list 10,000: ");
    start = System.currentTimeMillis(); //Start time
    sortA.insertionSort(rand10000);              //Sort using insertionSort
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    System.out.printf("\nInsertion Sort Runtime: %.3f ms \n", time);
    
    start = System.currentTimeMillis(); //Start time
    sortB.mergeSort(rand10000,comp);              //Sort using mergeSort
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    System.out.printf("Merge Sort Runtime: %.3f ms \n", time);


    //Test Case 3
    System.out.print("\nRandom list 100,000: ");
    start = System.currentTimeMillis(); //Start time
    sortA.insertionSort(rand100000);              //Sort using insertionSort
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    System.out.printf("\nInsertion Sort Runtime: %.3f ms \n", time);
    
    start = System.currentTimeMillis(); //Start time
    sortB.mergeSort(rand100000,comp);              //Sort using mergeSort
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    System.out.printf("Merge Sort Runtime: %.3f ms \n", time);
    
   
    
  }
}