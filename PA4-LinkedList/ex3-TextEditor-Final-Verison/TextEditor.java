/*  Java Class: TextEditor
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/24/2022
    Description: –Set up TextEditor class, which can be used to store, edit, and display a string of characters using a List from exercise 2. The editor (TextEditor class) must support the following operations:
• left – move cursor left one character (do nothing if at beginning).
• right – move cursor right one character (do nothing if at the end).
• insert – insert the character c just before the cursor.
• delete – delete the character just at the cursor (if not at end).
• current – provide current position i of the cursor (0 <= i <= n – 1)
• move – move to position i if i is a valid position (0 <= i <= n – 1)
• display – display string and number of characters (including spaces and cursor
    Exception(s):
*/
import java.util.Iterator;
import java.lang.Iterable;

public class TextEditor{

  //Instance variables
  private LinkedPositionalList<Character> list = new LinkedPositionalList<>();
  private Position<Character> cursorPosition = list.last(); //Hold cursor position
  private char myCursorChar = '>'; //Holds cursor character for display()
  private int spot = 0; //Holds cursor postiion in integer for display()
  
  //Constructor
  TextEditor(String s){
    char[] charArray = s.toCharArray(); //Add string character to linkedPositionalList
    for(char c : charArray){
      list.addLast(c);
    }
    setCursor(); // Sets cursor to end of list
  }
  //PRIVATE OPERATIONS
  private void setCursor(){  //Sets initial cursor position
    Iterable<Position<Character>> posIter = list.positions();  //Create position iterator
    Iterator<Position<Character>> myCursor = posIter.iterator();   // Create cursor 
    
    while(myCursor.hasNext()){
      cursorPosition = myCursor.next();
      spot++;
    } 
  }  
  
  //PUBLIC OPERATIONS
  public int getSpot(){
    return spot;
  }
  public int size(){
    return list.size();
  }
  
  /**************************Left***************************************/
  /*****Move cursor left one character (do nothing if at beginning).****/
  public void left(){
    if (cursorPosition == list.first()){
      return;
    } else{
      cursorPosition = list.before(cursorPosition);
      spot--;
    }
  }
/**************************Right***************************************/
/******Move cursor right one character (do nothing if at the end).****/
  public void right(){
    if (cursorPosition == list.last()){
      return;
    } else{
      cursorPosition = list.after(cursorPosition);
      spot++;
    }
  }
/**************************Insert***************************************/
/******Insert the character c just before the cursor.*******************/
  public void insert(char c){
    cursorPosition = list.addAfter(cursorPosition, c);    
  }
/**************************Delete***************************************/
/******Delete the character just at the cursor (if not at end)**********/
  public void delete(){
    if (cursorPosition == list.last()){
      return;
    } else{
      
      Position<Character> temp = cursorPosition;
      
      cursorPosition = list.after(cursorPosition);
      list.remove(temp);
      
      if (getSpot() == 0){
        return;
      }else{
        spot--;
      }
    }
  }
/**************************Current***************************************/
/******Provide current position i of the cursor (0 <= i <= n – 1)**********/
  public Position<Character> current(){
    
    Iterable<Position<Character>> posIter = list.positions();  //Create position iterator
    Iterator<Position<Character>> tempCursor = posIter.iterator();   // Create cursor 

    Position<Character> position = list.first();
    
    int count = 0;
    while(tempCursor.hasNext()){
      position = tempCursor.next();
      count++;
      if(count == spot){
        break;
      }
    }
    
    cursorPosition = position; //Reset cursorPosition
    return position;
  }
/**************************Move***************************************/
/*****Move to position i if i is a valid position (0 <= i <= n – 1)***/
  public void move(int i){
    Iterable<Position<Character>> posIter = list.positions();  //Create position iterator
    Iterator<Position<Character>> tempCursorIter = posIter.iterator();   // Create cursor 
    
    if((i < 0) || (i > list.size() -1)){ 
      System.out.println("Position for move in invalid");
      return;
    }
    
    spot = i;
    
    int count = 0;
    Position<Character> tempCursor = list.first();

    if(i ==0){
      cursorPosition = list.first();
      return;
    }
    
    while(tempCursorIter.hasNext()){
        tempCursor = tempCursorIter.next();
        count++;
        if (count == i){
          cursorPosition = tempCursor;
        }    
    } 
  }
/**************************Display******************************************/
/***Display string and number of characters (including spaces and cursor)***/
  public void display(){
    
    Iterable<Position<Character>> Iter = list.positions();
    Iterator<Position<Character>> printIter= Iter.iterator();
    
    if(spot ==0){
      System.out.print(myCursorChar);
    }
    
    int count =0;
    while(printIter.hasNext()){

      char c = printIter.next().getElement();
      count++;
      
      if(count == spot){
        System.out.print(c);
        System.out.print(myCursorChar);
      } else{   
        System.out.print(c);
      } 
    }//end while 
    System.out.println();
  
  }//end display 
} //end of TextEditor