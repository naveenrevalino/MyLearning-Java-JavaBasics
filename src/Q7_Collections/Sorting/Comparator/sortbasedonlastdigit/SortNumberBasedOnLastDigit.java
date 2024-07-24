package Q7_Collections.Sorting.Comparator.sortbasedonlastdigit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortNumberBasedOnLastDigit {

    public static void main(String[] args) {

        List<Integer> listOfInteger = new ArrayList<>();
        listOfInteger.add(45);
        listOfInteger.add(51);
        listOfInteger.add(77);
        listOfInteger.add(102);

        // Sort the list based on the last digit on the number.
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                // Modules 10 will give you the last digit of the number
                if( o1%10 > o2%10 ) {
                    return 1;
                }
                return -1;
            }
        };

        Collections.sort(listOfInteger, customComparator);
        System.out.println( listOfInteger );

    }
}
