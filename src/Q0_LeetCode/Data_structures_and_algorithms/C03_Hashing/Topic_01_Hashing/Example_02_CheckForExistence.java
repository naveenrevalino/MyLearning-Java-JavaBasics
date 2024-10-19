package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  TODO: Example 02: Given an array of integers and an integer target, return indices of two numbers such that they add
 *   up to target. You cannot use the same index twice.
 */
public class Example_02_CheckForExistence {

    // Class Variable(s):
    static int[] numbers = new int[] { 5,2,7,10,3,9 };
    static int targetSum = 8;

    public static void main(String[] args) {
        int[] finalResult = getRespectiveIndices( numbers, targetSum );
        System.out.println(Arrays.toString( finalResult ));
    }

    /**
     * TODO: SUDO CODE
     *  Map< Integer, Integer > = Map < key, value > where key is the number and the value is the index of the number in the array.
     *  loop through each item in the given array, get the value at each index, substract the value with target and get the difference.
     *  check if the map contains the difference?
     *      1. if yes the get the index of the item in the map, get the current index we are at in the array and return them.
     *      2. if it is not in the map, then add the respective number and its index position to the map and move on.
     * @param numbers
     * @param targetSum
     * @return
     */
    public static int[] getRespectiveIndices( int[] numbers, int targetSum ){

        // Method Variable(s):
        int[] respectiveIndices = new int[] {-1, -1};
        Map<Integer, Integer> itemsTraversedMap = new HashMap<>();

        // FOR LOOP: to iterate the array
        for( int i = 0; i < numbers.length; i ++){

            int eachNumber = numbers[i];
            int difference = targetSum - eachNumber;

            // IF: difference is in the map, get the value, return the currentIndex and the value from the map.
            if( itemsTraversedMap.containsKey( difference ) ){
                return new int[] { i, itemsTraversedMap.get( difference ) };
            }
            // ELSE: add the number and its index as key and value to the map.
            itemsTraversedMap.put( eachNumber, i );
        }

        return new int[] {-1,-1};
    }
}
