/*  Java Class: Progression
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/22/2022
    Description: Write a C++ class that is derived from the Progression class to produce a progression where each value is the absolute value of the difference between the previous two values. You should include a default constructor that starts with 2 and 200 as the first two values and a parametric constructor that starts with a specified pair of numbers as the first two values.
    I certify that the code below is my own work.
Exception(s): N/A
*/
class Progression{
  protected long current;

  //Constructors
  public Progression(){this(0);}
  public Progression(long start){current= start;  }

  //Methods
  public long nextValue(){
    long answer= current;
    advance();
    return answer;
  }

  protected void advance(){
    current++;
  }

  public void printProgression(int n){
    System.out.print(nextValue());
    
    for(int j=1; j<n; j++){
      System.out.print(" "+ nextValue());
    }
    System.out.println();
  } 
}