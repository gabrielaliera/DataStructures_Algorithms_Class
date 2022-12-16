/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/22/2022
    Description: Write a C++ class that is derived from the Progression class to produce a progression where each value is the absolute value of the difference between the previous two values. You should include a default constructor that starts with 2 and 200 as the first two values and a parametric constructor that starts with a specified pair of numbers as the first two values.
    I certify that the code below is my own work.
Exception(s): N/A
*/

class Main {

  public static void main(String[] args) {

    // 0,1,2,3,4
    Progression p = new Progression();
    p.printProgression(5);

    // default constructor with 2, 200 => 2 200 198 2 196 194 2
    AbsoluteDiffProgression a = new AbsoluteDiffProgression();
    a.printProgression(10);

    // Another text case 100 and 5 => 100 5 95 90 5
    AbsoluteDiffProgression b = new AbsoluteDiffProgression(100, 5);
    b.printProgression(10);

    // modfiy current testprogression
    AbsoluteDiffProgression c = new AbsoluteDiffProgression(10, 2);
    c.printProgression(10);
  }
}