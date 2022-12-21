import java.util.HashMap;
import java.util.Map;

public class BoyerMoore{

  public long comparisons=0;
  public long getComparisons(){return comparisons;}
  public void resetComparisons(){comparisons = 0;}
  //BoyerMoore Algo
  public int match(String T, String P) {
    
    char[] text = T.toCharArray();
    char[] pattern = P.toCharArray();
    int n = text.length;
    int m = pattern.length;
    
    if (m == 0) return 0;   // trivial search for empty string
    
    Map<Character,Integer> last = new HashMap<>(); //'last' map
    for (int i=0; i < n; i++)
      last.put(text[i], -1);   // set -1 as default for all text characters
    for (int k=0; k < m; k++)
      last.put(pattern[k], k);// rightmost occurrence in pattern is last
    
    // start with the end of the pattern aligned at index m-1 of the text
    int i = m-1;             // an index into the text
    int k = m-1;            // an index into the pattern
    while (i < n) {
      comparisons++;
      if (text[i] == pattern[k]) {      // a matching character
        if (k == 0){ 
          System.out.println("Match found at index: "+ i);
          return i;    // entire pattern has been found
        }
        i--;                   // otherwise, examine previous
        k--;                  // characters of text/pattern
      } else {
        i += m - Math.min(k, 1 + last.get(text[i])); // case analysis for jump step
        k = m - 1;   // restart at end of pattern
      }
    }
    System.out.println("No Match");
    return -1;                    // pattern was never found
  }
}