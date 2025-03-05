package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing;

/**
 * TODO: What is hashing?
 * Hashing is a function,
 *  - It takes an input( KEY ) and converts it to an integer.
 *  - The integer that was created should be lesser than a fixed size.
 *  - The reduction to less than a fixed size is performed by taking a modulus ( % ) on the final result.

 * TODO: Why we do hashing?
 * Hashing is performed to create Hash-Map / Hash-Table / Dictionary
 * Hashing-Function + Array = Hash-Map
 * In an array we map index to a value.
 * IN Hash-Map we map key to a value.
 * The important reason to use hash-map is that it reduces the algorithms time complexity to O(n) for huge amount of problems.

 * TODO: Problem with hashing?
 * COLLISION: When different keys convert to same integer collision occurs. When that happens the key-value pair get overwritten.
 * How to fix this:  The problem can be fixed using a concept called chaining.
 * Lets say we have a collision occurring at index(4) of an array, instead of overwriting the value, we insert a linked list
 * in index(4) and add both the value(s) to the same key, hence data is not lost. If you wat to retrieve a specific value,
 * then we iterate over the list of values in that index.

 * TODO: Example
 *   (0) (1) (2) (3) (4) (5)
 * [  O,  O,  O,  O,  O,  O  ]
 * index(4) will have a linked-list containing multiple value while other indexes will have only one element.
 */

import java.util.HashMap;

/**
 * TODO: Given an array of integers and a target value, return indices of two numbers such that they add up to target.
 *  You cannot use the same index twice.
 *
 *  Example: Given an array [ 4, 3, 2, 5, 6, 9, 1 ], and target value = 6.
 *  return [ 4, 2 ] and [ 5, 1 ] because they both add up to 6
 */
public class Example_01_Hashing {

    public static void main(String[] args) {

        // Method Variables:
        int targetedSum = 6;
        int[] givenArray = { 4, 3, 2, 5, 6, 9, 1 };

        generateTheIndexMapping( targetedSum, givenArray );

    }

    public static void generateTheIndexMapping( int targetedSum, int[] givenArray ){

        // Method Variables:
        int arrayLength = givenArray.length;
        HashMap< Integer, Integer > trackIndexMap = new HashMap<>();

        for( int index = 0; index < arrayLength; index ++ ){

            int difference = targetedSum - givenArray[index];
            // 6 - 4 = 2
            // 6 - 2 = 4

            // check if the map is not empty and the difference is already in the map.
            System.out.println("Boolean ? : " + !trackIndexMap.isEmpty() );
            trackIndexMap.put(givenArray[index], index );

        }

        System.out.println( trackIndexMap );


    }
}
