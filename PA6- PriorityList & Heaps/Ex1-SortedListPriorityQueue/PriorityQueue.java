/*  Java Class: PriorityQueue
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/6/2022
    Description: – PriorityQueue interface for Sorted PQ
    Modified from textbook:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014

    Exception(s): IllegalStateException
*/
public interface PriorityQueue<K,V>{
  int size();
  
  boolean isEmpty();
  
  Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
  
  Entry<K,V> min();
  
  Entry<K,V> removeMin();
}