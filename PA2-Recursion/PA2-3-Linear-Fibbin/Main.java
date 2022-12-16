/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/31/2022
    Description: Implement the linear Fibonacci version based on pseudocode on page 146 of the C++ textbook.
    I certify that the code below is my own work.
Exception(s): N/A
*/
import java.util.Arrays;

class Main {
  
  public static long[] LinearFibonacci(int k){
    if (k<= 1){
      long[] pair = {k,0};
      return pair;
    } else{
      
      long[] temp = LinearFibonacci(k-1);
      long[] pair = {temp[0] + temp[1], temp[0]};
      return pair;
    }
  }
  public static void main(String[] args) {
    //Testcases
    System.out.println(Arrays.toString(LinearFibonacci(0)));
    System.out.println(Arrays.toString(LinearFibonacci(1)));
    System.out.println(Arrays.toString(LinearFibonacci(5)));
    System.out.println(Arrays.toString(LinearFibonacci(10))); 
    System.out.println(Arrays.toString(LinearFibonacci(50)));
    System.out.println(Arrays.toString(LinearFibonacci(75)));
  }
}