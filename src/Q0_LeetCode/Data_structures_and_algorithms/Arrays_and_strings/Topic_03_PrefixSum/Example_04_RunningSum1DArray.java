package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_03_PrefixSum;

import java.util.Arrays;

/*
    TODO: Example 04: Running Sum of 1D Array.
     Given an array. We define a running sum of an array as runningSum[i] = sum(index[0]…index[i]). Return the running sum array.

     For Example.
     Input: numbers = [1,2,3,4]
     Output: [1,3,6,10]
     Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */
public class Example_04_RunningSum1DArray {

    // Class Variable(s):
    static int[] numbers= new int[] { 1, 2, 3, 4};

    /**
     * Main Method : Executes the function getRunningSumArray().
     * Time Complexity : BigO (n)
     * @param args : Main method argument
     */
    public static void main(String[] args) {
        int[] finalResult = getRunningSumArray( numbers );
        System.out.println(Arrays.toString( finalResult ));
    }

    /**
     TODO SUDO CODE
     1. FOR-LOOP - To iterate through each element of the numbers array.
        1.1: Calculate the prefix/running sum.
        1.2: Add the current prefix/running sum to the respective index of the runningSumArray.
     2. Return the runningSumArray.
     * @param numbers : An array of integers ( can be positive or negative numbers ).
     * @return Will return an array ( Running Sum Array ).
     */
    public static int[] getRunningSumArray( int[] numbers){

        // Method Variable(s)
        int[] runningSumArray = new int[ numbers.length ];
        int currentRunningSum = 0;

        // FOR LOOP to construct the runningSumArray.
        for( int itrIndex = 0; itrIndex < numbers.length; itrIndex ++){
            currentRunningSum += numbers[ itrIndex ];
            runningSumArray[ itrIndex ] = currentRunningSum;
        }

        // Total Time Complexity = O(n).
        return runningSumArray;
    }
}
