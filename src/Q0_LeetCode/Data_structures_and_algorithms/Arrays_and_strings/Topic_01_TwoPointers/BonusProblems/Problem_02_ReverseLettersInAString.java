package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_01_TwoPointers.BonusProblems;


import java.util.regex.Pattern;

/*
    TODO: Problem 01: Given a string s, reverse the string according to the following rules:
     All the characters that are not English letters remain in the same position.
     All the English letters (lowercase or uppercase) should be reversed.
     Return s after reversing it.

     Example 1:
     Input: s = "ab-cd"
     Output: "dc-ba"

     Example 2:
     Input: s = "a-bC-dEf-ghIj"
     Output: "j-Ih-gfE-dCba"

     Example 3:
     Input: s = "Test1ng-Leet=code-Q!"
     Output: "Qedo1ct-eeLg=ntse-T!"

 */
public class Problem_02_ReverseLettersInAString {

    // Class Variable(s):
    static String originalString = "a-bC-dEf-ghIj";

    public static void main(String[] args) {

        int lengthOfString = originalString.length() - 1;

        // Time: O(n)
        char[] convertedToCharArray = convertToArray( originalString );

        // Time: O(n)
        swapCharacters( convertedToCharArray, 0, lengthOfString );

        String finalResult = new String( convertedToCharArray );
        System.out.println( finalResult );
    }

    public static char[] convertToArray( String originalString ){

        return originalString.toCharArray();
    }

    public static void swapCharacters( char[] convertedToCharArray, int startBound, int endBound ){

        while( startBound < endBound ){

            if( Character.isLetter( convertedToCharArray[ startBound ]) && Character.isLetter( convertedToCharArray[ endBound ]) ){
                char tempStore = convertedToCharArray[ startBound ];
                convertedToCharArray[ startBound ] = convertedToCharArray[ endBound ];
                convertedToCharArray[ endBound ] = tempStore;
                startBound ++;
                endBound --;
            }

            if( !Character.isLetter( convertedToCharArray[ startBound ]) ){
                startBound ++;
            }
            if( !Character.isLetter( convertedToCharArray[ endBound ]) ){
                endBound --;
            }
        }

    }

}