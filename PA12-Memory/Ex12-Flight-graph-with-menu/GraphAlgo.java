import java.util.Stack;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GraphAlgo{

  AdjacencyMapGraph<String, Double> graph;
  Double roundTripCost = 0.0;

  GraphAlgo(AdjacencyMapGraph<String, Double> g){
    this.graph = g; 
  }

  public void printCost(){
    System.out.println("Total RoundTrip Cost: $"+ roundTripCost);
    roundTripCost = 0.0;
  }
  
  public void cheapestFlight(Vertex<String> v1, Vertex<String> v2){
    shortestPathLengths(graph,v1); //Dijkstra algo
    Stack<Vertex> path = new Stack<>();
    path.push(v2); //Push destination vertex E to stack

    //Find parent of E and push to stack
    Vertex parent = (Vertex) v2.getDecorator("Parent");
    path.push(parent);    

    //Continue finding parents until source vertex
    String origin = v1.getElement();
    while (!origin.equals(parent.getElement())){
      parent = path.peek();
      parent = (Vertex) parent.getDecorator("Parent");
      path.push(parent);
    }
    //Print out path
    Double totalCost = 0.0;
    while(!path.isEmpty()){
      Vertex airport = path.pop();

      if(path.isEmpty()){
        break;
      } else{
        Vertex nextAirport = path.peek();
        Edge price = graph.getEdge(airport, nextAirport);
        Double cost = (Double) price.getElement();
        System.out.print(airport.getElement() + "- $" + cost + "-> ");
        totalCost = totalCost + cost;
      }
    }
    System.out.print(v2.getElement()+ " Total Cost: $"+ totalCost);
    System.out.println();
    roundTripCost = roundTripCost + totalCost;   
  }

  public void cheapestRound(Vertex<String> v1, Vertex<String> v2){
    roundTripCost = 0.0;
    cheapestFlight(v1, v2);
    cheapestFlight(v2, v1);
    printCost();
  }
  
  //For cheapestFlight and cheapestRound
  public <V> Map<Vertex<V>, Double> shortestPathLengths(Graph<V,Double> g, Vertex<V> src) {
    // // d.get(v) is upper bound on distance from src to v
    Map<Vertex<V>, Double> d = new ProbeHashMap<>();
       // map reachable v to its d value
    Map<Vertex<V>, Double> cloud = new ProbeHashMap<>();
       // pq will have vertices as elements, with d.get(v) as key
    AdaptablePriorityQueue<Double, Vertex<V>> pq =new HeapAdaptablePriorityQueue<>();
    // maps from vertex to its pq locator
    Map<Vertex<V>, Entry<Double,Vertex<V>>> pqTokens = new ProbeHashMap<>();

    // for each vertex v of the graph, add an entry to the priority queue, with
    // the source having distance 0 and all others having infinite distance
    for (Vertex<V> v : g.vertices()) {
      if (v == src)
        d.put(v,0.0);
      else{
        d.put(v, Double.MAX_VALUE);
        v.setDecorator("Parent",null); 
      }
      pqTokens.put(v, pq.insert(d.get(v), v));       // save entry for future updates
    }
    // now begin adding reachable vertices to the cloud
    while (!pq.isEmpty()) {
      Entry<Double, Vertex<V>> entry = pq.removeMin();
      double key = entry.getKey();
      Vertex<V> u = entry.getValue();
      cloud.put(u, key);                             // this is actual distance to u
      pqTokens.remove(u);                            // u is no longer in pq
      for (Edge<Double> e : g.outgoingEdges(u)) {
        Vertex<V> v = g.opposite(u,e);
        if (cloud.get(v) == null) {
          // perform relaxation step on edge (u,v)
          double wgt = e.getElement();
          if (d.get(u) + wgt < d.get(v)) {              // better path to v?
            d.put(v, d.get(u) + wgt);                   // update the distance
            pq.replaceKey(pqTokens.get(v), d.get(v));   // update the pq entry
            v.setDecorator("Parent",u);
          }
        }
      }
    }
    return cloud;         // this only includes reachable vertices
  }

  //3.Find an order to visit all airports starting from an airport
  public void vistAll(Vertex<String> airport){ 
    HashSet<Vertex<String>> known = new HashSet<Vertex<String>>();
    HashMap<Vertex<String>,Edge<Double>> forest = new HashMap<Vertex<String>,Edge<Double>>();
    DFS(graph,airport,known,forest);
  }

  //3. DFS to find an order to visit all airports
  public <V,E> void DFS(Graph<V,E> g, Vertex<V> u,HashSet<Vertex<V>> known, HashMap<Vertex<V>,Edge<E>> forest) {
    known.add(u);                              // u has been discovered
    System.out.print(u.getElement());//print out visited Vertices
    
    for (Edge<E> e : g.outgoingEdges(u)) {     // for every outgoing edge from u  
      Vertex<V> v = g.opposite(u, e);
      if (!known.contains(v)) {
        forest.put(v, e);                      // e is the tree edge that discovered v
        System.out.print(" -> ");
        DFS(g, v, known, forest);              // recursively explore from v
      } 
    }
  }


  public void fewestStops(Vertex<String> v1, Vertex<String> v2){ // Extra credit flight with fewest stops from one airport to another airport. 
    HashSet<Vertex<String>> known = new HashSet<Vertex<String>>();
    HashMap<Vertex<String>,Edge<Double>> forest = new HashMap<Vertex<String>,Edge<Double>>();
    BFS(graph, v1,known,forest);
    
    Stack<Vertex<String>> stack = new Stack<>(); //Stack to hold vertices from fewestStop
    
    Edge<Double> edge = forest.get(v2);
    Vertex<String>[] endpoints = graph.endVertices(edge);
    stack.push(endpoints[1]); //Push final destination

    //Using BSF forest, find vertex from edge and push to stack until reach v1 airport
    while(v1 != endpoints[0]){
      Edge<Double> edgeB = forest.get(endpoints[0]);
      endpoints = graph.endVertices(edgeB);
      stack.push(endpoints[1]);
    }
    stack.push(endpoints[0]); //Push v1 to stack

    //Print stack  
    while(!stack.isEmpty()){
      System.out.print(stack.pop().getElement()+" ");
      
    }
  }

    /**
   * Performs breadth-first search of the undiscovered portion of Graph g starting at Vertex s.
   * @param g Graph instance
   * @param s Vertex of graph g that will be the source of the search
   * @param known is a set of previously discovered vertices
   * @param forest is a map from nonroot vertex to its discovery edge in DFS forest
   * As an outcome, this method adds newly discovered vertices (including s) to the known set,
   * and adds discovery graph edges to the forest.

Run distrak with weight of edge 1
   */
  public static <V,E> void BFS(Graph<V,E> g, Vertex<V> s,HashSet<Vertex<V>> known, HashMap<Vertex<V>,Edge<E>> forest) {
    PositionalList<Vertex<V>> level = new LinkedPositionalList<>();
    known.add(s);
    level.addLast(s);                         // first level includes only s
    while (!level.isEmpty()) {
      PositionalList<Vertex<V>> nextLevel = new LinkedPositionalList<>();
      for (Vertex<V> u : level)
        for (Edge<E> e : g.outgoingEdges(u)) {
          Vertex<V> v = g.opposite(u, e);
          if (!known.contains(v)) {
            known.add(v);
            forest.put(v, e);                 // e is the tree edge that discovered v
            nextLevel.addLast(v);             // v will be further considered in next pass
          }
        }
      level = nextLevel;                      // relabel 'next' level to become the current
    }
  }

//Didnt use 
  public static <V,E> PositionalList<Vertex<String>> topologicalSort(Graph<String ,Double> g) {
    // list of vertices placed in topological order
    PositionalList<Vertex<String>> topo = new LinkedPositionalList<>();
    // container of vertices that have no remaining constraints
    Stack<Vertex<String>> ready = new Stack<>();
    // map keeping track of remaining in-degree for each vertex
    Map<Vertex<String>,Integer> inCount = new ProbeHashMap<>();
    for (Vertex<String> u : g.vertices()) {
      inCount.put(u, g.inDegree(u));           // initialize with actual in-degree
      if (inCount.get(u) == 0)                 // if u has no incoming edges,
        ready.push(u);                         // it is free of constraints
    }
    while (!ready.isEmpty()) {
      Vertex<String> u = ready.pop();
      topo.addLast(u);
      for (Edge<Double> e : g.outgoingEdges(u)) {   // consider all outgoing neighbors of u
        Vertex<String> v = g.opposite(u, e);
        inCount.put(v, inCount.get(v) - 1);    // v has one less constraint without u
        if (inCount.get(v) == 0)
          ready.push(v);
      }
    }
    return topo;
  }


 
}