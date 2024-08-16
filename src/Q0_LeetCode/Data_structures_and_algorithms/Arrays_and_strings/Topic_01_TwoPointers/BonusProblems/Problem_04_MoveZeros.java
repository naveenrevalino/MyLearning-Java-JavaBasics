package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_01_TwoPointers.BonusProblems;

import java.util.Arrays;

/*
    TODO: Problem 04: Given an integer array, move all 0's to the end of it while maintaining the relative order of the
     non-zero elements.
     Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:
    Input: nums = [0]
    Output: [0]

    Example 3:
    Input: nums = [4,2,4,0,0,3,0,5,1,0]
    Output: [4, 2, 4, 3, 5, 1, 0, 0, 0, 0]
 */
public class Problem_04_MoveZeros {

    // Class Variable(s):
    static int[] numbers = new int[] {4,2,4,0,0,3,0,5,1,0};

    public static void main(String[] args) {

        int[] finalResult = getZerosMovedToTheEnd( numbers );
        System.out.println(Arrays.toString( finalResult ));

    }

    public static int[] getZerosMovedToTheEnd( int[] numbers ){

        int currentIndex = 0;
        int arrayLength = numbers.length;

        for( int eachNumber : numbers ){

            if( eachNumber != 0 ){
                numbers[ currentIndex ] = eachNumber;
                currentIndex ++;
            }

        }

        while( currentIndex < arrayLength ){

            numbers[ currentIndex ] = 0;
            currentIndex++;
        }

        return numbers;
    }
}
