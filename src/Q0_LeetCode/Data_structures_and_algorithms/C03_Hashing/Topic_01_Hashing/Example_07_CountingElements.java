package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr.
 *  If there are duplicates in arr, count them separately.
 *
 *  Example: Given an array [ 1, 2, 3 ]
 *  1 + 1 = 2, which is in the given array hence increment count by one.
 *  2 + 1 = 3, which is in the given array hence increment count by one.
 *  3 + 1 = 4, which is not in the given array hence return the count.
 */
public class Example_07_CountingElements {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 2, 2};
        int finalResult = checkSequentialCountOfElements( numbers );
        System.out.println( finalResult );
    }

    /**
     * This method will return a count of how many elements are there in a given array, such that the element + 1
     * is also there in the array.
     * @return : int, this int will be the count of sequential numbers
     */
    public static int checkSequentialCountOfElements( int[] numbers ) {

        // Method Variable(s):
        int finalCount = 0;
        Set<Integer> uniqueNumbers = new HashSet<>( );

        // FOR-LOOP: Loop to insert all elements from given ARRAY to SET
        for( int eachNumber : numbers ){
            uniqueNumbers.add( eachNumber );
        }

        // FOR-LOOP: Loop to compute sequential sum on each element of the given array.
        for ( int eachElement : numbers ){
            int tempSum = eachElement + 1;
            if( uniqueNumbers.contains( tempSum ) ) {
                finalCount ++;
            }
        }

        // Return final result
        return finalCount;
    }
}
