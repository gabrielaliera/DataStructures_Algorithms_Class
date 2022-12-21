public class InsertionSort {

  public int comparisons;
  public int dataMoves;
  
  public InsertionSort() {
  }
/** Insertion-sort of an array into nondecreasing order */
  public void insertionSort(int[] data) {

    //Reset values 
    comparisons = 0;
    dataMoves=0;    
    
    //Start Timer
    double start = System.currentTimeMillis(); 
    
    //Start of insertion sort alogirithm
    int n = data.length;
    for (int k = 1; k < n; k++) { // begin with second value
      int cur = data[k];        // time to insert cur=data[k]
      dataMoves++;
      int j = k;                 // find correct index j for cur
      while (j > 0 && data[j-1] > cur) {//thus,data[j-1] must go after cur
        data[j] = data[j-1];   // slide data[j-1] rightward
        j--;                   // and consider previous j for cur
        dataMoves++;
        comparisons++;
      }
      data[j] = cur;  // this is the proper place for cur
      dataMoves++;
    }

    //Finish Timer and Outputs
    double finish = System.currentTimeMillis(); //End time
    double time = finish -start;                //Calculate time and print 
    System.out.printf("\nSorting Runtime: %.3f ms \n", time);
    System.out.println("Data Moves: "+ dataMoves);
    System.out.println("Comparisons: "+ comparisons); 
  }
}