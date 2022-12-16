public class double{

  private static class Node{
    private int data;
    private Node prev;
    private Node next;

    public Node(int nun, Node p, Node n){
      this.data= num;
      this.prev=p;
      this.next=n;
    }

    private Node head = null;
    public void push(int new_data)
{
    /* 1. allocate node
     * 2. put in the data */
    Node new_Node = new Node(new_data);
 
    /* 3. Make next of new node as head and previous as NULL
     */
    new_Node.next = head;
    new_Node.prev = null;
 
    /* 4. change prev of head node to new node */
    if (head != null)
        head.prev = new_Node;
 
    /* 5. move the head to point to the new node */
    head = new_Node;
  }
  }
}