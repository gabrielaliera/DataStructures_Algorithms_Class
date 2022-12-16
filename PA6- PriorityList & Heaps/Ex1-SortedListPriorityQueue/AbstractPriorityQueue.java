/*  Java Class: Abstract Priority Queue
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/03/2022
    Description: 
      Modified from textbook:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    Exception(s):
*/
import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V>{

  //Nested PQ Entry class
  protected static class PQEntry<K,V> implements Entry<K,V>{
    private K k;
    private V v;
    public PQEntry(K key, V value){
      k= key;
      v = value;
    }

    public K getKey(){return k;}
    public V getValue(){return v;}
    protected void setKey(K key){k=key;}
    protected void setValue(V value){v=value;}
  }//end of nested PQ entry

  private Comparator<K> comp;
  
  protected AbstractPriorityQueue(Comparator<K> c ){comp = c;}

  protected AbstractPriorityQueue(){
    this(new DefaultComparator<K>());}

  protected int compare(Entry<K,V> a, Entry<K,V> b){
    return comp.compare(a.getKey(),b.getKey());
  }

  protected boolean checkKey(K key) throws IllegalArgumentException{
      try{
        return (comp.compare(key,key)==0);
        
      } catch( ClassCastException e){
        throw new IllegalArgumentException("Incompatible key");
      }
  }
  public boolean isEmpty(){return size()==0;}
 
}