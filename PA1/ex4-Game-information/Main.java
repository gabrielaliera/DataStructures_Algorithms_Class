/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/26/2022
    Description: Each game entry (GameEntry) consists of a player name, a score (0 to 1000), and a date (mm/dd/yyyy). Include appropriate constructor(s), setters, and getters for class GameEntry. Do validate scores (set to 0 for an invalid score), but you can assume that dates are valid.
The game scores (GameScore) hold the name of the game and a list of up to 10 scores by using a list of game entries (a current list might have fewer than 10 entries, but no more than 10 entries). A new game entry can be added if applicable. A complete list of scores can be printed upon request (always from highest to lowest). In addition to appropriate constructor(s), setters, and getters, this class must support the following public operations: add(entry) and print().
    I certify that the code below is my own work.
Exception(s): N/A
*/

import java.time.LocalDate;

class Main {
  public static void main(String[] args) {

    GameScore g1 = new GameScore("Classic Pac-Man");
    GameScore g2 = new GameScore("Wordle");
    GameScore g3 = new GameScore();
   
    GameEntry e1 = new GameEntry("Jill",980,LocalDate.of(2021,8,18));
    GameEntry e2 = new GameEntry("Jack",600,LocalDate.of(2021,8,17));
    GameEntry e3 = new GameEntry("Rob",875,LocalDate.of(2021,7,30));
    GameEntry e4 = new GameEntry("Dan",-100,LocalDate.of(2021,8,2));
    GameEntry e5 = new GameEntry("Gaby",0,LocalDate.of(2022,8,25));
    GameEntry e6 = new GameEntry("Fall",1,LocalDate.of(2022,7,12));
    GameEntry e7 = new GameEntry("Summer",1000,LocalDate.of(1999,8,25));
    GameEntry e8 = new GameEntry("John",1001,LocalDate.of(2022,5,15));
    GameEntry e9 = new GameEntry("Tom",-1,LocalDate.of(2020,1,1));
    GameEntry e10 = new GameEntry("Tyler",999,LocalDate.of(1999,2,23));
    GameEntry e11= new GameEntry("Extra1",200,LocalDate.of(2022,05,5));
    GameEntry e12= new GameEntry("Extra2",200,LocalDate.of(2022,5,5));
    
    GameEntry f1 = new GameEntry("Kira",1980,LocalDate.of(2021,8,18));
    GameEntry f2 = new GameEntry("Sarah",0,LocalDate.of(2021,8,17));
    GameEntry f3 = new GameEntry("Jessica",10,LocalDate.of(2021,7,30));
    GameEntry f4 = new GameEntry("Tyler",875,LocalDate.of(2021,8,2));
    GameEntry f5 = new GameEntry("Robert",875,LocalDate.of(2022,8,25));
    
    g1.add(e1);
    g1.add(e2);
    g1.add(e3);
    g1.add(e4);
    g1.add(e5);
    g1.add(e6);
    g1.add(e7);
    g1.add(e8);
    g1.add(e9);
    g1.add(e10);
    g1.add(e11); //extra entries to test if pushes down lower score out of top ten 
    g1.add(e12);

    g2.add(f1);
    g2.add(f2);
    g2.add(f3);
    g2.add(f4);
    g2.add(f5);

    g1.print();
    g2.print();
    g3.print();
    
    //Test for getGameName() and setGameName()
    System.out.println("Current game names: 1) " + g1.getGameName() + " 2) " + g2.getGameName()+"\n");
    g1.setGameName("Pac-Man Ultra");
    System.out.println("Updated game names: 1) " + g1.getGameName() + " 2) " + g2.getGameName()+"\n");
    
    //Test for getNumEntires() and setNumEntries() 
    System.out.println("Current number of entries: 1) " + g1.getNumEntries() + " 2) " + g2.getNumEntries()+"\n");
    g2.setNumEntries(3);
    System.out.println("Updated number of entries: 1) " + g1.getNumEntries() + " 2) " + g2.getNumEntries()+"\n");

    //Test for getPlayerName(), setPlayerName(), getScore(), setScore(), getDate(), setDate()
    System.out.println("e1 info: " + e1.getPlayerName() + " " + e1.getScore() + " " + e1.getDate()+"\n");
    e1.setPlayerName("NewName"); e1.setDate(LocalDate.of(1900,1,1)); e1.setScore(500);
    System.out.println("e1 updated info: " + e1.getPlayerName() + " " + e1.getScore() + " " + e1.getDate() +"\n");
    
    System.out.println("Updated Game1: \n");
    g1.print();
  }//end of main
}