package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_TwoPointers;

import java.util.Arrays;

/*
TODO PROBLEM 2: Given an integer array nums sorted in non-decreasing order, return an array of the squares of each
 number sorted in non-decreasing order.

Example 1:
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

Example 2:
    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]

 */
public class Example_07_SquaresOfSortedArray {

    // Class Variable(S)
    static int[] nums = new int[] {-4,-1,0,3,10};

    public static void main(String[] args) {

        // square each element of the given integer array.
        // sort the array in non-decreasing order || increasing order || Ascending order : 0 to 9 and/or A to Z.
        // Sorting can be done using the Arrays.sort( int[] ) method.
        int[] result = sortedSquares( nums );
        System.out.println(Arrays.toString(result) ) ;

    }

    public static int[] sortedSquares( int[] nums ) {

        int i =0;

        while ( i < nums.length ) {
            nums[i] =  nums[i] * nums[i];
            i++;
        }

        Arrays.sort( nums ) ;

        return nums;
    }
}
