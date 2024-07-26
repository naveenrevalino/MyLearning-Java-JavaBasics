package org.data_structures_and_algorithms.arrays_and_strings.tow_pointer;

public class TowPointer1 {

    static String[] myArray = new String[] {"n", "a", "v", "e", "e", "n"};


    public static void main(String[] args) {
        twoPointerArray( myArray );
    }

    public static void twoPointerArray( String[] myArray ) {
        int left = 0;
        int right = myArray.length - 1;
        while ( left <= right ) {
            System.out.println( "Left: " + myArray[left]);
            System.out.println( "Right: " + myArray[right]);
            left++;
            right--;
        }
    }
}
