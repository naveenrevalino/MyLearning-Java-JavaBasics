package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_TwoPointers;

/*
 TODO Example 2: Given a string s, return true if it is a palindrome, false otherwise.
A string is a palindrome if it reads the same forward as backward. That means, after reversing it, it is still
the same string.
 */

public class Example_02_CheckIfPalindrome {

    public static void main(String[] args) {

        System.out.println( checkPalindrome( "ABCdcba".toLowerCase() ) ? "Given string is palindrome." : "Given string is not palindrome" );

    }

    public static boolean checkPalindrome( String stringToCheck ) {

        /*
            int left = demotes the first character [ charAt[0] ] of the string
            int right = demotes the last character [ charAt[5] ] of the string
         */
        int left = 0;
        int right = stringToCheck.length() - 1;

        /* The while loop is used to traverse the string from both the ends until they meet in the middle */
        while ( left < right ) {

            /*
            If the charAt( left ) not equal to the charAt( right ), the given string is not palindrome,
            return false and terminate the while loop.
            */
            if ( stringToCheck.charAt( left ) != stringToCheck.charAt( right ) ) {
                return false;
            }

            /* Increment the left pointer */
            left++;
            /* Decrement the right pointer */
            right--;
        }
        /* Otherwise the give string is a palindrome, hence return true. */
        return true;
    }
}
