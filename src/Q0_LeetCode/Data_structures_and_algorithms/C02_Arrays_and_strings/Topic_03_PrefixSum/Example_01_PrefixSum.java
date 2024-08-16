package Q0_LeetCode.Data_structures_and_algorithms.C02_Arrays_and_strings.Topic_03_PrefixSum;

import java.util.Arrays;

/**
TODO: Example 01: Prefix Sum
 Given an integer array, create a prefix sum array of it.

For Example,
Input: numbers = [3 6 2 8 1 4 1 5].
Output: prefixSumArray = [3 9 11 19 20 24 25 30]

Explanation: In a prefix sum array each current index integer value will be the sum of that number and all the previous.
index(0) of prefix array is 3 + 0 ( as there is no prefix to it ) = 3.
index(1) of prefix array is 6 ( value of index(1) ) + 3 ( value of prefix index(0) ) = 9.
index(2) of the prefix array is 3 ( value of index(0) ) + 6 ( value of index(1) ) + 2 ( value of index(2) ) = 11...
 */
public class Example_01_PrefixSum {

    // Class Variable(s)
    static final int[] numbers = {3,6,2,8,1,4,1,5};

    /**
     * Main Method: Executes the function getPrefixSumArray().
     * Time Complexity : BigO (n)
     * @param args : Main method argument
     */
    public static void main(String[] args) {
        int[] finalResult = getPrefixSumArray( numbers );
        System.out.println( "Numbers   Array: " + Arrays.toString( numbers ) );
        System.out.println( "PrefixSum Array: " + Arrays.toString( finalResult ) );
    }

    /**
        TODO SUDO CODE
        1. FOR-LOOP - To iterate through each element of the numbers array.
            1.1: Calculate the prefix sum.
            1.2: Add the current prefixSum to the respective index of the prefixSumArray.
        2. Return the prefixSumArray.
     * @param numbers : An array of integers ( can be positive or negative numbers ).
     * @return Will return an array ( Prefix Sum Array ).
     */
    public static int[] getPrefixSumArray( int[] numbers ){

        // Method Variable(s)
        int[] prefixSumArray = new int[ numbers.length ];
        int currentPrefixSum = 0;

        // FOR LOOP to construct the prefixSumArray.
        for( int itrIndex = 0; itrIndex < numbers.length; itrIndex ++){
            currentPrefixSum += numbers[ itrIndex ];
            prefixSumArray[ itrIndex ] = currentPrefixSum;
        }

        // Total Time Complexity = O(n).
        return prefixSumArray;
    }
}
