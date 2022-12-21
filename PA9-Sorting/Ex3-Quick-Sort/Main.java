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

class Main {
  //Global integer array for small1k file
  public static int[] nums = new int[1000];
  public static LinkedQueue<Integer> numsQ = new LinkedQueue<>();

  //Print helper 
  public static void printList(int[] list){
    for(int x : list ){
      System.out.print(x +" ");
    }
  }
  
  public static LinkedQueue<Integer> printQueue(LinkedQueue<Integer> q){
    LinkedQueue<Integer> answer = new LinkedQueue<>();
    
    while(!q.isEmpty()){
      int data= q.dequeue();
      System.out.print(data+" ");
      answer.enqueue(data);
    }
    return answer;
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
        numsQ.enqueue(data);
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
    QuickSort sort = new QuickSort();
    DefaultComparator<Integer> comp = new DefaultComparator<>();
    System.out.println("\n*******Quicksort In Place********");
    /*************************************Testcase 1****************************************/
    System.out.print("\nOriginal list: ");
    int[] orignal = {4,3,1,0,9,8,6,7,5,2}; //Array for quicksort inplace
    
    //Create queue if using quicksort
    LinkedQueue<Integer> origQ = new LinkedQueue<>();
    for(int i=0;i< orignal.length;i++){
      origQ.enqueue(orignal[i]);
    }
    //Print list
    printList(orignal);
    //origQ = printQueue(origQ);
    
    //Start timer, Sort, End timer
    double start = System.currentTimeMillis(); //Start time
    sort.quickSortInPlace(orignal,comp);              //Sort using quickSort using arrays   
    //sort.quickSort(origQ,comp);                    //Quick sort with queue
    double finish = System.currentTimeMillis(); //End time
    double time = finish -start;                //Calculate time and print 
    
    //Output
    System.out.printf("\nSorting Runtime: %.3f ms \n", time);
    System.out.println("Data Moves: "+ sort.getDataMoves());
    System.out.println("Comparsions: "+ sort.getComparsions()); 
    
    sort.resetComparsions(); sort.resetDataMoves();
    System.out.print("Sorted Original list: ");
    printList(orignal);
    //printQueue(origQ);
    System.out.println();


    /***********************************************Testcase 2**********************************************/
    System.out.print("\nRandom list: ");
    int[] random = new int[10];
    LinkedQueue<Integer> randQ = new LinkedQueue<>();
    Random rand = new Random();
    for(int i=0; i<10;i++){
      random[i] = rand.nextInt(100);
      randQ.enqueue(rand.nextInt(100));
    }
    //Print unsorted
    printList(random);
    //randQ = printQueue(randQ);

    //Start timer, Sort, End timer
    start = System.currentTimeMillis(); //Start time
    sort.quickSortInPlace(random,comp);              //Sort using quickSort
    //sort.quickSort(randQ,comp);                    //Quick sort with queue
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    
    //Outputs
    System.out.printf("\nSorting Runtime: %.3f ms \n", time);
    System.out.println("Data Moves: "+ sort.getDataMoves());
    System.out.println("Comparsions: "+ sort.getComparsions()); 
    sort.resetComparsions(); sort.resetDataMoves();
    
    System.out.print("Sorted Random list: ");
    printList(random);
    //printQueue(randQ);
    System.out.println();

    /*************************************Testcase 3**********************************************************/
    System.out.print("\nSorted-list:");
    int[] sorted = {1,2,3,4,5,6,7,8,9,10};
    LinkedQueue<Integer> sortedQ = new LinkedQueue<>();
    for(int i=0; i<10;i++){
      sortedQ.enqueue(sorted[i]);
    }
    printList(sorted);
    //sortedQ = printQueue(sortedQ);
    
    //Start timer, Sort, End timer
    start = System.currentTimeMillis(); //Start time
    sort.quickSortInPlace(sorted,comp);              //Sort using quickSort
    //sort.quickSort(sortedQ,comp);                     //Quick sort with queue
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    
    //Outputs
    System.out.printf("\nSorting Runtime: %.3f ms \n", time);
    System.out.println("Data Moves: "+ sort.getDataMoves());
    System.out.println("Comparsions: "+ sort.getComparsions()); 
    sort.resetComparsions(); sort.resetDataMoves();
    
    
    System.out.print("Sorted Sorted-list: ");
    printList(sorted);
    //printQueue(sortedQ);
    System.out.println();

    /************************************************Testcase 4************************************************/
    System.out.print("\nDescending list:");
    int[] desc = {10,9,8,7,6,5,4,3,2,1};
    
    LinkedQueue<Integer> descQ = new LinkedQueue<>();
    for(int i=0;i< desc.length;i++){
      descQ.enqueue(desc[i]);
    }
    printList(desc);
    //descQ = printQueue(descQ);

    //Start timer, Sort, End timer
    start = System.currentTimeMillis(); //Start time
    sort.quickSortInPlace(desc,comp);              //Sort using quickSort using arrays
    //sort.quickSort(descQ,comp);                     //Quick sort with queue
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
   
    //Outputs
    System.out.printf("\nSorting Runtime: %.3f ms \n", time);
    System.out.println("Data Moves: "+ sort.getDataMoves());
    System.out.println("Comparsions: "+ sort.getComparsions()); 
    sort.resetComparsions(); sort.resetDataMoves();
    
    System.out.print("Sorted Descending list: ");
    printList(desc);
    //printQueue(descQ);
    System.out.println();

    /************************************Testcase 5*******************************************/
    System.out.print("\nSmall 1k File:");
    insertFile("small1k.txt"); //Read file and insert data into list and queue
    
    //Start timer, Sort, end timer
    start = System.currentTimeMillis(); //Start time
    //sort.quickSortInPlace(nums,comp);              //Quicksort inplace with arrays
    sort.quickSort(numsQ,comp);                      //Quick sort using queues
    finish = System.currentTimeMillis(); //End time
    time = finish -start;                //Calculate time and print 
    
    //Outputs
    System.out.printf("\nSorting Runtime: %.3f ms \n", time);
    System.out.println("Data Moves: "+ sort.getDataMoves());
    System.out.println("Comparsions: "+ sort.getComparsions()); 
    sort.resetComparsions(); sort.resetDataMoves();
  }
}