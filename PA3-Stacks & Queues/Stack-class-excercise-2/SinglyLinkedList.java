/*  Java Class: SinglyLinkedList
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/14/2022
    Description: Linked List for Stack
    Modified from textbook: I certify that the code below is my own work.
Exception(s): N/A
*/
public class SinglyLinkedList <E> {

  public class Node<E>{  //nested Node class
    private E data;
    private Node<E> next; 

    public Node(){};
    
    public Node(E data){
      this.data = data;
      this.next = null;
    }  
  } //end Node class

  private Node<E> head= null; 
  private int size = 0;

  public SinglyLinkedList(){};

  public int size(){return size;}
  public boolean isEmpty(){return size==0;}

  public void addFirst(E data){
    Node cur = new Node();
    cur.data = data;
    cur.next = head;
    size++;
    
    head = cur;
  }

  public E removeFirst(){
    if(isEmpty()){ return null;}
    
    E element = head.data;
    head= head.next;
    size --;
    System.out.println("Pop: "+ element);
    return element;   
  }

  public E first(){
    if(isEmpty()){ return null;}

    return head.data;
  }

  public void print(){
    Node cur = head;

    while(cur != null){
      System.out.print(cur.data + " ");
      cur = cur.next;
    }
    System.out.println();
  }
  
}//end class