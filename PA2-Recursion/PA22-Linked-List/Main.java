/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/31/2022
    Description:Provide a linked list implementation to maintain a list of names. The following operations are available: insert rear, insert front, remove a particular element, and print the whole list. Do not implement an ADT for this lab (i.e., do not use a class with data and operations). Just set up a node and use head pointer/reference to maintain a linked list of nodes and provide code in main calling functions/static methods to perform insert, remove, and print. You can set up a menu or hard code some test cases to test your implementation. Feel free to use provided code from textbook as the starting point.
    I certify that the code below is my own work.
Exception(s): N/A
*/
class Main {

  private static class Node{
     public String data;
     public Node next;
  }

  private static Node head=null;
  private static int COUNT=0;
  
  /********************insertFront**********************/
  static void insertFront(String s){
    Node cur = new Node();
    cur.data = s;
    cur.next = head;
    head = cur;

    COUNT++;
  }
  /********************insertRear**********************/
  static void insertRear(String s){
    Node cur = head;

    while(cur.next!=null){ //Traverse list 
      cur = cur.next;
    }

    Node temp = new Node(); //Create new node
    temp.data= s;
    temp.next = null;

    cur.next = temp; //Set cur.next to new Node temp

    COUNT++;
  }
/********************remove**********************/
  static void remove(String s){
    Node cur = head;
    int size = COUNT;

    if (cur==null){  // if list is empty
      System.out.println("List is empty. Can not remove "+ s);
    } else if(cur.data.equals(s)){  // if head contains string
       head = cur.next;
       COUNT--;
    }else{
  
      while (cur.next != null){   //Traverse list 
        
        if(cur.next.data.equals(s)){ //until next equals string
          cur.next = cur.next.next; // set next to node after node with string 
          COUNT--;
          break;
        } else{
          cur = cur.next;
        }
      }//end while
      if(COUNT == size){ //if string doesn't exist 
        System.out.println(s + " doesn't exist in list");
      }
      
    }//end if
    
  }
/********************print**********************/
  static void print(){
    Node cur = head;
    while (cur != null){ //Traverse list and print
      System.out.print(cur.data + " " );
      cur = cur.next;
    } 
    System.out.println();
  }
  
  public static void main(String[] args) {
    //Testcases
    insertFront("Jo");
    insertFront("Jane");
    insertRear("John");
    insertRear("Kim");
    remove("Jo");
    print(); // Jane John Kim
    
    insertFront("Gaby"); 
    insertFront("Danny"); 
    print(); //output Danny Gaby Jane John Kim
   
    insertRear("Robert");
    print(); // output Danny Gaby Jane John Kim Robert
    
    insertRear("Ben");
    insertFront("Nancy");
    insertRear("Jim");
    insertRear("Kira"); // 10th name
    print(); //output Danny Gaby Jane John Kim Robert Ben Jim Kim
    
    insertRear("Tim_Rear"); //11th name in rear
    print(); //output Danny Gaby Jane John Kim Robert Ben Jim Kim
    
    insertFront("Tim_Front"); //11th name in front
    print(); //output: Tim2 Nancy Danny Gaby Jane John Kim Robert Ben Jim 

    System.out.println("\nRemove Testcases: ");
    remove("Sarah"); // remove string that doesn't exist
    remove("Tim_Front"); // remove first string
    print();
    remove("Tim_Rear"); // remove last string
    print();
  }
}