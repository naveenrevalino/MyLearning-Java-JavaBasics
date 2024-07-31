package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_SlidingWindow;

/*
TODO: Example 06:
 Given a binary array and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

For Example,

Input: numbers = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Input: numbers = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

 */
public class Example_06_MaximumConsecutiveOnesIII {

    // Class Variable(s)
    static int[] numbers = {1,1,1,0,0,0,1,1,1,1,0};
    static int flipAtMost = 2;

    public static void main(String[] args) {
        int maxNumberOfConsecutive1S = getMaxNumberOfConsecutive1S( numbers, flipAtMost );
        System.out.println( maxNumberOfConsecutive1S );
    }

    public static int getMaxNumberOfConsecutive1S( int[] numbers, int flipAtMost ){

        /** SUDO CODE
        1. keep track of leftBound and rightBound
        2. Have a For-LOOP to keep moving the RightBound on each iteration
            On each iteration,
            2.1: IF block( numbers(rightBound) == 0 ) - increment count ( countOfZeros ++ ).
            2.2: While-LOOP ( countOfZeros > 2 ).
                2.2.1: IF block ( numbers(leftBound) == 0 ) - decrement count ( countOfZeros -- )
                2.2.1: Increment leftBound.
        3. Calculate the max number of consecutive one's.
        4. Return the value.
         */

        // Method Variable(s)
        int leftBound = 0;
        int rightBound;
        int numberOfZerosInTheWindow = 0;
        int maxNumberOfConsecutiveOnes = 0;

        for( rightBound = 0; rightBound < numbers.length; rightBound ++ ){

            if( numbers[rightBound] == 0 ){
                numberOfZerosInTheWindow ++;
            }

            while( numberOfZerosInTheWindow > flipAtMost ){

                if( numbers[leftBound] == 0 ){
                    numberOfZerosInTheWindow --;
                }

                leftBound++;
            }

            maxNumberOfConsecutiveOnes = Math.max( maxNumberOfConsecutiveOnes, (rightBound - leftBound) + 1 );
        }

        return maxNumberOfConsecutiveOnes;
    }
}
