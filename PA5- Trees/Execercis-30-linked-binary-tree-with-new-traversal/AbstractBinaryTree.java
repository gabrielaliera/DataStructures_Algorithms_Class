/*  Java Class: AbstractBinary Tree
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/30/2022
    Description: – Serves as the parent class for LinkedBinartTree.Inherits from AbstractTree and uses BinaryTree interface. Uses Position Class
    Modify from book
    Exception(s): IllegalStateExceptopm
*/
import java.util.List;
import java.util.ArrayList;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
                                            implements BinaryTree<E> {

  public Position<E> sibling(Position<E> p) {
    Position<E> parent = parent(p);
    if (parent == null) return null;                  // p must be the root
    if (p == left(parent))                            // p is a left child
      return right(parent);                           // (right child might be null)
    else                                              // p is a right child
      return left(parent);                            // (left child might be null)
  }

  public int numChildren(Position<E> p) {
    int count=0;
    if (left(p) != null)
      count++;
    if (right(p) != null)
      count++;
    return count;
  }

  
  public Iterable<Position<E>> children(Position<E> p) {
    List<Position<E>> snapshot = new ArrayList<>(2);    // max capacity of 2
    if (left(p) != null)
      snapshot.add(left(p));
    if (right(p) != null)
      snapshot.add(right(p));
    return snapshot;
  }

/************************Post-order Traversal**************************************/
   public Iterable<Position<E>> positions() { 
    return postorder();
  }

  public Iterable<Position<E>> postorder(){
      List<Position<E>> snapshot = new ArrayList<>();
      if(!isEmpty())
        postOrderSubtree(root(), snapshot);
      return snapshot;
    
  }

   private void postOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
    for (Position<E> c : children(p)){
      postOrderSubtree(c, snapshot);
    }
    snapshot.add(p); 
  }
/************************Pre-order Traversal**************************************/
   public Iterable<Position<E>> positions(int n) { 
    return preorder();
  }

  public Iterable<Position<E>> preorder(){
      List<Position<E>> snapshot = new ArrayList<>();
      if(!isEmpty()){
        preOrderSubtree(root(), snapshot);
      }
      return snapshot;
  }

   private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
    snapshot.add(p);
     for (Position<E> c : children(p)){
      preOrderSubtree(c, snapshot);
    }
  }

/************************Level-order Traversal**************************************/
   public Iterable<Position<E>> positions(int x, int y) {  
    return levelorder();
  }
                                              
  public Iterable<Position<E>> levelorder() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty()) {
      LinkedQueue<Position<E>> myQ = new LinkedQueue<>();
      myQ.enqueue(root());                
      while (!myQ.isEmpty()) {
        Position<E> p = myQ.dequeue();     
        snapshot.add(p);                      
        for (Position<E> c : children(p))
          myQ.enqueue(c);                 
      }
    }
    return snapshot;
  }                                                              
}