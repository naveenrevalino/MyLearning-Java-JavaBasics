package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.*;

/**
 *  Intersection of Multiple Arrays
 *  Given a 2D array numbers that contains n arrays of distinct integers,
 *  return a sorted array containing all the numbers that appear in all n arrays.
 *  Example, given  numbers =
 *  [
 *  [3,1,2,4,5],
 *  [1,2,3,4],
 *  [3,4,5,6]
 *  ]
 *  return [3, 4]. 3 and 4 are the only numbers that are in all arrays.
 */
public class Example_09_CountOfCommonElementsInAllArray {

    public static void main(String[] args) {

        // Method Variable(s)
        int[][] givenNumbersArray = { {3,1,2,4,5}, {1,2,3,4}, {3,4,5,6} };
        int numberOfRows = givenNumbersArray.length;
        List<Integer> finalResult= new ArrayList<>();
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        frequencyMap = findFrequencyOfEachElement( givenNumbersArray );
        System.out.println( frequencyMap );

        finalResult = findTheCommonElements( frequencyMap, numberOfRows );
        System.out.println( finalResult );
    }

    /**
     * Will compute the frequency of each element(s) in a given 2D Array.
     * Frequency meaning : number of times an element occur within with each array of the given 2D Array.
     * @param givenNumbersArray : Original 2D Array.
     * @return : Will return the frequencyMap ( HashMap ).
     */
    public static Map<Integer, Integer> findFrequencyOfEachElement( int[][] givenNumbersArray ){

        // Method Variable(s)
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // FOR-LOOP: To iterate each row of the 2D array
        for( int[] eachRow : givenNumbersArray ){

            // FOR-LOOP: To iterate over each element in a given row
            for( int eachElement : eachRow ){
                frequencyMap.put( eachElement, frequencyMap.getOrDefault(eachElement, 0) + 1 );
            }
        }

        // Return final result
        return frequencyMap;
    }

    /**
     * Given a frequencyMap and a target number, this method will return all the element(s) whose frequency matches the target number.
     * @param frequencyMap : HashMap [ key is the actual element, value is the frequency of occurrence.
     * @param numberOfRows : number of arrays in the given 2D Array. This will be used as the target number.
     * @return : List of elements, whose frequency matches the target number / numberOfRows.
     */
    public static List<Integer> findTheCommonElements( Map<Integer,Integer> frequencyMap, int numberOfRows ){

        // Method Variable(s):
        List<Integer> finalResult = new ArrayList<>();

        // FOR-LOOP: Iterate through the ketSet of the HashMap
        for( int key: frequencyMap.keySet() ){

            // IF CHECK: Check if the value for the given key is equal to the number of rows of the 2D Array.
            if( frequencyMap.get( key ) == numberOfRows ){
                finalResult.add( key );
            }
        }

        // Return final result
        return finalResult;
    }
}
