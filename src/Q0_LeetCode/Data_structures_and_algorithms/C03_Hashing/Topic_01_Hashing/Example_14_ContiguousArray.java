package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.HashMap;

/**
 * TODO Given a binary array numbers, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 * Example
 *  Input: nums = [0,1]
 *  Output: 2
 *  Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 *
 *  TODO MORE ABOUT THE PROBLEM
 *   let's say we have an array of 3 elements ( only ZEROS and ONES ) { 1, 0, 1 }.
 *   The longest sub array with equal number of ZEROS and ONES, are:
 *      1. 1 and 0 of index ZERO and ONE respectively.
 *      2. 0 and 1 of index ZERO and ONE respectively.
*    return 2 as the final result.
 */

/**
*             Index (0) (1) (2) (3) (4) (5) (6) (7) (8)
 *  Example: Array [ 1,  1,  0,  0,  1,  1,  0,  1,  1 ]
 *
 *  Iterate the given array, if you encounter ONE add 1 to sum, if it is ZERO subtract 1 from the sum.
 *  We will be using the SUM ( HashMap ) to find the longest sum array.
 *
 *  When the sum is ZERO : the longest sub array with equal number of 0's and 1's will start from index(0) to current index position.
 *  To calculate the length of the sub array ( current index value - index value where it 1st occurred ).
 *
 *  When the sum value occur again : That means, the sub array sum between these occurrence is zero.
 *  Ie, sub-array starting at index(2) and index(3) will have sum as zero, meaning equal number of 0's and 1's.
 *
 *  Everytime we calculate the sum, check the map's key-set contains the sum?
 *  If no, add the sum and its index position to the map.
 *  If yes, it means we have equal number of 1's and 0's in-between.
 *  Longest Sub Array = Current Index - index where it 1st occurred.
 */
public class Example_14_ContiguousArray {

    public static void main(String[] args) {

        // Method Variable(s):
        int[] originalArray = { 1,1,0,0,1,1,0,1,1 };

        int finalResult = secondWay( originalArray );
        System.out.println( finalResult );

    }

    public static int secondWay( int[] originalArray ){

        // Method Variable(s):
        HashMap<Integer,Integer> sumMapping = new HashMap<>(); // Key -> accumulatedSum, value -> currentIndexPosition
        sumMapping.put(0,-1);
        int maxLength = 0;
        int currentSum = 0;

        for ( int index = 0; index < originalArray.length; index ++ ){

            // Update currentSum: Convert 0 to -1
            currentSum += ( originalArray[index] == 0 ) ? -1 : 1;

            // If the currentSum has been seen before, calculate the subArray length
            if ( sumMapping.containsKey( currentSum ) ) {
                // The length of the subarray is the difference in indices
                maxLength = Math.max( maxLength, index - sumMapping.get(currentSum) );
            } else {
                // If currentSum was not seen, store it to the map.
                sumMapping.put(currentSum, index);
            }
        }

        return maxLength;

    }

}
