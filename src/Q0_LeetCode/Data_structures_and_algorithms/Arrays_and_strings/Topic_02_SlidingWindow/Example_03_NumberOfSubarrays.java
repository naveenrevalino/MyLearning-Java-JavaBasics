package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_SlidingWindow;

/*
TODO Number Of Subarrays
 If a problem asks for the number of subarrays that fit some constraint, we can still use sliding window, but we need
 to use a neat math trick to calculate the number of subarrays. Let's say that we are using the sliding window algorithm
 we have learned and currently have a window (left, right). How many valid windows end at index right? There's the
 current window (left, right), then (left + 1, right), (left + 2, right), and so on until (right, right) (only the element at right).
 You can fix the right bound and then choose any value between left and right inclusive for the left bound.
 Therefore, the number of valid windows ending at index right is equal to the size of the window, which we know
 is right - left + 1.
*/

/*
TODO Example 03: Subarray Product Less Than K.
 Given an array of positive integers and an integer K, return the number of subarrays where the product of all the
 elements in the subarray is strictly less than k.

For example, given the input numbers = [10, 5, 2, 6], k = 100, the answer is 8. The subarrays with products less than k
are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 */
public class Example_03_NumberOfSubarrays {

    // Class Variable(s)
    static int[] numbers = {10, 5, 2, 6};
    static int targetK = 100;

    public static void main(String[] args) {
        int finalResult = getNumberOfSubarrays( numbers, targetK );
        System.out.println( finalResult );
    }

    public static int getNumberOfSubarrays( int[] numbers, int targetK ) {

        // Method Variable(s)
        int leftBound = 0;
        int rightBound = 0;
        int numberOfSubarrays = 0;
        int currentProductValue = 1;

        // Sudo Code
        // LeftBound and RightBound of sliding window
        // For-Loop : to increase the rightBound at each iteration
        // currentProductValue = currentProductValue * rightBound
        // While-Loop : to iterate until condition hold true, here the condition is currentProductValue >= 100
        // Re-calculate the currentProductValue ( divide the current value by the leftBound to re adjust the products )
        // increment leftBound ++;
        // keep counting the possible number of substrings.

        for( rightBound = 0; rightBound < numbers.length; rightBound++ ){

            currentProductValue *= numbers[rightBound];

            while( currentProductValue >= targetK ){
                currentProductValue /= numbers[leftBound];
                leftBound ++;
            }

            numberOfSubarrays = numberOfSubarrays + ( rightBound - leftBound ) + 1;
        }

        return numberOfSubarrays;
    }
}
