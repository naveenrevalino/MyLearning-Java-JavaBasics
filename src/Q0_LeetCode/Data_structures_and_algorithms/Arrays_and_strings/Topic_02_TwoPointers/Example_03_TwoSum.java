package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_TwoPointers;

import java.util.Arrays;

/*
TODO Example 3:
 Given a sorted array of unique integers and a target integer, return true if there exists
 a pair of numbers that sum to target, false otherwise. This problem is similar to Two Sum.
 (In Two Sum, the input is not sorted).

For example, given numbers = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true because 4 + 9 = 13.
*/

public class Example_03_TwoSum {

    static int[] unsortedArray = new int[] { 6, 2, 1, 4, 8, 9, 15, 14 };
    static int[] sortedArray = new int[] { 1, 2, 4, 6, 8, 9, 14, 15 };

    public static void main(String[] args) {

        findSum(13, sortedArray);
        findSum( 13, getSortedArray(unsortedArray) );

    }

    public static void findSum( int targetSum, int[] sortedArray ) {

        /*
            int left = demotes the first character [ charAt[0] ] of the string
            int right = demotes the last character [ charAt[5] ] of the string
         */
        int left =0;
        int right = sortedArray.length - 1;

        // Sum is initialized to zero, used to store the sum of left and right integer value of the given array.
        int sum;

        // The while loop is used to traverse the array from both the ends until they meet in the middle.
        while( left < right ) {

            // Add the two integers and save the value in the sum variable.
            sum = sortedArray[left] + sortedArray[right];

            // Print the output to the console
            if ( sum == targetSum ) {
                System.out.println( "left : " + sortedArray[left] + "  " + "right: " + sortedArray[right] + " and sum is: " + sum);
            }

            // In a sorted array, the integer in the right is always greater than the integer in the left.
            // Hence, if the sum is greater than the target value, decrement the right index.
            if( sum > targetSum ) {
                right --;

            // In a sorted array, the integer in the left is always smaller than the integer in the right.
            // Hence, if the sum is lesser than the target value, increment the left index.
            } else {
                left ++;
            }

        }
    }

    public static int[] getSortedArray( int[] unsortedArray ) {

        return unsortedArray.length > 0 ?  Arrays.stream(unsortedArray).sorted().toArray() : new int[0];

    }

}
