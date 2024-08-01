package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_SlidingWindow;

/*
TODO Example 04:
 Given an integer array and an integer k, find the sum of the subarray with the largest sum whose length is k.

 For Example,
Input numbers = [ 3, -1, 4, 12, -8, 5, 6 ] and fixedWindowSize(K) = 4.
Output: the subarray with the largest will be [ 3, -1, 4, 12 ] = 18.

HINT: This is easier than the dynamically changing sliding window like in Example 01, 02, and 03. The window we have is
of a fixed length and we slide it over the given array.

Set the fixed window over the array, leftBound index( 0 ) and rightBound index( 3 ). Use a for loop, Iterate through the
window elements and calculate the sum by adding each element and save it to currentSum variable. Use a second for loop to
move the window over the array to get other possible subarrays and calculate their sum.

To calculate the new sum of the subarray, use the below logic:

1 : [3, -1, 4, 12, -8, 5, 6] : The window of length 4 will start from index(0) to index(3).
The sum of this subarray will be 3 + (-1) + 4 + 12 = 18.
2: [3, -1, 4, 12, -8, 5, 6] : The window of length 4 will start from index(1) to index(4).
The sum of this subarray will be (-1) + 4 + 12 + (-8) = 7.
An alternate way to fid the sum of the second subarray is to -3 the element at index(0) and then add (-8) the
element at index(4) to the previous total of 18.
*/
public class Example_04_FixedWindowSize {

    // Class Variable(s)
    static int[] numbers = new int[] {3, -1, 4, 12, -8, 5, 6};
    static int fixedWindowSize = 4;

    public static void main(String[] args) {

        int finalResult = getLargestSumOfSubarray( numbers, fixedWindowSize );
        System.out.println( finalResult );

    }

    /**
        TODO Sudo Code
        1. keep track of leftBound and rightBound
        2. FOR-LOOP to define the fixed subarray window of given fixedWindowSize starting from index( 0 ).
            On each iteration,
            2.1: read each element and add them all and save it to a variable ( currentSum ).
        3. FOR-LOOP to slide the fixed window over the span of given array.
            On each iteration,
            3.1: Re-calculate the currentSum.
                 CurrentSum = CurrentSum + element at index(4) - element at index(4-4).
                 CurrentSum = CurrentSum + element at index(5) - element at index(5-4) and so on till end of the array.
         4. Maintain track of the highest sum and save it to a variable ( highestSum ).
         5. Return the value.
     * @param numbers : An integer array with positive and negative numbers.
     * @param fixedWindowSize : An integer representing fixed window size.
     * @return An integer, which is the largest sum ( of all elements ) of all possible subarrays
     */
    public static int getLargestSumOfSubarray( int[] numbers, int fixedWindowSize ) {

        // Method Variable(s)
        int currentSum = 0;
        int highestSum = 0;

        for( int i = 0; i < fixedWindowSize; i++ ) {
            currentSum += numbers[i];
        }

        for( int j = fixedWindowSize; j < numbers.length; j++ ){

            currentSum += numbers[j] - numbers[j-fixedWindowSize];

            highestSum = Math.max( highestSum, currentSum );
        }

        return highestSum;
    }
}
