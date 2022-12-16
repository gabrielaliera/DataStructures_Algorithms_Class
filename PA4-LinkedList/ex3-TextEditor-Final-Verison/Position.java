/*  Java Class: Position Interface
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/23/2022
    Description: – Position interface for positional list and LPL
    Modify from book: I certify that the code below is my own work.
    Exception(s): IllegalStateExceptopm
*/
public interface Position<E>{
  
  E getElement() throws IllegalStateException;
}