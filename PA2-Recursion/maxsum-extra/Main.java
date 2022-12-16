/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/05/2022
    Description:Max Sum Problem: Given the integer array x[n], compute the maximum sum found in any contiguous sub-array. If the input array is \
31 -41 59 26 -53 58 97 -93 -23 84, then the program returns the sum of x[2..6] which is 187.
    I certify that the code below is my own work.
Exception(s): N/A
*/
class Main {

  static int ORIGINAL_ARRAY_SIZE = 10;
  static int MAX = Integer.MIN_VALUE;
  
  public static int maxSum(int[] a, int size){  
    int start = 0;
    int end = size;
    
    while(start+ size <= ORIGINAL_ARRAY_SIZE){
      int sum=0;
      for(int i =start;i<end;i++){
        sum += a[i];
      }
      start++; end ++;
      MAX = Math.max(MAX,sum);
    }

    if (size == 1){
      return MAX;
    } else {
      return maxSum(a, size-1);
    }
  }
   
  public static void main(String[] args) {
    int[] array = {31,-41,59,26,-53,58,97,-93,-23,84};
    System.out.println(maxSum(array, 10));

    MAX = Integer.MIN_VALUE;
    int[] array2 = {1,1,1,1,1,1,1,1,1,1};
    System.out.println(maxSum(array2, 10));

    MAX = Integer.MIN_VALUE;
    int[] array3 = {0,0,0,0,-10,0,0,0,1,1};
    System.out.println(maxSum(array3, 10));
  }
}