/*  Java Class: Main Driver w/ loaf factor

    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/12/2022
    Description: – Create a program to collect some data about chain hashing that you worked on in exercise 2. You would be able to enter the name of input data file and a load factor. Each input data file will have N records and the first value in the file will tell you how many records are in the file. You would need to use N and the load factor to determine the initial size of the hash table. The first value of each record will be the key (county/state code as integer type) and remaining items on each record will be the value (population and county/state and you can treat it as one string). After all the entries are inserted to the table, print the table size, average number of probes, and  maximum number of probes for the worst case. It would take at least one probe for each insertion (checking initial location). Therefore, it would be two probes if second location is examined.

After confirming that your implementation works reasonably well against the small input file (popSmall.txt), run it against the larger input file (popLarge.txt) and collect some required data. You must try the load factors of 0.25, 0.5, and 0.75 against the large input file (3 different runs). Make sure that your hash table size is determined correctly according to the load factor by using the following formula: N / LF + 1. For example, if
a file has 5 values and for a test at load factor 0.5, the table size is 11 (5 / 0.5 + 1).

    Implementation of ChainHashMap is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/
import java.util.HashMap;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.lang.Iterable;
import java.util.Iterator;
class Main {

  public static int getN(String fileName){
    int N= 0; 
    try{
      File myObj = new File(fileName);
      Scanner doc = new Scanner(myObj);
      N = doc.nextInt();
      System.out.println(N);
    
      doc.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return N;
  }

  
  public static ProbeHashMap<Integer,String> getWords(String fileName, int size, double  loadfactor){
   
    int tableSize = (int) (size / loadfactor) + 1;
    
    ProbeHashMap<Integer,String> freq = new ProbeHashMap<>(tableSize, size);
   
    try{
      File myObj = new File(fileName);     
      Scanner doc2 = new Scanner(myObj).useDelimiter(",");
      doc2.nextLine();
    
      while (doc2.hasNextLine()) {   //Read file
        int data = doc2.nextInt();
        String word = doc2.nextLine();  //Scan file for integer
        //System.out.println(word);
        freq.put(data,word);
       
      }
      doc2.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println(fileName + " \nLoadfactor: "+ loadfactor);
    System.out.println("Tablesize: "+ tableSize);
    System.out.println("Average Number of Probes: "+ freq.averageProbe());
    System.out.println("Max Number of Probes: "+ freq.maxProbe());
    System.out.println();
    return freq;
  }
  
  public static void main(String[] args) {
       
    
    int sizeA = getN("popSmall.txt");
    int sizeB = getN("popLarge.txt"); 
  

    ProbeHashMap<Integer,String> wordsA = getWords("popSmall.txt", sizeA, 0.25);
    ProbeHashMap<Integer,String> wordsB = getWords("popSmall.txt", sizeA, 0.5);
    ProbeHashMap<Integer,String> wordsC = getWords("popSmall.txt", sizeA, 0.75);

    ProbeHashMap<Integer,String> wordsD = getWords("popLarge.txt", sizeB, 0.25);
    ProbeHashMap<Integer,String> wordsE = getWords("popLarge.txt", sizeB, 0.5);
    ProbeHashMap<Integer,String> wordsF = getWords("popLarge.txt", sizeB, 0.75);
   }
}