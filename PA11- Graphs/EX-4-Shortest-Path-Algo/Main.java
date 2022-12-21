/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/16/2022
    Description: Implement a shortest path algorithm for a graph (preferably Dijkstra's algorithm) using AdjacencyListGraph class from exercise 1. Test it out using digraph above. Find the shortest path from B to E using the weights below. Print out the path how to get from source vertex to a destination vertex. Hint: need to store the vertex that you use to update the distance and you can backtrack from destination back to source vertex.
• <B, A>, 3
• <B, C>, 4
• <A, D>, 5
• <A, E>, 10
• <C, D>, 2
• <D, E>, 3
• <E, C>, 6
Implementation of DFS is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
I certify the code below is my own: Main, InSet 
    Exception(s): None
*/
import java.util.Stack;
class Main {

  public static void main(String[] args) {
    //Construct graph 
    boolean isDirected = true;
    AdjacencyMapGraph<String, Integer> graph2 = new AdjacencyMapGraph<>(isDirected);
    Vertex<String>A = graph2.insertVertex("A");
    Vertex<String>B =graph2.insertVertex("B");
    Vertex<String>C = graph2.insertVertex("C");
    Vertex<String>D = graph2.insertVertex("D");
    Vertex<String> E = graph2.insertVertex("E");
    graph2.insertEdge(B,A,3);
    graph2.insertEdge(B,C,4);
    graph2.insertEdge(A,E,10);
    graph2.insertEdge(A,D,5);
    graph2.insertEdge(C,D,2);
    graph2.insertEdge(D,E,3);
    graph2.insertEdge(E,C,6);
    System.out.println("\nDiagraph");
    System.out.println(graph2.toString());  //Print original graph
    
    //Implement shortest path
    ShortestPath sp = new ShortestPath();
    sp.shortestPathLengths(graph2, B);

//Find the shortest path from B to E using the weights below. Print out the path how to get from source vertex to a destination vertex. 
    Stack<Vertex> path = new Stack<>();
    path.push(E); //Push destination vertex E to stack

    //Find parent of E and push to stack
    Vertex parent = (Vertex) E.getDecorator("Parent");
    path.push(parent);    

    //Continue finding parents until source vertex
    while (parent.getElement() != "B"){
      parent = path.peek();
      parent = (Vertex) parent.getDecorator("Parent");
      path.push(parent);
    }
    //Print out path
    System.out.println("Shortest path from B to E");
    while(!path.isEmpty()){
      System.out.print(path.pop().getElement() + " ");
    }
  }
}