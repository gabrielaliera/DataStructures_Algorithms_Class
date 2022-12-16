/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/30/2022
    Description: – Set up LinkedBinaryTree class and then create a simple test driver to perform
some basic operations on a binary tree of strings. Once it is working correctly, modify
LinkedBinaryTree to support post-order traversal. It is best to modify positions() to
perform post-order traversal.
   I certify this is my own work.
    Exception(s):
*/
import java.util.Iterator;

class Main {
  public static void main(String[] args) {
  
    //Drive to test LinkedBinaryTree
    LinkedBinaryTree<Character> tree = new LinkedBinaryTree<>();
    tree.addRoot('A');                              //Tesst addRoot
    tree.addLeft(tree.root(),'B');                  //Test addLeft
    tree.addRight(tree.root(),'C');                 //Test addRight

    //Create pointer at root and find left & right children
    Position<Character> pointer = tree.root();      //test root()
    System.out.println("Left Root: "+ tree.left(pointer).getElement());  //Test left()
    System.out.println("Right Root: "+ tree.right(pointer).getElement()); //Test right()

    //Move pointer
    pointer = tree.left(pointer);
    System.out.println("Pointer at "+ pointer.getElement());
    System.out.println("Parent of pointer: "+ tree.parent(pointer).getElement());  //Test parent()

    //Add D and E 
    tree.addLeft(pointer,'D');
    tree.addRight(pointer,'E');
    
    System.out.println("Binary Tree Size: "+ tree.size()); //Test size

    //tree.set(tree.root(),'X');   //Test set()
    //System.out.println("New root value: "+ tree.root().getElement());

    //System.out.println("Removed " + tree.remove(tree.left(pointer)) +" from " + pointer.getElement());
    //System.out.println(tree.left(pointer).getElement());
   
    /*Test Case 1: Add code to construct a binary tree below and then perform a post-order*
    * traversal on that binary tree. Confirm it is working correctly.                     *
    *                      A                                                              *
    *                   /   \                                                             *
    *                  B     C                                                            *
    *                 / \                                                                 *
    *                D   E                                                                *
    * Post-order traversal for binary tree above: D E B C A                               */
    System.out.println("\nTESTCASE 1: ");
    Iterable<Position<Character>> Iter = tree.positions(); //Uses postorder positions
    Iterator<Position<Character>> inIter= Iter.iterator();
      
    while(inIter.hasNext()){  //Print postorder Iterator
      System.out.print(inIter.next().getElement()+ " ");
    }

    /*Test Case 2:Test Case 2: Remove node E from the binary tree above and then perform a*
    *post-order traversal on that binary tree. Confirm it is working correctly.           *
    *                      A                                                              *
    *                   /   \                                                             *
    *                  B     C                                                            *
    *                 /                                                                   *
    *                D                                                                    *
    * Post-order traversal for binary tree above: D  B C A                                */
    System.out.println("\n\nTESTCASE 2:");
    
    System.out.println("Pointer at "+ pointer.getElement());
    tree.remove(tree.right(pointer)); //Remove node E

    Iterable<Position<Character>> Iter2 = tree.positions(); //Uses postorder positions
    Iterator<Position<Character>> inIter2= Iter2.iterator();
  
    while(inIter2.hasNext()){  //Print postorder Iterator
       System.out.print(inIter2.next().getElement() + " ");
    } 
  }//End Driver
}