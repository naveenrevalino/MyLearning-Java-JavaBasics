package Q0_LeetCode.Data_structures_and_algorithms.C02_Arrays_and_strings.Topic_01_TwoPointers;

public class Example_01_TwoPointer {

    // Class Variable(s): Array of type string.
    static String[] myArray = new String[] {"n", "a", "v", "e", "e", "n"};

    public static void main(String[] args) {
        twoPointerArray( myArray );
    }

    public static void twoPointerArray( String[] myArray ) {

        /*
            int left = demotes the first index [ index[0] ] of the array
            int right = demotes the last index [ index[5] ] of the array
         */
        int left = 0;
        int right = myArray.length - 1;

        /* The while loop is used to traverse the array from both the ends until they meet in the middle */
        while ( left < right ) {

            System.out.println( "Left: " + myArray[left]);
            System.out.println( "Right: " + myArray[right]);

            /* Increment the left pointer */
            left++;
            /* Decrement the right pointer */
            right--;

        }
    }
}
