import java.util.Comparator;
import java.util.ArrayList;

class QuickSort {

  public double comparsions=0;
  public double dataMoves=0;

  public double getComparsions(){return comparsions;}
  public double getDataMoves(){return dataMoves;}
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
  //** Quick-sort contents of a queue. */
  public int findMedian(Pair[] S){
    
    int lastIndex = S.length-1;
    int midIndex = lastIndex/2;
    
    Pair firstEntry = S[0];
    Pair lastEntry = S[lastIndex];
    Pair midEntry = S[midIndex];

    int first = (int) firstEntry.getK();
    int last = (int) lastEntry.getK();
    int middle = (int) midEntry.getK();

    if((first < last) && (first < middle)){
      S[0]= firstEntry;
      if(last < middle){
        S[midIndex] = lastEntry;
        S[lastIndex] = midEntry;
        
      } else{
        S[midIndex] = midEntry;
        S[lastIndex] = lastEntry;
       
      }
    } else if(middle< first && middle<last){
      S[0] = midEntry;
      if(first < last){
        S[midIndex] = firstEntry;
        S[lastIndex] = lastEntry;
      } else{
        S[midIndex] = lastEntry;
        S[lastIndex] = firstEntry;
      }
    }else{
      S[0] = lastEntry;
      if(first < middle){
        S[midIndex] = firstEntry;
        S[lastIndex] = midEntry;
      } else{
        S[midIndex] = midEntry;
        S[lastIndex] = firstEntry;
      }
    }
    Pair temp = S[midIndex];
    S[midIndex] = S[lastIndex-1];
    S[lastIndex-1]= temp;
    
    return last-1;
  }
  
  
  public void quickSortInPlace(Pair[] S, Comparator<Integer> comp) {
    quickSortInPlace(S, comp, 0, S.length-1);
  }

  /** Sort the subarray S[a..b] inclusive. */
  private void quickSortInPlace(Pair[] S, Comparator<Integer> comp,int a, int b) {
    if (a >= b) return;                // subarray is trivially sorted
    int left = a;
    int right = b-1;
    //int pivot = (int) S[b].getK();
    int pivot = findMedian(S);
    Pair temp;                            // temp object used for swapping
    while (left <= right) {
      
      // scan until reaching value equal or larger than pivot (or right marker)
      while (left <= right && comp.compare((int)S[left].getK(), pivot) < 0){
        left++;
        comparsions++;
      }
      
      // scan until reaching value equal or smaller than pivot (or left marker)
      while (left <= right && comp.compare((int)S[right].getK(), pivot) > 0){
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




  // //-------- support for in-place quick-sort of an array --------
  // /** Quick-sort contents of a queue. */
  // public void quickSortInPlace(ArrayList<Pair> S, Comparator<Integer> comp) {
  //   quickSortInPlace(S, comp, 0, S.length-1);
  // }

  // /** Sort the subarray S[a..b] inclusive. */
  // private void quickSortInPlace(ArrayList<Pair> S, Comparator<Integer> comp,int a, int b) {
  //   if (a >= b) return;                // subarray is trivially sorted
  //   int left = a;
  //   int right = b-1;
  //   int pivot = S.get(b);
  //   int temp;                            // temp object used for swapping
  //   while (left <= right) {
      
  //     // scan until reaching value equal or larger than pivot (or right marker)
  //     while (left <= right && comp.compare(S.get(left), pivot) < 0){
  //       left++;
  //       comparsions++;
  //     }
      
  //     // scan until reaching value equal or smaller than pivot (or left marker)
  //     while (left <= right && comp.compare(S.get(right), pivot) > 0){
  //       right--;
  //       comparsions++;
  //     }
      
  //     if (left <= right) {  // indices did not strictly cross
  //       // so swap values and shrink range
  //       temp = S.get(left); 
  //       S.add(left,S.get(right)); 
  //       S.add(right, temp);
  //       left++; right--;
  //       dataMoves += dataMoves + 2;
  //     }
  //   }//end while
  //   // put pivot into its final place (currently marked by left index)
  //   temp = S.get(left);
  //   S.add(left, S.get(b)); 
  //   S.add(b, temp);
  //   dataMoves = dataMoves +2;
  //   // make recursive calls
  //   quickSortInPlace(S, comp, a, left - 1);
  //   quickSortInPlace(S, comp, left + 1, b);
  // }
}