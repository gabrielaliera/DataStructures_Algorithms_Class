/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 12/01/2022
    Description: Implement a C++ class template or Java class generic MySimpleList that uses a singly  linked list to include the following operations: insertFront(e), removeRear(), empty(),  print(), and size(). You must set up your own linked list. Try it out with a list of integers  and a list of strings in a test driver. What is the running time for each operation? 

    I certify that the code below is my own work.
Exception(s): N/A
*/
class Main {
  public static void main(String[] args) {

    //Try it out with a list of integers
    System.out.println("\nTestcase: Integers");
    MySimpleList<Integer> list = new MySimpleList<>();
    System.out.println(list.empty());
    list.size();
    list.print();
    System.out.println("Removed: "+list.removeRear());
    
    list.insertFront(5);
    list.print();
    System.out.println("Removed: "+list.removeRear().getData());
    list.print();

    
    list.insertFront(4);
    list.insertFront(3);
    list.insertFront(2);
    list.insertFront(1);
    list.print();
    list.size();
    System.out.println(list.empty());
    
    System.out.println("Removed: "+list.removeRear().getData());
    System.out.println("Removed: "+list.removeRear().getData());
    list.print();
    
    //list of strings in a test driver
    MySimpleList<String> listB = new MySimpleList<>();
    System.out.println("\nTestcase: Strings");
    System.out.println(listB.empty());
    listB.size();
    listB.print();
    listB.insertFront("A");
    listB.insertFront("B");
    listB.insertFront("C");
    listB.insertFront("D");
    listB.insertFront("E");
    listB.size();
    System.out.println(listB.empty());
    listB.print();
    System.out.println("Removed: "+listB.removeRear().getData());
    System.out.println("Removed: "+listB.removeRear().getData());
    listB.print();
   

    //Test cases
    System.out.println("\nTestcase: Final Revision");
    // Create a MySimpleList object that can hold a list of strings 
     MySimpleList<String> listC= new MySimpleList<>();
    // insert “Jane” to the front
    listC.insertFront("Jane");
     // insert “John” to the front
    listC.insertFront("John");
    // insert “Kim” to the rear
    listC.insertRear("Kim");
    // insert “Tom” to the rear
    listC.insertRear("Tom");
    // print the size of the list, should be 4 
    listC.size();
    // remove rear
    listC.removeRear();
    // remove front
    listC.removeFront();
     // print the list, should be Jane Kim
    listC.print();
     // Create a MySimpleList object that can hold a list of integers 
     MySimpleList<Integer> listD= new MySimpleList<>();
    // print the size of the list, should be 0 
    listD.size();
    // output running time for insertRear()(O notation)
    System.out.println("Running time for insertRear: O(n)");
    // output running time for removeRear()(O notation)
    System.out.println("Running time for removeRear: O(1)");
  }
}
class Main {
  public static void main(String[] args) {

    //Try it out with a list of integers
    System.out.println("\nTestcase: Integers");
    MySimpleList<Integer> list = new MySimpleList<>();
    System.out.println(list.empty());
    list.size();
    list.print();
    System.out.println("Removed: "+list.removeRear());
    
    list.insertFront(5);
    list.print();
    System.out.println("Removed: "+list.removeRear().getData());
    list.print();

    
    list.insertFront(4);
    list.insertFront(3);
    list.insertFront(2);
    list.insertFront(1);
    list.print();
    list.size();
    System.out.println(list.empty());
    
    System.out.println("Removed: "+list.removeRear().getData());
    System.out.println("Removed: "+list.removeRear().getData());
    list.print();
    
    //list of strings in a test driver
    MySimpleList<String> listB = new MySimpleList<>();
    System.out.println("\nTestcase: Strings");
    System.out.println(listB.empty());
    listB.size();
    listB.print();
    listB.insertFront("A");
    listB.insertFront("B");
    listB.insertFront("C");
    listB.insertFront("D");
    listB.insertFront("E");
    listB.size();
    System.out.println(listB.empty());
    listB.print();
    System.out.println("Removed: "+listB.removeRear().getData());
    System.out.println("Removed: "+listB.removeRear().getData());
    listB.print();
   

    //Test cases
    System.out.println("\nTestcase: Final Revision");
    // Create a MySimpleList object that can hold a list of strings 
     MySimpleList<String> listC= new MySimpleList<>();
    // insert “Jane” to the front
    listC.insertFront("Jane");
     // insert “John” to the front
    listC.insertFront("John");
    // insert “Kim” to the rear
    listC.insertRear("Kim");
    // insert “Tom” to the rear
    listC.insertRear("Tom");
    // print the size of the list, should be 4 
    listC.size();
    // remove rear
    listC.removeRear();
    // remove front
    listC.removeFront();
     // print the list, should be Jane Kim
    listC.print();
     // Create a MySimpleList object that can hold a list of integers 
     MySimpleList<Integer> listD= new MySimpleList<>();
    // print the size of the list, should be 0 
    listD.size();
    // output running time for insertRear()(O notation)
    System.out.println("Running time for insertRear: O(n)");
    // output running time for removeRear()(O notation)
    System.out.println("Running time for removeRear: O(1)");
  }
}