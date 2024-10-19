package Q7_Collections.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(96);
        numbers.add(81);
        numbers.add(75);
        numbers.add(63);
        numbers.add(49);
        numbers.add(50);
        numbers.add(32);
        numbers.add(24);
        numbers.add(18);
        numbers.add(47);

        lambdaSort( numbers );


    }

    public static void simpleSort( List<Integer> numbers ){
        Collections.sort ( numbers );
        System.out.println( numbers );
    }

    public static void comparatorSort( List<Integer> numbers ){
        Comparator<Integer> comparator = new Comparator<>(){

            @Override
            public int compare( Integer i, Integer j ) {
                if ( i%10 > j%10 ) {
                    return 1;
                }else {
                    return -1;
                }
            }
        };
        Collections.sort( numbers, comparator );
        System.out.println( numbers );
    }

    public static void lambdaSort( List<Integer> numbers ){
        Comparator<Integer> comparator = ( i, j ) -> i%10 > j%10 ? 1 : -1;
        Collections.sort( numbers, comparator );
        System.out.println( numbers );
    }
}
