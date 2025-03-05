import java.util.*;

import static java.util.stream.Collectors.*;


/**
 * Mode will calculate the most frequently occurring value from a list of supplied numbers.
 * If there are two or more frequently occurring values in the supplied data, the function returns the lowest of the values
 *
 * Example: Given a list = [ 1, 2, 2, 4, 4, 4, 3, 3, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 ]
 */
public class MapTest {
    // Class Variables:
    static List<Integer> originalCollection = new ArrayList<>();
    static Map<Integer, Integer> frequencyMap = new HashMap<>();
    static Map<Integer, Set<Integer>> groupedByFrequency;
    static int theSmallestValue;

    public static void main(String[] args) {

        addNumbersToTheList();
        findFrequencyOfEachNumber();
        groupedByFrequency = groupByFrequency();
        theSmallestValue = getTheSmallestNumber( groupedByFrequency );
        System.out.println( theSmallestValue );

    }

    public static void findFrequencyOfEachNumber(){

        for ( int eachElement : originalCollection ){
            frequencyMap.putIfAbsent( eachElement, 0);
            frequencyMap.put( eachElement, frequencyMap.get(eachElement) + 1 );
        }

    }

    public static Map<Integer, Set<Integer>> groupByFrequency(){

        Map<Integer, Set<Integer>> result = frequencyMap.entrySet()
                .stream()
                .collect( groupingBy( Map.Entry::getValue, mapping( Map.Entry::getKey, toSet() )) );

        return result;
    }

    public static int getTheSmallestNumber( Map<Integer, Set<Integer>> groupedByFrequency ){

        int macValue = Collections.max( groupedByFrequency.keySet() );
        Set<Integer> set = groupedByFrequency.get( macValue );

        return Collections.min( set );
    }

    public static void addNumbersToTheList(){
        originalCollection.add( 1 );
        originalCollection.add( 2 );
        originalCollection.add( 2 );
        originalCollection.add( 4 );
        originalCollection.add( 4 );
        originalCollection.add( 4 );
        originalCollection.add( 3 );
        originalCollection.add( 3 );
        originalCollection.add( 3 );
        originalCollection.add( 5 );
        originalCollection.add( 6 );
        originalCollection.add( 7 );
        originalCollection.add( 8 );
        originalCollection.add( 9 );
        originalCollection.add( 10 );
        originalCollection.add( 11 );
        originalCollection.add( 12 );
        originalCollection.add( 13 );
        originalCollection.add( 14 );
        originalCollection.add( 15 );
        originalCollection.add( 16 );
        originalCollection.add( 17 );
        originalCollection.add( 18 );
    }


}
