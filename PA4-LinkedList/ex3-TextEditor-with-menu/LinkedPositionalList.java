/*  Java Class: LinkedPositionalList (LPL) Class
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/23/2022
    Description: – LPL using double-linked list, Positional List interface, and Positional interface
    Modify from book: I certify that the code below is my own work.
    Exception(s): IllegalStateExceptopm, NoSuchElement Exception
*/
import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {

  private static class Node<E> implements Position<E> {//--------Nested Node Class--
    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node(E e, Node<E> p, Node<E> n) { // Node constructor
      element = e;
      prev = p;
      next = n;
    }

    public E getElement() throws IllegalStateException{
      if(next==null){
        throw new IllegalStateException("Position no longer valid");
      }
      return element;
    }

    public Node<E> getPrev() { return prev;}
    public Node<E> getNext() { return next;}

    public void setElement(E e){element = e;}
    public void setPrev(Node<E> p) {prev = p;}
    public void setNext(Node<E> n) {next = n;}

  }//-------------------end of nested Node class----------

  // Instance variables of Linked_Positional_List
  private Node<E> header;
  private Node<E> trailer;
  private int size = 0;

  // Constructor
  LinkedPositionalList() {
    header = new Node<>(null,null,null);
    trailer= new Node<>(null,header,null);
    header.setNext(trailer);
  }

  //Private Methods
  private Node<E>validate(Position<E> p) throws IllegalArgumentException{
    if(!(p instanceof Node))                      //check if p is a Node
      throw new IllegalArgumentException("Invalid p");
    Node<E> node = (Node<E>) p;
    if(node.getNext() == null)
      throw new IllegalArgumentException("p is no longer in the list");
    return node;
  }
  
  private Position<E> position(Node<E> node){
    if(node==header || node==trailer)
      return null;
    return node;
  }
  
  // Public Methods from PositionalList interface
  public int size() {return size;}
  public boolean isEmpty() {return size == 0;  }

  public Position<E> first() { return position(header.getNext());}
  public Position<E> last() { return position(trailer.getPrev());}

  public Position<E> before(Position<E> p) throws IllegalArgumentException{
    Node<E> node = validate(p);
    return position(node.getPrev());
  }

  public Position<E> after(Position<E> p) throws IllegalArgumentException{
    Node<E> node = validate(p);
    return position(node.getNext());
  }

  private Position<E> addBetween(E e, Node<E> pred, Node<E> succ){
    Node<E> newest = new Node<>(e,pred,succ);
    pred.setNext(newest);
    succ.setPrev(newest);
    size++;
    return newest;
  }
  
  public Position<E> addFirst(E e){
    return addBetween(e, header, header.getNext());
  }

  public Position<E> addLast(E e){
    return addBetween(e, trailer.getPrev(),trailer);
  }

  public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
    Node<E> node = validate(p);
    return addBetween(e,node.getPrev(),node);
  }
  
  public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{
    Node<E> node = validate(p);
    return addBetween(e,node,node.getNext());
  }
  
  public void set(Position<E> p, E e) throws IllegalArgumentException{
    Node<E>node = validate(p);
    node.setElement(e);
  }

  public E remove(Position<E> p) throws IllegalArgumentException{
    Node<E>node= validate(p);
    Node<E>previous = node.getPrev();
    Node<E>successor = node.getNext();
    previous.setNext(successor);
    successor.setPrev(previous);
    size--;
    E answer = node.getElement();
    node.setElement(null);
    node.setNext(null);
    node.setPrev(null);
    return answer;
  };

  //_____________________ITERATOR____________________________//
  private class PositionIterator implements Iterator<Position<E>>{
    private Position<E> cursor = first();
    private Position<E> recent = null;

    public boolean hasNext(){
      return cursor!= null;
    }

    public Position<E> getCursor(){
      return cursor;
    }
    public Position<E> next() throws NoSuchElementException{
      if (cursor == null){
        throw new NoSuchElementException("Nothing Left");
      }
      recent = cursor;
      cursor = after(cursor);
      return recent;
    }

    public void remove() throws IllegalStateException{
      if (recent== null)
          throw new IllegalStateException("Nothing to remove");
      LinkedPositionalList.this.remove(recent);
      recent = null;
    }
  }//end of PositionIterator class

  private class PositionIterable implements Iterable<Position<E>>{
    public Iterator<Position<E>> iterator(){
      return new PositionIterator();
    }
  }
  
  public Iterable<Position<E>>positions(){
      return new PositionIterable();
  }
 
  private class ElementIterator implements Iterator<E>{
    Iterator<Position<E>> posIterator = new PositionIterator();
    public boolean hasNext(){ return posIterator.hasNext();}
    public E next(){ return posIterator.next().getElement();}
    public void remove(){ posIterator.remove();}
  }

  public Iterator<E> iterator(){ return new ElementIterator();}
  
}//End of LPL CLASS