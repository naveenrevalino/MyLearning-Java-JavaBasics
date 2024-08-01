package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_SlidingWindow;

/**
TODO: Example 06: Maximum Number of Consecutive 1's ( Binary Array ).
 Given a binary array and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

For Example,

Input: numbers = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]

Input: numbers = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]

 */
public class Example_06_MaximumConsecutiveOnesSubarray {

    // Class Variable(s)
    static int[] numbers = {1,1,1,0,0,0,1,1,1,1,0};
    static int flipAtMost = 2;

    public static void main(String[] args) {
        int maxNumberOfConsecutive1S = getMaxNumberOfConsecutive1S( numbers, flipAtMost );
        System.out.println( maxNumberOfConsecutive1S );
    }

    /**
        TODO SUDO CODE
        1. keep track of leftBound and rightBound
        2. FOR-LOOP to move RightBound on each iteration
        On each iteration,
            2.1: IF ( numbers(rightBound) == 0 ) - increment count ( countOfZeros ++ ).
            2.2: WHILE-LOOP ( countOfZeros > 2 ).
                2.2.1: IF ( numbers(leftBound) == 0 ) - decrement count ( countOfZeros -- )
                2.2.1: Increment leftBound.
        3. Calculate the max number of consecutive one's.
        4. Return the value.
     * @param numbers: A random binary array.
     * @param flipAtMost: An integer representing max number of 0's that can be flipped to 1's.
     * @return This method returns an integer, which is the maximum number of consecutive 1's.
     */
    public static int getMaxNumberOfConsecutive1S( int[] numbers, int flipAtMost ){

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
