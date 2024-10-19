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

        boolean finalResult = checkIfSentenceIsPangram( givenSentence );
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

        for( char eachChar : givenSentence.toCharArray() ) {
            characterSet.add( eachChar );
        }

        if( characterSet.size() == 26 ){
            isPangram = true;
        }

        return isPangram;
    }
}
