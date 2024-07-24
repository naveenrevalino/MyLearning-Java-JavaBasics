package Q7_Collections.Sorting;

import java.util.Arrays;

public class OddNumberFirstAndThenEvenNumbers {

    public static void main(String[] args) {

        int[] mixedArray = { 1, 3, 5, 4, 2, 6, 9, 10 };
        int indexToTrackOddNumber = 0;

        // Find the first even number
        while( indexToTrackOddNumber < mixedArray.length && !( mixedArray[ indexToTrackOddNumber ] % 2 == 0 ) ) {
            indexToTrackOddNumber++;
        }

        // Rearrange the array such that odd numbers come first
        for ( int j = indexToTrackOddNumber + 1; j < mixedArray.length; j++ ) {

            if( mixedArray[j]%2 != 0 ) {
                int temp = mixedArray[ indexToTrackOddNumber ];
                mixedArray[ indexToTrackOddNumber ] = mixedArray[ j ];
                mixedArray[ j ] = temp;
                indexToTrackOddNumber++;
            }
        }

        System.out.println("New Array: " + Arrays.toString(mixedArray));




//        int[] outputArray = new int[mixedArray.length];
//        int count = 0;
//
//        for (int i=0; i < mixedArray.length; ++i) {
//
//            // if (mixedArray[i] % 2 == 0) outputArray[count++] = mixedArray[i];
//            if (mixedArray[i] % 2 == 0) {
//                outputArray[count] = mixedArray[i];
//                count++;
//            }
//        }
//
//        for (int i=0; i < mixedArray.length; ++i) {
//
//            // if (mixedArray[i] % 2 == 1) outputArray[count++] = mixedArray[i];
//            if (mixedArray[i] % 2 == 1) {
//                outputArray[count] = mixedArray[i];
//                count++;
//            }
//        }
    }
}
