/*  Java Class: GameScore
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/26/2022
    Description: Each game entry (GameEntry) consists of a player name, a score (0 to 1000), and a date (mm/dd/yyyy). Include appropriate constructor(s), setters, and getters for class GameEntry. Do validate scores (set to 0 for an invalid score), but you can assume that dates are valid.
The game scores (GameScore) hold the name of the game and a list of up to 10 scores by using a list of game entries (a current list might have fewer than 10 entries, but no more than 10 entries). A new game entry can be added if applicable. A complete list of scores can be printed upon request (always from highest to lowest). In addition to appropriate constructor(s), setters, and getters, this class must support the following public operations: add(entry) and print().
    I certify that the code below is my own work.
Exception(s): N/A
*/
class GameScore{

  private String gameName;
  private int numEntries = 0;
  private GameEntry[] board;
  final int MAX_CAPACITY = 10;

  
  /*********************Constructors**********************/
  GameScore(){
    this.gameName = "defaultName";
    this.numEntries = 0;
    this.board = new GameEntry[MAX_CAPACITY];
  }
  
  GameScore(String s){
    this.gameName = s;
    this.numEntries= 0;
    this.board = new GameEntry[MAX_CAPACITY];
  }

  /*********************Setters**********************/
  public void setGameName(String s){ this.gameName = s;}
  public void setNumEntries(int n){this.numEntries = n; }

  /********************Getters**********************/
  public String getGameName(){return gameName;}
  public int getNumEntries(){return numEntries;}
 
  /**********************add()**********************/
   public void add(GameEntry game){
    int newScore =game.getScore();

    if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
      if (numEntries < board.length)        // no score drops from the board
        numEntries++;                       // so overall number increases
      // shift any lower scores rightward to make room for the new entry
      int j = numEntries - 1;
      while (j > 0 && board[j-1].getScore() < newScore) {
        board[j] = board[j-1];              // shift entry from j-1 to j
        j--;                                // and decrement j
      }//end while
      board[j] = game;                         // when done, add new entry
    } 
    
  }
  /**********************print()**********************/
  public void print(){
    System.out.println("Name: "+ getGameName());
  
    if(getNumEntries() <= 0){
      System.out.println("  No Game Entries!");
    }
    
    int count = 1;
    for(int i=0;i < getNumEntries();i++){
      System.out.println(String.format("%2s %-10s %4s %13s",
                                       count,
                                       board[i].getPlayerName(),
                                       board[i].getScore(),
                                       board[i].getDate()));
      count++;
    }
  }
  
}