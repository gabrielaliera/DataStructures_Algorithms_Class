import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanTree{

//Public Variables and Accessor methods
public HashMap<Character,Integer> freqMap = new HashMap<>();
public HashMap<Character,Integer> getfreqMap(){return freqMap;}
  
public ArrayList<Character> distinct = new ArrayList<>();
public ArrayList<Character> getDistinct(){return distinct;}

public char[] charArray;
public char[] getcharArray(){return charArray;}

//Main HuffmanEncoding Method
public Entry<Integer,LinkedBinaryTree<Character>> HuffmanEncoding(String X){
  
  charArray = X.toCharArray(); //generate charArray from text
  distinctCharacter(X);          
  computureFrequencies(distinct,X);
  
  //Create PQ 
  HeapPriorityQueue<Integer,LinkedBinaryTree<Character>> pq = new HeapPriorityQueue<>();

  //Add freq and single character tree to pq for all distinct characters
  for(Character c : distinct){
    LinkedBinaryTree<Character> T = new LinkedBinaryTree<>();
    T.addRoot(c);
    pq.insert(freqMap.get(c),T);
  }
  //Reconstruct PQ
  while(pq.size()>1){
    int f1 = pq.min().getKey();
    LinkedBinaryTree<Character> t1 = pq.removeMin().getValue();
    
    int f2 = pq.min().getKey();
    LinkedBinaryTree<Character> t2 = pq.removeMin().getValue();
    
    LinkedBinaryTree<Character> T = new LinkedBinaryTree<>();
    T.addRoot(' ');
    T.attach(T.root(),t1,t2);
    
    pq.insert(f1+f2, T);
  }
  return pq.removeMin();
}

//Find all distinct characters of a given string and store in global arraylist distinct
  public void distinctCharacter(String X){
    for (char c : charArray) {
      if(!distinct.contains(c)){
        distinct.add(c);
      }
    }
  }
//Calcualates frequencies of distinct characters and stores in hashmap
  private void computureFrequencies(ArrayList<Character>C,String X){
    for(char c: charArray){
      if(!freqMap.containsKey(c)){
        freqMap.put(c,1);
      }else{
        freqMap.put(c, freqMap.get(c)+1);
      }
    }
  }
}