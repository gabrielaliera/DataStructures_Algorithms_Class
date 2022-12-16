/*  Java Class: Main
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
• display – display string and number of characters (including spaces and cursor)
Use > for the cursor. Set up a driver to create a TextEditor object, then use it to perform a few operations and then print the text. 
  Modify from book: I certify that the code below is my own work.
  Exception(s): IllegalStateException, NoSuchElementException from LinkedPositionalList
*/
class Main {
  public static void main(String[] args) {
    // 1. Create a TextEditor object with “HHello Word” (assume cursor at the end)
      TextEditor notepad = new TextEditor("HHello Word");
    //  2. Display current information (should be “HHello Word >” with 11 characters)
      notepad.display();
    //  3. Move cursor right
      notepad.right();
    //  4. Move cursor left
      notepad.left();
      notepad.display();
  //   //  5. Insert ‘l’
      notepad.insert('l');
      notepad.display();
  //   //  6. Move cursor to position 0
      notepad.move(0);
      notepad.display();
  //   //  7. Delete current character
       notepad.delete();
  //   //  8. Display current information (should be “>Hello World” with 11 characters)
     notepad.display();
  //   System.out.println(notepad.current());
  }//end main
}//end Main class