package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;


import java.util.HashMap;
import java.util.Map;

/**
 * Question: You are given a string s and an integer k. Find the length of the longest substring that contains at most k distinct characters.
 *
 * Example,
 * given s = "eceba" and k = 2, return 3. The longest substring with at most 2 distinct characters is "ece".
 */
public class Example_08_LongestSubString {

    public static void main(String[] args) {

        // Method Variables
        String givenString = "eceba";
        int numberOfDistinctCharacters = 2;

        int finalResult = computeLongestSubstring( givenString, numberOfDistinctCharacters );
        System.out.println( finalResult );
    }

    /**
     * For a give string, this method will compute the frequency of n(numberOfDistinctCharacters), and return the sum
     * of the frequencies.
     * @param givenString : Original string.
     * @param numberOfDistinctCharacters : How many distinct characters we want to track.
     * @return : Integer, sum or frequency of two distinct characters from the given string.
     */
    public static int computeLongestSubstring( String givenString, int numberOfDistinctCharacters ){

        // Method Variable(s)
        int subStringCount = 0;
        char[] charArray = givenString.toCharArray();
        Map< Character, Integer > substringHashMap = new HashMap<>();

        for( char eachCharacter : charArray ){

            // Check if the HashMap is empty OR current character is not in the key set of the HashMap.
            if( substringHashMap.isEmpty() || ( !substringHashMap.containsKey( eachCharacter ) && substringHashMap.size() < numberOfDistinctCharacters ) ){
                substringHashMap.put( eachCharacter, 1 );
            // If the HashMap has the key, then increment the value by one.
            } else if ( substringHashMap.containsKey( eachCharacter ) && substringHashMap.size() <= numberOfDistinctCharacters ) {
                substringHashMap.put( eachCharacter, substringHashMap.get(eachCharacter)+1 );
            }

        }

        for( int eachNumber : substringHashMap.values() ){
            subStringCount += eachNumber;
        }

        // Return final result
        return subStringCount;
    }

}
