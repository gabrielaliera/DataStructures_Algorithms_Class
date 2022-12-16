/*  Java Class: AbsoluteDiffProgression
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/22/2022
    Description: Write a C++ class that is derived from the Progression class to produce a progression where each value is the absolute value of the difference between the previous two values. You should include a default constructor that starts with 2 and 200 as the first two values and a parametric constructor that starts with a specified pair of numbers as the first two values.
    I certify that the code below is my own work.
Exception(s): N/A
*/

class AbsoluteDiffProgression extends Progression {
  protected long prev;

  //default constructor with 2, 200 => 2 200 198 2 196 194 2
  public AbsoluteDiffProgression(){
    this(2,200);
  }

  public AbsoluteDiffProgression(long first, long second){
    super(first);
    prev= second;
  }

  protected void advance(){
   // replace (current, prev) with (current, math.abs)
    long temp = current; //temp = 2
    current= prev;   // current = 200
    prev = Math.abs(temp-current); // prev = Math.abs(2-200) = 198
  }
}