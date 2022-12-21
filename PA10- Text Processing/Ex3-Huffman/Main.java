/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/10/2022
    Description:Write a program that construct a Huffman tree from a given text and output the encoded bits for each character. You should utilize a class named HuffmanTree with an appropriate interface. You can use binary tree and PQ data structures from previous PAs.
      Input text: more money needed
      Output:
      Number of characters: 17
      space    011
      d 	101
      e 	11
      m	100
      n 	010
      o 	000
      r 	0010
      y 	0011
    Implementation of Heap Proirity Queue and Linked Binary Tree is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, HuffmanTree
    Exception(s):
*/
import java.util.HashMap;
class Main {

  //Global bitMap to store character in bits
  public static HashMap<Character, String> bitMap = new HashMap<>();

  //Transverse through binaryTree from Huffman Encoding to generate character bits
  public static void transversePQ(LinkedBinaryTree<Character> tree, Node<Character> root, String path){
    
    Character c = root.getElement();
    //base case
    if(root.getLeft() == null && root.getRight()== null && (Character.isLetter(c) || c == ' ')){
          System.out.println(c + " "+ path); //Print path
          bitMap.put(c,path);                //add character path to bit hashmap
          return;
    }
    //Transverse left recursively
    if(root.getLeft() != null){
      transversePQ(tree,root.getLeft(), path+ "0");
    }
    //Transverse right recursively
    if(root.getRight() != null){
      transversePQ(tree,root.getRight(), path+ "1");
    }
  }

  //Main Driver
  public static void main(String[] args) {
    String text = "more money needed";
    System.out.println("\nText:"+ text);
    System.out.println("Number of character: "+ text.length());

    //Create HuffmanTree object and encode text
    HuffmanTree HT = new HuffmanTree();
    Entry<Integer,LinkedBinaryTree<Character>> huffMain = HT.HuffmanEncoding(text);
    
    //Transverse LinkedBinaryTree and print out character in bits
    String path = "";
    Node<Character> root =huffMain.getValue().getRoot();
    transversePQ(huffMain.getValue(),root, path);
    
   //Extra Credits*************

    //Get frequency hashmap from HuffmanEncoding
    HashMap<Character,Integer> freqHuff = HT.getfreqMap();
    int totalBits = 0;
    
    //Get charArray from HuffmanEncoding
    char[] charArray = HT.getcharArray();
    String textBits = "";
    
    //For each character in text
    //add character bits to string textBits
    //add number of bits to totalBits
    for(Character c: charArray){
      String bits = bitMap.get(c);
      textBits = textBits + bits;
      //totalBits = totalBits +freqHuff.get(c);
      totalBits = totalBits + bits.length();
    }
    //Output Results
    System.out.println("Number of Bits: "+ totalBits);
    System.out.println(textBits);
  }
}