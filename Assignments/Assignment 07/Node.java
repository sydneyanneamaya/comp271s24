/**
 * A simple Node class (think of it as a TrainStation object) to build
 * a linked list (think of it as a TrainLine object).
 */
class Node {
    /** Data stored in the node (like the name of the train station) */
    private String data;
    /** Pointer to the next node */
    private Node next;
    /**how many nodes in the linked lists contain data */
    private int usage;
    /*the number of Nodes in the list, also the capacity */
    private int numberOfNodes;

    /** Basic constructor */
    public Node(String data) {
        this.data = data;
        this.next = null;
        this.usage = 1;
        this.numberOfNodes = 1;
    } // basic constructor

    /** Predicate accessor for next */
    public boolean hasNext() {
        return this.next != null;
    } // method hasNext

    /** Accessor for next */
    public Node getNext() {
        return this.next;
    } // method getNext

    /** Mutator for next */
    public void setNext(Node next) {
        this.next = next;
    } // method setNext

    /** String representation */
    public String toString() {
        return this.data;
    } // method toString

    /**Accessor for usage */
    public int getUsage(){
        return this.usage;
    }//method getUsage

     /**Accessor for numberOfNodes */
    public int getNumberOfNodes(){
        return this.numberOfNodes;
    }//method getNumberOfNodes
} // class Node