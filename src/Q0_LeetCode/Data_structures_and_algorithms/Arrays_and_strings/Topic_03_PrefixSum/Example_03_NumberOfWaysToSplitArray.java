package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_03_PrefixSum;


/*
    TODO: Example 03: Number Of Ways To Split Array
     Given an integer array, find the number of ways to split the array into two parts so that the first section
     has a sum greater than or equal to the sum of the second section. The second section should have at least one number.

     For Example,
     Give array numbers = [ 10 4 -8 7 ]
     prefixSumArray = [ 10 14 6 13 ]

     first left array = [ 10 ], Sum = 10
     first right array = [ 4 -8 7 ], Sum = 3
     Sum of left > Sum of right, hence increment the count.

     The above can be easily done using prefixSumArray.
     Sum of left array = 10
     Sum of right array = 13 - 10 = 3, where 10 is the sum of the left array, and 13 is the sum of all elements of the right array
 */
public class Example_03_NumberOfWaysToSplitArray {

    // Class Variable(s):
    static int[] numbers = new int[] { 10, 4, -8, 7 };

    /**
     * Main Method: Executes the function getTheRespectiveBooleanArray().
     * Time Complexity : BigO (n).
     * @param args Main method arguments.
     */
    public static void main(String[] args) {
        int finalResult = getNumberOfWaysToSplitArray( numbers );
        System.out.println( finalResult );
    }

    /**
        TODO SUDO CODE
        1. FOR-LOOP - to iterate through each element of the prefixSumArray.
            1.1: Calculate the sum of all elements of the first subarray.
            1.2: Calculate the sum of all elements of the second subarray.
            1.3: IF sum of the first array is greater than the second array, increment the count of totalNumberOfWaysToSplitArray.
        2. Return the value of the variable( totalNumberOfWaysToSplitArray ).
     */
    public static int getNumberOfWaysToSplitArray( int[] numbers ){

        // Method Variable(s)
        int[] prefixSumArray = getPrefixSumArray( numbers );
        int rightBound = prefixSumArray.length - 1;
        int totalNumberOfWaysToSplitArray = 0;

        // FOR-LOOP to iterate through the elements of prefixSumArray.
        for( int leftBound = 0; leftBound < prefixSumArray.length; leftBound ++ ){

            int leftBoundSubArraySum = prefixSumArray[ leftBound ];
            int rightBoundSubArraySum = prefixSumArray [ rightBound ] - leftBoundSubArraySum;

            // IF Condition to increment the variable( totalNumberOfWaysToSplitArray ).
            if( leftBoundSubArraySum > rightBoundSubArraySum ){
                totalNumberOfWaysToSplitArray ++;
            }
        }

        // Total Time Complexity = O(n).
        return totalNumberOfWaysToSplitArray;
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
        int[] prefixSumArray = new int[ numbers.length ];
        int currentPrefixSum = 0;

        // FOR LOOP to construct the prefixSumArray.
        for( int itrIndex = 0; itrIndex < numbers.length; itrIndex ++){
            currentPrefixSum += numbers[ itrIndex ];
            prefixSumArray[ itrIndex ] = currentPrefixSum;
        }

        // Total Time Complexity = O(n).
        return prefixSumArray;
    }
}
