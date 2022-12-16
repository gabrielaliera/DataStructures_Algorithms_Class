/*  Java Class: Entry interface
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/03/2022
    Description: Entry with key and value
      Modified from textbook:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    Exception(s):
*/
public interface Entry<K,V>{
  K getKey();
  V getValue();
}