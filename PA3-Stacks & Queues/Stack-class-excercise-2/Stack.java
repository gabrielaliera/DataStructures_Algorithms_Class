/*  Java Class: Stack
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/14/2022
    Description: Stack calss
    Modified from textbook: I certify that the code below is my own work.
Exception(s): N/A
*/
public class Stack<E>{
  
  private SinglyLinkedList<E> list = new SinglyLinkedList<>(); //Create an empty linked list
  public Stack(){};//Constructor
  
  public int size(){ return list.size();}

  public boolean isEmpty(){ return list.isEmpty();}

  public void push(E data){list.addFirst(data);}

  public E pop(){ return list.removeFirst(); }

  public E top(){ return list.first();}
  
  public void print(){ list.print();}
    
}//end class