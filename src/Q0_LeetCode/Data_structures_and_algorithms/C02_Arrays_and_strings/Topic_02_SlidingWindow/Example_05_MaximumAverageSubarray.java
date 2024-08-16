package Q0_LeetCode.Data_structures_and_algorithms.C02_Arrays_and_strings.Topic_02_SlidingWindow;

/**
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

    /**
        TODO SUDO CODE
        1. FOR-LOOP - To build a subarray from index(0) up to index( fixed window size -1 )
            On Each Iteration,
            1.1: Add each element in the subarray, save the total sum to currentSum.
        2. Calculate the average of the sum and save it to currentAverage variable.
        3. FOR-LOOP - To slide the fixed window over the original array to find all other subarrays.
                      This loop will start from the next index position, which is the value of fixedWindowSize variable.
            3.1: Calculate the sum of all elements of this new subarray / window, There is an easy way to do this.

                 Imagine given array is : [ 1 2 3 4 5 6 7 8 ], and the first subarray starts from index(0) till index(3).
                 Then Sum = 1 + 2 + 3 + 4 = 10.
                 Now we are moving the window, the new subarray will start from index(1) and end at index(4).
                 Then Sum = 2 + 3 + 4 + 5 = 14.

                 the common element between the first subarray and the second subarray are 2, 3, and 4, the elements that
                 changed are 1, which was removed and 5 was added, hence from the previous subarray Sum 10, reduce 1, and
                 add 5 to get the new sum 10 -1 + 5 = 14.
            3.2: Calculate the new average, keep track of the highest average.
        4. Return the highest average.
     *
     * @param numbers : An integer array ( with positive and negative numbers )
     * @param fixedWindowSize : An integer denoting the fixed window / subarray size.
     * @return An integer, which is the Maximum average value of a contiguous subarray whose length is equal to fixedWindowSize( K ).
     */
    public static double getMaximumAverage( int[] numbers, int fixedWindowSize ){

        // Method Variable(s)
        double currentSum = 0.00;
        double currentAverage;

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
