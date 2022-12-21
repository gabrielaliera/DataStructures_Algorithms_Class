/*  Java Class: Main Driver
    Author: Gabriela Liera
    Class: CSCI 240 -Data Structures
    Date: 11/23/2022
    Description: You should use AdjacencyListGraph class from previous PA, which contains node/edge information and adjacency list using a list or vector. If you had problems with the class from previous PA, you could use AdjacencyMapGraph class.Download the data file, PA12Flights.txt, for this PA. The file contains flight connections between airports (a directed edge) – source airport code, destination airport code, and cost of the flight. Construct the digraph from the data file and display the graph like previous PA.
Implementation of class and graph algo is modify from:
        Data Structures and Algorithms in Java, Sixth Edition
        Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
        John Wiley & Sons, 2014
I certify the code below is my own: Main
    Exception(s): Main
*/
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.HashMap;
class Main {
  
  //Global variables
  static boolean isDirected = true;
  static AdjacencyMapGraph<String, Double> graph = new AdjacencyMapGraph<>(isDirected); //Main graph
  static ArrayList<String> data= new ArrayList<>();  //Hold string from text file
  static HashMap<String, Vertex<String>> vertexMap = new HashMap<>(); //stores already created Vertex

  //Read file to ArrayList<String> data
  public static void readFile(String fileName){

    try{
      File myObj = new File(fileName);
      Scanner scan = new Scanner(myObj);
    
      while (scan.hasNextLine()) {   //Read file
        String str = scan.nextLine();  //Scan file
        data.add(str);       
      }
    scan.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  public static void createGraph(){
    Vertex<String> v1;
    Vertex<String> v2;

    //Insert vertex and edge from each line in arraylist 
    for(String s: data){
      String[] line = s.split("\s+");
      //Create or find v1
      if(vertexMap.get(line[0])== null){
        v1 =  graph.insertVertex(line[0]); //if v1 doesn't exist, create and add to hashmap
        vertexMap.put(line[0], v1);
      } else{
        v1 = vertexMap.get(line[0]); //else get v1 from hashmap
      }
      //Create or find v2
      if(vertexMap.get(line[1]) == null){
        v2 =  graph.insertVertex(line[1]);//if v2 doesn't exist, create and add to hashmap
        vertexMap.put(line[1], v2);
      } else{
        v2 = vertexMap.get(line[1]); //else get v2 from hashmap
      }
      //Insert edge
      Double edgeData = Double.parseDouble(line[2]);
      graph.insertEdge(v1,v2,edgeData);
    }  
  }

  public static void displayMenu(){
    System.out.println("\n\n~Welcome~");
    System.out.println("0. Display all flights");
    System.out.println("1. Find a cheapest flight from one airport to another airport");
    System.out.println("2. Find a cheapest roundtrip from one airport to another airport");
    System.out.println("3. Find an order to visit all airports starting from an airport");
    System.out.println("4. Find a flight with the fewest stops from one airport to another airport");
    System.out.println("Q. Exit");
  }

  public static Vertex<String> getFlight(){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter origin airport: ");
    String str = scan.nextLine();
    
    Vertex<String> airport = vertexMap.get(str);

    while (vertexMap.get(str)== null){
      System.out.print("Airport doesn't exist. Re-enter airport: "); 
      str = scan.nextLine();
      airport = vertexMap.get(str);
    }
    return airport;
  }
  
  public static void main(String[] args) {

    //Read each line and inserts line to arraylist 
    readFile("PA12Flights.txt");
    createGraph();

    GraphAlgo algo = new GraphAlgo(graph);
    Scanner scan = new Scanner(System.in); //for user input
    String menuInput = "-1";
    
    while (menuInput != "Q"){
      displayMenu();
      System.out.print("\nEnter an option: ");
      menuInput = scan.nextLine().trim();
      switch (menuInput){
        case "0": //Left
          System.out.println(graph.toString());
          break;
        case "1":  //Cheapest OneWay Flight
          Vertex<String> a1 = getFlight();
          Vertex<String> a2 = getFlight();
          algo.cheapestFlight(a1,a2);
          break;
        case "2": //Cheapest Round Trip
          Vertex<String> a3 = getFlight();
          Vertex<String> a4 = getFlight();
          algo.cheapestRound(a3,a4);
          break;
        case "3": //Path to visit all
          Vertex<String> a5 = getFlight();
          algo.vistAll(a5);
          break;
        case "4": //Fewest Stops
          Vertex<String> a6 = getFlight();
          Vertex<String> a7 = getFlight();
          algo.fewestStops(a6,a7);
          break;
        case "Q": //Exit
          System.out.println("Thank you for using my program.");
          return;
      }
    }
    
  }
}