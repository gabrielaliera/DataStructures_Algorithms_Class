import java.util.Comparator;
import java.util.Arrays;

class QuickSort {

  public long comparsions=0;
  public long dataMoves=0;

  public long getComparsions(){return comparsions;}
  public long getDataMoves(){return dataMoves;}
  public void resetComparsions(){comparsions = 0;}
  public void resetDataMoves(){dataMoves=0;}


  //-------- support for top-down quick-sort of queues --------
  /** Quick-sort contents of a queue. */
  public void quickSort_Int(LinkedQueue<Pair> S, Comparator<Integer> comp) {
    int n = S.size();
    if (n < 2) return;                       // queue is trivially sorted
    // divide
    int pivot = (int) S.first().getK();                     // using first as arbitrary pivot
    // Queue<Integer> L = new LinkedQueue<>();
    // Queue<Integer> E = new LinkedQueue<>();
    // Queue<Integer> G = new LinkedQueue<>();

    LinkedQueue<Pair> L = new LinkedQueue<>();
    LinkedQueue<Pair> E = new LinkedQueue<>();
    LinkedQueue<Pair> G = new LinkedQueue<>();
    
    while (!S.isEmpty()) {                   // divide original into L, E, and G
      Pair element = S.dequeue();
      int c = comp.compare((int)element.getK(), pivot);
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
    quickSort_Int(L, comp);                      // sort elements less than pivot
    quickSort_Int(G, comp);                      // sort elements greater than pivot
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


  public void quickSort_String(LinkedQueue<Pair> S, Comparator<String> comp) {
    int n = S.size();
    if (n < 2) return;                       // queue is trivially sorted
    // divide
    String pivot = (String) S.first().getK();                     // using first as arbitrary pivot
    // Queue<Integer> L = new LinkedQueue<>();
    // Queue<Integer> E = new LinkedQueue<>();
    // Queue<Integer> G = new LinkedQueue<>();

    LinkedQueue<Pair> L = new LinkedQueue<>();
    LinkedQueue<Pair> E = new LinkedQueue<>();
    LinkedQueue<Pair> G = new LinkedQueue<>();
    
    while (!S.isEmpty()) {                   // divide original into L, E, and G
      Pair element = S.dequeue();
      String elementS = (String) element.getK();
      int c = comp.compare(elementS, pivot);
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
    quickSort_String(L, comp);                      // sort elements less than pivot
    quickSort_String(G, comp);                      // sort elements greater than pivot
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

  
  
  // //-------- support for in-place quick-sort of an array --------
 
  //Median of 3 for integer keys
  public Pair findMedian(Pair[] S, int firstIndex, int lastIndex){
    
    int midIndex = lastIndex/2;
    
    
    if((int)S[firstIndex].getK() > (int) S[midIndex].getK()){
      swap(firstIndex, midIndex, S);
    }

    if((int)S[firstIndex].getK() > (int)S[lastIndex].getK()){
      swap(firstIndex, lastIndex, S);
    }

     if((int)S[midIndex].getK() > (int)S[lastIndex].getK()){
      swap(midIndex, lastIndex, S);
    }

    swap(midIndex, lastIndex-1,S);
    return S[lastIndex -1];
  }

  //Median of 3 for string keys
  public Pair findMedian_S(Pair[] S, int firstIndex, int lastIndex){
    
    int midIndex = lastIndex/2;
    
    if(String.valueOf(S[firstIndex].getK()).compareTo(String.valueOf(S[midIndex].getK())) > 0){
      swap(firstIndex, midIndex, S);
    }

    if(String.valueOf(S[firstIndex].getK()).compareTo(String.valueOf(S[lastIndex].getK())) > 0){
      swap(firstIndex, lastIndex, S);
    }

     if( String.valueOf(S[firstIndex].getK()).compareTo(String.valueOf(S[midIndex].getK())) > 0){
      swap(midIndex, lastIndex, S);
    }

    swap(midIndex, lastIndex-1,S);
    return S[lastIndex -1];
  }
  

  public void swap(int a, int b, Pair[] S){
    Pair temp = S[a];
    S[a] = S[b];
    S[b] = temp;
    dataMoves = dataMoves +2;
    comparsions++;
  }
  
  //Quick sort in place for integer keys
  public void quickSortInPlace(Pair[] S, Comparator<Integer> comp) {
    quickSortInPlace(S, comp, 0, S.length-1);
  }

  private void quickSortInPlace(Pair[] S, Comparator<Integer> comp,int a, int b) {
    if (a >= b) return;                // subarray is trivially sorted
    int left = a;
    int right = b-1;
    //int pivotKey = (int) S[b].getK();
    Pair pivot = findMedian(S,a,b);      //Use median of 3
    int pivotKey = (int) pivot.getK();
    Pair temp;                            // temp object used for swapping
    while (left <= right) {
      
      // scan until reaching value equal or larger than pivot (or right marker)
      while (left <= right && comp.compare((int)S[left].getK(), pivotKey) < 0){
        left++;
        comparsions++;
      }
      
      // scan until reaching value equal or smaller than pivot (or left marker)
      while (left <= right && comp.compare((int)S[right].getK(), pivotKey) > 0){
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

  //quick sort in place for string keys
  public void quickSortInPlace_S(Pair[] S, Comparator<String> comp) {
    quickSortInPlace_S(S, comp, 0, S.length-1);
  }
  
 private void quickSortInPlace_S(Pair[] S, Comparator<String> comp,int a, int b) {
    if (a >= b) return;                // subarray is trivially sorted
    int left = a;
    int right = b-1;
    //Pair pivot = S[b];
    Pair pivot = findMedian_S(S,a,b);
    String pivotKey = String.valueOf(pivot.getK());
   
    Pair temp;                            // temp object used for swapping
    while (left <= right) {
      
      // scan until reaching value equal or larger than pivot (or right marker)
      while (left <= right && comp.compare(String.valueOf(S[left].getK()), pivotKey) < 0){
        left++;
        comparsions++;
      }
      
      // scan until reaching value equal or smaller than pivot (or left marker)
      while (left <= right && comp.compare(String.valueOf(S[right].getK()), pivotKey) > 0){
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
    quickSortInPlace_S(S, comp, a, left - 1);
    quickSortInPlace_S(S, comp, left + 1, b);
  }


  
}