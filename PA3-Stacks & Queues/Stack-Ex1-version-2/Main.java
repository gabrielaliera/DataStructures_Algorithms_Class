/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/12/2022
    Description:You must use either existing C++ language stack class or Java language Stack class to solve the "Balancing Symbols" problem. The symbols are (), [], and {}, and each opening symbol must have a corresponding closing symbol as well as in correct order. Ignore operands and arithmetic operators since they are not relevant to our
problem. You can assume each token is separated by spaces. Try the 3 examples below:
• { ( a + b ) * c1 } – valid
• { ( a + b ) * c1 ] – invalid
• ( ( a + b ) * c1 } / 15 ) – invalid
    Modified: Data-Strucutures and Algorithms in Java 6th 
    I certify that the code below is my own work.
Exception(s): N/A
*/
import java.util.Stack; //LIFO last in first out
class Main {

  public static boolean isMatch( String expression){
    final String opening = "({[";
    final String closing = ")}]";

    Stack<String> myStack = new Stack<>();
    //expression = expression.replaceAll("\\s"," ");
    String[]  array = expression.split(" ");

    for(String c : array){
      if(opening.indexOf(c) != -1){ //Symbol found in opening string
        myStack.push(c);
      } else if( closing.indexOf(c) != -1){ //Symbol found in closing string

        if(myStack.empty()){
          return false;
        }

        if(opening.indexOf(myStack.pop()) != closing.indexOf(c)){ //Compare top of stack w/ current c
          return false;
        }
      } //if symbol not found in opening/closing string (ie a,+,b,etc) skip to next element in array
    }//end for
    return myStack.empty();
  }
  public static void main(String[] args) {
    
    String testA = "{ ( a + b ) * c1 }";
    String testB = "{ ( a + b ) * c1 ]";
    String testC = "( ( a + b ) * c1 } / 15 )";
    //String testD = "{(a+25  )* c1}";

    if (isMatch(testA)){
      System.out.println("testA is valid");
    } else{
      System.out.println("testA is invalid");
    }

    if (isMatch(testB)){
      System.out.println("testB is valid");
    } else{
      System.out.println("testB is invalid");
    }

    if (isMatch(testC)){
      System.out.println("testC is valid");
    } else{
      System.out.println("testC is invalid");
    }
    
    // if (isMatch(testD)){
    //   System.out.println("testD is valid");
    // } else{
    //   System.out.println("testD is invalid");
    // }
  
  }
}