import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class NextFit{

  int startIndex = 0;
  int[] memory;
  int usedMemory = 0;
  int availMemory =0;
  boolean isAvailable = true;
  int lastIndex = 0;

  Queue<Integer> blocks = new LinkedList<>();
  Queue<Pair<Integer,Integer>> blockIndex = new LinkedList<>();

  public NextFit(int[] m){
    this.memory = m;
  }
  
  public int allocationSize(){
    Random rand = new Random();
    return rand.nextInt(16) + 5;
  }

  public void resetMemory(){
    for(int i=0;i<memory.length;i++){
      memory[i] = -1;
    }
  }

  public int remainingMemory(int[] memory){
    int counter =0;
    for(int i=0;i<memory.length;i++){
      if(memory[i] == -1){
        counter++;
      }
    }
    return counter;
  }
  
  public void nextfit(){
    resetMemory();
    int half = memory.length/2;
   
    while(usedMemory <= half && isAvailable){
      allocation();
      allocation();
      deallocation();
    }
    //step allocation until cant 
    while(isAvailable){
      allocation();
    }
    
    //e) Tally up all available blocks to see how many blocks are still available and how much memory available
    int avalBlocks = findAvailableBlocks();
    System.out.println("Available Blocks: " +avalBlocks);
    System.out.println("Available Memory: " + availMemory);
  }
  public int findstartIndex(int allocationSize){ // error
   
    int slow = lastIndex; // 
    int index  = lastIndex;
    int fast = allocationSize -1;
    int start = fast;
    
    while( slow < fast){
      if(memory[fast] == -1){
        fast--;
      } else{
      
        slow = fast +1;
        fast = slow + allocationSize;
        index = slow;
      }
    }
    if(fast == memory.length -1){ //didnt find space
      return -1;
    }
    
    lastIndex = index + allocationSize;
    if(lastIndex >= 1024){  //checks memory in cycle 
      lastIndex = 0;
      findstartIndex(allocationSize);
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
    
      if(startIndex != -1 && lastIndex < 1024){
        for(int i=startIndex;i<lastIndex;i++){
          memory[i] = 0; 
        }
        usedMemory = usedMemory + size;
      } else{
        isAvailable = false;
      }
    }
  }

  public void deallocation(){ // Deallocate from start?
  
    int size = blocks.remove();
  
    Pair<Integer,Integer> index = blockIndex.remove();
    
    int start = index.getStartIndex();
    int end = index.getEndIndex();
   
    for(int i = start; i < end;i++){
      memory[i] = -1;
    }

    usedMemory = usedMemory - size;
  }

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
