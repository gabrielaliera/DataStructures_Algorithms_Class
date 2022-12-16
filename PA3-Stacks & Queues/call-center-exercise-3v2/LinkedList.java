/*  Java Class: LinkedList
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/14/2022
    Description:Linked list for queue
    I certify that the code below is my own work.
Exception(s): N/A
*/

public class LinkedList<E>{

  private class Node<E>{ //Nested node class
    private E data;
    private Node<E> next;

    public Node(){};
    
    public void setData(E data){ this.data = data;}
    public void setNext(Node<E> n){this.next=n;}
    
    public E getData(){return data;}
    public Node<E> getNext(){return next;}
  }

  public Node<E> head=null;
  public Node<E> tail = null;
  public int count= 0;

  public int size(){
    return count;
  }

  public boolean isEmpty(){
    return count == 0;
  }
  
  public E first(){
    if(isEmpty())
      return null;
    return head.getData();
  }
  
  public void addLast(E e){
    Node<E> cur = new Node<>();
    cur.data = e;
    
    if (isEmpty()){
      head= cur;
    } else{
      tail.setNext(cur);
    }
    tail = cur;
    count++;
  }

  public E removeFirst(){
    if (isEmpty()){
      System.out.println("List is empty.Cannot dequeue.");
      return null;
    }
    E answer = head.getData();
    head = head.getNext();
    count--;

    if(count== 0){
      tail = null;
    }
    return answer;    
  }

 public void print(){
    Node cur = head;

    if(isEmpty()){
     System.out.print("List is empty.");
    } else {
      while(cur != null){
        System.out.print(cur.data + " ");
        cur = cur.next;
      }
   }
    System.out.println();
  }
}