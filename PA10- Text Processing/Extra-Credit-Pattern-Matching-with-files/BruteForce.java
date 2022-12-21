public class BruteForce{

  public long comparisons=0;
  public long dataMoves=0;

  public long getComparisons(){  
    return comparisons;
  }
  public long getDataMoves(){return dataMoves;}
  public void resetComparisons(){comparisons = 0;}
  public void resetDataMoves(){dataMoves=0;}

  public int match(String text, String pattern){
    
    char[] T = text.toCharArray();
    char[] P = pattern.toCharArray();
    int n = T.length;
    int m = P.length;
   
    for(int i=0;i<=n-m;i++){
      int j = 0;
      comparisons++;
    
      while(j < m && T[i+j] == P[j]){
        j++;
        comparisons++;   
      }
        
      if(j == m){
        System.out.println("Match found at index "+ i);
        return i;
      } 
      
    }
    System.out.println("No Match");
    return -1;
  }
  
}