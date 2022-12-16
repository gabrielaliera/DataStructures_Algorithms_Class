/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/30/2022
    Description: – Set up LinkedBinaryTree class and then create a simple test driver to perform some basic operations on a binary tree of strings. Once it is working correctly, modify LinkedBinaryTree to support post-order traversal. It is best to modify positions() to
perform post-order traversal.

   Modified from textbook:
      Data Structures and Algorithms in Java, Sixth Edition
      Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
      John Wiley & Sons, 2014
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
    System.out.println("\nTESTCASE 1: Post-order ");
    Iterable<Position<Character>> Iter = tree.positions(); //Uses postorder positions
    Iterator<Position<Character>> inIter= Iter.iterator();
      
    while(inIter.hasNext()){  //Print postorder Iterator
      System.out.print(inIter.next().getElement()+ " ");
    }

    /*Test Case 2: Pre-order Traversal                                                   *
    *Pre-order traversal for binary tree above: A B D E C                                */
    System.out.println("\n\nTESTCASE 2: Pre-order");
    
    Iterable<Position<Character>> Iter2 = tree.positions(2); //Uses postorder positions
    Iterator<Position<Character>> preIter2= Iter2.iterator();
  
    while(preIter2.hasNext()){  //Print postorder Iterator
       System.out.print(preIter2.next().getElement() + " ");
    } 

    /*Test Case 3: Level-order Traversal                                                   *
    *Level-order traversal for binary tree above: A B C D E                                */
    System.out.println("\n\nTESTCASE 3: Level-order");
    
    Iterable<Position<Character>> iter3= tree.positions(1,2); //Uses leveler positions
    Iterator<Position<Character>> levelIter= iter3.iterator();
  
    while(levelIter.hasNext()){  //Print postorder Iterator
       System.out.print(levelIter.next().getElement() + " ");
    } 
  }//End Driver
}