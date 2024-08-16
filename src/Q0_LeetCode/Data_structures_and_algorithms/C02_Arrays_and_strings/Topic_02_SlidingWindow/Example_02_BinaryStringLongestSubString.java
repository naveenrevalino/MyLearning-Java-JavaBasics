package Q0_LeetCode.Data_structures_and_algorithms.C02_Arrays_and_strings.Topic_02_SlidingWindow;

/**
TODO Example 02: Maximum Number of Consecutive 1's ( Binary String ).
 You are given a binary string s (a string containing only "0" and "1"). You may choose up to
 one "0" and flip it to a "1". What is the length of the longest substring achievable that contains only "1"?

HINT: Instead of looking for the longest sub-string with only "1", LOOK FOR LONGEST SUB-STRING WITH ONLY ONE "0"

For Example,
Input: numbers = "1101100111".
Output: 5
Explanation: If you perform the flip at index 2, the string becomes 1111100111.
 */
public class Example_02_BinaryStringLongestSubString {

    // Class Variable(s)
    static String originalString = "1101100111";

    public static void main(String[] args) {

        int finalAnswer = findLongestSubString( originalString );
        System.out.println( finalAnswer );

    }

    /**
        TODO SUDO CODE Logic
        1. keep track of leftBound and rightBound
        2. FOR-LOOP to move RightBound on each iteration
            On each iteration,
            2.1: IF ( originalString.charAt( rightBound ) == '0' ) - increment numberOfZerosInSubstring.
            2.2: WHILE-LOOP ( numberOfZerosInSubstring > 1 )
                2.2.1: IF ( originalString.charAt( leftBound ) == '0' ) - decrement numberOfZerosInSubstring.
                2.2.2: Increment leftBound.
     3. Calculate the length of longest substring with consecutive one's.
     4. Return the value.
     * @param originalString : The original binary sub-string.
     * @return : An integer, which is the length of the longest sub-string with consecutive one's.
     */
    public static int findLongestSubString( String originalString ) {

        // Method Variable(s)
        int leftBound = 0;
        int rightBound;
        int numberOfZerosInSubstring = 0;
        int lengthOfLongestSubstringWithOnes = 0;

        for( rightBound = 0; rightBound < originalString.length(); rightBound ++ ){

            if( originalString.charAt( rightBound )  == '0' ) {
                numberOfZerosInSubstring ++;
            }

            while( numberOfZerosInSubstring > 1 ){

                if( originalString.charAt( leftBound )  == '0' ){
                    numberOfZerosInSubstring --;
                }

                leftBound ++;
            }

            lengthOfLongestSubstringWithOnes = Math.max( lengthOfLongestSubstringWithOnes, ( rightBound - leftBound ) + 1 );
        }

        return lengthOfLongestSubstringWithOnes;
    }
}
