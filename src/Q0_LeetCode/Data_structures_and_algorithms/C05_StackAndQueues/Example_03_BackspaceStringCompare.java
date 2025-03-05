package Q0_LeetCode.Data_structures_and_algorithms.C05_StackAndQueues;

import java.util.Stack;

/**
 * TODO Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means
 *  a backspace character.
 * Example, given s = "ab#c" and t = "ad#c", return true. Because of the backspace, the strings are both equal to "ac".
 */
public class Example_03_BackspaceStringCompare {

    // Class Variables:
    static String stringOne = "ab#c";
    static String stringTwo = "ad#c";
    public static void main(String[] args) {

        // Method Variables:
        Stack<Character> stackForStringOne;
        Stack<Character> stackForStringTwo;

        stackForStringOne = generateStackForGivenString( stringOne );
        stackForStringTwo = generateStackForGivenString( stringTwo );

        // CHECK ( If StringOne and StringTwo are the same after modification )
        System.out.println("Final Result: " + stackForStringOne.equals( stackForStringTwo ) );

    }

    /**
     * Given a string, this method will iterate over each character and every time it encounters a #, it will remove the
     * previous character from the string.
     * @param originalString String to be modified
     * @return Stack <Character>
     */
    public static Stack<Character> generateStackForGivenString( String originalString ){

        // Method Variables:
        Stack<Character> stack = new Stack<>();

        // ITERATOR: Iterate over each character of the given string.
        for( char eachCharacter : originalString.toCharArray() ){

            // CHECK ( If the current character is # )
            if( eachCharacter == '#' ){

                // if the above condition is true, we will pop the top most character from the stack.
                stack.pop();
            }

            // CHECK ( Otherwise )
            else {

                // We will keep pushing characters to the stack.
                stack.push( eachCharacter );
            }
        }

        // Return statement
        return stack;

    }
}
