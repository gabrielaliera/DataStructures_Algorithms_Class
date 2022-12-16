/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/15/2022
    Description:Provide a linked implementation of a deque and name it LinkedDeque (use doubly linked list). It can be a template/generic class, or you can set it up with a certain data type like string. Use a test driver to try out your LinkedDeque by adding and removing values from both ends. Try the following test cases: insert front, insert front, insert rear, remove rear, remove rear, size, and front item.

    I certify that the code below is my own work.
Exception(s): N/A
*/
class Main {
  public static void main(String[] args) {
    
    System.out.println("\nTestcase from assigment:");
    LinkedDeque<Integer> myDequeA = new LinkedDeque<>();
    myDequeA.addFirst(1);
    myDequeA.addFirst(2);
    myDequeA.addLast(3);
    myDequeA.removeLast();
    myDequeA.removeLast();
    System.out.println("Size: "+ myDequeA.size());
    System.out.println("Front: "+myDequeA.first());
    myDequeA.print();
    
   //Testcase 2    
    System.out.println("\nTestcases 2: ");
    LinkedDeque<Integer> myDeque = new LinkedDeque<>();

    myDeque.print();
    myDeque.addFirst(1);
    myDeque.addFirst(2);
    myDeque.addFirst(3);
    myDeque.addLast(4);
    myDeque.addLast(5);
    myDeque.addLast(6);
    myDeque.addFirst(7);
    System.out.println("First: "+ myDeque.first());
    System.out.println("Last: "+ myDeque.last());
    myDeque.print();
    
    myDeque.removeFirst();
    myDeque.removeLast();
    System.out.println("First: "+ myDeque.first());
    System.out.println("Last: "+ myDeque.last());
    myDeque.print();
  //Testcases 3
    System.out.println("\nTestcases 3: ");
    LinkedDeque<String> myDeque2 = new LinkedDeque<>();
    myDeque2.addFirst("A");
    myDeque2.removeFirst();
    myDeque2.print();
    myDeque2.addFirst("A");
    myDeque2.addFirst("B");
    myDeque2.removeFirst();
    myDeque2.print();
    myDeque2.addFirst("B");
    myDeque2.addFirst("C");
    myDeque2.removeFirst();
    myDeque2.print();
  }
}