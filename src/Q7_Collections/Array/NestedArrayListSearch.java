package Q7_Collections.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class NestedArrayListSearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );

        // STEP : OUTER ARRAY LIST CONSTRUCTION
        System.out.println("What should be the size on the outer array list? ");
        int outerArrayListSize = scanner.nextInt();

        // Outer Array List
        ArrayList< ArrayList<Integer> > outerArrayList = new ArrayList<>();

        // Add elements to the outer array list
        for(int j = 0; j < outerArrayListSize; j++ ){

            // STEP : INNER ARRAY LIST CONSTRUCTION :
            System.out.println("What should be the size on the inner array list? ");
            int innerArrayListSize = scanner.nextInt();

            // Inner Array List
            ArrayList<Integer> innerArrayList = new ArrayList<>();

            // Add the inner array size as the first element of the list.
            innerArrayList.add( innerArrayListSize );

            // Add elements to the inner array list
            for(int i=0; i < innerArrayListSize ; i++ ){

                int indexPosition = i+1;
                System.out.println(" Please enter the element at index : " + indexPosition );
                innerArrayList.add( scanner.nextInt() );
            }

            System.out.println( "Inner Array list : " + innerArrayList);
            outerArrayList.add( innerArrayList );

        }

        System.out.println("Outer Array List : " + outerArrayList );

        // Close Scanner Class : to prevent memory leakage
        scanner.close();

        findElementFromOuterList(outerArrayList, 1, 7);
    }

    static void findElementFromOuterList ( ArrayList < ArrayList<Integer> > outerArray, int lineNumber, int indexOfElement ) {

        try {
            // Get the array from the given line number
            ArrayList<Integer> arrayListAtGivenLineNumber = outerArray.get( lineNumber );

            // Get the respective element from the array
            int elementAtGivenIndex = arrayListAtGivenLineNumber.get(indexOfElement);

            System.out.println("Element at give index is : " + elementAtGivenIndex );

        } catch ( Exception e) {
            System.out.println("ERROR!");
        }

    }
}
