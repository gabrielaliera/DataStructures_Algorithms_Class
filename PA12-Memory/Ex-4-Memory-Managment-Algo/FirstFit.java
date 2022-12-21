import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class FirstFit{

  
  int[] memory;
  int startIndex = 0;
  int usedMemory = 0;
  int availMemory =0;
  boolean isAvailable = true;

  Queue<Integer> blocks = new LinkedList<>();
  Queue<Pair<Integer,Integer>> blockIndex = new LinkedList<>();

  public FirstFit(int[] m){
    this.memory = m;
  }

  //For step b
  public int allocationSize(){
    Random rand = new Random();
    return rand.nextInt(16) + 5;
  }

  //Makes entire memory empty
  public void resetMemory(){
    for(int i=0;i<memory.length;i++){
      memory[i] = -1;
    }
  }

  
  public void firstfit(){
    resetMemory();

    int half = memory.length/2;
    
    //Step C 
    while(usedMemory <= half && isAvailable){
      allocation();
      allocation();
      deallocation();
    }
    //step allocation until cant 
    while(isAvailable){
      allocation();
    }
    
    //Step E: Tally up all available blocks (small blocks not being used)
    //to see how many blocks are still available and how much memory available
    int avalBlocks = findAvailableBlocks();
    System.out.println("Available Blocks: " +avalBlocks);
    System.out.println("Available Memory: " + availMemory);
  }

  //Uses two pointer to find start index of next avaiable block
  //Fast pointer searches from right to left
  //if fast pointer hits index which contains is filled
  //shift windown to that index and continue
  public int findstartIndex(int allocationSize){ 

    int index  = 0;
    int fast = allocationSize -1;
    int start = fast;
    int slow = 0; // 
    while( slow < fast && fast< 1024){
      if(memory[fast] == -1){
        fast--;
      } else{
      
        slow = fast +1;
        fast = slow + allocationSize;
        index = slow;
      }
    }
   
    if(index + allocationSize >= 1024 ){ //didnt find space
      return -1;
    }
    
    return index;
  }

  public void allocation(){
    int size = allocationSize();
    if(usedMemory+ size > 1024){
      isAvailable = false;
    } else{
  
      blocks.add(size);
      startIndex = findstartIndex(size);
      
      Pair position = new Pair<>(startIndex, startIndex+size);
      blockIndex.add(position);
  
      if(startIndex != -1){
        for(int i=startIndex;i<size+startIndex;i++){
          memory[i] = 0; 
        }
        usedMemory = usedMemory + size;
      } else{
        isAvailable = false;
      }
    }
  }

  //Deallocation is FIFO
  public void deallocation(){ 

    int size = blocks.remove(); 
    Pair<Integer,Integer> index = blockIndex.remove();
    
    int start = index.getStartIndex();
    int end = index.getEndIndex();
   
    for(int i = start; i < end;i++){
      memory[i] = -1;
    }

    usedMemory = usedMemory - size;
  }

  //For step e: finds leftover blocks and leftover memory
  public int findAvailableBlocks(){
    int count = 0;
    for(int i = 0; i < 1024;i++){
      if(memory[i]== -1){
        int j = i;
        while( j < 1024 && memory[j] == -1) {
          availMemory++;
          j++;
        }
        i  = j;
        count++;
      }
    }
    return count;
  } 
  
}