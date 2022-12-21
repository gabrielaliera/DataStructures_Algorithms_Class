/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 12/02/2022
    Description: Given a large data file of positive integers up to 1 million values, your task is to quickly  determine if an input value x is in the file and there is also a value y in the file that  satisfies x + y = t. For the sake of simplicity, we will assume that the values in the file  are unique. You need to do this look up very efficiently in O(1) so a hash map is needed.  Design a solution that uses a hash map to solve this problem. Hint: input values and  store them in a hash map first. Here are two test cases to help you with this problem: 
Input file: large100k.txt from project 2 (unique values from 1  to 100000) 
Input x: 5<Enter> 
Input t: 100<Enter> 
Yes 
Input x: 5<Enter> 
Input t: 10000000<Enter> 
No 
I certify the code below is my own: Main
    Exception(s): Main
*/
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
import java.util.ArrayList;//check if reading file is correct

class Main {
  
  static ArrayList<Integer> data = new ArrayList<>();
  static HashMap<Integer,Integer> map = new HashMap<>();
  
  //Read file to ArrayList<String> data
  public static void readFile(String fileName){

    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
    
      while (scan.hasNextLine()) {   //Read file
        int num = scan.nextInt();  //Scan file
        data.add(num);
        map.put(num,num);
        
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  //Print for debugging 
  public static void print(){
    for(int num : data){
      System.out.println(num);
    }
  }
  
  public static void main(String[] args) {

    readFile("small1k.txt");
    //readFile("large100k.txt");
    //print();

    
    //Get user input
    Scanner scan = new Scanner(System.in);

    System.out.print("Input x: ");
    int x = scan.nextInt();
   
    System.out.print("Input t: ");
    int t = scan.nextInt();
  
    //Calculate y
    int y = t - x;
  
    //Check if y exist using hashmap
    if(map.containsKey(y)){
        System.out.println("Yes");
        System.out.println(map.get(y));
    } else {
       System.out.println("No");
    }
    
    //System.out.println("Hello world!");
  }
}