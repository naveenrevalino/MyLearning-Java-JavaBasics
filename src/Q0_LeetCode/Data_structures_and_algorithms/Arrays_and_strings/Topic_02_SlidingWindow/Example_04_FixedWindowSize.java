package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_SlidingWindow;

/*
TODO Example 04:
 Given an integer array and an integer k, find the sum of the subarray with the largest sum whose length is k.

 For Example, Integer array = [ 3, -1, 4, 12, -8, 5, 6 ] and k = 4, the subarray with the largest will be
 [ 3, -1, 4, 12 ] = 18.

 HINT: This is easier than the dynamically changing sliding window like in Example 01, 02, and 03. The window we have is
 of a fixed length and we slide it over the given array.
 */
public class Example_04_FixedWindowSize {

    // Class Variable(s)
    static int[] numbers = new int[] {3, -1, 4, 12, -8, 5, 6};
    static int fixedWindowSize = 4;

    public static void main(String[] args) {

        int finalResult = getLargestSumOfSubarray( numbers, fixedWindowSize );
        System.out.println( finalResult );

    }

    public static int getLargestSumOfSubarray( int[] numbers, int fixedWindowSize ) {

        /*
        Sudo Code Steps

        set the fixed window over the array, the leftBound is at index 0 and the rightBound is at index 3. This can be
        done using a for loop, iterate through the window and calculate the sum and save it to currentSum variable.

        use a second for loop to move the window over the array to get other possible subarrays and calculate their sum.
        To calculate the new sum of the subarray, use the below logic:

        1 : [3, -1, 4, 12, -8, 5, 6] : The window of length 4 will start from index(0) to index(3).
        The sum of this subarray will be 3 + (-1) + 4 + 12 = 18.
        2: [3, -1, 4, 12, -8, 5, 6] : The window of length 4 will start from index(1) to index(4).
        The sum of this subarray will be (-1) + 4 + 12 + (-8) = 7.
        An alternate way to fid the sum of the second subarray is to -3 the element at index(0) and then add (-8) the
        element at index(4) to the previous total of 18.
        */

        // Method Variable(s)
        int currentSum = 0;
        int highestSum = 0;

        // This loop will give you the sum of all the elements within the window of length 4 starting from index 0.
        for( int i = 0; i < fixedWindowSize; i++ ) {
            currentSum += numbers[i];
        }

        // This loop is to move the window over the array till the end of it, and recalculate the sum each time.
        for( int j = fixedWindowSize; j < numbers.length; j++ ){
            // CurrentSum = CurrentSum + element at index(4) - element at index(4-4)
            // CurrentSum = CurrentSum + element at index(5) - element at index(5-4) and so on till end of the array.
            currentSum += numbers[j] - numbers[j-fixedWindowSize];

            // Save the highest sum to a local variable
            highestSum = Math.max( highestSum, currentSum );
        }

        return 0;
    }
}
