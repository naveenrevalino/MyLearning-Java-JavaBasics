package Q7_Collections.Array.hourglass;

public class HourGlassFive {

    /**
     * This problem is for a 2D Array
     * For hour glass to exist in the array the minimum number of rows and columns should not be less than 3.
     *
     * What is an hour glass : Example below : this has 4 different hour glasses.
     * [1] [1] [1] [1] [1]
     * [0] [1] [0] [1] [0]
     * [1] [1] [2] [2] [2]
     * [1] [0] [1] [1] [1]
     * [1] [1] [2] [2] [8]
     *
     * in this case the max sum oof the hour glass is : 7
     */

    public static void main(String[] args) {

        // Method variable
        int finalSum = 0;

        // Initialize a 2D array, with 3 rows and 3 columns
        int[][] sampleArray = {
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {1, 1, 2, 2, 2},
                {1, 0, 1, 1, 1},
                {1, 1, 2, 2, 8}
        };

        // Travers through each row in the array
        for ( int i =0; i <5; i++ ) {
            // Travers through each column in the array
            for ( int j = 0; j < 5; j++) {
                System.out.print( "[ " + sampleArray[i][j] + " ]" );
            }
            System.out.println();
        }

        // Read the elements in the hour glass:
        // Travers through each row in the array
        for ( int i =0; i <3; i++ ) {
            // Travers through each column in the array
            for ( int j = 0; j < 3; j++) {
//                ( sampleArray[i][j] + sampleArray[i][j + 1] );
                int sum = (sampleArray[i][j] + sampleArray[i][j + 1] + sampleArray[i][j + 2]) +
                        (sampleArray[i + 1][j + 1]) +
                        (sampleArray[i + 2][j] + sampleArray[i + 2][j + 1] + sampleArray[i + 2][j + 2]);

                finalSum = Math.max( finalSum, sum );
            }
        }

        System.out.println( "Sum of the elements in the hour glass is : " + finalSum );
}
}
