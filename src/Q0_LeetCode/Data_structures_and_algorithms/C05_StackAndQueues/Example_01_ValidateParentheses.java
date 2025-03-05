package Q0_LeetCode.Data_structures_and_algorithms.C05_StackAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * TODO Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string
 *  is valid. The string is valid if all open brackets are closed by the same type of closing bracket in the correct
 *  order, and each closing bracket closes exactly one open bracket.
 * Example, originalString = "({})" OR "(){}[]" are valid, but originalString = "(]" OR "({)}" are not valid.
 */
public class Example_01_ValidateParentheses {

    // Class Variables:
    static String originalString = "{([]){}}";
    static String invalidString = "{([])}}";

    public static void main(String[] args) {

        // Method Variables:
        boolean finalResult;
        finalResult = isValidString( originalString );
        System.out.println("Final Result: " + finalResult );

    }

    /**
     * This method will check if all the open brackets are closed by the same type of closing bracket in the correct
     * order, and each closing bracket closes exactly one open bracket. If the condition is satisfied the method will
     * return true, else false.
     * NOTE: If all open brackets have its respective closing brackets, then the stack will be empty at the end.
     * @param originalString String to be tested.
     * @return boolean
     */
    public static boolean isValidString( String originalString ){

        // Method Variables:
        Map<Character,Character> matchingBracketsMap = getMatchingMap();
        Stack<Character> stack = new Stack<>();


        // ITERATOR: Iterate over each character of the given string.
        for( char eachCharacter : originalString.toCharArray() ){

            // CHECK ( Look For Opening Brackets ): If eachCharacter is a key in the map.
            if( matchingBracketsMap.containsKey( eachCharacter ) ){
                // PUSH eachCharacter to the stack. Stack will hold the most recent character at the top of it.
                stack.push( eachCharacter );
            }
            // CHECK ( Look For Closing Brackets ): If eachCharacter is not a key in the map.
            else
            {

                // CHECK ( If the stack is empty, then return false )
                if( stack.empty() ){
                    return false;
                }

                // Get the previous character from the stack, using pop function.
                char previousChar = stack.pop();

                // CHECK ( If the value of the previousChar from the map is not equal to eachCharacter )
                if( matchingBracketsMap.get( previousChar ) != eachCharacter ){

                    // Since the previousCharacter does not have a matching closing bracket, we can return false.
                    return false;
                }
            }

        }

        // Return statement
        return stack.empty();
    }

    /**
     * This method will auto populate the MAP with all possible bracket types.
     * Map key:   Will be the opening bracket, example "(".
     * Map value: Will be the closing bracket, example ")".
     * @return Map<Character,Character>
     */
    public static Map<Character,Character> getMatchingMap(){

        // Method Variables:
        Map<Character,Character> matchingBracketsMap = new HashMap<>();

        matchingBracketsMap.put('(', ')');
        matchingBracketsMap.put('[', ']');
        matchingBracketsMap.put('{', '}');

        // Return statement
        return matchingBracketsMap;

    }

}
