package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_01_TwoPointers.BonusProblems;


import java.util.Arrays;

/*
    TODO: Problem 03: Given two integer arrays, sorted in increasing order, return the minimum integer common to both
     arrays. If there is no common integer amongst, return -1.
     Note that an integer is said to be common if both arrays have at least one occurrence of that integer.

     Example 1:
     Input: numbers1 = [1,2,3], numbers2 = [2,4]
     Output: 2
     Explanation: The smallest element common to both arrays is 2, so we return 2.

    Example 2:
    Input: numbers1 = [1,2,3,6], numbers2 = [2,3,4,5]
    Output: 2
    Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 */
public class Problem_03_MinimumCommon_Value {

    // Class Variable(s):
    static int[] numbers1 = {1, 2, 3, 6};
    static int[] numbers2 = new int[] {2, 3, 4, 5};

    public static void main(String[] args) {

        int finalResult = getMinimumCommonValue( numbers1, numbers2 );
        System.out.println( finalResult );

    }

    public static int getMinimumCommonValue( int[] numbers1, int[] numbers2){

        int indexOfNumbers1 = 0;
        int indexOfNumbers2 = 0;
        int lengthOfNumber1 = numbers1.length;
        int lengthOfNumber2 = numbers2.length;
        int minimumCommonValue = -1;

        while( indexOfNumbers1 < lengthOfNumber1 && indexOfNumbers2 < lengthOfNumber2 ){

            if( numbers1[ indexOfNumbers1 ] < numbers2[ indexOfNumbers2 ] ){
                indexOfNumbers1 ++;
            } else if ( numbers2[ indexOfNumbers2 ] < numbers1[ indexOfNumbers1 ] ) {
                indexOfNumbers2 ++;
            } else {
                minimumCommonValue = numbers1[ indexOfNumbers1 ];
                return minimumCommonValue;
            }
        }
        return minimumCommonValue;
    }
}
