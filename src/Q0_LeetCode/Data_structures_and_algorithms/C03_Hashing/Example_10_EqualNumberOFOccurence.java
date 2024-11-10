package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Check if All Characters Have Equal Number of Occurrences:
 * TODO Given a string s, determine if all characters have the same frequency.
 * Example: given s = "abacbc", return true. All characters appear twice. Given s = "aaabb", return false.
 * "a" appears 3 times, "b" appears 2 times. 3 != 2.
 */
public class Example_10_EqualNumberOFOccurence {

    public static void main(String[] args) {

        // Method Variable(s):
        Map< Character, Integer > frequencyMap = new HashMap<>();
        String originalString = "abacbcee";
        char[] originalStringArray = originalString.toCharArray();
        boolean finalResult = false;

        frequencyMap = determineEachCharacterFrequency ( originalStringArray );
        System.out.println( frequencyMap );

        finalResult = checkIfFrequencyIsSameForAllCharacters( frequencyMap );
        System.out.println( finalResult );

    }

    /**
     * Will compute the frequency of each element(s) in a given character array.
     * Frequency meaning : number of times an element occur within the array.
     * @param originalStringArray : Character array representation of the original string.
     * @return : HashMap : frequencyMap.
     */
    public static Map< Character, Integer > determineEachCharacterFrequency( char[] originalStringArray ){

        // Method Variable(s)
        Map< Character,Integer > frequencyMap = new HashMap<>();

        // FOR-LOOP: Will iterate over each char of the original string and determine the frequency of each.
        for( char eachCharacter : originalStringArray ){
            frequencyMap.put( eachCharacter, frequencyMap.getOrDefault(eachCharacter, 0) +1  );
        }

        // Return Final Result
        return frequencyMap;
    }

    /**
     * This method will return TRUE if all the characters in the given map have the same frequency, else FALSE.
     * @param frequencyMap : HashMap containing frequency of each character
     * @return : boolean value
     */
    public static boolean checkIfFrequencyIsSameForAllCharacters( Map< Character, Integer > frequencyMap ){

        // Method Variable(s)
        boolean didCharsAppearSameNumberOfTimes = false;
        Set< Integer > resultSet = new HashSet<>();
        int sizeOfResultSize = 0;

        // BULK-ADD: add all the values of the set.
        resultSet.addAll( frequencyMap.values() );
        sizeOfResultSize = resultSet.size();

        if( sizeOfResultSize == 1 ){
            didCharsAppearSameNumberOfTimes = true;
        }

        // Return final result
        return didCharsAppearSameNumberOfTimes;

    }
}
