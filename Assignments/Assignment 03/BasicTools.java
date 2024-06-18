/**
 * This interface specifies a few key behaviors for every DynamicArray
 * object.
 */
public interface BasicTools {


    /**
     * Determines if this DynamicArray intersects the specified DynamicArray (other).
     *
     * @param other DynamicArray to determine if it intersects with this object
     * @return true if two DynamicArrays have a common entry; false otherwise.
     *
     * To see if there is a common entry, each element in the arrays must be compared
     * to one another to see if they are equal
     *
     * Use a while loop to traverse the object array and end the loop
     * when a match is found or when the entire array is traversed
     *    while ( some boolean is false && i<this.position) {
     *       do something that returns boolean as true or false;
     *       i++;
     *     }
     *  
     * Use method contains to see if other[i] is in this object
     *     this.contains(other[i])
     * if contains returns true then intersects returns true
     */
    public boolean intersects(DynamicArray other){
        boolean match = false;
        int i = 0;
        while (match == false && i < this.position){
            match = this.contains(other[i]);
            i++;
        }
        return match;
    }
}
