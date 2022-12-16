/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/22/2022
    Description: – Write a C++ function or a Java method that takes an array of int values and determines if all the numbers are different from each other (that is they are distinct).Include a driver to test your function/method with at least two test cases: all values are distinct (5, 7, 2, 6, 4) and two or more values are the same (5, 7, 2, 6, 4, 2).
    I certify that the code below is my own work.
Exception(s): N/A
*/
class Main {

  public static boolean isDistinctValues(int[] a) {
    boolean isDistinct = true;

    for (int i = 0; i < a.length; i++) {
      for (int j = 1; j < a.length; j++) {
        if (a[i] == a[j] && i != j) {
          isDistinct = false;
          break;
        }
      }
    }
    return isDistinct;
  }

  public static void main(String[] args) {
    int[] array1 = { 5, 7, 2, 6, 4 }; // true
    int[] array2 = { 5, 7, 2, 6, 4, 2 }; // false
    int[] array3 = { 1, 1 }; // false
    int[] array4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 2 }; // false
    int[] array5 = { 0 }; // true
    int[] array6 = { 1, 2 }; // true
    int[] array7 = { 1, 1, 2, 2, 3, 3 }; // false
    int[] array8 = { 1, 1, 2, 2, 3, 3, 4, 5 }; // false

    System.out.println("Array1 is " + isDistinctValues(array1));
    System.out.println("Array2 is " + isDistinctValues(array2));
    System.out.println("Array3 is " + isDistinctValues(array3));
    System.out.println("Array4 is " + isDistinctValues(array4));
    System.out.println("Array5 is " + isDistinctValues(array5));
    System.out.println("Array6 is " + isDistinctValues(array6));
    System.out.println("Array7 is " + isDistinctValues(array7));
    System.out.println("Array8 is " + isDistinctValues(array8));
  }
}