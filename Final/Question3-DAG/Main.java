/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 12/3/2022
    Description:  Given the following DAG, provide a simple matrix to represent it (each entry of the  matrix would hold a value 0 or 1). 

    Provide code to print the above DAG using the following format (there are two edges from 0 to 2 and 0 to 3, …, and no edge from 5).  
    Vertex Edges 
    0      2 3 
    … 
    5 
    Print one possible topological ordering for the above DAG such as:  0 2 1 3 4 5
    I certify the code below is my own: Main
    Exception(s): None
*/
class Main {

  static int[][] matrix = new int[6][6];
  static int[][] matrixB = new int[7][7];
  
  public static void addEdge(int v1, int v2){
    matrix[v1][v2] =1;
  }

  public static void addEdgeB(int v1, int v2){
    matrixB[v1][v2] =1;
  }

  //print matrix
  public static void printMatrix(int[][] m){
    for(int i=0;i<m.length;i++){
      System.out.println();
      for(int j=0;j<m[0].length;j++){
        System.out.printf("%-7s",m[i][j]);
      }
      System.out.println();
    }
  }

  //Prints vertices and edges
  public static void printVE(int[][]m){
    System.out.printf("\nVertex %-3s\n","Edges");
    for(int i=0;i<m.length;i++){
      System.out.print(i+"      ");
      for(int j=0;j<m[0].length;j++){
        if(m[i][j]== 1){
          System.out.print(j+ " ");
        }  
      }
      System.out.println();
    }
  }
  
  public static void printNew(int[][]m){
    System.out.print("- ");
    for(int x =0;x<7;x++){
      System.out.printf("%-2d",x);
    }
    System.out.println();
    
    for(int i=0;i<m.length;i++){
    System.out.print(i+" ");
      for(int j=0;j<m[0].length;j++){
        if(m[i][j]== 1){
          System.out.print("y ");
        } else{
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }
    
  public static void main(String[] args) {
    addEdge(0,2);
    addEdge(0,3);
    addEdge(1,3);
    addEdge(2,4);
    addEdge(3,4);
    addEdge(4,5);

    System.out.println("Matrix 1:");
    printMatrix(matrix);
    printVE(matrix);
  
  
    Sort sort = new Sort(matrix);
    sort.topo();

    //Revision
    addEdgeB(0,2);
    addEdgeB(0,3);
    addEdgeB(1,3);
    addEdgeB(2,4);
    addEdgeB(3,4);
    addEdgeB(4,5);
    addEdgeB(3,6);

    System.out.println("\n\nMATRIX 2");
    printMatrix(matrixB);
    printVE(matrixB);
    printNew(matrixB);
  
    Sort sortB = new Sort(matrixB);
    sortB.topo();

    System.out.println("\nEnd");
    
  }
}