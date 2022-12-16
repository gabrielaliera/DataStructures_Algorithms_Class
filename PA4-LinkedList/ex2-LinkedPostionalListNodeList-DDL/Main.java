/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/23/2022
    Description: –Use a list (C++ NodeList or Java LinkedPositionalList) from the textbook to perform operations on a list of strings. Set up a driver to create a list, add a few items, remove a few items, and print the list. You must declare and use an iterator in your driver.
    Modify from textbook: I certify that the code below is my own work.
    Exception(s): IllegalStateException, NoSuchElementException
*/
import java.util.Iterator;
import java.lang.Iterable;

class Main { //Driver Program
  public static void main(String[] args) {
    
    LinkedPositionalList<String> myList = new LinkedPositionalList<>();
    
  //1. Add “Two” to the front
    myList.addFirst("Two");
  //2. Add “Three” to the rear
    myList.addLast("Three");
  // 3. Add “One” to the front   
    myList.addFirst("One");
  //4. Add “Four” to the rear
    myList.addLast("Four");

  //5. Use an iterator to print the list
    Iterator<String> iter= myList.iterator();
    System.out.print("First Print: ");
    while(iter.hasNext()){
      System.out.print(iter.next() + " ");
    }
  //6. Remove front
  //7. Remove back
    myList.remove(myList.first());
    myList.remove(myList.last());
   
  // 8. Set up an iterator at the begin and advance once
    Iterable<Position<String>> posIter = myList.positions();  //Create position iterator
    Iterator<Position<String>> cursor = posIter.iterator();   // Create cursor 
    cursor.next();                                  // Advance one position to 2nd postion
    
  // 9. Insert your name before the iterator
     myList.addBefore(cursor.next(), "Gaby");
  
  // 10. Use an iterator to print the list
    System.out.print("\nSecond Print: ");
    
    for(Position<String> p: posIter){
      System.out.print(p.getElement()+" ");
    }
    
  }//End of Main Program
}//End of file