/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/30/2022
    Description: Implement one MST algorithm -- either Prim-Jarnik Algorithm or Kruskal Algorithm. Try a small graph below and print out the MST and total cost. Use the following weights:

Implementation of MST is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
I certify the code below is my own: Main, Modified Adjecency List Graph
    Exception(s): Main
*/
import java.util.Iterator;
class Main {
  public static void main(String[] args) {
   //Build graph
    boolean isDirected = false;
    AdjacencyMapGraph<String, Integer> adjMap = new AdjacencyMapGraph<>(isDirected);
    Vertex<String> A = adjMap.insertVertex("A");
    Vertex<String> B =adjMap.insertVertex("B");
    Vertex<String> C =adjMap.insertVertex("C");
    Vertex<String> D =adjMap.insertVertex("D");
    Vertex<String> E =adjMap.insertVertex("E");       
    adjMap.insertEdge(A,B,3);
    adjMap.insertEdge(A,D,5);
    adjMap.insertEdge(A,E,5);
    adjMap.insertEdge(B,C,4);
    adjMap.insertEdge(C,D,2);
    adjMap.insertEdge(D,E,5);
    adjMap.insertEdge(C,E,3);
    System.out.println("\nUndirected Graph");
    System.out.println(adjMap.toString());

    //Run Kruskal MST
    MST mst = new MST();

    System.out.println("MST graph");
    int totalCost = 0;
    
    PositionalList<Edge<Integer>> tree = mst.MST(adjMap);
    Iterator<Edge<Integer>> iter = tree.iterator();
    //Print out edges and total weight
    while(iter.hasNext()){
      Edge<Integer> edge = iter.next();
      Vertex<String>[] endpoints = adjMap.endVertices(edge);
      System.out.println("Edge " + endpoints[0].getElement()+"->"+ endpoints[1].getElement());
      totalCost += edge.getElement();
    }
    System.out.println("Total Cost: "+totalCost);
  }
}