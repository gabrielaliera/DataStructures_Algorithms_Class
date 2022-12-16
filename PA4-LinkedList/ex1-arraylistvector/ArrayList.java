/*  Java Class: ArrayList
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/21/2022
    Description: – Class ArrayList using List interface 
    Modify from book: I certify that the code below is my own work.
    Exception(s): IndexOutOfBoundsException
*/
public class ArrayList<E> implements List<E>{
  private int size=0;
  private E[] data;

  //Constructors
  public ArrayList(){}
  public ArrayList(int capacity){
    data = (E[]) new Object[capacity];
  }

  public int size(){ return size;}

  public boolean isEmpty(){ return size==0;}

  public void set(E e, int index){
    checkIndex(index,size);
    data[index] = e;
  }

  public E get(int index){
    checkIndex(index,size);
    return data[index];
  }

  public void add(E e, int index) throws IndexOutOfBoundsException{
    checkIndex(index,size+1);
    if(size==data.length){
      resize(2*data.length);
    }

    System.out.println("   Add "+e+" to index "+ index);

    for(int k = size-1; k >= index; k--){ //shift right starting at last element 
      data[k+1] = data[k];
    }
    data[index] =e;
    size++;
  }

  public E remove(int index){
    checkIndex(index,size);
    
    System.out.println("   Remove item at index "+ index);
    E temp = data[index];
    
    for(int k=index;k<data.length-1;k++){
      data[k]= data[k+1];
    }
    data[size-1]= null;
    size--;
    return temp;
  }

  public void print(){
    for(int k=0;k<size;k++){
      System.out.print(data[k]+" ");
    }
    System.out.println();
  }

  protected void resize(int capacity){
    E[] temp = (E[]) new Object[capacity];

    for(int k=0;k<size;k++){
      temp[k] =data[k];
    }
    data =temp;
  }
  
  protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
    if(i<0 || i>= n){
      throw new IndexOutOfBoundsException("Illegal index: "+ i);
    }
  }
}