/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/05/2022
    Description:Add recPrint() operation to both exercises 1 and 2 to print the list using a recursive function/method.
// call recursive version to print
recPrint(arr, count); // print array in exercise 1

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
    
    for(int i=0;i < COUNT;i++){
      System.out.print(ARRAY[i] + " ");
    } 
    System.out.println();
  }

  /*****************recPrint***************/
  public static void recPrint(int size){
   
    if (size > 0){
        recPrint(size-1);
        System.out.print(ARRAY[size-1]+ " ");
    }

  }
  
  public static void main(String[] args) {
    //try testcases
    insertFront("Jo"); 
    insertFront("Jane"); 
    insertRear("John");
    insertRear("Kim"); 
    remove("Jo"); //Remove string in middle
    print(); // output Jane John Kim
    recPrint(COUNT);
    insertFront("Gaby"); 
    insertFront("Danny"); 
    System.out.println();
    print(); //output Danny Gaby Jane John Kim
    recPrint(COUNT);
    // insertRear("Robert");
    // print(); // output Danny Gaby Jane John Kim Robert
    
    // insertRear("Ben");
    // insertFront("Nancy");
    // insertRear("Jim");
    // insertRear("Kira"); // 10th name
    // print(); //output Danny Gaby Jane John Kim Robert Ben Jim Kim
    
    // insertRear("Tim"); //11th name in rear
    // print(); //output Danny Gaby Jane John Kim Robert Ben Jim Kim
    
    // insertFront("Tim2"); //11th name in front
    // print(); //output: Tim2 Nancy Danny Gaby Jane John Kim Robert Ben Jim 

    // remove("Sarah"); // remove string that doesn't exist
    // remove("Tim2"); // remove first string
    // print();
    // remove("Jim"); // remove last string
    // print();
  }
}