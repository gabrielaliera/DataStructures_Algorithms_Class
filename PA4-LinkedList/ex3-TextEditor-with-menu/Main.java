import java.util.Scanner;

/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/24/2022
    Description: –Use a menu to perform various operations and you can submit
this final version in lieu of exercise 3.

  Modify from book: Position, PsotionalList, LinkedPositional Link 
  I certify that the code below is my own work.
  Exception(s): IllegalStateException, NoSuchElementException from LinkedPositionalList
*/
class Main {
  public static void main(String[] args) {
   
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a starting string: ");

    String userInput = scan.nextLine();
    int menuInput =-1;

     //Create a TextEditor object with “HHello Word” (assume cursor at the end)
    TextEditor notepad = new TextEditor(userInput);
    
    System.out.println("Editing document ...");
    System.out.println("    Editing Menu");
    System.out.println("1.Left");
    System.out.println("2.Right");
    System.out.println("3.Insert character");
    System.out.println("4.Delete character");
    System.out.println("5.Get current position");
    System.out.println("6.Move to position");
    System.out.println("7.Display");
    System.out.println("8.Quit");

    while (menuInput != 8){
      System.out.print("\nEnter an option: ");
      menuInput = scan.nextInt();
      switch (menuInput){
        case 1: //Left
          notepad.left();
          break;
        case 2:  //Right
          notepad.right();
          break;
        case 3: //Insert
          System.out.print("Enter a character: ");
          char c = scan.next().charAt(0);
          notepad.insert(c);
          System.out.println("Inserted character "+ c);
          break;
        case 4: //Delete
          notepad.delete();
          System.out.println("Deleted one character.");
          break;
        case 5://Current Position
          int position = notepad.getSpot();
          System.out.println("Current position: " + position);
          break;
        case 6: //Move
          System.out.print("Enter a position: ");
          int i = scan.nextInt();
          notepad.move(i);
          System.out.println("Moved to position: "+ i);
          break;
        case 7://Display
          System.out.print("String: \"");
          notepad.display();
          System.out.print("\"");
          System.out.println("\nLength: "+ notepad.size());
          break;
        case 8: //Exit
          System.out.println("Thank for using my ediotr program.");
          break;
      }
    }
  }//end main
}//end Main class