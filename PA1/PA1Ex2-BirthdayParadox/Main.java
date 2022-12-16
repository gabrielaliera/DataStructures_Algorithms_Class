/*  Java Class:Main
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 08/22/2022
    Description: P-1.3 The birthday paradox says that the probability that two people in  a room will have the same birthday is more than half as long as the number of  people in the room (n), is more than 23. This property is not really a paradox, but many people find it surprising. Design a C++ program that can test this paradox by a series of experiments on randomly generated birthdays, which test this paradox for n = 5,10,15,20,...,100. You should run at least 10 experiments for each value of n and it should output, for each n, the number of experiments for that n, such that two people in that test have the same birthday
    I certify that the code below is my own work.
Exception(s): N/A
*/
import java.util.Random;
import java.time.LocalDate;

class Main {
/* -------------------getBirthday()-------------------------*/
  public static LocalDate getBirthday(){
    Random random = new Random();
    int minDay = (int) LocalDate.of(1990, 1, 1).toEpochDay();
    int maxDay = (int) LocalDate.of(2000, 12, 31).toEpochDay();
    long randomDay = minDay + random.nextInt(maxDay - minDay);
    LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
    return randomBirthDate;
  }
  /* --------------------createBirthdayArray()------------------------*/
  public static LocalDate[] createBirthdayArray(int size){
      LocalDate[] birthdays = new LocalDate[size]; 
    
      for(int i=0;i<size;i++){
        birthdays[i]= getBirthday();
      }      
      return birthdays;
  }

    /* -------------------checkBirthdayDuplicates()-------------------------*/
  public static int checkBirthdayDuplicates(LocalDate[] a){
    int duplicates = 0;

    for(int i=0;i<a.length;i++){
      for(int j=1;j<a.length;j++) {
        if (String.valueOf(a[i]).equals(String.valueOf(a[j])) && i!=j){
          duplicates++;
        }
      }//end for
    }//end for
    return duplicates;
  }
  
  /* --------------------Main------------------------*/
  public static void main(String[] args) {
    
    System.out.println(String.format( "%3s %8s", "N","Count out of 10"));
    
    for(int i=5; i<=100; i+=5){   //Sample testcase size from 5 to 100 birthday 
      
      int count = 0;
      
      for(int j=0;j<10; j++){
        LocalDate[] testcase = createBirthdayArray(i);
        int numOfDuplicates = checkBirthdayDuplicates(testcase);

        if (numOfDuplicates >0){
          count++;
        }  //end for
      }
      System.out.println(String.format( "%3s %8s", i, count));
    } //end for 
  
  }
}