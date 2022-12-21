/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/21/2022
    Description: – Use SearchTree class in C++ book (modified by me and provided here) or TreeMap class for Java book and set up a test driver to perform some operations such as insert, erase, and find. Perform the operations in question 1 below (steps 1 to 7) and then search for 15, 30, and 8. Print the BST as the final step. Assume that key is an integer and value is a string such as a name (come up with your own names).
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
    TreeMap<Integer,String> BST = new TreeMap<Integer,String>();
    BST.put(10,"Ben");
    BST.put(20,"Gaby");
    BST.put(4,"Sam");
    BST.put(8,"Joe");
    BST.put(15,"Sarah");
    BST.remove(8);
    BST.remove(10);
    System.out.println(BST.get(15));
    System.out.println(BST.get(30));
    System.out.println(BST.get(8));

    Iterable<Entry<Integer,String>> iter = BST.entrySet();
    Iterator<Entry<Integer,String>> printIter = iter.iterator();
    
    while(printIter.hasNext()){
      System.out.println(printIter.next()+ " ");
    }
    
  }
}