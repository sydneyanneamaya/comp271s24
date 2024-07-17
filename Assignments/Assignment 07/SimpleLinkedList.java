
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

    public static void main(String[] args) {

        SimpleLinkedList demoQueue = new SimpleLinkedList();
        SimpleLinkedList demoStack = new SimpleLinkedList();

        demoQueue.add("A");
        demoQueue.add("B");
        demoQueue.add("C");
       
        boolean queueWorks = demoQueue.remove().equals("A") &&
                demoQueue.remove().equals("B") &&
                demoQueue.remove().equals("C") &&
                demoQueue.remove() == null;

        demoStack.push("A");
        demoStack.push("B");
        demoStack.push("C");

        boolean stackWorks = demoStack.pull().equals("C") &&
                demoStack.pull().equals("B") &&
                demoStack.pull().equals("A") &&
                demoStack.pull() == null;

        System.out.println(queueWorks);
        System.out.println(stackWorks);
    }

    public boolean add(String string){
        Node newNode = new Node(string);
        boolean ifAdded = false;
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
            ifAdded = true;
        }
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
            ifAdded = true;
        }
        return ifAdded;
    } 

    public String remove(){
        String first = null;
        if(this.head == null){
            first = null;
        }
        else {
           first = this.head.toString();
           this.head = this.head.getNext();
        }
        return first;
    }

    public boolean push(String string){
        boolean isAdded = false;
        Node newNode = new Node(string);
        Node oldHead = this.head;
        this.head = newNode;
        this.head.setNext(oldHead);
        isAdded = true;
        return isAdded;
    }

    public String pull(){
            return this.remove();
    }
}// class SimpleLinkedList

