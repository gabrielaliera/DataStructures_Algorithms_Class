/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/10/2022
    Description: Modify exercise 2 to accept text (T) from an input data file and pattern (P) from the keyboard. Try the test cases below. Do results seem reasonable?

Explain.
1. T: US declaration file from a previous PA, P: “computer”, P: “magnanimity”
2. T: humanDNA.txt file on Canvas, P: “CAAATGGCCTG”, and P: “CAAATGGGCCTG”

    Implementation of alogrithms are modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
class Main {

  public static String getText(String fileName){
    
    String text = "";    
    try{
      File myObj = new File(fileName);
      Scanner doc = new Scanner(myObj).useDelimiter("[^a-zA-Z]+");
      
      while (doc.hasNext()) {   //Read file
        String word = doc.next();
        text = text + word;
      }
      doc.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return text;
  }
  public static void main(String[] args) {
    
    //Sorting objects
    BruteForce bf = new BruteForce();
    BoyerMoore bm = new BoyerMoore(); 
    KMP km = new KMP();
    
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter fileName: ");
    String fileName = scan.nextLine();
    String T = getText(fileName);
    
    System.out.print("Enter pattern: ");
    String P1 = scan.nextLine();

    System.out.print("Enter pattern: ");
    String P2 = scan.nextLine();

    System.out.print("Enter fileName2: ");
    String fileName2 = scan.nextLine();
    String T2 = getText(fileName2);
    
    System.out.print("Enter pattern: ");
    String P3 = scan.nextLine();

    System.out.print("Enter pattern: ");
    String P4 = scan.nextLine();

    System.out.println("\n*****  Brute Force Alogrithm  ******");
    System.out.println("\nTEXT: "+fileName +" \nPATTERN: "+ P1);
    bf.match(T,P1);
    System.out.println("Comparisons: "+ bf.getComparisons());
    bf.resetComparisons();

    System.out.println("\nTEXT: "+fileName +" \nPATTERN: "+ P2);
    bf.match(T,P2);
    System.out.println("Comparisons: "+ bf.getComparisons());
    bf.resetComparisons();

   System.out.println("\nTEXT: "+fileName2 +" \nPATTERN: "+ P3);
    bf.match(T2,P3);
    System.out.println("Comparisons: "+ bf.getComparisons());
    bf.resetComparisons();

    System.out.println("\nTEXT: "+fileName2 +" \nPATTERN: "+ P4);
    bf.match(T2,P4);
    System.out.println("Comparisons: "+ bf.getComparisons());
    bf.resetComparisons();

    //BoyerMoor Algo
    System.out.println("\n*****  BoyerMoore Algorithm  *****");
    System.out.println("\nTEXT: "+fileName +" \nPATTERN: "+ P1);
    bm.match(T,P1);
    System.out.println("Comparisons: "+ bm.getComparisons());
    bm.resetComparisons();

    System.out.println("\nTEXT: "+fileName +" \nPATTERN: "+ P2);
    bm.match(T,P2);
    System.out.println("Comparisons: "+ bm.getComparisons());
    bm.resetComparisons();

    System.out.println("\nTEXT: "+fileName2 +" \nPATTERN: "+ P3);
    bm.match(T2,P3);
    System.out.println("Comparisons: "+ bm.getComparisons());
    bm.resetComparisons();

    System.out.println("\nTEXT: "+fileName2 +" \nPATTERN: "+ P4);
    bm.match(T2,P4);
    System.out.println("Comparisons: "+ bm.getComparisons());
    bm.resetComparisons();


    //BoyerMoor Algo
    System.out.println("\n***** KMP Algorithm *****");
    System.out.println("\nTEXT: "+fileName +" \nPATTERN: "+ P1);
    km.match(T,P1);
    System.out.println("Comparisons: "+ km.getComparisons());
    km.resetComparisons();

    System.out.println("\nTEXT: "+fileName +" \nPATTERN: "+ P2);
    km.match(T,P2);
    System.out.println("Comparisons: "+ km.getComparisons());
    km.resetComparisons();

    System.out.println("\nTEXT: "+fileName2 +" \nPATTERN: "+ P3);
    km.match(T2,P3);usa.t
    System.out.println("Comparisons: "+ km.getComparisons());
    km.resetComparisons();

    System.out.println("\nTEXT: "+fileName2 +" \nPATTERN: "+ P4);
    km.match(T2,P4);
    System.out.println("Comparisons: "+ km.getComparisons());
    km.resetComparisons();
  
  }
}