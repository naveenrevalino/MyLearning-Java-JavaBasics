package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.*;

/**
 * TODO Given an array of integers nums, find the maximum value of nums[i] + nums[j], where nums[i] and nums[j] have the
 *  same digit sum (the sum of their individual digits). Return -1 if there is no pair of numbers with the same digit sum.
 * Example:
 */
public class Example_17_MaxSumOfAPairWithEqualSumOfDigit {

    public static void main(String[] args) {

        // Method Variables:
        int[] numbers = {51, 71, 17, 42, 411, 321};
        Map< Integer, List<Integer>> sumPairMap = new HashMap<>();
        int maxSum = 0;

        sumPairMap = computeMaxSumPair( numbers );
        System.out.println( "Map: Grouping each number by the sum of their digits. " + sumPairMap );
        maxSum = findMaxPairOfNumbers( sumPairMap );
        System.out.println("Max Sum: " + maxSum );

        // Alternate and more efficient method.
        // maxSum = computeMaxSumPair1( numbers );
        // System.out.println( maxSum );

    }

    /**
     * Given an integer array, this method will iterate over the elements in the array, group them by the sum of their digits.
     * Example: given {51, 71, 17, 42, 411, 321}, this method will return a map like, { 6=[51, 42, 411, 321], 8=[71, 17] }.
     * @param numbers [ Integer Array ]
     * @return Returns a map [ Map< Integer, List<Integer> > ]
     */
    public static Map< Integer, List<Integer>> computeMaxSumPair( int[] numbers ){

        // Method Variables:
        Map< Integer, List<Integer>> sumPairMap = new HashMap<>();

        // ITERATOR: will iterate over each element of the given array.
        for( int eachNumber : numbers ){
            // Calculate the sum of the digits.
            int sumOfDigits = sumOfEachDigitsOfAGivenNumber(eachNumber);
            // If the sumOfDigits(key) is not in the map, then add it to the map and create an empty list(value).
            sumPairMap.putIfAbsent( sumOfDigits, new ArrayList<>() );
            // If the map has the sumOfDigits(key), then add each number to the list.
            sumPairMap.get(sumOfDigits).add(eachNumber);

        }

        // Return statement.
        return sumPairMap;
    }

    /**
     * Calculates the sum of the digits of a given integer by repeatedly extracting the last digit.
     * Extract the last digit using modulo operation (num % 10), add it to the sum.
     * Removing the last digit by dividing the number by 10 (eachNumber /= 10).
     * Repeat the loop until the number becomes ZERO.
     * @param eachNumber integer value.
     * @return Return an integer.
     */
    public static int sumOfEachDigitsOfAGivenNumber( int eachNumber ){

        // Method variables:
        int sumOfDigits = 0;

        // LOOP: To extract the last digit. The Loop is repeated until the number becomes ZERO.
        while( eachNumber > 0 ){
            // Extract the last digit and add it to the sum.
             sumOfDigits += eachNumber % 10;
             // Remove the last digit (that we just added to the sum) from the number.
             eachNumber /= 10;
        }

        // Return statement.
        return sumOfDigits;
    }

    /**
     * This method will iterate over the map, get the values ( list of integers ).
     * Will check if the list has more than one element, if it does, then it will do the following.
     * Sort the list in descending order, that way we can extract the largest two numbers from top two index of the list.
     * Calculate the sum of these two numbers from each list, finally return the maximum value.
     * @param sumPairMap HashMap [ Map< Integer, List<Integer> > ]
     * @return Integer, default value is -1.
     */
    public static int findMaxPairOfNumbers( Map< Integer, List<Integer>> sumPairMap ){

        // Method Variables:
        int maxSum = -1;

        // ITERATOR: iterate through each grouped list elements
        for( List<Integer> eachGroupedList : sumPairMap.values() ){
            // Check if the list has more than one element.
            if( eachGroupedList.size() > 1 ){
                // SORT: the list descending order.
                eachGroupedList.sort(Collections.reverseOrder());
                // Calculate the sum of the largest two numbers from each list, and return the maximum value.
                maxSum = Math.max( maxSum, eachGroupedList.get(0) + eachGroupedList.get(1) );
            }
        }

        // Return statement.
        return maxSum;

    }

    /**
     * For a given integer array, this method will iterate over each element of the array.
     * Calculate the sum of the digits of each number. Then check if the map has key matching the sum of the digits.
     * If the key exists in the map, then do the following.
     * Step 1: Calculate the sum of the current number and the largest number previously encountered with the same sumOfDigits.
     *         If the new sum is greater than the old value of the maxSum, then update the variable to the new max value.
     * Step 2: Update the map to always have the largest number, meaning if the current number is greater than the number
     *         already in the map with the same key, then it will update the value to hold the current number.
     *
     * @param numbers Integer array.
     * @return Integer, default value is -1.
     */
    public static int alternateSolution( int[] numbers ){

        Map<Integer,Integer> sampleMap = new HashMap<>();
        int maxSum = -1;

        // ITERATOR: Iterate over each element.
        for( int eachNumberFromTheArray : numbers ){

            // Calculate the sum of digits of each number.
            int sumOfDigits = sumOfEachDigitsOfAGivenNumber( eachNumberFromTheArray );

            // Check if the key(sumOfDigits) exists.
            if( sampleMap.containsKey(sumOfDigits) ){

                // Step 1: Update the maxSum value, if the sum of the current number and the previous number from the map is greater.
                maxSum = Math.max( maxSum, eachNumberFromTheArray + sampleMap.get(sumOfDigits) );
            }

            // Step 2: The map will always hold the greatest number with the same key.
            sampleMap.put( sumOfDigits, Math.max( sampleMap.getOrDefault(sumOfDigits, 0), eachNumberFromTheArray ));
        }

        // Return statement.
        return maxSum;

    }
}
