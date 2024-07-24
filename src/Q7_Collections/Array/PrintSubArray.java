package Q7_Collections.Array;

public class PrintSubArray {

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

        int expectedSum = 33;
        int currentSum = 0;


        int[] orginalArray = { 1, 4, 20, 3, 10, 5 };

        // Logic to print sub array:

        // This loop will always point to the starting element of the array
        for(int i =0; i < orginalArray.length; i++ ) {

            // This loop will always point to the ending element of the array
            for(int j = i; j < orginalArray.length; j++) {

                // This loop will print all the element from the starting rage till the ending range
                for(int k = i; k<=j; k++) {

                    // Print each element between the specified range
                    System.out.print( "[ " + orginalArray[k] + " ]" );

                }
                System.out.println();
            }


        }
    }
}



//            for ( int j = i ; j < orginalArray.length; j++ ) {
//
//                currentSum = orginalArray[j] + currentSum;
//                System.out.print( "[ " + orginalArray[j] + " ]");
//
//
//
//            }
//            System.out.print(  "   [ " + " Sum : " + currentSum + " ]");
//            currentSum = 0;
//            System.out.println();


