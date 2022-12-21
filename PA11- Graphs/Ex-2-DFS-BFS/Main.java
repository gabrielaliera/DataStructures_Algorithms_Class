/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/16/2022
    Description: Implement either DFS or BFS using your graph class from exercise 1. You can set up DFS(G, v) like the book (perform DFS on a graph) or G.DFS(v) where DFS() is a member of Graph class (use similar set up for BFS). For C++, you can use Decorator.h and DFS.h and use GaphAlgorithms.java for Java. Print out the vertices and discovery/forward edges in the order that they were visited (should be vertex, discovery edge, vertex, etc.). Try the following graph and start out with vertex B:

Implementation of DFS is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
I certify the code below is my own: Main, InSet 
    Exception(s): None
*/
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

class Main {
  public static void main(String[] args) {

    //Testcase 1- Undirected Graph
    boolean isDirected = false;
    //Build graph
    AdjacencyMapGraph<String, String> adjMap = new AdjacencyMapGraph<>(isDirected);
    Vertex<String> A = adjMap.insertVertex("A");
    Vertex<String> B =adjMap.insertVertex("B");
    Vertex<String> C =adjMap.insertVertex("C");
    Vertex<String> D =adjMap.insertVertex("D");
    Vertex<String> E =adjMap.insertVertex("E");       
    adjMap.insertEdge(A,B,"AB");
    adjMap.insertEdge(A,D,"AD");
    adjMap.insertEdge(B,C,"BC");
    adjMap.insertEdge(C,D,"CD");
    adjMap.insertEdge(D,E,"DE");

    System.out.println("\nUndirected Graph");
    System.out.println(adjMap.toString());

    //Implement DFS
    DFS_Algo DFS = new DFS_Algo();
    HashSet<Vertex<String>> known = new HashSet<Vertex<String>>();
    HashMap<Vertex<String>,Edge<String>> forest = new HashMap<Vertex<String>,Edge<String>>();
    DFS.DFS(adjMap,B,known,forest);


    //Testcase 2- Directed Graph

    //Build graph
    isDirected = true;
    AdjacencyMapGraph<String, String> graph2 = new AdjacencyMapGraph<>(isDirected);
    HashSet<Vertex<String>> known2 = new HashSet<Vertex<String>>();
    HashMap<Vertex<String>,Edge<String>> forest2 = new HashMap<Vertex<String>,Edge<String>>();

    A = graph2.insertVertex("A");
    B =graph2.insertVertex("B");
    C = graph2.insertVertex("C");
    D = graph2.insertVertex("D");
    E = graph2.insertVertex("E");    
    graph2.insertEdge(B,A,"BA");
    graph2.insertEdge(B,C,"BC");
    graph2.insertEdge(A,E,"AE");
    graph2.insertEdge(A,D,"AD");
    graph2.insertEdge(C,D,"CD");
    graph2.insertEdge(D,E,"DE");
    graph2.insertEdge(E,C,"EC");

    //Implement DFS
    System.out.println("\nDiagraph");
    System.out.println(graph2.toString());
    DFS.DFS(graph2,B,known2,forest2);

  }
}