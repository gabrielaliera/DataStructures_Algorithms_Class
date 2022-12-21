import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class DFS_Algo{

  public ArrayList<Vertex> discovered = new ArrayList<>();

  public <V,E> void DFS(Graph<V,E> g, Vertex<V> u,HashSet<Vertex<V>> known, HashMap<Vertex<V>,Edge<E>> forest) {
    known.add(u);                              // u has been discovered
    discovered.add(u);//GL add vertex to discovered
    System.out.println("Visting: "+ u.getElement());//print out visited Vertices
    
    for (Edge<E> e : g.outgoingEdges(u)) {     // for every outgoing edge from u
      System.out.println("Discovery Edge: "+ e.getElement());
      
      Vertex<V> v = g.opposite(u, e);
      
      if (!known.contains(v)) {
        
        forest.put(v, e);                      // e is the tree edge that discovered v
        
        DFS(g, v, known, forest);              // recursively explore from v
      }
     // System.out.println(v.getElement());
    }
  }
}