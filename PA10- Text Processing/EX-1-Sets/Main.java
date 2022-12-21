/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/09/2022
    Description: Set up a class named IntSet that keeps track a set of int values from 0 to 999 and you can perform basic operations like creating a set (constructor that accepts an array of int values), insert(e), remove(e), find(e), and print(). Set up three methods/functions to perform union, intersection, and difference of two sets and return
the new set as shown below. Try set1 = {1, 4, 6}, set2 = {2, 4, 8, 10}.
set3 = setUnion(set1, set2); // set3 = {1, 2, 4, 6, 8, 10}
set3 = setInter(set1, set2); // set3 = {4}
set3 = setDiff(set1, set2); // set3 = {1, 6}
    I certify the code below is my own: Main, InSet 
    Exception(s): None
*/
class Main {
  //Union
  static InSet setUnion(InSet setX, InSet setY){
    InSet answer = new InSet();

    for(int i=0;i<1000;i++){
      if(setX.find(i) == i  || setY.find(i)==i){
        answer.insert(i);
      }
    }
    return answer;
  }
  //Intersection
  static InSet setInter(InSet setX, InSet setY){
    InSet answer = new InSet();

    for(int i=0;i<1000;i++){
      if(setX.find(i) == i  && setY.find(i)==i){
        answer.insert(i);
      }
    }
    return answer;
  }
  //Difference
  static InSet setDiff(InSet setX, InSet setY){
    InSet answer = new InSet();

    for(int i=0;i<1000;i++){
      if(setX.find(i) == i ){
        answer.insert(i);
        if(setY.find(i)== i){
          answer.remove(i);
        }
      }
      
    }
    return answer;
  }
  //Main 
  public static void main(String[] args) {

    int[] a = {1,4,6};
    
    InSet set1 = new InSet(a);
    System.out.print("\nSet 1: ");
    set1.print();

    InSet set2 = new InSet();
    set2.insert(2);
    set2.insert(4);
    set2.insert(8);
    set2.insert(10);
    System.out.print("\nSet 2: ");
    set2.print();

    // set2.find(10);
    // set2.remove(10);
    // set2.print();
    // set2.insert(10);
    // set2.print();

    InSet unionSet = setUnion(set1,set2);
    System.out.print("\nUnion");
    unionSet.print();
    
    InSet intersectSet = setInter(set1, set2);
    System.out.print("\nIntersection: ");
    intersectSet.print();

    InSet diffSet = setDiff(set1,set2);
    System.out.print("\nDifference: ");
    diffSet.print();

  }
}