/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/16/2022
    Description: Implement Transitive Closure for a digraph using AdjacencyListGraph class from exercise 1. Test it out on a simple example above (can assume each edge has a weight of 1). Print both original digraph and updated digraph.

Implementation of Adjacency Map Graph/Trasitivie Clsoure are modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
I certify the code below is my own: Main
    Exception(s): None
*/
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

class Main {
   
  public static <V,E> void transitiveClosure(Graph<V,E> g) {
    for (Vertex<V> k : g.vertices())
      for (Vertex<V> i : g.vertices())
        // verify that edge (i,k) exists in the partial closure
        if (i != k && g.getEdge(i,k) != null)
          for (Vertex<V> j : g.vertices())
            // verify that edge (k,j) exists in the partial closure
            if (i != j && j != k && g.getEdge(k,j) != null)
              // if (i,j) not yet included, add it to the closure
              if (g.getEdge(i,j) == null)
                g.insertEdge(i, j, null);
  }
  
  public static void main(String[] args) {

    //Testcase 2
    boolean isDirected = true;

    AdjacencyMapGraph<String, Integer> graph2 = new AdjacencyMapGraph<>(isDirected);

    Vertex<String>A = graph2.insertVertex("A");
    Vertex<String>B =graph2.insertVertex("B");
    Vertex<String>C = graph2.insertVertex("C");
    Vertex<String>D = graph2.insertVertex("D");
    Vertex<String> E = graph2.insertVertex("E");
        
    graph2.insertEdge(B,A,1);
    graph2.insertEdge(B,C,1);
    graph2.insertEdge(A,E,1);
    graph2.insertEdge(A,D,1);
    graph2.insertEdge(C,D,1);
    graph2.insertEdge(D,E,1);
    graph2.insertEdge(E,C,1);

    System.out.println("\nDiagraph");
    System.out.println(graph2.toString());

    System.out.println("\nDiagraph with transitive closure");
    transitiveClosure(graph2);
    System.out.println(graph2.toString());

  }
}