package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Given an n x n matrix grid, return the number of pairs (R, C) where R is a row and C is a column, and R and C
 *  are equal if we consider them as 1D arrays.
 */
public class Example_18_EqualRowsAndColumnPairs {

    public static void main(String[] args) {

        // Method Variables:
        int[][] twoDimensionalArray = { {3,2,1}, {1,7,6}, {2,7,7} };
        Map<String, Integer> frequencyMapOfRowElements;
        Map<String, Integer> frequencyMapOfColumnElements;
        int finalNumberOfPairs = 0;

        frequencyMapOfRowElements = computeFrequencyOfRowElements(twoDimensionalArray);
        frequencyMapOfColumnElements = computeFrequencyOfColumnElements(twoDimensionalArray);

        finalNumberOfPairs = numberOfPairs( frequencyMapOfRowElements, frequencyMapOfColumnElements);
        System.out.println( finalNumberOfPairs );


    }

    /**
     * Given a 2Dimensional array, this method will iterate over each row, convert the row to a key, add the key to the
     * map with its frequency as value.
     * @param twoDimensionalArray : n X n two-dimensional array, meaning equal number of elements in row and column.
     * @return A map [ Map<String, Integer> ].
     */
    public static Map<String, Integer> computeFrequencyOfRowElements( int[][] twoDimensionalArray ){

        // Method Variables:
        Map<String, Integer> frequencyMapOfRowElements = new HashMap<>();

        // ITERATOR: Iterate through each row of the 2D array.
        for( int[] eachRow : twoDimensionalArray ){

            // Construct the frequency map based on each row.
            String key = convertToKey( eachRow );
            frequencyMapOfRowElements.put( key, frequencyMapOfRowElements.getOrDefault(key, 0) + 1 );
        }

        // Return statement.
        return frequencyMapOfRowElements;
    }

    /**
     * Given a 2Dimensional array, this method will iterate over each column, and for each column, it will iterate
     * through the row to get the respective elements. If it is in the first column, it will get all the elements in
     * the first index of each row and add them to a new array. That way i will have a new array with all the elements
     * in the first column.
     * @param twoDimensionalArray : n X n two-dimensional array, meaning equal number of elements in row and column.
     * @return A map [ Map<String, Integer> ].
     */
    public static Map<String, Integer> computeFrequencyOfColumnElements( int[][] twoDimensionalArray ){

        // Method Variables:
        Map<String, Integer> frequencyMapOfColumnElements = new HashMap<>();
        int givenArrayLength = twoDimensionalArray.length;


        // OUTER ITERATOR: Iterate through each column of the 2D array.
        for( int columnIndex = 0; columnIndex < givenArrayLength; columnIndex ++ ){

            // Construct a new array for each column.
            int[] eachColumn = new int[givenArrayLength];

            //  INNER ITERATOR: Iterate through each row of the 2D array.
            for( int rowindex = 0; rowindex < givenArrayLength; rowindex ++ ){

                // From eachColumn get the respective row elements, add it to the respective index of the column array.
                eachColumn[rowindex] = twoDimensionalArray[rowindex][columnIndex];
            }

            // Construct the frequency map based on each column.
            String key = convertToKey( eachColumn );
            frequencyMapOfColumnElements.put( key, frequencyMapOfColumnElements.getOrDefault(key, 0) + 1 );
        }

        // Return statement.
        return frequencyMapOfColumnElements;
    }

    /**
     * Given two frequency maps, this method will iterate through key set the first map, check if the same key is in the
     * second map as well. If yes then it will calculate the product of the values from both the maps and set that value
     * to the variable finalNumberOfPairs. It will continue doing this for each key and add the product to the
     * finalNumberOfPairs variable.
     * @param frequencyMapOfRowElements : A map [ Map<String, Integer> ]
     * @param frequencyMapOfColumnElements : A map [ Map<String, Integer> ]
     * @return An integer
     */
    public static int numberOfPairs( Map<String, Integer> frequencyMapOfRowElements, Map<String, Integer> frequencyMapOfColumnElements ){

        // Method variables:
        int finalNumberOfPairs = 0;

        // Iterator: Iterate the map frequencyMapOfRowElements.
        for( String eachKey : frequencyMapOfRowElements.keySet() ){
            // Compute the pairs and add them all, how many pairs can be formed will be the product of the values from both maps.
            finalNumberOfPairs += frequencyMapOfRowElements.get( eachKey ) * frequencyMapOfColumnElements.getOrDefault( eachKey, 0);
        }

        // Return statement.
        return finalNumberOfPairs;
    }


    /**
     * What this method does is, given an integer array, it will iterate through each element in the array.
     * It will append each element of the array to a string using StringBuilder, and return the constructed string.
     * @param eachRow : int[] array.
     * @return A string
     */
    public static String convertToKey( int[] eachRow ){

        // Method Variables:
        StringBuilder constructedString = new StringBuilder();

        // ITERATOR: Iterate the array and construct the string.
        for( int eachNumber : eachRow ){
            constructedString.append(eachNumber);
        }

        // Return statement.
        return constructedString.toString();
    }


}
