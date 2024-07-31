package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_SlidingWindow;

/*
TODO: Example 05: Maximum Average Subarray I
 You are given an integer array consisting of n elements, and an integer k.
 Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.

For Example,
Input: numbers = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */
public class Example_05_MaximumAverageSubarray {

    // Class Variable(S)
    static int[] numbers =  new int[] { 1,12,-5,-6,50,3 };
    static int fixedWindowSize = 4;

    public static void main(String[] args) {
        double finalResult = getMaximumAverage( numbers, fixedWindowSize );
        System.out.println( finalResult );
    }

    public static double getMaximumAverage( int[] numbers, int fixedWindowSize ){

        /*
        SUDO CODE
        1. Using a FOR-LOOP generate the fixed window , inside calculate sum of all elements.
        2. Calculate the average by dividing the sum by the fixedWindowSize.
        3. Using a FOR-LOOP slide the fixed window over the array to find sum and average of each possible subarray.
        4. Return the maximumAverage.
         */

        // Method Variable(s)
        double currentSum = 0.00;
        double currentAverage = 0.00;

        for( int rightBound = 0; rightBound < fixedWindowSize; rightBound ++ ){
            currentSum += numbers[rightBound];
        }

        currentAverage = currentSum / fixedWindowSize;

        for( int leftBound = fixedWindowSize; leftBound < numbers.length; leftBound ++){
            currentSum += numbers[leftBound] - numbers[ leftBound - fixedWindowSize ];
            currentAverage = Math.max( currentAverage, currentSum / fixedWindowSize );
        }


        return currentAverage;
    }
}
