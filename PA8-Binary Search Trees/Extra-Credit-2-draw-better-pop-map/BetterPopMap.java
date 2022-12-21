/*  Java Class: BetterPopMap
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/21/2022
    Description: – Using a AVL TreeMap, this class reads the input file and insert country code as key and population/city/state as value. Methods include find, insert, erase, print.
    Implementation of AVLTreeMap is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own.
    Exception(s):
*/
import java.util.Iterator;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.lang.Iterable;
import java.util.Iterator;
import java.util.ArrayList;

public class BetterPopMap{

  private AVLTreeMap<Integer,String> tree= new AVLTreeMap<Integer,String>();
  private String fileName;

  BetterPopMap(String filename){
    this.fileName = filename;
    createAVL(fileName);
  }

  //print appropriate message and data if found
  public void find(int code){
    String value =tree.get(code);
    if (value != null){
      System.out.println("\nFound: Country Code: "+ code + " Population, City, State: "+ value.substring(1));
    } else{
      System.out.println("\nNot Found: County Code "+ code);
    }
    
  }

  // //print appropriate message and insert node if not found
  // //replace data if found
  public void insert(int code, int pop, String country){
    String value = ","+String.valueOf(pop) + ",\""+country+"\"";

    String insertValue = tree.put(code,value);

    if (insertValue == null){
      System.out.println("\nInsert New Country Code: "+ code + " Population, City, State: "+ value.substring(1));
    } else{
      System.out.println("\nReplaced Old Info: "+ insertValue.substring(1) + " New Info: "+ value.substring(1));
    }  
  }

  // //print appropriate message and erase node if found
   public void erase(int code){
      String value = tree.remove(code);
      if (value != null){
        System.out.println("\nRemoved Country Code: "+ code + " Population, City, State: "+ value.substring(1));
      } else{
        System.out.println("\nNo Removal: County Code "+code+ " information not found.");
      }     
   }

  //print one record per line using in-order traversal
  //include height of each node
  public void print(){
    Iterable<Position<Entry<Integer,String>>> set = tree.entryPositionSet();    
    int counter= 1;
    for(Position<Entry<Integer,String>> Node: set){
      System.out.println("\nNode "+counter+ ": "+ Node.getElement() + " \n        Height: "
                         + tree.height(Node));
      counter++;
    }
   
  }

  private TreeMap<Integer,String> createAVL(String fileName){
   
    try{
      File myObj = new File(fileName);     
      Scanner doc2 = new Scanner(myObj).useDelimiter(",");
      doc2.nextLine();
    
      while (doc2.hasNextLine()) {   //Read file
        int countryCode = doc2.nextInt();
        String str = doc2.nextLine();  //Scan file for integer
        //System.out.println(word);
        tree.put(countryCode,str);       
      }
      doc2.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
   
    return tree;
  }

  public void draw(){
    tree.printPreorder(tree.root(),1);   
  }
  
}