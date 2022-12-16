/*  Java Class:Sorted Priority Queue
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/6/2022
    Description: – Sorted PQ using Linked Positional List
    Modified from textbook:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    Exception(s): IllegalStateException
*/
import java.util.Comparator;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

  private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

  public SortedPriorityQueue() { super(); }

  public SortedPriorityQueue(Comparator<K> comp) { super(comp); }

  public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
    checkKey(key);    // auxiliary key-checking method (could throw exception)
    Entry<K,V> newest = new PQEntry<>(key, value);
    Position<Entry<K,V>> walk = list.last();
    // walk backward, looking for smaller key
    while (walk != null && compare(newest, walk.getElement()) < 0)
      walk = list.before(walk);
    if (walk == null)
      list.addFirst(newest);                   // new key is smallest
    else
      list.addAfter(walk, newest);             // newest goes after walk
    return newest;
  }

  public Entry<K,V> min() {
    if (list.isEmpty()) return null;
    return list.first().getElement();
  }

  public Entry<K,V> removeMin() {
    if (list.isEmpty()) return null;
    return list.remove(list.first());
  }

  public int size() { return list.size(); }
}
