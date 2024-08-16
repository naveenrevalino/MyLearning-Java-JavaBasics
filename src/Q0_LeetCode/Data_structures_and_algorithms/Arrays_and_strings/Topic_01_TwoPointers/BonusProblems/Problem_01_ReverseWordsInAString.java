package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_01_TwoPointers.BonusProblems;


import java.util.Arrays;
import java.util.regex.Pattern;

/*
    TODO: Problem 01: Given a string s, reverse the order of characters in each word within a sentence while still
     preserving whitespace and initial word order.

     Example 1:
     Input: s = "Let's take LeetCode contest"
     Output: "s'teL ekat edoCteeL tsetnoc"

     Example 2:
     Input: s = "Mr Ding"
     Output: "rM gniD"

 */
public class Problem_01_ReverseWordsInAString {

    // Class Variable(s):
    static String originalString = "Let's take LeetCode contest";

    public static void main(String[] args) {


        int startBound = 0;
        int lengthOfString = originalString.length();
        Pattern finnalPattern = createRegxExpression( " ");

        // Time: O(n)
        char[] convertedToCharArray = convertToArray( originalString );

        // Time: O(n)
        // iterate through the entire array using a FOR LOOP.
        for( int index = 0; index <= lengthOfString; index ++){

            // check if endBound is equal to the length of array || value at endBound is equal to white-space
            if( index == lengthOfString || String.valueOf( convertedToCharArray[ index ] ).matches(String.valueOf(finnalPattern)) ){

                int endBound = index -1;
                swapCharacters( convertedToCharArray, startBound, endBound);
                startBound = index + 1;
            }

        }

        String finalResult = new String( convertedToCharArray );
        System.out.println( finalResult );
    }

    public static char[] convertToArray( String originalString ){

        return originalString.toCharArray();
    }

    public static void swapCharacters( char[] convertedToCharArray, int startBound, int endBound ){

        while( startBound < endBound ){
            char tempStore = convertedToCharArray[ startBound ];
            convertedToCharArray[ startBound ] = convertedToCharArray[ endBound ];
            convertedToCharArray[ endBound ] = tempStore;
            startBound ++;
            endBound --;
        }
    }

    public static Pattern createRegxExpression( String expressionAsString ){
        Pattern myCustomPattern = Pattern.compile(expressionAsString, Pattern.CASE_INSENSITIVE);
        return myCustomPattern;
    }

}