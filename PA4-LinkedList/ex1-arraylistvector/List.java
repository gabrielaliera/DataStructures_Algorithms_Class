/*  Java Interface: List 
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/21/2022
    Description: – Interface List for Arraylist
    Modify from book: I certify that the code below is my own work.
    Exception(s):  IndexOutOfBoundsException
*/
public interface List<E>{ // using can apply at any location

  int size();

  boolean isEmpty();

  E get(int index) throws IndexOutOfBoundsException;

  void set(E e, int index) throws IndexOutOfBoundsException;
 
  void add(E e,int index) throws IndexOutOfBoundsException;

  E remove(int index) throws IndexOutOfBoundsException;
}