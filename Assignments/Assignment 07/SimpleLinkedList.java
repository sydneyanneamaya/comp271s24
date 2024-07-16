
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    /** The number of nodes in this linked list
     *  this also represents the capacity and usage 
     *  of this list because there cannot be a node 
     *  without data (so usage is the same as capacity)
     */
    private int usage;

    private static final int DEFAULT_CAPACITY = 4;

    public boolean add(String string){
        Node newNode = new Node(string);
        boolean ifAdded = false;
        if((this.head == null) && (this.usage < DEFAULT_CAPACITY)){
            this.head = newNode;
            this.tail = newNode;
            ifAdded = true;
        }
        else if(this.usage < DEFAULT_CAPACITY){
            this.tail.setNext(newNode);
            ifAdded = true;
            this.usage++;
        }
        return ifAdded;
    }

    public String remove(){
        String first = this.head.toString();
        This.head = this.head.getNext; 
        nextNode = this.head;
        for (int i = 0; i < DEFAULT_CAPACITY; i++){
            nextNextNode = nextNode.getNext.getNext();
            nextNode.setNext(nextNextNode);
            nextNode = nextNode.getNext();
        } 
        if (this.usage == 0){
            first = null;
        }
        else {
            this.usage--;
        }
        return first;
    }
}







} // class SimpleLinkedList
