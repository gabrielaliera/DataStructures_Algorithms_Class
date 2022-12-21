/*  Java Class: Map intergace
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/12/2022
    Description: Map interface
    Modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
Exception(s): 
*/
public interface Map<K,V> {

  int size();

  boolean isEmpty();

  V get(K key);

  V put(K key, V value);

  V remove(K key);

  Iterable<K> keySet();

  Iterable<V> values();

  Iterable<Entry<K,V>> entrySet();
}