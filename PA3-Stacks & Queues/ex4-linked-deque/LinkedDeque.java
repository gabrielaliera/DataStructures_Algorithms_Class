/*  Java Class: LinkedDeque
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/15/2022
    Description:Double Linked list for Deque
    I certify that the code below is my own work.
Exception(s): N/A
*/
public class LinkedDeque<E>{
  
  public class Node<E>{
    private E data;
    private Node<E> prev;
    private Node<E> next;

    Node(){};

    Node(E data){
      this.data= data;
      prev=null;
      next=null;
    }
    
  }//end Node class
  
  //Class Members
  private Node<E> dummyHead = new Node<>();
  private Node<E> dummyTail = new Node<>();
  private Node<E> first = dummyHead;
  private Node<E> last = dummyTail;

  //Constructor
  LinkedDeque(){
    dummyHead.next= dummyTail;
    dummyTail.prev = dummyHead;
  }
  
  private int size= 0;

  //Methods
  public int size(){return size;}
  public boolean isEmpty(){return size==0;}

  public E first(){
    if(isEmpty()){return null;}
    return first.data;
  }
  
  public E last(){ 
    if(isEmpty()) {return null;}
    return last.data;  
  }

  public void addFirst(E e){
    Node<E> newest = new Node<>(e);
    if(isEmpty()){
      newest.next= dummyTail;
      newest.prev= dummyHead;
      dummyHead.next= newest;
      dummyTail.prev= newest;
    } else{
      newest.next= first;
      newest.prev = dummyHead;

      first.prev= newest;
      dummyHead.next=newest;
    }
    if(size==1){ last= first;}
    first= newest;
    size++;
    
  }

  public void addLast(E e){
    Node<E> newest = new Node<>(e);
    
    if(isEmpty()){
      newest.next= dummyTail;
      newest.prev= dummyHead;
      dummyHead.next= newest;
      dummyTail.prev= newest;
    } else{
      newest.next= dummyTail;
      newest.prev = last;

      last.next= newest;
      dummyTail.prev=newest;
    }
    if(size==1){first= last;}
    last= newest;
    size++;
  }

  public void removeFirst(){
    if(isEmpty()){
      System.out.println("Can't Remove First:Empty List");
    } else{
      dummyHead.next = first.next;
      first.next.prev = dummyHead;
      first = first.next;
      size--;
    }
  }

  public void removeLast(){
    if(isEmpty()){
      System.out.println("Can't Remove Last:Empty List");
    } else{
      dummyTail.prev = last.prev;
      last.prev.next = dummyTail;
      last = last.prev;
      size--;
    }
  }

  public void print(){
    Node cur = first;
    if (isEmpty()){
      System.out.println("Empty Deque");
    } else{
      for(int i=1;i<=size;i++){
        System.out.print(cur.data+ " ");
        cur = cur.next;
      }
      System.out.println();
    }
  }
}