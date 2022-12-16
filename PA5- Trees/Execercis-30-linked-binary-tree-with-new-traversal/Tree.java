/*  Java Class: Tree Interface
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/30/2022
    Description: – Tree interface for Abstract Tree
    Modify from book
    Exception(s): IllegalStateExceptopm
*/
import java.util.Iterator;
public interface Tree<E> extends Iterable<E> {
  
  Position<E> root();

  Position<E> parent(Position<E> p) throws IllegalArgumentException;
  
  Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
  
  int numChildren(Position<E> p) throws IllegalArgumentException;

  boolean isInternal(Position<E> p) throws IllegalArgumentException;

  boolean isExternal(Position<E> p) throws IllegalArgumentException;
  
  boolean isRoot(Position<E> p) throws IllegalArgumentException;

  int size();

  boolean isEmpty();

  Iterator<E> iterator();

  Iterable<Position<E>> positions();
}