public class Sorting271 {

/**
 * takes two integer sorted arrays called left and right respectively and merges them into a single sorted array.
 * 
 */

 public int[] merge(int[] left, int[] right){
    /**
     * I created and initialized all my variables 
     */
    //tracks the index when right is added to merged array
    int count = 0;
    //stores the value of merge[i]
    int current = 0;
    //stores the value of merge[j]
    int other = 0;
    //create an array that is the length of both parameters combined
    int [] merged = new int[left.length + right.length];
    //check to see if arrays are null
    if (left != null && right != null){
      //traverse through left and add the values to merged
      for(int i = 0; i <= left.length; i++){
          merged[i] = left[i];
      }
      //traverses through right and add the valued to merged starting at the
      //index where left stopped
      for(int i = left.length + 1; i <= right.length; i++){
        merged[i] = right[count];
        count++;
      } 
      //traverses through merge and compare each value at merge[i] to every 
      //other value in the array
      for(int i = 0; i <= merged.length;i++){
        //store the int at merge[i]
        current = merged[i];
        /**
         * traverses through merge and compares current to every other value 
         * (which is stoed in other) and if current is greater than merge
         * the two ints swap locations in the array since the greater value should 
         * be further down the array
         */
        for(int j = 0; j <= merged.length; j++){
            other = merged[j];
            if( current > merged[i]){
                merged[i] = other;
                merged[j] = current;
            }
          } 
       }
    }
    return merged;
}

}//class Sorting271
