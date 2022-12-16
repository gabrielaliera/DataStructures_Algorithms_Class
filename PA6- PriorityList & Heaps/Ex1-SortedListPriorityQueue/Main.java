/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/03/2022
    Description: – Put together a list priority queue (ListPriorityQueue for C++ and SortedListPriorityQueue for Java) and use a test driver to perform some operations to confirm it is working correctly. You can use a PQ with integer as element. Create two PQ objects – one with largest value having highest priority and one with lowest value having highest priority. Be sure to use a comparator for the PQ. 

Perform the following operations: insert(5), insert(4), insert(7), insert(1), min(), removeMin(), insert(3), insert(6), min(), removeMin(), min(), removeMin(), insert(8), min(), removeMin(), insert(2), min(), removeMin(), min(), removeMin()

Output value for each min() operation so there should be 6 values for each set of output.

    Modified from textbook-  SortedPriorityQueue ,AbstractPriorityQueue, DefaultComparator, 
      Entry, LinkedPositionalList,Position,PositionalList,PriorityQueue
      Data Structures and Algorithms in Java, Sixth Edition
      Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
      John Wiley & Sons, 2014
  I certify the code is my own: Main, minComparator, maxComparator
    Exception(s):
*/
import java.util.Comparator;

class Main {
  
  public static void main(String[] args) {

    //Create comparators
    minComparator minComp = new minComparator();
    maxComparator maxComp = new maxComparator();

    //Create PQ with custome comparator
    SortedPriorityQueue<Integer,Integer> PQ_High = new SortedPriorityQueue<>(maxComp);
    SortedPriorityQueue<Integer,Integer> PQ_Low = new SortedPriorityQueue<>(minComp);


  //TESTCASE 1: High values have priority
    System.out.println("    TESTCASE 1: High values have priority");
  // insert(5), insert(4),insert(7), insert(1), min()
    PQ_High.insert(5,null);
    PQ_High.insert(4,null);
    PQ_High.insert(7,null);
    PQ_High.insert(1,null);
    System.out.println("Min: "+ PQ_High.min().getKey());
  //removeMin(), insert(3), insert(6)
    PQ_High.removeMin();
    PQ_High.insert(3,null);
    PQ_High.insert(6,null);
  //min(), removeMin()
    System.out.println("Min: "+ PQ_High.min().getKey());
    PQ_High.removeMin();
  //min(), removeMin()
    System.out.println("Min: "+ PQ_High.min().getKey());
    PQ_High.removeMin(); 
  //insert(8), min()
    PQ_High.insert(8,null);
    System.out.println("Min: "+ PQ_High.min().getKey());
  //removeMin(), insert(2), min(), 
    PQ_High.removeMin();
    PQ_High.insert(2,null);
    System.out.println("Min: "+ PQ_High.min().getKey());
  //removeMin(), min(), removeMin()
    PQ_High.removeMin();
    System.out.println("Min: "+ PQ_High.min().getKey());
    PQ_High.removeMin();


    //TESTCASE 2: Low values have priority
    System.out.println("    TESTCASE 2: Low values have priority");
  // insert(5), insert(4),insert(7), insert(1), min()
    PQ_Low.insert(5,null);
    PQ_Low.insert(4,null);
    PQ_Low.insert(7,null);
    PQ_Low.insert(1,null);
    System.out.println("Min: "+ PQ_Low.min().getKey());
  //removeMin(), insert(3), insert(6)
    PQ_Low.removeMin();
    PQ_Low.insert(3,null);
    PQ_Low.insert(6,null);
  //min(), removeMin()
    System.out.println("Min: "+ PQ_Low.min().getKey());
    PQ_Low.removeMin();
  //min(), removeMin()
    System.out.println("Min: "+ PQ_Low.min().getKey());
    PQ_Low.removeMin();
  //insert(8), min()
    PQ_Low.insert(8,null);
    System.out.println("Min: "+ PQ_Low.min().getKey());
  //removeMin(), insert(2), min(), 
    PQ_Low.removeMin();
    PQ_Low.insert(2,null);
    System.out.println("Min: "+ PQ_Low.min().getKey());
  //removeMin(), min(), removeMin()
    PQ_Low.removeMin();
    System.out.println("Min: "+ PQ_Low.min().getKey());
    PQ_Low.removeMin();
  }
}