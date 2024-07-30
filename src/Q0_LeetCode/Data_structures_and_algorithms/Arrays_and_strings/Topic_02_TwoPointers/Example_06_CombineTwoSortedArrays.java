package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_TwoPointers;

import java.util.ArrayList;
import java.util.List;

/*
TODO Example 06: Combine Two Sorted Arrays.
 Given two sorted integer arrays arr1 and arr2, return a new array that combines both of them and is also sorted.

Hint : The trivial approach would be to first combine both input arrays and then perform a sort. If we have
n = arr1.length + arr2.length, then this gives a time complexity of O(n⋅log n) (the cost of sorting). This would be a
good approach if the input arrays were not sorted, but because they are sorted, we can take advantage of the two
pointers technique to improve to O(n).
*/
public class Example_06_CombineTwoSortedArrays {

    static int[] arr1 = new int[] { 1, 4, 7, 20 };
    static int[] arr2 = new int[] { 3, 5, 6 };
    static List<Integer> answer = new ArrayList<>();


    public static void main(String[] args) {

        combineArrays(arr1, arr2, answer);

    }

    public static void combineArrays( int[] arr1, int[] arr2, List<Integer> answer ) {

        // int i = denotes the index of the iterator for array1.
        int i=0;
        // int j = denotes the index of the iterator for array2.
        int j=0;

        /*
        LOOP 1 : This loop will run initially, will continue to run until one of the two iterator is exhausted.
        In the above given example array 2 has fewer elements, hence will exhaust first, this loop will run until then.
        */
        while( i < arr1.length && j < arr2.length ) {

            if( arr1[i] < arr2[j] ) {
                answer.add( arr1[i] );
                i++;
            } else {
                answer.add( arr2[j] );
                j++;
            }
        }

        /*
        LOOP 2 : This loop may or may not run.
        In the above given example array 2 will exhaust first, this loop will run until the array 1 iterator exhausts.
        */
        while( i < arr1.length ) {

            answer.add( arr1[i] );
            i++;

        }

        /*
        LOOP 2 : This loop may or may not run.
        In the above given example array 2 will exhaust first, this loop will never run.
        */
        while( j < arr2.length ) {

            answer.add( arr2[j] );
            j++;

        }

        // Print the final output to console.
        System.out.println( "print answer array: " + answer.toString() );

    }
}
