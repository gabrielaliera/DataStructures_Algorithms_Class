/*  Java Class: InSet Class
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/09/2022
    Description: Set up a class named IntSet that keeps track a set of int values from 0 to 999 and you can perform basic operations like creating a set (constructor that accepts an array of int values), insert(e), remove(e), find(e), and print(). Set up three methods/functions to perform union, intersection, and difference of two sets and return
    I certify the code below is my own: Main,InSet 
    Exception(s):
*/
public class InSet{

  private int[] set = new int[1000];
  //set[i] == 0 means set does not contain value
  //set[i] == 1 means set contains value

  //Default constructor
  InSet(){
    set = new int[1000];
  }
  //Constructor
  InSet(int[] a){
    for(int i = 0; i< a.length;i++){
      set[a[i]] = 1;
    }
  }
  //Insert method
  public void insert(int n){
    if( n >= 0 && n<= 999){
      set[n] = 1;
    } else {
      System.out.println("Value out of bound");
    }
  }
  //Remove method
  public void remove(int n){
    if( n >= 0 && n<= 999){
      set[n] = 0;
    } else {
      System.out.println("Value out of bound");
    }
  }
  //Find method
  public int find(int n){
    if( n >= 0 && n<= 999){
      if(set[n] == 0){
      //System.out.println("Value "+ n +" does not exist");
      return -1;  
      }else{
      //System.out.println("\nFound: "+ n);
        return n;   // n is the index
      }
    } else {
      System.out.println("Value out of bound");
      return -999;
    }
  }
  //Print 
  public void print(){
    for(int i=0;i<set.length; i++){
        if(set[i] == 1){
          System.out.print(i + " ");
        }
    }
  }
}