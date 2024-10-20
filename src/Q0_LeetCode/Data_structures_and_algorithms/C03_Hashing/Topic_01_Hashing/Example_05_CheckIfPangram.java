package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: A pangram is a sentence where every letter of the English alphabet appears at least once.
 *  Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 */
public class Example_05_CheckIfPangram {

    // Class Variable(s):
    static String givenSentence = "thequickbrownfoxjumpsoverthelazydog";

    public static void main(String[] args) {

        boolean finalResult;

        finalResult = checkIfSentenceIsPangram( givenSentence );
        finalResult = alternateCheckIsPangram( givenSentence );
        System.out.println( finalResult );



    }

    /**
     * TODO: SUDO CODE
     * 1. Declare an HashSet<Character>.
     * 2. FOR-LOOP: iterate given string and add each character to the HashSet.
     * 3. IF CHECK: if the size of the HashSet = 26, if yes return TRUE, else return FALSE.
     *
     * @param givenSentence a sentence.
     * @return true is pangram else return false
     */
    public static boolean checkIfSentenceIsPangram( String givenSentence ){

        // Method Variable(s):
        boolean isPangram = false;
        Set<Character> characterSet = new HashSet<>();

        // If the length of the sentence is less than 26 then we don't have to do any computation, simply return FALSE.
        if ( givenSentence.length() < 26 ){
            return isPangram;
        } else {

            // if length of given sentence is equal to 26 or more than 26, then perform the complex computation.
            for (char eachChar : givenSentence.toCharArray()) {
                characterSet.add(eachChar);
            }

            // Check if the final size of the SET is equal to 26? Then set isPangram to TRUE.
            if( characterSet.size() == 26 ){
                isPangram = true;
            }
        }

        // Final return statement.
        return isPangram;
    }

    public static boolean alternateCheckIsPangram( String givenSentence ) {

        // Method Variable(s):
        boolean isPangram = true;

        // FOR-LOOP : to iterate through each character in english alphabet.
        for( char eachAlphabet = 'a'; eachAlphabet <= 'z'; eachAlphabet ++ ){

            // IF-CHECK : to check if each alphabet is present in the given sentence.
            if( givenSentence.indexOf( eachAlphabet  ) < 0 ){
                isPangram = false;
            }
        }

        // Final return statement.
        return isPangram;
    }
}
