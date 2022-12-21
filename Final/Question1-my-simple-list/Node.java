/*  Java Class: Node
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 12/01/2022
    Description: Node class
    I certify that the code below is my own work.
Exception(s): N/A
*/

public class Node<E>{
    private E data;
    private Node<E> next;

    public Node(E d, Node<E> n){
      this.data = d;
      this.next = n;
    }

    public Node(E d){
      this.data = d;
    }

    public E getData(){return data;}
    public Node<E> getNext(){return next;}
    public void setData(E d){data= d;}
    public void setNext(Node<E> n){next = n;}
  }