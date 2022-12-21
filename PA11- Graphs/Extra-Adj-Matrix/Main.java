/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/16/2022
    Description: Set up code to represent an undirected graph using either a simple matrix or adjacency matrix. There is no code for it, but it should be straight forward with a simple matrix that stores only 0 or 1. Try it out with the same two test cases in exercise 1.
I certify the code below is my own: Main, Adjacecny Matrix
    Exception(s): None
*/
class Main {
  public static void main(String[] args) {
    //Testcase - Adjacency Map Graph
    AdjacencyMatrix adjMat = new AdjacencyMatrix(3);

    int A = adjMat.insertVertex();
    int B = adjMat.insertVertex();
    int C = adjMat.insertVertex();
    adjMat.insertEdge(A,C);
    adjMat.insertEdge(A,B);

    System.out.println("\nAdjecency Matrix");
    adjMat.print();
    //Testcase 2
    AdjacencyMatrix adjMat2 = new AdjacencyMatrix(4);

    int A2 = adjMat2.insertVertex();
    int B2 = adjMat2.insertVertex();
    int C2 = adjMat2.insertVertex();
    int D2 = adjMat2.insertVertex();
    adjMat2.insertEdge(A2,C2);
    adjMat2.insertEdge(A2,B2);
    adjMat2.insertEdge(A2,D2);
    adjMat2.insertEdge(B2,C2);
    adjMat2.insertEdge(B2,D2);
    adjMat2.insertEdge(C2,D2);
    System.out.println("\nAdjecency Matrix: 4 vertices 6 edges");
    adjMat2.print();
  }
}