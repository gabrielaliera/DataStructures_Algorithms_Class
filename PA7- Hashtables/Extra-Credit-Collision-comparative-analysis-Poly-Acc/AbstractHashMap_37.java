/*Java Class: Abstract Hash Map
  Author: Gabriela Liera
  Class: CSCI 240 -Data Structures
  Date: 10/12/2022
  Description: An abstract base class supporting Map implementations that use hash   
  tables with MAD compression.
  The base class provides the following means of support:
    1) Support for calculating hash values with MAD compression
    2) Support for resizing table when load factor reaches 1/2
 
  Subclass is responsible for providing abstract methods: 
    createTable(), bucketGet(h,k), bucketPut(h,k,v), 
    bucketRemove(h,k), and entrySet()
    and for accurately maintaining the protected member, n, to reflect changes
    within bucketPut and bucketRemove.
  Modify from:
    Data Structures and Algorithms in Java, Sixth Edition
    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
    John Wiley & Sons, 2014
  Exception(s): 
*/
import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap_37<K,V> extends AbstractMap<K,V> {
  protected int n = 0;                 // number of entries in the dictionary
  protected int capacity;              // length of the table
  private int prime;                   // prime factor
  private long scale, shift;           // the shift and scaling factors
  private UnsortedTableMap<Integer,Integer>collisionTable;
  private UnsortedTableMap<String,Integer>wordTable;
  int numCollisions = 0;

  /** Creates a hash table with the given capacity and prime factor. */
  public AbstractHashMap_37(int cap, int p) {
    prime = p;
    capacity = cap;
    Random rand = new Random();
    scale = rand.nextInt(prime-1) + 1;
    shift = rand.nextInt(prime);
    createTable();
    collisionTable = (UnsortedTableMap<Integer,Integer>) new UnsortedTableMap<Integer,Integer>();
    wordTable = (UnsortedTableMap<String,Integer>) new UnsortedTableMap<String,Integer>();   
  }

  /** Creates a hash table with given capacity and prime factor 109345121. */
  public AbstractHashMap_37(int cap) { this(cap, 109345121); }  // default prime

  /** Creates a hash table with capacity 17 and prime factor 109345121. */
  public AbstractHashMap_37() { this(17); }                     // default capacity

  // public methods
  public int size() { return n; }

  public V get(K key) { return bucketGet(hashValue(key), key); }

  public V remove(K key) { return bucketRemove(hashValue(key), key); }

  public V put(K key, V value) {
    V answer = bucketPut(hashValue(key), key, value);
    if (n > capacity / 2)              // keep load factor <= 0.5
      resize(2 * capacity - 1);        // (or find a nearby prime)
    return answer;
  }

  // private utilities
  /** Hash function applying MAD method to default hash code. */
  //  private int hashValue(K key) {
  //   int hashcode = polynomialAccumulation(key);
  //   return (int) ((Math.abs(hashcode*scale + shift) % prime) % capacity);
  // }

     private int hashValue(K key) {
    int hashcode;
    String Key = (String) key;
    if (wordTable.get(Key)==null){ //if word not in wordTable
      wordTable.put(Key, 1); //insert into wordtable
      
      hashcode = polynomialAccumulation(key); //generate hashcode
      
      if (collisionTable.get(hashcode)== null){ // if hashcode not in collisionTable
        collisionTable.put(hashcode,1); // insert hashcode into collision talbe
      } else{
        numCollisions++; // hashcode already exist so increase num of collisiona
      }
    }
    
    hashcode = polynomialAccumulation(key);
    int location =(int) ((Math.abs(hashcode*scale + shift) % prime) % capacity);
    //collision(location);
    //return (int) ((Math.abs(hashcode*scale + shift) % prime) % capacity);
   return location;
  }  
  public int getNumCollisions(){
    return numCollisions;
  }
  //Creates hashcode for strings using cyclic shift
  private int polynomialAccumulation(K key) {
    
    int z = 37;
    int hashVal = 0;
    String stringKey = (String) key;
    
    for(int i=0;i<stringKey.length();i++){
      hashVal += z * hashVal + stringKey.charAt(i);
    }
    return hashVal;
  }
  
  /** Updates the size of the hash table and rehashes all entries. */
  private void resize(int newCap) {
    ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
    for (Entry<K,V> e : entrySet())
      buffer.add(e);
    capacity = newCap;
    createTable();              // based on updated capacity
    n = 0;        // will be recomputed while reinserting entries
    for (Entry<K,V> e : buffer)
      put(e.getKey(), e.getValue());
  }

  // protected abstract methods to be implemented by subclasses
  protected abstract void createTable();

 
  protected abstract V bucketGet(int h, K k);

  
  protected abstract V bucketPut(int h, K k, V v);

  protected abstract V bucketRemove(int h, K k);
}