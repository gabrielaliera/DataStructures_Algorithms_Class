/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/26/2022
    Description: Write an efficient C++ function that takes any integer value i and returns 2i, as a long value. Your function should not multiply 2 by itself i times; there are much faster ways of computing 2i.
    I certify that the code below is my own work.
Exception(s): N/A
*/

class Main {
   // Recursion is not more efficient than iteration
  // public static long powerofI(int i){
  //   long answer;

  //   if (i == 0){
  //     return 1;
  //   } else {
  //     i--;
  //     answer =2 * powerofI(i);
  //   }
  //   return answer;  
  // }

  // 2 = 0000 0010 2^1
  // 4 = 0000 0100 2^2
  // 8 = 0000 1000  2^3
  //16 = 0001 0000 2^4
  public static long power(int i){
    long answer;
    answer = 1 << i;
    return answer;
    
  }
  
  public static void main(String[] args) {
    System.out.println(power(3));
    System.out.println(power(20));
    System.out.println(power(0));
    System.out.println(power(1));
    System.out.println(power(2));
    System.out.println(power(10));
  }
}