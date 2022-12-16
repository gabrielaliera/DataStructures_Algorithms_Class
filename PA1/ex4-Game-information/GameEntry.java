
/*  Java Class: GameEntry
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/26/2022
    Description: Each game entry (GameEntry) consists of a player name, a score (0 to 1000), and a date (mm/dd/yyyy). Include appropriate constructor(s), setters, and getters for class GameEntry. Do validate scores (set to 0 for an invalid score), but you can assume that dates are valid.
The game scores (GameScore) hold the name of the game and a list of up to 10 scores by using a list of game entries (a current list might have fewer than 10 entries, but no more than 10 entries). A new game entry can be added if applicable. A complete list of scores can be printed upon request (always from highest to lowest). In addition to appropriate constructor(s), setters, and getters, this class must support the following public operations: add(entry) and print().
    I certify that the code below is my own work.
Exception(s): N/A
*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GameEntry {

  private String playerName;
  private int score;
  private LocalDate date;

  /********************* Constructors **********************/
  GameEntry() {
    this.playerName = "";
    this.score = 0;
    this.date = LocalDate.now();
  }

  GameEntry(String s, int n, LocalDate d) {
    this.playerName = s;
    this.date = d;

    if (n >= 0 && n <= 1000) { // Validate score >= 0
      this.score = n;
    } else {
      System.out.println("Invalid score: " + s + "'s score was set to 0");
      this.score = 0;
    }

    System.out.println("GameEntry created: " + playerName + " " + score + " " + date);
  }

  /********************* Setters **********************/
  public void setPlayerName(String s) {
    this.playerName = s;
  }

  public void setDate(LocalDate d) {
    this.date = d;
  }

  public void setScore(int n) {
    if (n >= 0) {
      this.score = n;
    } else {
      System.out.println("Valid score: Score was set to 0");
      this.score = 0;
    }
  }

  /********************* Getters **********************/
  public String getPlayerName() {
    return playerName;
  }

  public int getScore() {
    return score;
  }

  public String getDate() { // Changed date to String in order to print as MM/dd/yyyy
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String text = date.format(formatter);

    return text;
  }
}