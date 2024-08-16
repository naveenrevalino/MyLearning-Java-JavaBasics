package Q0_LeetCode.Data_structures_and_algorithms.C02_Arrays_and_strings.Topic_03_PrefixSum;

/*
    TODO: Example 05: Minimum Value To Get Positive Step By Step Sum.
     Given an array of integers, you start with an initial positive value startValue.
     In each iteration, you calculate the step by step sum of startValue plus elements in array (from left to right).
     Return the minimum positive value of startValue such that the step by step sum is never less than 1.

     For Example,
     Input: numbers = [-3,2,-3,4,2]
     Output: 5

     Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.

    step by step sum
    startValue = 4 | startValue = 5 | numbers[]
      (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
      (1 +2 ) = 3  | (2 +2 ) = 4    |   2
      (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
      (0 +4 ) = 4  | (1 +4 ) = 5    |   4
      (4 +2 ) = 6  | (5 +2 ) = 7    |   2

      Overview,
      In this problem, we are given an integer array numbers. Then we pick a positive value (let's call it startValue) and
      iterate over numbers. In the iteration, we calculate the step-by-step total of this startValue plus the value of each
      elements in numbers. Since there the array might contain negative values, it is possible for the total to become less
      than 1. However, if we select a sufficiently large startValue, we can ensure the step-by-step total will never be
      less than 1. For this problem, a startValue is valid if it makes the step-by-step total always remain positive.
      Otherwise, the startValue is invalid.
      Here, our task is to find the minimum valid startValue.
 */
public class Example_05_MinimumValueToGetPositive {

    // Class Variable(s):
    static int [] numbers = { -3, 2, -3, 4, 2 };
    static int neverLessThan = 1;

    /**
     * Main Method : Executes the function getSmallestPositiveStartValue().
     * Time Complexity : BigO (n)
     * @param args : Main method argument
     */
    public static void main(String[] args) {

        int finalResult = getSmallestPositiveStartValue( numbers, neverLessThan );
        System.out.println( finalResult );

    }

    /*
        TODO SUDO CODE
        1. Get the smallest prefix sum from the prefixSumArray by calling the method getSmallestPrefixSum().
        2. Using the smallest prefix sum calculate the smallest positive start value.
        3. Return the calculated value.
     */
    public static int getSmallestPositiveStartValue( int[] numbers, int neverLessThan ){

        int smallestPrefixSum = getSmallestPrefixSum( numbers );
        return Math.abs( smallestPrefixSum ) + neverLessThan;
    }

    /**
     TODO SUDO CODE
     1. FOR-LOOP - To iterate through each element of the numbers array.
     1.1: Calculate the smallest prefix sum.
     2. Return the SmallestPrefixSum.
     * @param numbers : An array of integers ( can be positive or negative numbers ).
     * @return Will return an integer ( Smallest Prefix Sum ).
     */
    public static int getSmallestPrefixSum( int[] numbers ){

        // Method Variable(s)
        int currentPrefixSum = 0;
        int smallestPrefixSum = 0;

        // FOR LOOP to construct the prefixSumArray.
        for( int eachElement : numbers ){
            currentPrefixSum += eachElement;
            smallestPrefixSum = Math.min( smallestPrefixSum, currentPrefixSum );
        }

        // Total Time Complexity = O(n).
        return smallestPrefixSum;
    }


}
