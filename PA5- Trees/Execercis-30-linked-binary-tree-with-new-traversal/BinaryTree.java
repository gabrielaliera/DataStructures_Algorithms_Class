/*  Java Class: BinaryTree Interface
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/30/2022
    Description: – Serves as the interface for Abstract Binary Tree.
                   Inherits from Tree interface. Uses Position class
    Modify from book
    Exception(s): IllegalStateExceptopm
*/

public interface BinaryTree<E> extends Tree<E> {

  /** Returns the Position of p's left child (or null if no child exists). */
  Position<E> left(Position<E> p) throws IllegalArgumentException;

  /** Returns the Position of p's right child (or null if no child exists). */
  Position<E> right(Position<E> p) throws IllegalArgumentException;

  /** Returns the Position of p's sibling (or null if no sibling exists). */
  Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}