public class Pair<K,V>{
      K key;
      V value;

      Pair(K key, V value){
        this.key = key;
        this.value = value;
      }
      public K getK(){return key;}
      public V getV(){return value;}
    
  }