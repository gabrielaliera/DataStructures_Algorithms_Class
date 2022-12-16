/*  Java Class:minx Comparator
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/6/2022
    Description: – Comparator for Sorted PQ with lower values having priority
    I certify the code is my own
    Exception(s): ClassCastException
*/
import java.util.Comparator;

 public class minComparator<E> implements Comparator<E>{
    public int compare(E a, E b) throws ClassCastException{

      if (((Comparable<E>)a).compareTo(b) < 0 ){  //a < b
        return -1;  //lowest value has higher priority
      } else if  (((Comparable<E>)a).compareTo(b) == 0 ){ 
        return 0;
      } else{
        return 1;
      }
    }
  }