package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_SlidingWindow;

/**
TODO Number Of Subarrays
 If a problem asks for the number of subarrays that fit some constraint, we can still use sliding window, but we need
 to use a neat math trick to calculate the number of subarrays. Let's say that we are using the sliding window algorithm
 we have learned and currently have a window (left, right). How many valid windows end at index right? There's the current
 window (left, right), then (left + 1, right), (left + 2, right), and so on until (right, right) (only the element at right).
 You can fix the right bound and then choose any value between left and right inclusive for the left bound. Therefore, the
 number of valid windows ending at index right is equal to the size of the window, which we know is right - left + 1.

TODO Example 03: Subarray Product Less Than K.
 Given an array of positive integers and an integer K, return the number of subarrays where the product of all the
 elements in the subarray is strictly less than k.

For Example,
Input: numbers = [10, 5, 2, 6], and k = 100.
Output: 8.
Explanation: The subarrays with products less than k are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 */
public class Example_03_NumberOfSubarrays {

    // Class Variable(s)
    static int[] numbers = {10, 5, 2, 6};
    static int targetProductValue = 100;

    public static void main(String[] args) {
        int finalResult = getNumberOfSubarrays( numbers, targetProductValue);
        System.out.println( finalResult );
    }

    /**
        TODO Sudo Code
        1. keep track of leftBound and rightBound
        2. FOR-LOOP to move RightBound on each iteration
            On each iteration,
            2.1: Calculate currentProductValue = currentProductValue * rightBound
            2.2: WHILE-LOOP ( currentProductValue >= targetProductValue ).
                2.2.1: Re-calculate the currentProductValue
                ( divide the current value by the leftBound to re adjust the products )
                2.2.2: increment leftBound;
        3. Calculate the number of subarray, where the product of all elements in the subarray is less than targetProductValue.
        4. Return the value.
     * @param numbers : An integer array with positive numbers.
     * @param targetProductValue : Maximum allowed product value ( of all elements in the subarray ).
     * @return This method returns an integer, which is the total number of subarrays.
     */
    public static int getNumberOfSubarrays( int[] numbers, int targetProductValue ) {

        // Method Variable(s)
        int leftBound = 0;
        int rightBound = 0;
        int numberOfSubarrays = 0;
        int currentProductValue = 1;

        for( rightBound = 0; rightBound < numbers.length; rightBound++ ){

            currentProductValue *= numbers[rightBound];

            while( currentProductValue >= targetProductValue ){
                currentProductValue /= numbers[leftBound];
                leftBound ++;
            }

            numberOfSubarrays = numberOfSubarrays + ( rightBound - leftBound ) + 1;
        }

        return numberOfSubarrays;
    }
}
