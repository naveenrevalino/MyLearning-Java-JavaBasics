package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_SlidingWindow;

/*
TODO Example 02: You are given a binary string s (a string containing only "0" and "1"). You may choose up to
 one "0" and flip it to a "1". What is the length of the longest substring achievable that contains only "1"?

For example, given s = "1101100111", the answer is 5. If you perform the flip at index 2, the string becomes 1111100111.
 */
public class Example_02_BinaryStringLongestSubString {

    // Class Variable(s)
    static String originalString = "1101100111";


    public static void main(String[] args) {

        int finalAnswer = findLongestSubString( originalString );
        System.out.println( finalAnswer );

    }

    /**
     * This method will identify the longest possible sub-string for a given binary string ( originalString ).
     * CONDITION: You may choose up to one "0" and flip it to "1". What is the length of the longest sub-string with only "1".
     * HINT: Instead of looking for the longest sub-string with only "1", LOOK FOR LONGEST SUB-STRING WITH ONLY ONE "0".
     *
     * @param originalString : The original binary sub-string.
     * @return : An integer, which is the length of the longest sub-string.
     */
    public static int findLongestSubString( String originalString ) {

        /**
         * SUDO CODE Logic
         *
         * int LeftBond CharAt(0)
         * int RightBond CharAt(0)
         *
         * ForLoop - to traverse through the entire string by incrementing the RightBound
         * inside the for-loop, we will check if originalString.charAt( rightBound )  == 0, if yes increment countOfZerosInSubString.
         *
         * WhileLoop - to check if countOfZerosInSubString > 1, while the condition is true
         * check if originalString.charAt( leftBound ) == 0, if yes decrement countOfZerosInSubString.
         * also increment the position of leftBound outside of if check.
         */

        // Method Variable(s)
        int leftBound = 0;
        int rightBound;
        int countOfZerosInSubString = 0;
        int longestSubStringWithOneZero = 0;

        for( rightBound = 0; rightBound < originalString.length(); rightBound ++ ){

            if( originalString.charAt( rightBound )  == '0' ) {
                countOfZerosInSubString ++;
            }

            while( countOfZerosInSubString > 1 ){

                if( originalString.charAt( leftBound )  == '0' ){
                    countOfZerosInSubString --;
                }

                leftBound ++;
            }

            longestSubStringWithOneZero = Math.max( longestSubStringWithOneZero, ( rightBound - leftBound ) + 1 );
        }


        return longestSubStringWithOneZero;
    }
}
