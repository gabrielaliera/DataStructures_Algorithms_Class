/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/14/2022
    Description: Implement the MCP algorithm and print out resulting table as well as the minimum number of operations. Try B x C x D with B a 2x10 matrix, C a 10x50 matrix, and D a 50x20 matrix. Try another test case with 10x5 (A), 5x2 (B), 2x20 (C), 20x12 (D), 12x4 (E), and 4x60 (F).

    Implementation of alogrithms are modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/
class Main {

  public static void printMatrix(int[][] matrix){
    for(int i=0;i<matrix.length;i++){
      System.out.println();
      for(int j=0;j<matrix[0].length;j++){
        System.out.printf("%-7s",matrix[i][j]);
      }
    }
  }
  public static void main(String[] args) {
    
    MatrixChain mc = new MatrixChain();

    //Testcase 1
    int[]d = {2,10,50,20};

    int n = d.length - 1;            // number of matrices
    int[][] N = new int[n][n]; 

    N = mc.matrixChain(d);
    System.out.println("\nTestCase 1: ");
    System.out.println("Min number of min operations: "+N[0][n-1]);
    printMatrix(N);

    //Try another test case with 10x5 (A), 5x2 (B), 2x20 (C), 20x12 (D), 12x4 (E), and 4x60 (F).
    int[] d2 = {10,5,2,20,12,4,60};
    int n2 = d2.length - 1;            // number of matrices
    int[][] N2 = new int[n2][n2]; 

    N2 = mc.matrixChain(d2);
    System.out.println("\n\nTestCase 2: ");
    System.out.println("Min number of operations: "+ N2[0][n2-1]);
    printMatrix(N2);

  }
}