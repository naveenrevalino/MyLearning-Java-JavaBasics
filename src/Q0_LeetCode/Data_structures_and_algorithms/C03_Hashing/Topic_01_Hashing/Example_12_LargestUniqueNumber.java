package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * TODO Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.
 * Example:
 *  Input: nums = [5,7,3,9,4,9,8,3,1]
 *  Output: 8
 *  Explanation: The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it is the answer.
 */
public class Example_12_LargestUniqueNumber {

    public static void main(String[] args) {

        // Method Variable(s):
        int[] originalNumbers = { 5,7,3,9,4,9,8,3,1 };
        Map< Integer, Integer > frequencyMap;
        int largestUniqueNumber;

        // Function call 1 : getFrequencyOfEachNumber()
        frequencyMap = getFrequencyOfEachNumber( originalNumbers );
        System.out.println( "Frequency Map: " + frequencyMap );

        // Function call 2 : getLargestUniqueNumber()
        largestUniqueNumber = getLargestUniqueNumber( frequencyMap );
        System.out.println( largestUniqueNumber );

    }

    /**
     * This method will iterate over each element of the given array and compute the frequency of each number.
     * The result is then saved to a Hashmap, where the KEY of the map is the number, and the value is its frequency.
     * @param originalNumbers : Original array of integers provided in the question.
     * @return : HashMap : contains each number and their frequency.
     */
    public static Map< Integer, Integer > getFrequencyOfEachNumber( int[] originalNumbers ){

        // Method Variable(s):
        Map< Integer, Integer > frequencyMap = new HashMap<>();

        // FOR-LOOP: Iterate the original numbers array, and populate the map with each number and its frequency.
        for ( int eachNumberFromArray : originalNumbers ){
            frequencyMap.put( eachNumberFromArray, frequencyMap.getOrDefault( eachNumberFromArray, 0 ) + 1 );
        }
        // Return final result
        return frequencyMap;

    }

    /**
     * This method will compute the largest unique number with frequency 1 fro the given HashMap.
     * @param frequencyMap : HashMap : contains each number and their frequency.
     * @return : int, the largest unique number with frequency as 1.
     */
    public static int getLargestUniqueNumber( Map< Integer, Integer > frequencyMap ){

        // Method Variable(s):
        int largestUniqueNumber = -1;

        // loop through the keyset of the map, with value 1, and if the key is greater than the largestUniqueNumber, overwrite it.
        for( Integer eachNumber : frequencyMap.keySet() ){

            int eachNumbersFrequency = frequencyMap.get( eachNumber );
            if ( eachNumbersFrequency==1 && eachNumber > largestUniqueNumber ){
                largestUniqueNumber = eachNumber;
            }
        }

        // Return final result
        return largestUniqueNumber;
    }
}
