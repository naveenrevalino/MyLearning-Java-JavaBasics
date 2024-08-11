package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_03_PrefixSum;


import java.util.Arrays;

/**
    TODO Example 02: Query Based Boolean Array.
     Given an integer array NUMBERS[], an array QUERIES[] where queries[i] = [x, y] and an integer limit.
     Return a boolean array that represents the answer to each query. A query is true if the sum of the subarray
     from x to y is less than limit, or false otherwise.

For example,
Input: numbers array = [1, 6, 3, 2, 7, 2],
Input: queries array = [[0, 3], [2, 5], [2, 4]],
Input: and limit = 13

Output: [true, false, true]

Explanation:
Given numbers array is = [1, 6, 3, 2, 7, 2], the queries array = [[0, 3], [2, 5], [2, 4]], and the limit = 13.
Compute the elements of the PrefixSumArray [ 1, 7, 10, 12, 19, 21] by iterating through the numbers array.
Compute the sum of each subarray defined in the two dimensional queries array. For Example, the first subarray mentioned
in the queries array is queriesArray[0, 0] = 0 and queriesArray[0, 1] = 3.
Hence my leftBound = 0 and rightBound = 3.

 The syntax/formula to calculate the sum of a subarray using a prefixSumArray is:
 ( PrefixSumArray[ leftBound ] - PrefixSumArray[ rightBound ] ) + numbers[ leftBound ]


 */
public class Example_02_QueryBasedBooleanArray {

    // Class Variable(s)
    static int[] numbers = {1, 6, 3, 2, 7, 2};
    static int[][] queries = { {0, 3}, {2, 5}, {2, 4} };
    static int limit = 13;

    /**
     * Main Method: Executes the function getTheRespectiveBooleanArray().
     * Time Complexity : BigO (n).
     * @param args Main method arguments.
     */
    public static void main(String[] args) {
        boolean[] finalResult = getTheRespectiveBooleanArray( numbers, queries, limit );
        System.out.println( Arrays.toString( finalResult ));
    }

    /**
        TODO SUDO CODE
        1. FOR-LOOP - To iterate through each element of the queries array ( 2D Array ).
            1.1: Get the range( right and left bound ) of the sub array from the queries array.
            1.2: Calculate the sum of all elements of the subarray.
            1.3: Assign the result of the condition check as each element of the booleanArray.
                 Check If ( currentSubarraySum < limit ), the result of this will be either TRUE / FALSE.
                 Set this result as the element of the respective index of the boolean array.
        2. Return the boolean array( booleanArray ).
     * @param numbers : An array of integers ( can be positive or negative numbers ).
     * @param queries : A 2D array, which specifies the rage of each sub array for which the sum has to be calculated.
     * @param limit : An integer, which specifies the maximum possible value, against which we compare the subarray sum.
     * @return Will return an array of type boolean.
     */
    public static boolean[] getTheRespectiveBooleanArray( int[] numbers, int[][] queries, int limit ){

        // Method Variable(s)
        boolean[] booleanArray = new boolean[ queries.length ];
        int[] prefixSumArray = getPrefixSumArray( numbers );

        // FOR-LOOP : To iterate through each element of the queries array ( 2D Array ).
        for( int itrIndex1 = 0; itrIndex1 < queries.length; itrIndex1 ++ ){

            int leftBound = queries[itrIndex1][0];
            int rightBound = queries[itrIndex1][1];
            int currentSubarraySum = ( prefixSumArray[rightBound] - prefixSumArray[leftBound] ) + numbers[leftBound];
            booleanArray[itrIndex1] = currentSubarraySum < limit;
        }

        // Total Time Complexity = O(n).
        return booleanArray;
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
    public static int[] getPrefixSumArray( int[] numbers){

        // Method Variable(s).
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
