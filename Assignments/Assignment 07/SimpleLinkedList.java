
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

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
    /** Adds a string at the next available position in the underlying data structure
     * and updates the usage of that data structure. If usage exceed capacity, the
     * method returns a false value. If addition of the element is successful, the
     * method returns a true.
     * 
     * @param s String to add
     * @return true is room for string; false otherwise
     * 
     * In a linked list, the usage AND capacity is equal to the number of objects in the 
     * list unklike an array which can have empty elements. The node object cannot be 
     * empty because in order for the node object to be added to the linke list
     * it must have data(string). Since there is no set capacity, the add method will 
     * add the String to the end of the linked lists.
     */
    public boolean add(String s){
        //create a new node with the @param as the data in it
        Node newNode = new Node(s);
        //create a boolen variable to return later
        boolean ifAdded = false;
        /*check to see if there is a head Node in this list and if not
         make the @param s the head and tail and set ifAdded to true
        since a node was added to the list*/
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
            ifAdded = true;
        }
        /*there is a head node, so the @param s will be added to the end of 
         the list, set the @param s as the Node after the tail and also 
         make it the new tail, ifAdded is true since a Node was added to 
         the list*/
        else {
            this.tail.setNext(newNode);
            this.tail = newNode;
            ifAdded = true;
        }
        return ifAdded;
    }//method add

    /**
     * Removes the first element from the underlying data structure and returns it.
     * If an element is removed, then the usage of the underlying data structure is
     * reduced by one and every element in the queue moves one position closer to
     * the front. If the usage is already 0, the method returns a null value
     * and the usage remains zero.
     * 
     * @return String in the front of the underlying data structure.
     * 
     * Linked lists cannot have empty indexes like arrays, so usage will allways be the
     * same as the number of Nodes in this list. To remove the first element, return the 
     * head as a string. Then set the Node after the previous head as the new head. Since
     * the new head has a pointer to the next Node and that Node has a pointer to the next 
     * Node and so on, there is no need to move the positions because every Node automatically
     * moves up one (technically there is no index to move up but this is how I can phrase it 
     * best)
     */
    public String remove(){
        String first = null;
        //check to see if there is a head 
        if(this.head == null){
            first = null;
        }
        else {
            //gets the head Node in string form 
           first = this.head.toString();
           //sets the new head as the Node after the previous head
           //subsequently, all Nodes move up one 
           this.head = this.head.getNext();
        }
        return first;
    }//method remove

    /**
     * Inserts an element at the front of the underlying data structure. All
     * existing elements are first moved one position closer to the end of 
     * underlying data structure. Then the new element is placed at the 
     * front position. If the underlying data structure is full, the method
     * returns false to indicate nothing was inserted; otherwise true. When
     * inserting something successfully, usage++
     * @param e
     * @return
     * 
     * Linked lists don't have a set capacity like arrays, so the data strucutre will not be 
     * full. When a new Node is added to the front (set as new head) every Node after it 
     * automatically moves down one position. 
     */
    public boolean push(String s){
        //create boolean variable
        boolean isAdded = false;
        //create a Node object with @param s
        Node newNode = new Node(s);
        //store current head in a variable
        Node oldHead = this.head;
        //set the head to be the @param
        this.head = newNode;
        /*set the Node after the new head as the old head
        since the old head points to the next node and that
        node points to the next node and so on every 
        node moves down one position
        this.head.setNext(oldHead);
        the @param s was added as the new head so isAdded is true*/
        isAdded = true;
        return isAdded;
    }//method push

    /**
     * Removes and returns what's in the front of the underlying data structure,
     * including nulls. Null means that structure is empty. Otherwise the first
     * element is returned and the usage is adjusted accordingly. Successful 
     * removals cause remaining elements to move one position closer to the front.
     * @return 
     * 
     * this method does the same thing as the remove method
     */
    public String pull(){
            return this.remove();
    }//method pull
}// class SimpleLinkedList

