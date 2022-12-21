/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/10/2022
    Description: Try Brute Force pattern matching (pseudocode given in C++ textbook), BM pattern matching (code is given), and KMP pattern matching (code given) on various T and P and then modify the code to count the number of comparisons. Use a driver to check them out. Make sure to understand the algorithms and confirm that results are reasonable.
Try the following test cases:
1. T: “a pattern matching algorithm”, P: “rithm”, P: “rithn”
2. T: “GTTTATGTAGCTTACCTCCTCAAAGCAATACACTGAAAA”, P: “CTGA”, and P: “CTGG”
    Implementation of BoyerMoore, KMP is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/
class Main {
  public static void main(String[] args) {
    //Sorting objects
    BruteForce bf = new BruteForce();
    BoyerMoore bm = new BoyerMoore(); 
    KMP km = new KMP();
    
    //Patterm and text testcase 1
    String T = "a pattern matching algorithm"; //size 28
    String P1 = "rithm"; String P2 = "rithn";

    //Patterm and text testcase 2
    String T2 = "GTTTATGTAGCTTACCTCCTCAAAGCAATACACTGAAAA"; 
    String P3 = "CTGA"; String P4 = "CTGG";

    System.out.println("\n*****  Brute Force Alogrithm  ******");
    System.out.println("\nTEXT: a pattern matching algorithm PATTERN:rithm  ");
    bf.match(T,P1);
    System.out.println("Comparisons: "+ bf.getComparisons());
    bf.resetComparisons();

    System.out.println("\nTEXT: a pattern matching algorithm PATTERN:rithn  ");
    bf.match(T,P2);
    System.out.println("Comparisons: "+ bf.getComparisons());
    bf.resetComparisons();

    System.out.println("\nTEXT:GTTTA.... PATTERN:CTGA ");
    bf.match(T2,P3);
    System.out.println("Comparisons: "+ bf.getComparisons());
    bf.resetComparisons();

    System.out.println("\nTEXT:GTTTA.... PATTERN:CTGG ");
    bf.match(T2,P4);
    System.out.println("Comparisons: "+ bf.getComparisons());
    bf.resetComparisons();

    //BoyerMoor Algo
    System.out.println("\n*****  BoyerMoore Algorithm  *****");
    System.out.println("\nTEXT: a pattern matching algorithm PATTERN:rithm  ");
    bm.match(T,P1);
    System.out.println("Comparisons: "+ bm.getComparisons());
    bm.resetComparisons();

    System.out.println("\nTEXT: a pattern matching algorithm PATTERN:rithn  ");
    bm.match(T,P2);
    System.out.println("Comparisons: "+ bm.getComparisons());
    bm.resetComparisons();

    System.out.println("\nTEXT:GTTTA.... PATTERN:CTGA ");
    bm.match(T2,P3);
    System.out.println("Comparisons: "+ bm.getComparisons());
    bm.resetComparisons();

    System.out.println("\nTEXT:GTTTA.... PATTERN:CTGG ");
    bm.match(T2,P4);
    System.out.println("Comparisons: "+ bm.getComparisons());
    bm.resetComparisons();

    //KMP Algo
    System.out.println("\n***** KMP Algorithm *****");
    System.out.println("\nTEXT: a pattern matching algorithm PATTERN:rithm  ");
    km.match(T,P1);
    System.out.println("Comparisons: "+ km.getComparisons());
    km.resetComparisons();

    System.out.println("\nTEXT: a pattern matching algorithm PATTERN:rithn  ");
    km.match(T,P2);
    System.out.println("Comparisons: "+ km.getComparisons());
    km.resetComparisons();

    System.out.println("\nTEXT:GTTTA.... PATTERN:CTGA ");
    km.match(T2,P3);
    System.out.println("Comparisons: "+ km.getComparisons());
    km.resetComparisons();

    System.out.println("\nTEXT:GTTTA.... PATTERN:CTGG ");
    km.match(T2,P4);
    System.out.println("Comparisons: "+ km.getComparisons());
    km.resetComparisons();
  }
}