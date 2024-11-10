package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters
 *  from magazine and false otherwise. Each letter in magazine can only be used once in ransomNote.
 * Example: Input: ransomNote = "a", magazine = "b" Output: false
 * Input: ransomNote = "aa", magazine = "aab" Output: true
 */
public class Example_19_RansomNote {

    public static void main(String[] args) {

        // Method Variables:
        String ransomNote = "a";
        String magazine = "b";

        Map<Character, Integer> findFrequencyOfMagazine = new HashMap<>();
        boolean finalResult = false;


        findFrequencyOfMagazine = findFrequencyOfMagazine(magazine);
        finalResult = canItBeConstructedUsingTheLettersInMagazine( ransomNote, findFrequencyOfMagazine );
        System.out.println( finalResult );
    }

    /**
     * Given a string, this method will iterate through each character of the given string and compute the frequency of each character.
     * @param magazine String
     * @return A map [ Map<Character, Integer> ]
     */
    public static Map<Character, Integer> findFrequencyOfMagazine(String magazine){

        // Method Variables:
        Map<Character, Integer> findFrequencyOfMagazine = new HashMap<>();
        char[] convertingStringToCharArray = magazine.toCharArray();

        // ITERATOR: iterate through each character of the array.
        for( char eachCharacter : convertingStringToCharArray ){
            findFrequencyOfMagazine.put( eachCharacter, findFrequencyOfMagazine.getOrDefault( eachCharacter,0) + 1);
        }

        // Return statement.
        return findFrequencyOfMagazine;
    }

    /**
     * Given a string and a frequency map of another string, this method will check if the string can be constructed using
     * the characters we have in the frequency map.
     * @param ransomNote String
     * @param findFrequencyOfMagazine Map [ Map<Character, Integer> ]
     * @return Boolean
     */
    public static boolean canItBeConstructedUsingTheLettersInMagazine( String ransomNote, Map<Character, Integer> findFrequencyOfMagazine){

        // Method variables:
        boolean finalResult = true;

        // ITERATOR: Iterate over each character of the string
        for( Character eachCharacter : ransomNote.toCharArray() ){

            // Check: If each character IS NOT in the  map [OR] If the value of the character is equal to zero in the map.
            if( !findFrequencyOfMagazine.containsKey( eachCharacter ) || findFrequencyOfMagazine.get( eachCharacter ) == 0 ){
                finalResult = false;
            }

            // Put: each character in the map and decrement the value by 1 if it is not zero.
            findFrequencyOfMagazine.put( eachCharacter, findFrequencyOfMagazine.getOrDefault( eachCharacter,0 ) -1 );
        }

        // Return statement.
        return finalResult;
    }
}
