import java.time.*;

public class GameEntryS{

  private String playerName;
  private int score;
  //private LocalDate date;
  private String date;
  
  
  /*********************Constructors**********************/
  GameEntryS(){
    this.playerName ="";
    this.score = 0;
    //this.date = new LocalDate.now();
    this.date = "08/24/2022";
  }

  GameEntryS(String s, int n, String d){
    this.playerName = s;
    this.score = n;
    this.date = d;
    System.out.println("GameEntry created: "+ playerName +score+date);
  }
  
  /*********************Setters**********************/
  public void setName(String s){this.playerName = s;}
  public void setDate(String d){this.date = d;}
  public void setScore(int n){
    if (n >= 0){
      this.score = n;
    } else {
      System.out.println("Valid score: Score was set to 0");
      this.score = 0;
    }
  }
  
  /*********************Getters**********************/
  public String getPlayerName(){return playerName;}
  public int getScore(){return score;}
  public String getDate(){return date;}
}