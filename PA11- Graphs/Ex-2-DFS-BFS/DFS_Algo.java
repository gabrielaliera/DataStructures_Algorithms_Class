import java.util.HashSet;
import java.util.HashMap;

public class DFS_Algo{

  public <V,E> void DFS(Graph<V,E> g, Vertex<V> u,HashSet<Vertex<V>> known, HashMap<Vertex<V>,Edge<E>> forest) {
    
    known.add(u);                              // u has been discovered
    System.out.println("Vertex: "+ u.getElement());//print out visited Vertices
    
    for (Edge<E> e : g.outgoingEdges(u)) {     // for every outgoing edge from u  
      Vertex<V> v = g.opposite(u, e);
      if (!known.contains(v)) {
        forest.put(v, e);                      // e is the tree edge that discovered v
        System.out.println(u.getElement()+" to adjacent vertex: "+v.getElement()+" Discovery Edge: "+ e.getElement());
        
        DFS(g, v, known, forest);              // recursively explore from v
      } else{
        System.out.println(u.getElement()+ " Back Edge: "+ e.getElement());
      }
    }
  }
}