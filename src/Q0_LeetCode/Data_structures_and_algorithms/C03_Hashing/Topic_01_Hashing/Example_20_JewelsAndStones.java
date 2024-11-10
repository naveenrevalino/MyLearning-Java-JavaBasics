package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO You're given strings jewels representing the types of stones that are jewels, and stones representing the stones
 *  you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are
 *  also jewels. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * Example: Input: jewels = "aA", stones = "aAAbbbb" Output: 3
 * Input: jewels = "z", stones = "ZZ" Output: 0
 */
public class Example_20_JewelsAndStones {

    public static void main(String[] args) {

        String jewels = "aA";
        String magazine = "aAAbbbb";
        Map<Character, Integer> frequencyMapOfJewels = new HashMap<>();
        int finalCount = 0;

        frequencyMapOfJewels = constructMap( jewels );

        finalCount = findCount(frequencyMapOfJewels, magazine);
        System.out.println( finalCount );

        finalCount = alternateWay( jewels, magazine );
        System.out.println( finalCount );

    }

    /**
     * Given a map and a string, this method will iterate over each character of the string, check if the character is
     * int the map, if yes then increment the count variable.
     * @param frequencyMapOfJewels Map [ Map<Character, Integer> ]
     * @param magazine String
     * @return Integer
     */
    public static int findCount( Map<Character, Integer> frequencyMapOfJewels, String magazine ){

        // Method Variables:
        int count = 0;

        // ITERATOR: Iterate through each character of the given string
        for( char eachCharacter : magazine.toCharArray() ){

            // Check: If the character is in the map.
            if( frequencyMapOfJewels.containsKey( eachCharacter ) ){
                count++;
            }
        }

        // Return statement.
        return count;
    }

    /**
     * Given a string, this method will iterate over each character of the string and add it to the map.
     * The key of the map is the character and the value will be set to 0 by default.
     * @param jewels String
     * @return Map [ Map<Character, Integer> ]
     */
    public static Map<Character, Integer> constructMap( String jewels ){

        // Method Variables:
        Map<Character, Integer> frequencyMapOfJewels = new HashMap<>();

        // ITERATOR: Iterate over each character of the string.
        for( char eachCharacter : jewels.toCharArray() ){
            frequencyMapOfJewels.put( eachCharacter, 0 );
        }

        // Return statement.
        return frequencyMapOfJewels;
    }

    /**
     * Given two strings ( jewels and magazine ), this method will iterate over each character of the string ( jewels ).
     * Check if each character of ( jewels ) occur in the magazine string. For each occurrence of the character in the
     * magazine string, the count is incremented.
     * @param jewels String
     * @param magazine String
     * @return Integer
     */
    public static int alternateWay( String jewels, String magazine ){

        // Method variables:
        int finalCount = 0;

        // ITERATOR: Iterate through each character in jewels string.
        for( int jewelsChar = 0; jewelsChar < jewels.length(); jewelsChar++ ){

            // ITERATOR: Iterate through every character of magazine, if they match with jewels current character, increment the count.
            for( int magazineChar =0; magazineChar < magazine.length(); magazineChar++ ){

                // Check: If current character of jewels match with any character in magazine.
                if( jewels.charAt(jewelsChar) == magazine.charAt(magazineChar) ){
                    finalCount ++;
                }
            }
        }

        // Return statement.
        return finalCount;
    }
}
