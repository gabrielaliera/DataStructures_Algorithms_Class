/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/16/2022
    Description: Implement Topological Ordering on a DAG using AdjacencyListGraph class. Test it out on the following DAG:

Implementation of topological sort is modified from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
I certify the code below is my own: Main
    Exception(s): None
*/
import java.util.Stack;
import java.util.Iterator;
class Main { 
 /**
   * Returns a list of verticies of directed acyclic graph g in topological order.
   * If graph g has a cycle, the result will be incomplete.
   */
  public static <V,E> PositionalList<Vertex<String>> topologicalSort(Graph<String ,Integer> g) {
    // list of vertices placed in topological order
    PositionalList<Vertex<String>> topo = new LinkedPositionalList<>();
    // container of vertices that have no remaining constraints
    Stack<Vertex<String>> ready = new Stack<>();
    // map keeping track of remaining in-degree for each vertex
    Map<Vertex<String>, Integer> inCount = new ProbeHashMap<>();
    for (Vertex<String> u : g.vertices()) {
      inCount.put(u, g.inDegree(u));           // initialize with actual in-degree
      if (inCount.get(u) == 0)                 // if u has no incoming edges,
        ready.push(u);                         // it is free of constraints
    }
    while (!ready.isEmpty()) {
      Vertex<String> u = ready.pop();
      topo.addLast(u);
      for (Edge<Integer> e : g.outgoingEdges(u)) {   // consider all outgoing neighbors of u
        Vertex<String> v = g.opposite(u, e);
        inCount.put(v, inCount.get(v) - 1);    // v has one less constraint without u
        if (inCount.get(v) == 0)
          ready.push(v);
      }
    }
    return topo;
  }
  
  public static void main(String[] args) {
    //Create DAG
    boolean isDirected = true;
    AdjacencyMapGraph<String, Integer> graph2 = new AdjacencyMapGraph<>(isDirected);
    Vertex<String>A = graph2.insertVertex("A");
    Vertex<String>B =graph2.insertVertex("B");
    Vertex<String>C = graph2.insertVertex("C");
    Vertex<String>D = graph2.insertVertex("D");
    Vertex<String> E = graph2.insertVertex("E");
    Vertex<String> F = graph2.insertVertex("F");
    graph2.insertEdge(B,A,1);
    graph2.insertEdge(B,C,1);
    graph2.insertEdge(A,F,1);
    graph2.insertEdge(A,D,1);
    graph2.insertEdge(C,D,1);
    graph2.insertEdge(D,E,1);

    System.out.println("\nDiagraph");
    System.out.println(graph2.toString());

    //Topoligical Sort on DAG and print
    PositionalList<Vertex<String>> topo = topologicalSort(graph2);
    Iterator<Vertex<String>> iter = topo.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next().getElement()+"->");
    }
  }
}