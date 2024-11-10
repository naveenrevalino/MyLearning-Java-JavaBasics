package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing.Topic_01_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Given an integer array cards, find the length of the shortest subarray that contains at least one duplicate.
 *  If the array has no duplicates, return -1.
 * Example: given cards = [1, 2, 6, 2, 1], we would map 1: [0, 4], 2: [1, 3], and 6: [2]. Then we can iterate over the
 * values and see that the minimum difference can be achieved from picking up the 2s.
 */
public class Example_16_MinimumConsecutiveCardPickUp {

    public static void main(String[] args) {
        // Method variable(s):
        int[] cards = {1, 2, 6, 2, 1};
        Map<Integer, List<Integer>> mapOccurrence = new HashMap<>();
        int smallestValue = -1;

        mapOccurrence = mapFirstOccurrenceOfDuplicateElement( cards );
        smallestValue = computerShortestDistance( mapOccurrence );

        System.out.println( smallestValue );
    }

    public static Map<Integer, List<Integer>> mapFirstOccurrenceOfDuplicateElement( int[] cards ) {

        // Method Variables:
        Map<Integer, List<Integer>> mapOccurrence = new HashMap<>();

        // ITERATE: each element and record each of it first and duplicate occurrence indices.
        for( int index = 0; index < cards.length; index ++ ){

            int currentElement = cards[index];

            if( !mapOccurrence.containsKey( currentElement ) ){
                mapOccurrence.put( currentElement, new ArrayList<>() );
            }

            mapOccurrence.get( currentElement ).add( index );
        }

        return mapOccurrence;
    }

    public static int computerShortestDistance( Map<Integer, List<Integer>> mapOccurrence ){

        // Method Variables:
        int smallestValue = Integer.MAX_VALUE;

        // ITERATE: the values in the map and determine the smallest value.
        for( int key : mapOccurrence.keySet() ){

            // Get the values list with each key
            List<Integer> valueList = mapOccurrence.get( key );

            // ITERATE: each element in the list and compute the difference.
            for( int currentIndex = 0; currentIndex < valueList.size()-1 ; currentIndex ++ ){
                smallestValue = Math.min( smallestValue, valueList.get( currentIndex + 1 ) - valueList.get( currentIndex ) + 1 );
            }
        }

        return smallestValue;
    }
}
