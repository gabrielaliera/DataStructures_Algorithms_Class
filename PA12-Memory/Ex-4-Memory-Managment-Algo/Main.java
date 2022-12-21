/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/30/2022
    Description: P-14.1 Write a C++ class that simulates the best-fit, worst-fit, first-fit, and next-fit algorithms for memory management. Determine experimentally which method is the best under various sequences of memory requests

a) Assume that you have an array of 1024 integers (4048 bytes or 4 KB) to manage
b) Each allocation can be between 5 and 20 integers
c) Start out with some allocations and deallocations until about half of the memory is being used (do 2 allocations for each random deallocation)
d) Perform some allocations and stop when an allocation cannot be made
e) Tally up all available blocks (small blocks not being used) to see how many
blocks are still available and how much memory available
 
I certify the code below is my own: Main, firstFit, Nextfit, Pair
*/

class Main {
 
  public static void main(String[] args) {

    int[] memory = new int[1024];
    
    System.out.println("First Fit:");
    FirstFit management = new FirstFit(memory);
    management.firstfit();

    System.out.println("\nNext Fit:");
    NextFit mag = new NextFit(memory);
    mag.nextfit();
  }
}