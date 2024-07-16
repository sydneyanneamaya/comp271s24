
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    public boolean add(String s){
        int capacity = this.findCapacity();;
        Node nextNode = findNextspot();
        boolean isThereRoom = (this.usage < capacity);
        if(isThereRoom){
            nextNode.data(s);
            usage++;
        }
        return isThereRoom;
    }

    public int findCapacity(){
        currentNode = this.head;
        int capacity = 1;
        while (currentNode.hasNext()){
            capacity++;
            currentNode = currentNode.getNext;
        }
        return capacity;
    }

    public Node findNextSpot(){
        Node currentNode = this.head;
        String data = currentNode.toString();
        while (!data.equals(null)){
            currentNode = currentNode.getNext();
        }
        return currentNode.getNext();
    }


} // class SimpleLinkedList
