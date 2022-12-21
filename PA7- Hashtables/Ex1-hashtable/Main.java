/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/12/2022
    Description: –  Use C++ language STL map or Java language HashMap to store the following integer keys: 13 21 5 37 15 (use they key as a string for the value part so first entry would be <13, "13">). Perform the following operations to make sure it is working properly: search for 10 and 21, remove 20, 37, and then search for 37. 

Input data file small1k.txt, containing a list of 1,000 integer values and insert all the pairs <int, key as string> to a new hash map. Collect the time it took to insert 1,000 pairs of values to the hash map and output the time to the screen.

Input data file large100k.txt, containing a list of 100,000 integer values and insert all the pairs <int, key as string> to another new hash map. Collect the time it took to insert 100,000 pairs of values to the hash map and output the time to the screen.

    I certify the code below is my own: Main, 
    Exception(s):
*/
import java.util.HashMap;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


class Main {


  public static void runtime_HashMap(String fileName,int size){
   HashMap<Integer,String> map = new HashMap<Integer,String>();
    
    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
      int[] holder = new int[size];  //Create array to hold value from file
      
      int count = 0;                //Holds index value for array
      while (scan.hasNextInt()) {   //Read file
        int data = scan.nextInt();  //Scan file for integer
        holder[count] = data;       //Insert value into holder array
        count++;
      }
      scan.close();
      
      double start = System.currentTimeMillis(); //Start time
      for(int i=0;i<holder.length;i++){
        map.put(holder[i],String.valueOf(holder[i])); //Insert value into map
      } 
      double finish = System.currentTimeMillis(); //End time

      double time = finish -start;                //Calculate time and print 
      System.out.printf("\nRuntime: "+fileName+ " %.3f ms \n", time);      
      
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  
  }
  public static void main(String[] args) {
    HashMap<Integer,String> map = new HashMap<Integer,String>();
    map.put(13,"13");
    map.put(21,"21");
    map.put(5,"5");
    map.put(37,"37");
    map.put(15,"15");
    System.out.println(map.get(10));
    System.out.println(map.get(21));
    map.remove(20);
    map.remove(37);
    System.out.println(map.get(37));

    //Testcase 1
    runtime_HashMap("small1k.txt",1000);

    //Testcase 2
    runtime_HashMap("large100k.txt",100000);
  }
}