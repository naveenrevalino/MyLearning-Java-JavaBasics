package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO Given a string s, find the length of the longest substring without repeating characters.
 * Example: Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Notice that the answer must be
 * a substring, "pwke" is a subsequence and not a substring.
 */
public class Example_21_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        // Method Variables:
        String originalString = "pwwkew";
        int count = 0;

        count = slidingWindow( originalString );
        System.out.println( count );

    }

    public static int slidingWindow( String originalString ){

        // Method Variables:
        int leftBound = 0;
        int rightBound;
        Set<Character> characterSet = new HashSet<>();
        int answer = 0;

        for( rightBound = 0; rightBound < originalString.length(); rightBound++ ){

            if( !characterSet.contains( originalString.charAt( rightBound ) ) ){
                characterSet.add( originalString.charAt( rightBound )  );
            } else {

                leftBound++;
                answer = Math.max( answer, rightBound - leftBound + 1);
                leftBound = rightBound;

            }
        }

        // Return statement.
        return answer;
    }


}
