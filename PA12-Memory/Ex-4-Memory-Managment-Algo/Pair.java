public class Pair<K,V> {
  
  K start;
  V end;

  Pair(K a, V b){
    this.start =a;
    this.end = b;
  }
  /**
   * Returns the key stored in this entry.
   * @return the entry's key
   */
  K getStartIndex(){
    return start;
  }

  /**
   * Returns the value stored in this entry.
   * @return the entry's value
   */
  V getEndIndex(){
    return end;
  }
}