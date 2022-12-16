/*  Java Class: Position
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/6/2022
    Description: – Position interface
    Modified from textbook:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014

    Exception(s): IllegalStateExceptopm
*/
public interface Position<E>{
  E getElement() throws IllegalStateException;
}