package Q0_LeetCode.Data_structures_and_algorithms.Arrays_and_strings.Topic_02_TwoPointers;


import java.util.Arrays;

/*
TODO Example 4 : Write a function that reverses a string. The input string is given as an array of characters s.
Condition: You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class Example_04_ReverseString {

    // Class Variable(s)
    static char[] s = new char[] { 'n', 'a', 'v', 'e', 'e', 'n' };

    public static void main(String[] args) {

        // Given string array = nav, expected string array = van.
        // This can be done using two pointer method, one starting from index(0) and the second one starting from index(length -1).
        // use a temp variable and exchange the value of both the index values.

        reverseGivenArray(s);

    }

    public static void reverseGivenArray( char[] s ) {

        int left = 0;
        int right = s.length - 1;

        while( left < right ) {

            char leftString = s[left];
            char rightString = s[right];

            s[left] = rightString;
            s[right] = leftString;

            left ++;
            right --;

            /*
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
            */


        }

        System.out.println(Arrays.toString(s));
    }
}
