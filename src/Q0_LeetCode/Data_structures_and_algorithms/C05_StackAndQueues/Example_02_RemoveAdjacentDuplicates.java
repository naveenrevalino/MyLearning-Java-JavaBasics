package Q0_LeetCode.Data_structures_and_algorithms.C05_StackAndQueues;

import java.util.Stack;

/**
 * TODO You are given a string. Continuously remove duplicates (two of the same character beside each other) until you
 *  can't anymore. Return the final string after this.
 * Example: given s = "abbaca", you can first remove the "bb" to get "aaca". Next, you can remove the "aa" to get "ca". This is the final answer.
 */
public class Example_02_RemoveAdjacentDuplicates {

    // Class Variables:
    static String originalString = "abccba";

    public static void main(String[] args) {

        // Method Variables:
        Stack<Character> stack;

        stack = getStackAfterRemovingAdjacentDuplicate( originalString );
        System.out.println( stack );

    }

    /**
     * Given a string, this method will iterate over each character of the string and remove all adjacent duplicate
     * characters, until no more duplicates found.
     * @param originalString String to be tested.
     * @return Stack <Character>.
     */
    public static Stack<Character> getStackAfterRemovingAdjacentDuplicate( String originalString ){

        // Method Variables:
        Stack<Character> stack = new Stack<>();

        // ITERATOR: Iterate over each character of the given string.
        for( char eachCharacter : originalString.toCharArray() ){

            // CHECK ( If the stack is not empty and eachCharacter is equal to previous character we have in the stack.
            if( !stack.empty() && stack.peek() == eachCharacter ){

                // We will remove the respective character from the stack.
                stack.pop();

            }
            // CHECK ( Otherwise )
            else {
                // We keep adding the character to the stack
                stack.push( eachCharacter );
            }

        }

        // Return statement
        return stack;
    }

}
