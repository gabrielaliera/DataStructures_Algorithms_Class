/*  Java Class: PopMap
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/21/2022
    Description: – Using AVL TreeMap, this class read input file and insert country code as key and population/city/state as value. Also include public methods- find,search,insert,print
    Implementation of AVLTreeMap is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own
    Exception(s):
*/
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.lang.Iterable;
import java.util.Iterator;

public class PopMap{

  private TreeMap<Integer,String> tree= new TreeMap<Integer,String>();
  private String fileName;

  //Constructor
  PopMap(String filename){
    this.fileName = filename;
    createBST(fileName);
  }

  //Private Methods
   private TreeMap<Integer,String> createBST(String fileName){
          
    try{
      File myObj = new File(fileName);     
      Scanner doc2 = new Scanner(myObj).useDelimiter(",");
      doc2.nextLine();
    
      while (doc2.hasNextLine()) {   //Read file
        int countryCode = doc2.nextInt();
        String str = doc2.nextLine();  //Scan file for integer
        tree.put(countryCode,str);       
      }
      doc2.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
   
    return tree;
  }

  //Public Methods- find, insert,erase,print
  
  //print appropriate message and data if found
  public void find(int code){
    String value =tree.get(code);
    if (value != null){
      System.out.println("\nFound: Country Code: "+ code + " Population, City, State: "+ value.substring(1));
    } else{
      System.out.println("\nNot Found: County Code "+ code);
    }

    System.out.println("Nodes Exammined: "+ tree.getNodeExamined());
    
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
  public void print(){
    Iterable<Entry<Integer,String>> iter = tree.entrySet();
    Iterator<Entry<Integer,String>> printIter = iter.iterator();
    int counter = 1;
    while(printIter.hasNext()){
      System.out.println(counter+ " "+ printIter.next()+ " ");
      counter++;
    }
  }  
}