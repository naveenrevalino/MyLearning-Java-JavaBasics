package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range
 *  that is missing from the array.

 *  Example:
 *  Input: nums = [3,0,1]
 *  Output: 2
 *  Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing n
 */
public class Example_06_MissingNumber {

    // Class Variable(s):
    static int[] numbers = new int[] { 3,0,1 };

    public static void main(String[] args) {

//        int finalResult = getTheMissingNumber( numbers );
//        System.out.println( finalResult );
        getTheMissingNumber2( numbers );
    }

    public static int getTheMissingNumber( int[] numbers ){

        // Method Variable(s)
        int missingNumber = -1;
        int arrayLength = numbers.length; // In this case the size is 3, hence the range is 0-3, hence the
        Set<Integer> integerSet = new HashSet<>();

        //FOR-LOOP: add all from numbers to set
        for( int eachNumber : numbers ){
            integerSet.add( eachNumber );
        }

        // FOR-LOOP: since the range is 0-3 the expected numbers to be in the set are 0, 1, 2, and 3
        for( int i = 0; i < arrayLength + 1; i ++ ){
            if( !integerSet.contains( i ) ){
                missingNumber = i;
            }
        }

        return missingNumber;
    }

    public static int getTheMissingNumber2( int[] numbers ){

        // Method Variable(s)
        int missingNumber = -1;

        int sumOfElementsInNumbers = 0;
        int expectedSum = 0;

        for( int eachNumber : numbers ){
            sumOfElementsInNumbers += eachNumber;
        }

        for( int i = 0; i < numbers.length + 1 ; i ++ ){
            expectedSum += i;
        }

        missingNumber = expectedSum - sumOfElementsInNumbers;

        return missingNumber;
    }
}
