package Q0_LeetCode.Data_structures_and_algorithms.C05_StackAndQueues;

import java.util.Stack;

public class Example_04_SimplifyPath {

    // Class Variables:
    static String orginalString = "/a/b///c/.././d/../f";
    public static void main(String[] args) {

        // Method Variables:
        String[] stringArray;
        Stack<String> charactersAsStack;
        String formattedString;

        stringArray = splitTheString( orginalString );
        charactersAsStack = generateCharacterStack( stringArray );
        formattedString = printFinal( charactersAsStack );

        System.out.println("Formatted String: " + formattedString );

    }

    /**
     * This method will remove all the "/" from the original string.
     * @param originalString String to be modified.
     * @return String[] Array
     */
    public static String[] splitTheString( String originalString ){

        // Method Variables:
        String[] stringArray;

        stringArray = originalString.split("/");

        // Return statement
        return stringArray;

    }

    /**
     * This method will iterate through each element of the array, everytime it comes across a "..", it will remove the
     * previous character from the string. Because ".." means go one step above the directory level in unix.
     * @param stringArray String[] Array
     * @return Stack <String>
     */
    public static Stack<String> generateCharacterStack( String[] stringArray ){

        // Method variables:
        Stack<String> charactersAsStack = new Stack<>();

        // ITERATOR: Iterate over each item in the array.
        for( String eachString : stringArray){

            // CHECK ( If the item is not empty and not equal to "." )
            if( !eachString.isEmpty() && !eachString.equals(".") ){

                // CHECK ( If the item is equal to ".." )
                if( eachString.equals("..") ){

                    // CHECK ( If the stack is not empty )
                    if( !charactersAsStack.isEmpty() ){

                        // Remove the character that occurred just before "..".
                        charactersAsStack.pop();
                    }

                }

                // CHECK ( Otherwise )
                else {
                    charactersAsStack.push( eachString );
                }

            }

        }

        // Return statement
        return charactersAsStack;
    }

    /**
     * This method will add back the "/" ahead of each character in the given stack.
     * @param charactersAsStack Stack <String>
     * @return String
     */
    public static String printFinal( Stack<String> charactersAsStack ){

        // Given a delimiter and an iterable element, the join function will add the delimiter ahead of each element in the stack.
        String formatedString = "/" + String.join("/", charactersAsStack );

        // Return statement
        return formatedString;
    }
}
