/*  Java Class: PositionalList Interface
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/23/2022
    Description: – PositionalList interface for LPL
    Modify from book: I certify that the code below is my own work.
    Exception(s): IllegalArgumentException
*/
public interface PositionalList<E> {

  int size();

  boolean isEmpty();

  Position<E> first();

  Position<E> last();

  Position<E> before(Position<E> p) throws IllegalArgumentException;

  Position<E> after(Position<E> p) throws IllegalArgumentException;

  Position<E> addFirst(E e);

  Position<E> addLast(E e);

  Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

  Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

  void set(Position<E> p, E e) throws IllegalArgumentException;

  E remove(Position<E> p) throws IllegalArgumentException;
}