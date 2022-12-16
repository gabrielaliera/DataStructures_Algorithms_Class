/*  Java Class: Customer
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/14/2022
    Description:Customer Object class
    I certify that the code below is my own work.
Exception(s): N/A
*/

public class Customer{
    private int ID;
    
    private int minuteCalled = 0;
    private int minuteServed = 0;
    private int waitTime = minuteServed - minuteCalled;
    private boolean serviceCompleted = false;
  
    Customer(){}
    Customer(int num, int minCalled,int minServed){
      this.ID = num;
      this.minuteCalled = minCalled;
      this.minuteServed = minServed;
    }

    public void setID(int n){
      this.ID = n;
    }
    public void setMinuteCalled(int min){
      this.minuteCalled = min;
    }

    public void setMinuteServed(int min){
      this.minuteServed = min;
    }

    public void setServiceCompleted(boolean t){
      this.serviceCompleted = t;
    }

    public int getID(){
      return ID;
    }
    public int getMinuteCalled(){
      return minuteCalled;
    }

    public int getMinuteServed(){
      return minuteServed;
    }

    public boolean getServiceCompleted(){
      return serviceCompleted;
    }

  public int getWaitTime(){
      waitTime = minuteServed - minuteCalled;
      return waitTime;
    }
  } 