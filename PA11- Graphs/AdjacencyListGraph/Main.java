/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/16/2022
    Description: Set up your AdjacencyListGraph class to represent an undirected graph using Adjacency List (use string for vertex and int for edge. Try the test case below first and then create a simple graph with 4 vertices and 6 edges and print it. Output your graph in this format:
Vertex A
2 adjacencies:(C, 200) (B, 100)
Vertex B
1 adjacencies:(A, 100)
Vertex C
1 adjacencies:(A, 200)
For Java, you can modify AdjacencyMapGraph to use a list instead of map to create AdjacencyListGraph class (Adjacency List option). Files to use: AdjacencyMapGraph.java and GraphExample.java.
Implementation of AdjacencyMapGraph is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
I certify the code below is my own: Main, Modified Adjecency List Graph
    Exception(s): None
*/
class Main {
  public static void main(String[] args) {
    //Testcase - Adjacency Map Graph
    boolean isDirected = false;
    AdjacencyMapGraph<String, Integer> adjMap = new AdjacencyMapGraph<>(isDirected);

    Vertex<String> A = adjMap.insertVertex("A");
    Vertex<String> B =adjMap.insertVertex("B");
    Vertex<String> C =adjMap.insertVertex("C");
    
    adjMap.insertEdge(A,C,200);
    adjMap.insertEdge(A,B,100);

    System.out.println("\nAdjecency Map Graph");
    System.out.println(adjMap.toString());

    //Testcase -- Adjacency List Graph
    AdjacencyListGraph<String, Integer> adjList = new AdjacencyListGraph<>(isDirected);

    A = adjList.insertVertex("A");
    B = adjList.insertVertex("B");
    C = adjList.insertVertex("C");
    
    adjList.insertEdge(A,C,200);
    adjList.insertEdge(A,B,100);
    
    System.out.println("Adjecency List Graph");
    System.out.println(adjList.toString());
    
    System.out.println("Edge AC: "+ adjList.getEdge(A,C).getElement());
    System.out.println("Edge AB: "+ adjList.getEdge(A,B).getElement());
    System.out.println("Edge CA: "+ adjList.getEdge(C,A).getElement());
   // adjList.removeVertex(A);

    //TestCase 2
    AdjacencyListGraph<String, Integer> adjList2 = new AdjacencyListGraph<>(isDirected);
    Vertex<String> A2 = adjList2.insertVertex("A");
    Vertex<String> B2= adjList2.insertVertex("B");
    Vertex<String> C2 = adjList2.insertVertex("C");
    Vertex<String> D2 = adjList2.insertVertex("D"); 
    adjList2.insertEdge(A2,C2,200);
    adjList2.insertEdge(A2,B2,100);
    adjList2.insertEdge(A2,D2,100);
    adjList2.insertEdge(B2,C2,100);
    adjList2.insertEdge(B2,D2,200);
    adjList2.insertEdge(C2,D2,100);
    System.out.println("\nAdjecency List Graph: 4 vertices 6 edges");
    System.out.println(adjList2.toString());
    //Test other methods
    System.out.println("Edge AC: "+ adjList2.getEdge(A2,C2).getElement());
    System.out.println("Edge AB: "+ adjList2.getEdge(A2,B2).getElement());
    System.out.println("Edge CD: "+ adjList2.getEdge(C2,D2).getElement());
  }
}