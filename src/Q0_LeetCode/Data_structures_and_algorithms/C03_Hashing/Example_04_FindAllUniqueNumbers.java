package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO: Given an integer array, find all the unique numbers that satisfy the following condition:
 *  x + 1 is not in given array, and x - 1 is not in array.
 */
public class Example_04_FindAllUniqueNumbers {

    // Class Variable(s):
    static int[] numbers = {1,2,3,9,11,25,4};

    public static void main(String[] args) {

        List<Integer> finalResult = getAllUniqueNumbers( numbers );
        // Time Complexity : O(n)
        System.out.println( finalResult );

    }

    public static List<Integer> getAllUniqueNumbers( int[] numbers ){

        // Method Variable(s):
        List<Integer> listOfUniqueNumbers = new ArrayList<>();
        Set<Integer> setOfNumbers = new HashSet<>();

        // FOR LOOP: iterate the array ( numbers ).
        for( int eachNumber : numbers ){ // Time Complexity : O(n)
            setOfNumbers.add( eachNumber );
        }

        // FOR LOOP: iterate the set, check if each number satisfy the given condition, if yes add it to the list.
        for( int eachNumber : setOfNumbers ){ // Time Complexity : O(n)

            if( !setOfNumbers.contains( eachNumber + 1 ) && !setOfNumbers.contains( eachNumber - 1 ) ){
                listOfUniqueNumbers.add( eachNumber );
            }
        }

        return listOfUniqueNumbers;
    }
}
