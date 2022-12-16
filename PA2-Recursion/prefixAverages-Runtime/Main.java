/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/01/2022
    Description:Perform max sum problem below or P-4.1 from C++ textbook as an alternate problem. Run your program with the 10 values below as one test case to confirm it is working correctly and output results to the screen. In addition, run your program and output only running times in ms for 100, 1000, 10000, and 10000 elements (generate random values between -10000 and 10000). 
    I certify that the code below is my own work.
Exception(s): N/A
*/
import java.util.Random;
import java.util.Arrays;

class Main {

  public static int[] prefixAverages1(int X[]){
    
    int[] A = new int[X.length];
    
    for(int i=0;i<A.length;i++){
      int a = 0;
      for(int j=0;j<i+1;j++){
        a = a + X[j];
      }
      A[i] = a/(i+1);
    }
    return A;  
  }

 public static int[] prefixAverages2(int X[]){
   int[] A = new int[X.length];
   int s = 0;

   for(int i=0; i< A.length;i++){
     s = s + X[i];
     A[i] = s/(i+1);
   }
   return A;
    
 } 
/**************************makeArray********************/
  public static int[] makeArray(int size){
    int[] a = new int[size];
    int min = -10000;
    int max = 10000;
    Random random = new Random();
    
    for(int i = 0; i<size;i++){
      int num = random.nextInt(max-min) + min;
      a[i] = num;
    }
    return a;
  }
  /**************************runAverage1********************/
  public static void runAverage1(int[] testcase, String size){
    double start = System.currentTimeMillis();

    prefixAverages1(testcase);

    double finish = System.currentTimeMillis();
    double time = finish -start;
    System.out.println("prefixAverage1: " +size+ " elements");
      //System.out.println(" Runtime: " + time+ " ms");
    System.out.printf("Runtime: %.3f ms \n", time);
  }
   /**************************runAverage2********************/
  public static void runAverage2(int[] testcase, String size){
    double start = System.currentTimeMillis();

    prefixAverages2(testcase);

    double finish = System.currentTimeMillis();
    double time = finish -start;
    System.out.println("prefixAverage2: " +size+ " elements");
   // System.out.println(" Runtime: " + time+ " ms");
    System.out.printf("Runtime: %.3f ms \n", time);
  }
  /**************************MAIN********************/
  public static void main(String[] args) {

    int[] test10 = makeArray(10);
    int[] test100 = makeArray(100);
    int[] test1000 = makeArray(1000);
    int[] test10000 = makeArray(10000);
    int[] test100000 = makeArray(100000);
                                
    int[] a = {10,30,50};
    System.out.println(Arrays.toString(prefixAverages1(a)));
    System.out.println(Arrays.toString(prefixAverages2(a)));
    
    
    runAverage1(test100,"100");
    runAverage2(test100,"100");
    System.out.println();

    runAverage1(test1000,"1000");
    runAverage2(test1000,"1000");
    System.out.println();
    
    runAverage1(test10000,"10,000");
    runAverage2(test10000,"10,000");
    System.out.println();
    
    runAverage1(test100000,"100,000");
    runAverage2(test100000,"100,000");
    System.out.println("DONE");
  }
}