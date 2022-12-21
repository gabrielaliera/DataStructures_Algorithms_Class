/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/21/2022
    Description: – You will implement a better population database for California counties using an AVL tree from exercise 1 to store the database records. Define and implement PopBetterMap class that supports standard map operations using county code as a key for each record (no duplicate keys). Your PopBetterMap class uses an AVL tree to store population records. Download the data file p4small.txt, containing a list of a few population records – county code, population in million, and county with state abbreviation (3 fields separated by commas). Build the AVL tree from the records of the input data file by inserting one record at a time to the tree. Run the following test cases after the tree is constructed:
1. List all records
2. Search for 6037
3. Search for 6000
4. Insert 6066, 1, “New County, CA”
5. Insert 6065, 2000, “Riverside, CA”
6. Delete 6999
7. Delete 6075
8. Delete 6055
9. List all records
    Implementation of AVLTreeMap is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
    I certify the code below is my own: Main, BetterPopMap 
    Exception(s):
*/
class Main {

  public static void main(String[] args) {

    BetterPopMap pop = new BetterPopMap("popSmall.txt");
    // 1. List all records
    pop.print();
    // 2. Search for 6037
    pop.find(6037);
    // 3. Search for 6000
    pop.find(6000);
    // 4. Insert 6066, 1, “New County, CA”
    pop.insert(6066,1,"New County, CA");
    // 5. Insert 6065, 2000, “Riverside, CA”
    pop.insert(6065,2000,"Riverside, CA");
    // 6. Delete 6999
    pop.erase(6999);
    // 7. Delete 6075
    pop.erase(6075);
    // 8. Delete 6055
    pop.erase(6055);
    // 9. List all records
    pop.print();    
  }
}