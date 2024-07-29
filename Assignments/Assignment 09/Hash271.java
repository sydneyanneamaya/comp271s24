public class Hash271 {

    /** Default size for foundation array */
    private static final int DEFAULT_SIZE = 4;

    /**number of nodes in the array */
    private int numberOfNodes;

    /** Foundation array of node objects */
    Node[] foundation;

    /** Basic constructor */
    public Hash271(int size) {
        this.foundation = new Node[size];
        this.numberOfNodes = 0;
    } // basic constructor

    /** Default constructor */
    public Hash271() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Map an integer number to one of the positions of the underlying array. This
     * will come handy we need to find the place to chain a node.
     * 
     * @param value int to map to one of the array positions
     * @return int with the integer division remainder between the input value and
     *         the length of the array
     */
    private int computeArrayPosition(int value) {
        return value % this.foundation.length;
    } // method computeArrayPosition

    /**
     * Chain a node to the underlying array
     * 
     * @param node Node to chain to the underlying array
     */
    public void put(Node node) {
        // Operate only is node is not null
        if (node != null) {
            // Use the node's hashcode to determine is position in
            // the underlying array
            int destination = computeArrayPosition(node.hashCode());
            // If the position in the array is occupied by another node,
            // place that node under the new node we wish to insert
            if (this.foundation[destination] != null) {
                node.setNext(this.foundation[destination]);
            }
            // Put the new node to the array position
            this.foundation[destination] = node;
            //update numberOfNodes since a new node was added
            this.numberOfNodes++;
            //check to see if loadfactor is over %75 anf if it is rehash
            if(this.getLoadFactor() >= .75){
                rehash();
            }
        }
    } // method put

    /**
     * Wrapper for put(Node). Accepts a string, creates a Node object and passes it
     * to the put(Node) method.
     * 
     * @param string String to create a node for, then chain that node to the
     *               underlying array.
     */
    public void put(String string) {
        if (string != null && string.length() > 0) {
            Node node = new Node(string);
            this.put(node);
        }
    } // method put

    /** String representation of this object */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.foundation.length; i++) {
            sb.append(String.format("[ %03d ]: ", i));
            Node current = this.foundation[i];
            while (current != null) {
                sb.append(String.format("<%s> ", current.toString()));
                current = current.getNext();
            }
            sb.append("\n");
        }
        return sb.toString();
    } // method toString

    /**
     * rehashes the array when loadfactor is over 75%
     */

    private void rehash(){
        //create node variable
        Node nodeAtIndex;
        //double the length of the foundation
        this.foundation = new Node[this.foundation.length*2];
        //use a for looop to traverse the first half of the foundation
        //since there will be no nodes in the second half because
        //they haven't been repositioned yet
        for (int i = 0; i < this.foundation.length / 2; i++){
            //check to see if there are any nodes at the index
            if(this.foundation[i] != null){
                //if there is a node set the first node to nodeAtIndex
                nodeAtIndex = this.foundation[i];
                //use a while loop to traverse linked list at the index
                while(nodeAtIndex != null){
                    //call put method to put node at its index based off new 
                    //length of array
                    put(nodeAtIndex);
                    //set nodeAtIndex as next node in list, if it is null then 
                    //then while loop will end
                    nodeAtIndex = nodeAtIndex.getNext();
                }
            }
            //update index
            i++;
        }
    }//rehash()

    /**
     * accessor method 
     * returns the number of nodes in the array
     */
    public int getNumberOfNodes(){
        return this.numberOfNodes;
    }//getNumberOfNodes

    /**
     * finds load factor by dividing the number of node by the array length
     * and returns a double
     * 
     */
    public double getLoadFactor(){
        return (double) numberOfNodes/this.foundation.length;
    }//getLoadFactor

    /** Driver code */
    public static void main(String[] args) {
        Hash271 h = new Hash271();
        h.put(new Node("Java"));
        h.put(new Node("Python"));
        h.put(new Node("Lisp"));
        h.put(new Node("Fortran"));
        h.put(new Node("Prolog"));
        h.put(new Node("Cobol"));
        h.put(new Node("C++"));
        h.put(new Node("C"));
        h.put(new Node("C#"));
        System.out.println(h);
    }
}
