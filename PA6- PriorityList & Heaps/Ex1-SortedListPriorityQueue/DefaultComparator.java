/*  Java Class: Default Comparator
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/03/2022
    Description: 
      Modified from textbook:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    Exception(s):
*/
import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E>{
public int compare(E a, E b) throws ClassCastException{
  return ((Comparable<E>)a).compareTo(b);
}
  
}