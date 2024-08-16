package Q0_LeetCode.Data_structures_and_algorithms.C02_Arrays_and_strings.Topic_02_SlidingWindow;

/**
 TODO Example 01: Length of Longest Subarray.
  Given an array of positive integers and an integer k, find the length of the longest sub-array whose sum is less than
  or equal to k.

 For Example,
 Input: numbers = [3, 1, 2, 7, 4, 2, 1, 1, 5] and k = 8
 Output: 4

 Explanation: The window starts empty, but we can grow it to [3, 1, 2] while maintaining the constraint. However, after
 adding the 7, the window's sum becomes too large. We need to tighten the window until the sum is below 8 again, which
 doesn't happen until our window looks like [7]. When we try to add the next element, our window again becomes too large,
 and we need to remove the 7 which means we have [4]. We can now grow the window until it looks like [4, 2, 1, 1], but
 adding the next element makes the sum too large. We remove elements from the left until it fits the constraint again,
 which happens at [1, 1, 5]. The longest subarray we found was [4, 2, 1, 1] which means the answer is 4.
 */
public class Example_01_MaximumConsecutiveOnesSubstring {

    // Class Variable(s)
    static int[] numbers = {3, 1, 2, 7, 4, 2, 1, 1, 5};
    static int maxPossibleSumLimit = 8;

    public static void main(String[] args) {

        int finalAnswer = getLengthOfLongestSubArray( numbers, maxPossibleSumLimit );
        System.out.println( finalAnswer );

    }

    /**
        TODO SUDO CODE
        1. Keep track of rightBound, leftBound.
        2. FOR-LOOP to move rightBound on each iteration, to increase the window size.
            On Each Iteration,
            2.1: Read the element from numbers[ rightBound ], add it to currentSum.
            2.2: WHILE-LOOP ( currentSum > maxSum ) - we need to readjust the window size.
                2.2.1: Read the element from numbers[ leftBound ] and reduce it from the currentSum.
                2.2.2: Increment leftBound.
        3. Calculate the maximum possible length of the subarray.
        4. Return the value.
     * @param numbers: An array of random positive integers.
     * @param maxPossibleSumLimit: An integer representing max sum limit,
     * @return This method returns an integer, which is the longest possible subarray.
     */
    public static int getLengthOfLongestSubArray( int[] numbers, int maxPossibleSumLimit ) {

        // Method Variable(s)
        int leftBound = 0;
        int rightBound;
        int currentWindowElementsSum = 0;
        int lengthOfLongestSubarray = 0;

        for( rightBound= 0; rightBound < numbers.length; rightBound++ ){

            currentWindowElementsSum += numbers[rightBound];

            while ( currentWindowElementsSum > maxPossibleSumLimit ){
                currentWindowElementsSum -= numbers[leftBound];
                leftBound ++;
            }

            lengthOfLongestSubarray = Math.max( lengthOfLongestSubarray, (rightBound - leftBound) + 1 ) ;
        }

        return lengthOfLongestSubarray;
    }
}
