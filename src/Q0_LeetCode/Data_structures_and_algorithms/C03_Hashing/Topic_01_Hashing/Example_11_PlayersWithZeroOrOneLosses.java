package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.*;

/**
 * Find Players With Zero Or One Losses
 * TODO You are given an integer array matches where matches[i] = [winneri, loseri]
 *  indicates that the player winneri won the given match, player loseri lost the match match.
 *  Return a list answer of size 2 where:
 *  answer[0] is a list of all players that have not lost any matches.
 *  answer[1] is a list of all players that have lost exactly one match.
 *  The values in the two lists should be returned in increasing order.
 *
 * Note:
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 */
public class Example_11_PlayersWithZeroOrOneLosses {

    // Class Variable:
    private static final int[][] matches = { {1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9} };

    public static void main(String[] args) {

        // Method Variable(s):
        Map<Integer, Integer> matchesWonFrequency = new HashMap<>();
        Map<Integer, Integer> matchesLostFrequency = new HashMap<>();
        List < List<Integer> > finalResultList = new ArrayList<>();

        // Function call 1 : getFrequencyOfWinners()
        matchesWonFrequency = getFrequencyOfWinners( matches );
        System.out.println( matchesWonFrequency );

        // Function call 2 : getFrequencyOfLosers()
        matchesLostFrequency = getFrequencyOfLosers( matches );
        System.out.println( matchesLostFrequency );

        // Function call 3 : generateFinalResultList()
        finalResultList = generateFinalResultList( matchesWonFrequency, matchesLostFrequency );
        System.out.println( finalResultList );

    }

    /**
     * This method will compute the frequencies of matches won by each player.
     * @param matchesArray : 2D array with info of matches won and lost by each user.
     * @return : HashMap : matchesWonFrequency
     */
    public static Map<Integer, Integer> getFrequencyOfWinners( int[][] matchesArray ) {

        // Method Variable(s):
        Map<Integer, Integer> matchesWonFrequency = new HashMap<>();

        // FOR-LOOP:
        for ( int[] eachRow : matchesArray ){

            matchesWonFrequency.put( eachRow[0], matchesWonFrequency.getOrDefault( eachRow[0], 0) + 1 );
        }

        // Return final result
        return matchesWonFrequency;
    }

    /**
     * This method will compute the frequencies of matches lost by each player.
     * @param matchesArray : 2D array with info of matches won and lost by each user.
     * @return  HashMap : getFrequencyOfLosers
     */
    public static Map<Integer, Integer> getFrequencyOfLosers( int[][] matchesArray ) {

        // Method Variable(s):
        Map<Integer, Integer> matchesLostFrequency = new HashMap<>();

        // FOR-LOOP:
        for ( int[] eachRow : matchesArray ){

            matchesLostFrequency.put( eachRow[1], matchesLostFrequency.getOrDefault( eachRow[1], 0) + 1 );
        }

        // Return final result
        return matchesLostFrequency;
    }

    /**
     * Return a list answer of size 2 where:
     *  answer[0] is a list of all players that have not lost any matches.
     *  answer[1] is a list of all players that have lost exactly one match.
     * @param matchesWonFrequency : HashMap
     * @param matchesLostFrequency : HashMap
     * @return : List< List<Integer> > generateFinalResultList
     */
    public static List< List<Integer> > generateFinalResultList( Map<Integer, Integer> matchesWonFrequency, Map<Integer, Integer> matchesLostFrequency){

        // Method Variable(s):
        List< List<Integer> > finalResultList = new ArrayList<>();
        List< Integer > listOfPlayersNotLostAnyMatches = new ArrayList<>();
        List< Integer > listOfPlayersLostExactlyOneMatch = new ArrayList<>();

        // Players who have not lost a single match. ( determine all players not in the matchesLostFrequency map ).
        for( int eachPlayer : matchesWonFrequency.keySet() ){
            if( ! matchesLostFrequency.containsKey( eachPlayer ) ){
                listOfPlayersNotLostAnyMatches.add( eachPlayer );
            }
        }

        // Players who have lost exactly one match
        for ( Map.Entry< Integer, Integer> eachEntry : matchesLostFrequency.entrySet() ){

            if( eachEntry.getValue() == 1 ){
                listOfPlayersLostExactlyOneMatch.add( eachEntry.getKey() );
            }
        }

        // Combine both the result to a single List
        finalResultList.add( listOfPlayersNotLostAnyMatches );
        finalResultList.add( listOfPlayersLostExactlyOneMatch );

        // Return final result
        return finalResultList;
    }
}
