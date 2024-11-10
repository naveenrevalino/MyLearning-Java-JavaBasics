package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing;

import java.util.Arrays;

/**
 * TODO Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *  You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * Example:
 * Input: text = "nlaebolko"
 * Output: 1
 */
public class Example_13_MaximumNumberOfBalloons {

    public static void main(String[] args) {

        // Method Variable(s):
        String originalText = "nlaebolko";
        String desiredPattern = "balloon";
        int[] frequencyOfOriginalText = new int[ 26 ];
        int[] frequencyOfPattern = new int[ 26 ];
        int maxNumberOfPattern = 0;

        // Function call 1: getFrequencyOfOriginalText()
        frequencyOfOriginalText = getFrequencyOfOriginalText( originalText );

        // Function call 2: getFrequencyOfPattern()
        frequencyOfPattern =  getFrequencyOfPattern( desiredPattern );

        // Function call 3: getMaxNumberOfPatternPossible()
        maxNumberOfPattern = getMaxNumberOfPatternPossible( frequencyOfOriginalText, frequencyOfPattern );

        // Print the final result to console
        System.out.println("Final Result: " + maxNumberOfPattern );

    }

    /**
     * This method converts the given string into a frequency array. It will iterate through each character of the string
     * string.charAt(i) - 'a' converts the character to an index. For example, if the character is 'a', this will evaluate
     * to 0; if it's 'b', it will evaluate to 1, and so on. The result is used as an index to increment the corresponding
     * position in the frequencyOfOriginalText array. This assumes that frequencyOfOriginalText is an array that counts
     * the occurrences of each letter from 'a' to 'z'.
     * @param originalText : String
     * @return : int[] frequencyOfOriginalText
     */
    public static int[] getFrequencyOfOriginalText( String originalText ){

        // Method Variable(s):
        int englishAlphabetCount = 26;
        int OriginalTextLength = originalText.length();
        int[] frequencyOfOriginalText = new int[ englishAlphabetCount ];

        // FOR-LOOP: It will iterate through each character of the string.
        // originalText.charAt(i) - 'a' converts the character to an index, a->0, b->1, ..z->25
        for (int i = 0; i < OriginalTextLength; i++) {
            frequencyOfOriginalText[ originalText.charAt(i) - 'a' ] ++;
        }
        System.out.println("Original Text Frequency Array: " + Arrays.toString( frequencyOfOriginalText ) );

        // Return the final result
        return frequencyOfOriginalText;
    }

    /**
     * This method converts the given string into a frequency array. It will iterate through each character of the string
     * string.charAt(i) - 'a' converts the character to an index. For example, if the character is 'a', this will evaluate
     * to 0; if it's 'b', it will evaluate to 1, and so on. The result is used as an index to increment the corresponding
     * position in the frequencyOfDesiredPattern array. This assumes that frequencyOfOriginalText is an array that counts
     * the occurrences of each letter from 'a' to 'z'.
     * @param desiredPattern : String
     * @return : int[] frequencyOfDesiredPattern
     */
    public static int[] getFrequencyOfPattern( String desiredPattern ){

        // Method Variable(s):
        int englishAlphabetCount = 26;
        int lengthOfPattern = desiredPattern.length();
        int[] frequencyOfDesiredPattern = new int[ englishAlphabetCount ];

        // FOR-LOOP: It will iterate through each character of the desired pattern.
        // desiredPattern.charAt(i) - 'a' converts the character to an index, a->0, b->1, ..z->25
        for (int i = 0; i < lengthOfPattern; i++) {
            frequencyOfDesiredPattern[ desiredPattern.charAt(i) - 'a' ] ++;
        }
        System.out.println("Desired Pattern Frequency Array: " + Arrays.toString( frequencyOfDesiredPattern ) );

        // Return the final result
        return frequencyOfDesiredPattern;
    }

    /**
     * This method compares the frequency array of OriginalText and DesiredPatter, and determine how many such instance of pattern can be formed.
     * @param frequencyOfOriginalText : Integer Array : contains frequency of each character from the original text.
     * @param frequencyOfDesiredPattern : Integer Array : contains frequency of each character from the desired pattern text.
     * @return : Integer : Which is the maximum number of possible pattern.
     */
    public static int getMaxNumberOfPatternPossible( int[] frequencyOfOriginalText, int[] frequencyOfDesiredPattern ){

        // Method Variable(s)
        int maxNumberOfPattern = Integer.MAX_VALUE;
        int englishAlphabetCount = 26;

        // FOR-LOOP: A generic loop to iterate from a - z / 0 - 26
        for (int i = 0; i < englishAlphabetCount; i++) {

            // This check will discard any frequency with value ZERO, because we don't want to divide a number by zero.
            if ( frequencyOfDesiredPattern[i] > 0) {
                maxNumberOfPattern = Math.min( maxNumberOfPattern, frequencyOfOriginalText[i] / frequencyOfDesiredPattern[i] );
            }

        }

        // Return final result
        return maxNumberOfPattern;
    }
}
