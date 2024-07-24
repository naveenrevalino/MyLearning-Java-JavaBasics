package Q7_Collections.Array;

public class SubArraySum {
    /**
     * Given an array[] = { 1, 4, 20, 3, 10, 5 }
     * Its corresponding sub array will be =
     * {1}
     * {1, 4}
     * {1, 4, 20}
     * {1, 4, 20, 3}
     * {1, 4, 20, 3, 10}
     * {1, 4, 20, 3, 10, 5}
     * {4}
     * {4, 20}
     * {4, 20, 3}
     * {4, 20, 3, 10}
     * {4, 20, 3, 10, 5}
     * {20}
     * {20, 3}
     * {20, 3, 10}
     * {20, 3, 10, 5}
     * {3}
     * {3, 10}
     * {3, 10, 5}
     * {10}
     * {10,5}
     * {5}
     */

    public static void main(String[] args) {


        // Logic to print sub array : LINEAR METHOD : Time Complexity will be O(n)
        /**
         * We will use two pointers i and j
         * then we will use sum = 0
         * sum = sum + arr[j]
         * while ( sum > the required sum ) : then we will perform some complex operation
         * { sum = sum - arr[i] } we are doing this because i is still in the starting position
         * now increment position of i, i++
         *
         * if ( sum == required Sum ) {
         * return i, j }
         */

        int expectedSum = 33;
        int currentSum = 0;
        int i = 0;


        //int[] orginalArray = { 1, 2, 3, 7, 5 };
        int[] orginalArray = {1, 4, 20, 3, 10, 5};

        // Logic to print sub array: BRUTE FORCE METHOD : Time Complexity will be O(n^2)
        // This loop will traverse through the elements in the array and keep adding them.
        for(int j =0; j < orginalArray.length; j++ ) {

            // This will keep track of the sum
            currentSum = currentSum + orginalArray[j];

            // This condition will hold true until the given condition is satisfied
            while ( currentSum > expectedSum ) {
                currentSum = currentSum - orginalArray[i];
                i++;
            }

            //
            if ( currentSum == expectedSum ) {
                System.out.println( "Starting Index : " + i );
                System.out.println( "Ending Index : " + j );
                return;
            }


        }

        System.out.println("No such sub array was found.");


    }
}
