/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 10/21/2022
    Description: – Add operation draw() to BetterPopMap class in exercise 4 to draw the tree (key only). You can submit one version here to include exercise 4. See sample drawing below where 1234 is the root with left child 1000. 2000 is the right child of the root with 2 children, 1500 and 2000.
1234
    1000
    2000
        1500
        2000

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

    pop.draw();
  }
}