/*  Java Class: Merge Sort
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/03/2022
    Description: Merge sort with data moves and comparisons
    Implementation of Mergesort is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

  public long comparsions=0;
  public long dataMoves=0;

  public long getComparsions(){return comparsions;}
  public long getDataMoves(){return dataMoves;}
  public void resetComparsions(){comparsions = 0;}
  public void resetDataMoves(){dataMoves=0;}
  
  //-------- support for top-down merge-sort of arrays --------
  /** Merge contents of arrays S1 and S2 into properly sized array S. */
  public void merge(int[] S1, int[] S2, int[] S, Comparator<Integer> comp) {
    int i = 0, j = 0;
    while (i + j < S.length) {
      if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)){
        S[i+j] = S1[i++];                     // copy ith element of S1 and increment i
        dataMoves++;
      } else{
        S[i+j] = S2[j++];                     // copy jth element of S2 and increment j
        dataMoves++;
      }
      comparsions++;
    }
  }

  /** Merge-sort contents of array S. */
  public void mergeSort(int[] S, Comparator<Integer> comp) {
    
    int n = S.length;
    if (n < 2) return;                        // array is trivially sorted
    // divide
    int mid = n/2;
    int[] S1 = Arrays.copyOfRange(S, 0, mid);   // copy of first half
    int[] S2 = Arrays.copyOfRange(S, mid, n);   // copy of second half
   // dataMoves += dataMoves + 1; 
    // conquer (with recursion)
    mergeSort(S1, comp);                      // sort copy of first half
    mergeSort(S2, comp);                      // sort copy of second half
    // merge results
    merge(S1, S2, S, comp);               // merge sorted halves back into original
  
  }

  
  //-------- support for top-down merge-sort of queues --------
  /** Merge contents of sorted queues S1 and S2 into empty queue S. */
  public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S,
                                                        Comparator<K> comp) {
    while (!S1.isEmpty() && !S2.isEmpty()) {
      if (comp.compare(S1.first(), S2.first()) < 0){
        S.enqueue(S1.dequeue());           // take next element from S1
      } else{
        S.enqueue(S2.dequeue());           // take next element from S2
      }
    }
    
    while (!S1.isEmpty()){
      S.enqueue(S1.dequeue());             // move any elements that remain in S1
    }
    
    while (!S2.isEmpty()){
      S.enqueue(S2.dequeue());             // move any elements that remain in S2
    }
  }

  /** Merge-sort contents of queue. */
  public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) {
    int n = S.size();
    if (n < 2) return;                     // queue is trivially sorted
    // divide
    Queue<K> S1 = new LinkedQueue<>();     // (or any queue implementation)
    Queue<K> S2 = new LinkedQueue<>();
    while (S1.size() < n/2){
      S1.enqueue(S.dequeue());             // move the first n/2 elements to S1
    }
    
    while (!S.isEmpty()){
      S2.enqueue(S.dequeue());             // move remaining elements to S2
    }
    // conquer (with recursion)
    mergeSort(S1, comp);                   // sort first half
    mergeSort(S2, comp);                   // sort second half
    // merge results
    merge(S1, S2, S, comp);                // merge sorted halves back into original
  }

 
}
