package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_SlidingWindow;

/*
TODO Example 1: Given an array of positive integers and an integer k, find the length of the longest sub-array whose
 sum is less than or equal to k.
 */
public class Example_01_LengthOfLongestSubarray {

    // Class Variable(s)
    static int[] numbers = {3, 1, 2, 7, 4, 2, 1, 1, 5};
    static int maxSum = 8;
    static int currentSum = 0;
    static int subArrayLength = 0;
    static int leftBound = 0;

    public static void main(String[] args) {

        int finalAnswer = getLengthOfLongestSubArray( numbers );
        System.out.println( finalAnswer );

    }

    public static int getLengthOfLongestSubArray( int[] numbers ) {

        // Always increment the rightBound value using the below for loop, thereby increasing the window size.
        for( int rightBound = 0; rightBound < numbers.length; rightBound++ ){

            // read the first element from the array and add it to currentSum.
            currentSum += numbers[rightBound];

            // using a while loop, check if the current sum is greater than maxSum.
            while ( currentSum > maxSum ){
                // Minus the leftBound value from currentSum and increment leftBound, thereby shrinking the window size.
                currentSum -= numbers[leftBound];
                leftBound ++;
            }

            // The Math.max function is used to save the length of the longest sub-array whose sum is <= k.
            subArrayLength = Math.max( subArrayLength, (rightBound - leftBound) + 1 ) ;
        }


        return subArrayLength;
    }
}
