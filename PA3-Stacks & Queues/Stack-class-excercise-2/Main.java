/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/14/2022
    Description: You must define and implement your own Stack class or use the one from the textbook. The Stack class supports standard basic stack operations, and you can implement it with an array or a linked list. You should create a class template Stack in C++ or generic class Stack in Java, but an integer stack would work as well. Set up a function or static method that receives a string representing a postfix expression and it returns an integer result. Your function/method uses a stack to evaluate a postfix expression (see an operand -- push; see an operator – pop twice, evaluate, then push result).
• Test your function/method and Stack class with the following postfix expressions by using a test driver:
17 2 3 + / 13 -
5 2 3 ^ *
2 3 2 ^ ^

    I certify that the code below is my own work.
Exception(s): N/A
*/

class Main {
  
  public static int postfix(String s){
    Stack<Integer> myStack = new Stack<>();
    int answer=-1;
    String[] a = s.split(" ");
    for(String str: a){                     //iterate throughout String array 
      if(isInteger(str)){                   // Check if element is integer
        myStack.push(Integer.parseInt(str));   // push integer to stack
        myStack.print();
      } else{
        int num1 = myStack.pop();
        int num2 = myStack.pop();
        
        switch (str){                      //Switch case for operators
          case "+":
            answer = num1 + num2;
            break;
          case "-":
            answer = num2-num1;
            break;
          case "*":
            answer = num1 * num2;
            break;
          case "/":
            answer = num2 / num1;
            break;
          case "^":
            answer = (int) Math.pow(num2,num1);
            break;
        }
        System.out.println("Answer: "+ answer);
        myStack.push(answer);
      }
    }
    System.out.println("Final stack: ");
    myStack.print();
    return answer;
  }

  public static boolean isInteger(String str){
    char[] array = str.toCharArray();
    for (char c : array){
      if(!Character.isDigit(c)){
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    Stack<Integer> myStack = new Stack<>();
    //Testcase for Stack
    System.out.println("Empty: "+ myStack.isEmpty());
    myStack.pop();
    myStack.print();
    myStack.push(17);
    myStack.push(2);
    myStack.push(3);
    myStack.print();
    System.out.println("Size: "+ myStack.size());
    System.out.println("Empty: "+ myStack.isEmpty());
    myStack.pop();
    myStack.print();
    System.out.println("Top: " +myStack.top());
    myStack.print();
    
    //Testcases for program
    System.out.println("\nTESTCASE 1: ");
    postfix("17 2 3 + / 13 -");
    System.out.println("\nTESTCASE 2: ");
    postfix("5 2 3 ^ *");
    System.out.println("\nTESTCASE 3: ");
    postfix("2 3 2 ^ ^");
    postfix("8 3 / 4 +");
  }
}