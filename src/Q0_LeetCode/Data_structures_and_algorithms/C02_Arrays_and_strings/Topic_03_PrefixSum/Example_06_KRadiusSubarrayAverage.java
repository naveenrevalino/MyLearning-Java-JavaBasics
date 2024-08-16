package Q0_LeetCode.Data_structures_and_algorithms.C02_Arrays_and_strings.Topic_03_PrefixSum;

import java.util.Arrays;

/*
    TODO: Example: K Radius Subarray Average
     You are given a 0-indexed array of n integers, and an integer k. The k-radius average for a subarray of numbers(given array)
     centered at some index i with the radius k is the average of all elements in numbers(given array between the indices i - k
     and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
     Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
     The average of x elements is the sum of the x elements divided by x, using integer division. The integer division
     truncates toward zero, which means losing its fractional part. For example, the average of four elements 2, 3, 1, and
     5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.

     For Example(1),
     [  7,  4,  3,  9,  1,  8,  5,  2,  6 ]
        |___________^___________|
            |___________^___________|
                |___________^___________|

    Input: numbers = [7,4,3,9,1,8,5,2,6], k = 3
    Output: [-1,-1,-1,5,4,4,-1,-1,-1]

    Explanation:
    - avg[0], avg[1], and avg[2] are -1 because there are less than k elements before each index.
    - The sum of the subarray centered at index 3 with radius 3 is: 7 + 4 + 3 + 9 + 1 + 8 + 5 = 37.
      Using integer division, avg[3] = 37 / 7 = 5.
    - For the subarray centered at index 4, avg[4] = (4 + 3 + 9 + 1 + 8 + 5 + 2) / 7 = 4.
    - For the subarray centered at index 5, avg[5] = (3 + 9 + 1 + 8 + 5 + 2 + 6) / 7 = 4.
    - avg[6], avg[7], and avg[8] are -1 because there are less than k elements after each index.

    For Example(2),
    Input: numbers = [100000], k = 0
    Output: [100000]

    Explanation:
    - The sum of the subarray centered at index 0 with radius 0 is: 100000.
    avg[0] = 100000 / 1 = 100000.

    For Example(3),
    Input: numbers = [8], k = 100000
    Output: [-1]

    For Example(3),
    Input: numbers = [40527,53696,10730,66491,62141,83909,78635,18560], k = 2
    Output: [-1,-1,46717,55393,60381,61947,-1,-1]

    Explanation:
    - avg[0] is -1 because there are less than k elements before and after index 0.

    TODO SOLUTION:
     In this problem, we have to return the k-radius average for each given element of the numbers array. If any element
     doesn't have k-elements in its left and right, then its average is considered to be -1, otherwise, the average will
     be the sum of all these (2 * k + 1) elements divided by the number of elements.
 */
public class Example_06_KRadiusSubarrayAverage {

    //Class Variable(s):
    static int[] numbers = new int[] { 7,4,3,9,1,8,5,2,6 };
    static int radius = 3;

    public static void main(String[] args) {

        int[] finalResult = getKRadiusSubarrayAverage( numbers, radius );
        System.out.println(Arrays.toString( finalResult ));

    }

    /*
        TODO SUDO CODE
        1. If radius(K) is ZERO, then simply return the numbers array.
        2. Return the default averageArray, windowSize value is lesser than the numbersArrayLength.
        3. Generate/Compute the prefixSumArray for the given numbers array.
        4. FOR-LOOP - To iterate only those indexes which has 'K' elements to the left and right.
            Logic: iterator should start from an index such that there are Radius(K) elements to the left and right.
            hence starting index i = radius(K) which is 3, hence value of index(3) is 9, and it does have 3 elements to
            the right and left. The range of the loop is < ( total length of numbers array ) - ( radius ) = 9 - 3 = 6

            4.1: Define the window ( its leftBound and rightBound ).
            4.2: Calculate the subarray sum
     */
    public static int[] getKRadiusSubarrayAverage( int [] numbers, int radius ){

        // Method Variable(s):
        int windowSize = 2 * radius + 1;
        int numbersArrayLength = numbers.length;
        int[] averagesArray = new int[ numbersArrayLength ];
        Arrays.fill( averagesArray, -1);
        double averageAsDouble = 0.00;
        int averageAsInteger = 0;

        // Return numbers array if Radius(K) is ZERO
        if( radius == 0){
            return numbers;
        }

        // Return the default averageArray, windowSize value is lesser than the numbersArrayLength.
        if( windowSize > numbersArrayLength ){
            return averagesArray;
        }

        // FOR LOOP - To iterate only those indexes which has 'K' elements to the left and right.
        for( int i = radius; i < ( numbersArrayLength - radius ); i ++ ){

            int leftBound = i - radius;
            int rightBound = (i + radius) + 1;

            int[] prefixSumArray = getPrefixSumArray( numbers );
            int subArraySum = prefixSumArray[ rightBound ] - prefixSumArray[ leftBound ];


            averageAsDouble = (double) subArraySum / windowSize;

            averageAsInteger = (int) averageAsDouble ;


            // Print log to console
            printToConsole( prefixSumArray, subArraySum, windowSize, averageAsDouble, averageAsInteger);
            averagesArray[i] = averageAsInteger;

        }

        return averagesArray;
    }

    /**
     TODO SUDO CODE
     1. FOR-LOOP - To iterate through each element of the numbers array.
     1.1: Calculate the prefix sum.
     1.2: Add the current prefixSum to the respective index of the prefixSumArray.
     2. Return the prefixSumArray.
     * @param numbers : An array of integers ( can be positive or negative numbers ).
     * @return Will return an array ( Prefix Sum Array ).
     */
    public static int[] getPrefixSumArray( int[] numbers){

        // Method Variable(s).
        int[] prefixSumArray = new int[ numbers.length + 1 ];
        int currentPrefixSum = 0;

        // FOR LOOP to construct the prefixSumArray.
        for( int itrIndex = 0; itrIndex < numbers.length; itrIndex ++){
            currentPrefixSum += numbers[ itrIndex ];
            prefixSumArray[ itrIndex + 1 ] = currentPrefixSum;
        }

        // Total Time Complexity = O(n).
        return prefixSumArray;
    }

    /**
     * Method to print log to console
     * @param prefixSumArray : Integer array
     * @param subArraySum : Integer value
     * @param windowSize : Integer value
     * @param averageAsDouble : Double value
     * @param averageAsInteger : Integer value
     */
    public static void printToConsole( int[] prefixSumArray, int subArraySum, int windowSize, double averageAsDouble, int averageAsInteger){
        System.out.println();
        System.out.println( " Prefix Sum Array: " + Arrays.toString( prefixSumArray ) );
        System.out.println( " Subarray Sum: " + subArraySum );
        System.out.println( " Window Size: " + windowSize );
        System.out.println( " Average as Double: " + averageAsDouble );
        System.out.println( " Average as Integer: " + averageAsInteger );
        System.out.println();
    }
}
