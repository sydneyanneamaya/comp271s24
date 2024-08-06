public class Sorting271 {

/**
 * takes two integer sorted arrays called left and right respectively and merges them into a single sorted array.
 * 
 */

 public static int[] merge(int[] left, int[] right){
    /**
     * I created and initialized all my variables 
     */
    //tracks the index when right is added to merged array
    int count = left.length;
    //stores the value of merge[i]
    int current = 0;
    //create an array that is the length of both parameters combined
    int [] merged = new int[left.length + right.length];
    //check to see if arrays are null
    if (left != null && right != null){
      //traverse through left and add the values to merged
      for(int i = 0; i <= left.length -1; i++){
          merged[i] = left[i];
      }
      //traverses through right and add the valued to merged starting at the
      //index where left stopped
      for(int i = 0; i <= right.length -1; i++){
        merged[count] = right[i];
        count++;
      } 
      //traverses through merge and compare each value at merge[i] to every 
      //other value in the array
      for(int i = 0; i <= merged.length -1;i++){
        //store the int at merge[i]
        /**
         * traverses through merge and compares i to every other value 
         * and if the value at index[i] is greater than index[j] 
         * the two ints swap locations in the array since the greater value should 
         * be further down the array
         */
        //start at i + 1 so the loop do not start at the same location
        //also starting at i + 1 assumes the indexes before i are already sorted 
        for(int j = i + 1; j < merged.length; j++){
          //store value of current i 
          current = merged[i];
          //if the int at the index before i is less than current than the two ints
          //swap locations in the array
            if( merged[j] < merged[i]){
                merged[i] = merged[j];
                merged[j] = current;
            }
          } 
        }
      }
    return merged;
  }


/**
 * Write a method int[] sort(int[] array) that takes an integer array with 2n
 * elements and sorts it in ascending order, by using the technique described above. 
 */
public static int[] sort(int[] array){
  //create int arrays to store values
  int [] newArray = new int[array.length];
  //stores first half of parameter array
  int [] one = new int[array.length / 2];
  //stores second half of parameter array 
  int [] two = new int[array.length / 2];
  //iterates through first half of array and stores those elements
  for (int i = 0; i < array.length / 2; i++){
    one[i] = array[i];
  }
  //iterates through second half of array and stores those elements
  for (int i = array.length / 2; i <= array.length - 1; i++){
    two[i - 2] = array[i];
  }
  //puts both arrays in numerical order
  newArray = merge(one, two);
  return newArray;
}

public static void main(String [] args){
  int[] a = {1,2,8,9}; 
  int [] b = {0,5,6,7};
  int [] c = merge(a,b);
  for (int i = 0; i <= c.length -1;i++){
    System.out.print(c[i] + ",");
  }
  System.out.println();
  int [] d = {10,8,5,3};
  int [] e = sort(d);
  for (int i = 0; i <= e.length -1;i++){
    System.out.print(e[i] + ",");
  }
  System.out.println();
 }

}//class Sorting271

