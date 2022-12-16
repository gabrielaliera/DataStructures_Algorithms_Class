/*  Java Class:Abstract Tree class
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/30/2022
    Description: – Abstract class for Abstract Binary Tree. 
                   Uses Tree interface. Has-A Position class for methods parameters
    Modify from book
    Exception(s): IllegalStateExceptopm
*/
import java.util.Iterator;
import java.util.List;         // for use as snapshot iterator
import java.util.ArrayList;    // for use as snapshot iterator
public abstract class AbstractTree<E> implements Tree<E> {

  
  public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }

  
  public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }

  public boolean isRoot(Position<E> p) { return p == root(); }

  public int numChildren(Position<E> p) {
    int count=0;
    for (Position child : children(p)) count++;
    return count;
  }

  public int size() {
    int count=0;
    for (Position p : positions()) count++;
    return count;
  }

  public boolean isEmpty() { return size() == 0; }

  //---------- support for computing depth of nodes and height of (sub)trees ----------

  public int depth(Position<E> p) throws IllegalArgumentException {
    if (isRoot(p))
      return 0;
    else
      return 1 + depth(parent(p));
  }

  public int height(Position<E> p) throws IllegalArgumentException {
    int h = 0;                          // base case if p is external
    for (Position<E> c : children(p))
      h = Math.max(h, 1 + height(c));
    return h;
  }

  //---------- support for various iterations of a tree ----------

  //---------------- nested ElementIterator class ----------------
  /* This class adapts the iteration produced by positions() to return elements. */
  private class ElementIterator implements Iterator<E> {
    Iterator<Position<E>> posIterator = positions().iterator();
    public boolean hasNext() { return posIterator.hasNext(); }
    public E next() { return posIterator.next().getElement(); } // return element!
    public void remove() { posIterator.remove(); }
  }

  public Iterator<E> iterator() { return new ElementIterator(); }

}