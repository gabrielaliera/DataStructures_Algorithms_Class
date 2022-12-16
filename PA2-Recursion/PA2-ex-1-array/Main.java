/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/29/2022
    Description: Provide an array implementation to maintain a list of names. The following operations are available: insert rear, insert front, remove a particular element, and print the whole list. Do not implement an ADT for this assignment (i.e., do not use a class with data and operations). Just set up a fixed size array of 10 elements (will not insert more than 10 elements) and provide code in main calling functions/static methods to perform insert, remove, and print. You can set up a menu or hard code some test cases to test your implementation. Feel free to use provided code from textbook as the starting point.
    I certify that the code below is my own work.
Exception(s): N/A
*/
public class Main {

  //Global Variables
  static private String[] ARRAY = new String[10];
  static private int COUNT = 0;

  /************************insertRear**********************/
  public static void insertRear(String s){
    
    if(COUNT ==10){
      System.out.println("Reach Max Array Size. Can't insert "+ s);
    } else{
      ARRAY[COUNT]=s;
      COUNT++;
    }
  }
/**********************insertFront************************/
  public static void insertFront(String s){

    if (COUNT == 10){ //if count 10, insert in front and push last element out
      System.out.println(ARRAY[9]+ " was push out of Array because max array size of 10 was reached. " + s + " insert in front");
      for(int i=COUNT-2;i>=0;i--){
        ARRAY[i+1] = ARRAY[i];
      }
      ARRAY[0] = s; 
      
    } else if (COUNT < 1){ //if count is 0, insert string at index 0 
        ARRAY[COUNT] = s;
        COUNT++;
    } else {
      
      for(int k=1;k<ARRAY.length; k++){ //Find index with first null
        if(ARRAY[k]== null){

          for(int j=k ; j> 0; j--){ //shift value to rigiht
            ARRAY[j] = ARRAY[j-1];
          }
          ARRAY[0] = s; // Set string to index 0
          COUNT++;
          break;
        }  
      }
    }
  }
/*********************remove********************/
  public static void  remove(String s){
    boolean containsString = false;
        
      for(int i=0;i<COUNT;i++){ //Iterate through each index to find string
        
        if(ARRAY[i].equals(s)){  //Once string is found
          containsString = true;
          
          for(int j = i+1; j< COUNT; j++){ //Shift values to the left
            ARRAY[j-1] = ARRAY[j]; 
          }
          COUNT--;
        }
      }
    
      if (!containsString){
        System.out.println("String "+ s+ " is not found in array.");
      }
  }
/*****************print***************/
  public static void print(){
    System.out.print("Array : ");
    
    for(int i=0;i < COUNT;i++){
      System.out.print(ARRAY[i] + " ");
    }
    
    System.out.println("\n");
  }
  
  public static void main(String[] args) {
    //try testcases
    insertFront("Jo"); 
    insertFront("Jane"); 
    insertRear("John");
    insertRear("Kim"); 
    remove("Jo"); //Remove string in middle
    print(); // output Jane John Kim

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
    
    insertRear("Tim"); //11th name in rear
    print(); //output Danny Gaby Jane John Kim Robert Ben Jim Kim
    
    insertFront("Tim2"); //11th name in front
    print(); //output: Tim2 Nancy Danny Gaby Jane John Kim Robert Ben Jim 

    remove("Sarah"); // remove string that doesn't exist
    remove("Tim2"); // remove first string
    print();
    remove("Jim"); // remove last string
    print();
  }
}