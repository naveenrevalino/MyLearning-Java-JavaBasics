package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_TwoPointers;

/*
TODO Question 6:
 Given two strings "s" and "t", return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a sequence of characters that can be obtained by deleting some (or none) of the characters
from the original string, while maintaining the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde",
             while "aec" is not a subsequence of "abcde".
*/
public class Example_05_IsSubSequence {

    // Class Variable(s)
    static String string1 = "ace";
    static String string2 = "abcde";

    public static void main(String[] args) {

        boolean finalResult = checkIfSubSequenceOrNot(string1, string2);
        System.out.println( finalResult ? "GIven string is a sub sequence." : "Given string is not a sub sequence.");

    }

    private static boolean checkIfSubSequenceOrNot( String subString, String fullString ) {

        // Iterator of subString, initialized to index zero.
        int i = 0;
        // Iterator of fullString, initialized to index zero.
        int j = 0;

        /* The while loop is used to traverse both the string(s). In the above case it will stop only after
           traversing through all characters in the fullString.

           the length of the iterator of the subString is incremented only if a match is found, but the iterator of the
           fullString is incremented each time a comparison is done. If the subString is present in the fullString then
           the value of i will be equal to the length of the subString, else will be less than the length of subString.
        */
        while( i < subString.length() && j < fullString.length() ) {

            // Increment the iterator(i) of the subString only when a match is found.
            if( subString.charAt(i) == fullString.charAt(j) ) {
                i++;
            }

            // Increment the iterator(j) of the fullString each time.
            j++;
        }

        // If the iterator(i) is equal to the length of subString this function will return TRUE, otherwise FALSE.
        return i == subString.length();
    }
}
