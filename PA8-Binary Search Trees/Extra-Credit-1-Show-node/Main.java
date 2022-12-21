/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/21/2022
    Description: – Add code to exercise 2 to display number of nodes examined for search, insert, and erase operations. You can submit one version here to include exercise 2.

    Implementation of TreeMap is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, 
    Exception(s):
*/
class Main {

  public static void main(String[] args) {

    PopMap pop = new PopMap("popSmall.txt");
    // 1. List all records
  //  pop.print();
    // 2. Search for 6037
    pop.find(6037);
    // 3. Search for 6000
    // pop.find(6000);
    // // 4. Insert 6066, 1, “New County, CA”
    // pop.insert(6066,1,"New County, CA");
    // // 5. Insert 6065, 2000, “Riverside, CA”
    // pop.insert(6065,2000,"Riverside, CA");
    // // 6. Delete 6999
    // pop.erase(6999);
    // // 7. Delete 6075
    // pop.erase(6075);
    // // 8. Delete 6055
    // pop.erase(6055);
    // // 9. List all records
    // pop.print();   
  }
}