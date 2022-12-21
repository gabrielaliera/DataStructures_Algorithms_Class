/*  Java Class: MySimpleList
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 12/01/2022
    Description: Generic Single Linked List Lab Final
    I certify that the code below is my own work.
Exception(s): N/A
*/
public class MySimpleList<E>{
 
  //Instance variables
  private int size = 0;
  private Node<E> head =null; 
 
  public void insertFront(E data){
    Node<E> node = new Node<E>(data);
    if(head == null){
      head = node;
    } else{
      node.setNext(head);
      head = node;
    }
    size++;
  }

  public Node<E> removeRear(){
    Node<E> del;          // hold deleted node
    Node<E> prev =head;  // pointer for previous of current node
    Node<E> curr= head; // pointer that iterates through list

    if(head == null){ return null;} //Base case - empty list
    
    if(head.getNext() == null){ // base case - 1 item
      del = head;
      head = null;
      size--;
      return del;
    }
    
    while(curr.getNext() != null){
      prev = curr;
      curr = curr.getNext();
    }
    
    del = curr;
    prev.setNext(null);

    size--;
    
    return del;
  }


  public boolean empty(){
    return size==0;
  }

  public void print(){
    Node<E> curr = head;
    System.out.print("List: ");
    
    while(curr != null){
      System.out.print( curr.getData()+ " ");
      curr = curr.getNext();
    }
    
    System.out.println();  
  }

  public int size(){
    System.out.println("Size: "+ size);
    return size;
  }


  //Revised functions
  public void insertRear(E data){
    Node<E> vtx = new Node<>(data);
    
    Node<E> curr = head;

    while(curr.getNext() != null){
      curr =curr.getNext();
    }
    curr.setNext(vtx);
    
  }

  public Node<E> removeFront(){
    Node<E> del;
    
    if(head == null){
      return null;
    }

    if (head.getNext() == null){
      del= head;
      head = null;
      return del;
    }

    del = head;
    head = head.getNext();
    return del;
  }
}