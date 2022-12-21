
public class ShellSort {
   
  public double comparisons=0;
  public double dataMoves=0;

  public double getComparisons(){return comparisons;}
  public double getDataMoves(){return dataMoves;}
  public void resetComparisons(){comparisons = 0;}
  public void resetDataMoves(){dataMoves=0;}
  
    /* function to sort arr using shellSort */

 public int shellsort(Pair<Integer,String>[] arr) {
        
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        int n = arr.length;
          
        // Start with a big gap, then reduce the gap
        for (int gap : gaps)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                Pair temp = arr[i];
                int tempKey =  (int) temp.getK();
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap &&( (int) arr[j - gap].getK() > tempKey) ; j -= gap){
                    arr[j] = arr[j - gap];
                    dataMoves++;
                    comparisons++;
                }
                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
                dataMoves++;
            }
        }
        return 0;
    }
  
  public int shellsortS(Pair[] arr){
        
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

        int n = arr.length;
          
        // Start with a big gap, then reduce the gap
        for (int gap : gaps)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                Pair temp = arr[i];
                String tempKey =  (String) temp.getK();
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && (String.valueOf(arr[j - gap].getK()).compareTo(tempKey)) > 0 ; j -= gap){
                    arr[j] = arr[j - gap];
                    dataMoves++;
                    comparisons++;
                }
                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
               comparisons++;
            }
        }
        return 0;
    }
 
  }

/*This code is contributed by Rajat Mishra */