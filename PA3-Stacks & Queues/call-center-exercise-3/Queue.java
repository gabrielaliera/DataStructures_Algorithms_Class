/*  Java Class: Queue
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/14/2022
    Description:Queue Class for call center
    I certify that the code below is my own work.
Exception(s): N/A
*/
public class Queue <E>{
  
  LinkedList<E> list = new LinkedList<>(){};
  private int maxSize = Integer.MIN_VALUE;
  
  public int size(){ return list.size();}

  public boolean isEmpty(){ return list.isEmpty();}

  public void enqueue(E e){
    list.addLast(e);
    //check for size
    if (size()>maxSize){
      maxSize = size();
    }
  }

  public E first(){ return list.first();}

  public E dequeue(){ return list.removeFirst();}

  public void print(){ list.print();  }

  public int getMaxSize(){ return maxSize;}
}