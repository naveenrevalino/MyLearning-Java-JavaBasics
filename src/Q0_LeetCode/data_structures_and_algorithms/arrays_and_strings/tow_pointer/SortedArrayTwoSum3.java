package org.data_structures_and_algorithms.arrays_and_strings.tow_pointer;

import java.util.Arrays;

/*
Question 3:
Given a sorted array of unique integers and a target integer, return true if there exists
a pair of numbers that sum to target, false otherwise. This problem is similar to Two Sum.
(In Two Sum, the input is not sorted).

For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true because 4 + 9 = 13.
*/

public class SortedArrayTwoSum3 {

    static int[] unsortedArray = new int[] {6, 2, 1, 4, 8, 9, 15, 14};

    public static void main(String[] args) {

        int[] sortedArray = Arrays.stream(unsortedArray).sorted().toArray();
        int targetSum = 15;
        findSum(targetSum, sortedArray);


    }

    public static void findSum( int targetSum, int[] sortedArray ) {

        int left =0;
        int right = sortedArray.length - 1;
        int sum = 0;

        while( left < right ) {

            sum = sortedArray[left] + sortedArray[right];

            if ( sum == targetSum ) {
                System.out.println( "left : " + sortedArray[left] + "  " + "right: " + sortedArray[right] + " and sum is: " + sum);
            }

            if( sum > targetSum ) {
                right --;
            } else {
                left ++;
            }

        }
    }


}
