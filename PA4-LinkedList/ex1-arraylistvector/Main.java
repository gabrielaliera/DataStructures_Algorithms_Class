/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/21/2022
    Description: – Exercise 1: Use a vector (C++ ArrayVector or Java ArrayList) from the textbook to perform operations on a vector of strings. Set up a driver to create a vector, add a few items, remove a few items, and print the vector.
Try the following:
  1. Add “Two” to index 0
  2. Add “Three” to the 1
  3. Add “One” to index 0
  4. Add “Four” to index 3
  5. Print the vector
  6. Remove item at index 0
  7. Remove item at index 2
  8. Insert your name at index 1
  9. Print the vector
  Modified from text book 
  Exception(s): IndexOutOfBoundException in ArrayList  
*/
class Main {
  public static void main(String[] args) {
    ArrayList<String> myList = new ArrayList<>(1);
    myList.add("Two",0);
    myList.add("Three",1);
    myList.add("One",0);
    myList.add("Four",3);
    myList.print();

    myList.remove(0);
    myList.remove(2);
    myList.add("Gaby",1);
    myList.print();
    myList.add("TEST",10);
  }
}