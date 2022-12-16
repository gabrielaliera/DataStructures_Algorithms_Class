/*  Java Class: Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 09/14/2022
    Description:You need to write a program that simulates call lines at a calling center. A line is basically a queue object, and you can assume one customer representative per line. Based on some preliminary estimate, customers are expected to call in random integer  intervals of 1 to n minutes (inclusively and two customers are expected to call between that interval so if customer 1 calls at minute 3, then customer 2 is expected to call between minute 4 and 7 when n is 4). Also, it is expected to take a random integer interval of 1 to m minutes to serve each customer. If the call arrival rate is faster than the service rate (n < m), the line will grow indefinitely. Even with a "balanced" rate (n = m), randomness can still possibly cause a long line over a period. You are going to run the calling center simulation with one line (it is more interesting with multiple lines, but more work to do so) for a period of t minutes using the following algorithm (enter input parameters from keyboard and use t = 30, n = 4, and m = 4 as test case 0):
    I certify that the code below is my own work.
Exception(s): N/A
*/
import java.util.Random;

class Main {

  //Global Variable
  static Customer[] customerList = new Customer[3600]; // Array to hold customer information
  static int customerCount = 0;                     // Total number of customer calling
  
  public static void callCenter(int totalTime, int intervalTime, int servingTime){
    
    Queue<Customer> myQueue = new Queue<>();  // create queue
    int numCustomerServed = 0;
    customerCount = 1;                    //create customer count
    
    //Create customer1 
    int r = callInterval(intervalTime);     //Holds customer1 call start time interval
    int m = servingInterval(servingTime);  //Holds customer1 call end time interval
    System.out.println("r interval:"+r);
    System.out.println("m interval:"+m);
    Customer c1 = new Customer(customerCount, r, m+r);  //Create first customer with r and m
    customerList[customerCount-1] = c1;                 //Add c1 to global customerList[]
    customerCount ++;
    
    int schedule_next_call= 0;              //Holds value for next scheduled call
    boolean serving = false;                //Holds value if customer is being served
    
    
    //Begin loop for each minutes
    //Current is the customer begin served
    Customer current = c1;
    for (int i=1; i <= totalTime; i++){         // Loop through each minute
      
      System.out.println("Minute: "+ i);       //Display Minute

      //Customer Calls
      if(current.getMinuteCalled()==i){        
        System.out.print(" Customer "+ current.getID() + " Calls\n");
        myQueue.enqueue(current);                           //Add customer to queue         
        schedule_next_call = callInterval(intervalTime) +i; //schedule next call
        
      }

      //Current Customer Call Complete
      if(serving && (current.getMinuteServed() == i)){   
        System.out.print(" Customer "+ current.getID() + " Done \n");
        current.setServiceCompleted(true);
        numCustomerServed ++;                              //Increase numCustomerServed
        serving = false;                                   //No longer serving customers
      } 

      //Next Customer Calls
      if(schedule_next_call==i){                   
        Customer c2 = new Customer(customerCount,schedule_next_call, servingInterval(servingTime));
        customerList[customerCount-1] = c2;               //Add c2 to global customerList[]
        customerCount++;                                  //Increase total number of customers
        System.out.print(" Customer "+ c2.getID() + " Calls\n");
        myQueue.enqueue(c2);                              // Add customer to queue
        
       schedule_next_call= callInterval(intervalTime) +i; //Schedule next call
       System.out.println(" Schedule next call: "+schedule_next_call);
      }

      //Serving Customer
      if(serving == false && (myQueue.size() > 0)){    
       System.out.print(" Serving Customer " + myQueue.first().getID()+ "\n");
        current = myQueue.dequeue();                     //Remove customer from queue and served
        if (current != c1){                              //Set serving interval to include current i
          current.setMinuteServed(current.getMinuteServed()+i);
        }
        System.out.println(" Customer "+ current.getID() + " time when calls done: "+ current.getMinuteServed());
        serving = true;
         
      }
    
    }//end for
    
    //Display Final Information
    System.out.println("***************TIME DONE***************");
    System.out.println("Number of customers served to completion: "+ numCustomerServed);
    
    if(!current.getServiceCompleted()){
      System.out.println("Currently serving customer "+ current.getID());
    } else{
      System.out.println("Not serving any customers");
    }
    
    System.out.println("Current customers in queue: " + myQueue.size());

    //Extra Credit
    System.out.println("Maximum number of customers in the line at any time: "+ myQueue.getMaxSize());
    System.out.println("Longest wait time: "+longestWaitTime());
    System.out.println("Avergage wait time: "+averageWaitTime());
  }
  
  public static int callInterval(int n){
    Random random = new Random();;
    int intervalT = 1 + random.nextInt(n);
    return intervalT;
  }

  public static int servingInterval(int n){
    Random random = new Random();;
    int servingT = 1 + random.nextInt(n);
    return servingT;
  }

  public static int longestWaitTime(){
    int maxWait = Integer.MIN_VALUE;
    for(int i=0; i<customerCount-1;i++){
      int wait = customerList[i].getWaitTime();
      maxWait = Math.max(maxWait,wait);
    }
    return maxWait;
  }

  public static double averageWaitTime(){
    int sum =0; 
    int countServed = 0;
    for(int i=0; i<customerCount-1;i++){
      if(customerList[i].getWaitTime()> 0){
        sum = sum + customerList[i].getWaitTime();
        countServed++;
      }
    }
    return sum/(countServed);
  }
  
  public static void main(String[] args) {
    Queue<Integer> myQueue = new Queue<>();
    // System.out.println("Empty: " + myQueue.isEmpty());
    // System.out.println("First: " + myQueue.first());
    // myQueue.print();
    // myQueue.dequeue();
    // myQueue.enqueue(1);
    // myQueue.enqueue(2);
    // myQueue.enqueue(3);
    // System.out.println("Empty: " + myQueue.isEmpty());
    // System.out.println("First: " + myQueue.first());
    // System.out.println("Size: " + myQueue.size());
    // myQueue.dequeue(); //removes 1st
    // myQueue.print();

    callCenter(30,4,4);
   
    
    for(int i=0;i<customerCount-1;i++){
      System.out.println(" ID "+customerList[i].getID());
      System.out.println(customerList[i].getMinuteCalled());
      System.out.println(customerList[i].getMinuteServed());
      System.out.println(customerList[i].getWaitTime());
      System.out.println(customerList[i].getServiceCompleted());
    }

    
   
    //Other Testcases
    //callCenter(360,4,4);
    // callCenter(360,3,4);
    // callCenter(360,5,4);
  }
}