/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/21/2022
    Description: – Use AVLTree class in C++ book (modified by me and provided here) or AVLTreeMap class for Java book and set up a test driver to perform some operations such as insert, erase, and find. Perform the operations in question 1 below (steps 1 to 7) and then search for 15, 30, and 8. Print the AVL tree as the final step (include key, value,
and height of each node). Assume that key is an integer and value is a string such as a name (come up with your own names).
1. Insert 10
2. Insert 20
3. Insert 4
4. Insert 8
5. Insert 15
6. Erase 8
7. Erase 10
    Implementation of TreeMap is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/
import java.util.Iterator;
import java.lang.Iterable;

class Main {
  public static void main(String[] args) {
    AVLTreeMap<Integer,String> AVL = new AVLTreeMap<Integer,String>();
    AVL.put(10,"Ben");
    AVL.put(20,"Gaby");
    AVL.put(4,"Sam");
    AVL.put(8,"Joe");
    AVL.put(15,"Sarah");
    AVL.remove(8);
    AVL.remove(10);
    System.out.println(AVL.get(15));
    System.out.println(AVL.get(30));
    System.out.println(AVL.get(8));

    //Print AVL Tree
    Iterable<Position<Entry<Integer,String>>> set = AVL.entryPositionSet();    
    int counter= 1;
    for(Position<Entry<Integer,String>> Node: set){
      System.out.println("\nNode "+counter+ ": "+ Node.getElement() + " \n        Height: "
                         + AVL.height(Node));
      counter++;
    }
    
  }
}