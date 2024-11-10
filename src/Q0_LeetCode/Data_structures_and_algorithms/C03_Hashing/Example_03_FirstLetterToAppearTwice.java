package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Example 03: Given a string s, return the first character to appear twice. It is guaranteed that the input will
 *  have a duplicate character.
 */
public class Example_03_FirstLetterToAppearTwice {

    // Class Variable(s):
    static String givenWord = "abcdeda";

    public static void main(String[] args) {

        char finalResult = getDuplicateCharacter( givenWord );
        System.out.println( finalResult );

    }

    /**
     * TODO: SUDO CODE
     * 1. Declare an empty set that will hold only characters.
     * 2. LOOP - to iterate the entire word, look for each character.
     *  2.1: Check if the current character is in the set, if YES return the character, ELSE add the character to the set.
     * 3. Return empty character.
     *
     * @param givenWord: A string.
     * @return the first character that appear twice.
     */
    public static char getDuplicateCharacter( String givenWord ){

        // Method Variable(s):
        Set<Character> characterSet = new HashSet<>();

        for( int i = 0; i < givenWord.length(); i ++ ){
            char currentChar = givenWord.charAt(i);

            if( characterSet.contains( currentChar ) ){
                return  currentChar;
            }

            characterSet.add( currentChar );
        }
        return ' ';
    }


}
