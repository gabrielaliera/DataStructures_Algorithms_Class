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

public class StringComparator implements Comparator<String>{

  public int compare(String a, String b) throws ClassCastException{
    if (a==b){
      return 0;
    }
    if( a == null){
      return -1;
    }

    if(b ==null){
      return 1;
    }
    
    return a.compareTo(b);
  }
  
}