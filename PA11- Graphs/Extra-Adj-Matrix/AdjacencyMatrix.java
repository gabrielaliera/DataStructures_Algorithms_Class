public class AdjacencyMatrix{

  private int matrix[][];
  private int numVertices;
  private int counter = 0;

  public AdjacencyMatrix(int num){
    this.numVertices = num;
    matrix = new int[num][num];
  }

  public void insertEdge(int a, int b){
    matrix[a][b] = 1;
    matrix[b][a] = 1;  
  }

  public void removeEdge(int a, int b){
     matrix[a][b] = 0;
     matrix[a][b] = 0;
  }

  public int insertVertex(){
    int oldcounter = counter;
    counter++;
    return oldcounter;
  }

  public void print(){
    for(int i=0; i< numVertices;i++){
      System.out.println();
      for(int j=0; j< numVertices;j++){
        System.out.printf("%-7s", matrix[i][j]);
      }
    }
  }
}  