

import java.util.Comparator;

 public class minComparator<E> implements Comparator<E>{
    public int compare(E a, E b) throws ClassCastException{

      if (((Comparable<E>)a).compareTo(b) < 0 ){  //a < b
        return -1;  //lowest value has higher priority
      } else if  (((Comparable<E>)a).compareTo(b) == 0 ){ 
        return 0;
      } else{
        return 1;
      }
    }
  }