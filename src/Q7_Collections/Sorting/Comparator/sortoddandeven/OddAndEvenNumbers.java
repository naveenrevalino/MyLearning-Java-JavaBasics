package Q7_Collections.Sorting.Comparator.sortoddandeven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OddAndEvenNumbers {

    public static void main(String[] args) {

        int[] originalArray = { 1, 3, 5, 4, 2, 6, 9, 10 };
        List<Integer> originalList = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2, 6, 9, 10));

        Comparator<Integer> firstComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                // if o1 and o2 are both even then we don't have to swap
                if ( o1 % 2 == 0 && o2 % 2 == 0 || o1 % 2 != 0 && o2 % 2 != 0) {
                    return 0;
                }
                if ( o1 % 2 == 0 ) {

                    // If we return 1 : that means it will swap
                    return 1;
                }

                // If we return -1 : we will not swap as this is the default return.
                return -1;
            }
        };

        List<Integer> sortedList = originalList.stream()
                .sorted( firstComparator )
                .collect(Collectors.toList());

        System.out.println( sortedList );
    }
}
