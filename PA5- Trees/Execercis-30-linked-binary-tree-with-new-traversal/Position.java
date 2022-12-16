/*  Java Class: Position Interface
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/30/2022
    Description: – Position uses in multiple files
    Modify from book
    Exception(s): IllegalStateExceptopm
*/
public interface Position<E>{
  E getElement() throws IllegalStateException;
}