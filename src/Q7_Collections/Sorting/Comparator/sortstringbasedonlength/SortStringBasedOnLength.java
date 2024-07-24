package Q7_Collections.Sorting.Comparator.sortstringbasedonlength;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStringBasedOnLength {

    public static void main(String[] args) {

        List<String> listOfString = new ArrayList<>();
        listOfString.add("Nav");
        listOfString.add("Naveen");
        listOfString.add("Navee");
        listOfString.add("Nave");
        listOfString.add("Pra");

        // [Pra, Nav, Nave, Navee, Naveen]

        System.out.println( "Original List of strings : " + listOfString );

        // Sort the list of string based on the length of each string.
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

//                if( o1.length() == o2.length()) {
//                    return 0;
//                }
//
//                if( o1.length() > o2.length() ) {
//                    return 1;
//                }
//                return -1;

                return Integer.compare( o1.length(), o2.length() );
            }
        };

        Collections.sort( listOfString, customComparator );

        System.out.println("Sorted List : " + listOfString );


    }
}
