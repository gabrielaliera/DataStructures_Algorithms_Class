import java.util.Comparator;

class QuickSort {

  public double comparsions=0;
  public double dataMoves=0;

  public double getComparsions(){return comparsions;}
  public double getDataMoves(){return dataMoves;}
  public void resetComparsions(){comparsions = 0;}
  public void resetDataMoves(){dataMoves=0;}
  
  //-------- support for top-down quick-sort of queues --------
  /** Quick-sort contents of a queue. */
  public void quickSort(Queue<Integer> S, Comparator<Integer> comp) {
    int n = S.size();
    if (n < 2) return;                       // queue is trivially sorted
    // divide
    int pivot = S.first();                     // using first as arbitrary pivot
    Queue<Integer> L = new LinkedQueue<>();
    Queue<Integer> E = new LinkedQueue<>();
    Queue<Integer> G = new LinkedQueue<>();
    while (!S.isEmpty()) {                   // divide original into L, E, and G
      int element = S.dequeue();
      int c = comp.compare(element, pivot);
      comparsions++;
      
      if (c < 0){                            // element is less than pivot
        L.enqueue(element);
        dataMoves++;
      }else if (c == 0){                       // element is equal to pivot
        E.enqueue(element);
        dataMoves++;
      }else{                                   // element is greater than pivot
        G.enqueue(element);
        dataMoves++;
      }
    }
    // conquer
    quickSort(L, comp);                      // sort elements less than pivot
    quickSort(G, comp);                      // sort elements greater than pivot
    // concatenate results
    while (!L.isEmpty()){
      S.enqueue(L.dequeue());
      dataMoves = dataMoves +2;
    }
    while (!E.isEmpty()){
      S.enqueue(E.dequeue());
      dataMoves = dataMoves +2;
    }
    while (!G.isEmpty()){
      S.enqueue(G.dequeue());
      dataMoves = dataMoves +2;
    }
  }

  
  //-------- support for in-place quick-sort of an array --------
  /** Quick-sort contents of a queue. */
  public void quickSortInPlace(int[] S, Comparator<Integer> comp) {
    quickSortInPlace(S, comp, 0, S.length-1);
  }

  /** Sort the subarray S[a..b] inclusive. */
  private void quickSortInPlace(int[] S, Comparator<Integer> comp,int a, int b) {
    if (a >= b) return;                // subarray is trivially sorted
    int left = a;
    int right = b-1;
    int pivot = S[b];
    int temp;                            // temp object used for swapping
    while (left <= right) {
      
      // scan until reaching value equal or larger than pivot (or right marker)
      while (left <= right && comp.compare(S[left], pivot) < 0){
        left++;
        comparsions++;
      }
      
      // scan until reaching value equal or smaller than pivot (or left marker)
      while (left <= right && comp.compare(S[right], pivot) > 0){
        right--;
        comparsions++;
      }
      
      if (left <= right) {  // indices did not strictly cross
        // so swap values and shrink range
        temp = S[left]; 
        S[left] = S[right]; 
        S[right] = temp;
        left++; right--;
        dataMoves += dataMoves + 2;
      }
    }//end while
    // put pivot into its final place (currently marked by left index)
    temp = S[left];
    S[left] = S[b]; 
    S[b] = temp;
    dataMoves = dataMoves +2;
    // make recursive calls
    quickSortInPlace(S, comp, a, left - 1);
    quickSortInPlace(S, comp, left + 1, b);
  }
}