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

    Stack<Character> myStack = new Stack<>();

    for( char c: expression.toCharArray()){
        if(opening.indexOf(c) != -1){
          myStack.push(c);
        } else if (closing.indexOf(c) != -1){
            if (myStack.empty()){
              return false;
            }
            if (closing.indexOf(c) != opening.indexOf(myStack.pop())){
              return false;
            }
        } //enf if 
    }//end for
    return buffer.empty();
  }
  
  
  public static void main(String[] args) {

    String testA = "{ ( a + b ) * c1 }";
    String testB = "{ ( a + b ) * c1 ]";
    String testC = "( ( a + b ) * c1 } / 15 )";

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
  
  }
}