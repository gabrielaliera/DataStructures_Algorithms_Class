/*  Java Class: Sort
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 12/01/2022
    Description: Topogolical sorting of DAG
    I certify that the code below is my own work.
Exception(s): N/A
*/

import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;

public class SortOld{

  static int[][] matrix;
  
  //List of vertices in topolocial sort
  static ArrayList<Integer> topo = new ArrayList<>();

  //Container for process vertices
  static Stack<Integer> ready = new Stack<>();

  //tracks remaining in-degree for each vertex
  static HashMap<Integer,Integer> inCount = new HashMap<>();

  SortOld(int[][]m){
    this.matrix = m;
  }
  
  public void topo(){
    //System.out.println("start matrix");
   //  printMatrix();

    //Add vertex and indgree to  inCount starting at column and iterating down rows
    for(int col=0;col<matrix.length;col++){
      inCount.put(col,0); //Add vertex with intial in-degree zeo
     // System.out.println("Incount O: "+ col);
      
      for(int row=0;row<matrix[0].length;row++){
       // System.out.println("Get 1st indegree: col-"+ col+ "t[][]: "+ matrix[row][col]);
        if(matrix[row][col]== 1){
          inCount.put(col, inCount.get(col) + 1); //update in-degree
        }  
    
      }
      if(inCount.get(col)==0){  //End Vertex to stack if indegree is still 0
        ready.push(col);
       // System.out.println("1st push: "+ col);
      }
    }

  //  System.out.println("Generated all indgrees");

    while(!ready.isEmpty()){
      int vertex = ready.pop();
    // System.out.println("pop: "+vertex);
      topo.add(vertex);  // Add vertex to topological order

      for(int i=0; i < matrix.length ;i++){  // remove edges at vertex
        matrix[vertex][i] =0;
       // System.out.println("Erase edges: "+ matrix[vertex][i]);
      } 
      //printMatrix();
      
      updateInDegree(vertex);  // update indegree
      //break;
    }

    printTopo();
  }

  //Internal method in topological sort to update indegree when 
  //vertex is remove from grapg
  public static void updateInDegree(int vertex){
        
    for(int col=0;col<matrix.length;col++){
      int count = 0;
      for(int row=0;row<matrix[0].length;row++){
        if(matrix[row][col]== 1){ 
          count++;
        }
        inCount.put(col, count); //update in-degree
      }
    //System.out.println("Col "+col+" update incout: "+ inCount.get(col));
    
      if(inCount.get(col)==0 && !topo.contains(col) && ready.search(col) == -1){  //Add Vertex to stack if indegree= 0
        ready.push(col);
      //  System.out.println("push during update: "+ col);
      }
    }
  }

  //Print for debugging 
  public static void printMatrix(){
    for(int i=0;i<matrix.length;i++){
      System.out.println();
      for(int j=0;j<matrix[0].length;j++){
        System.out.printf("%-7s",matrix[i][j]);
      }
      System.out.println();
    }
  }

  //Prints topological linked list
  public static void printTopo(){
    System.out.println("DAG Topological Order: ");
    for(int vertex: topo){
      System.out.print(vertex+" ");
    }
  }
}