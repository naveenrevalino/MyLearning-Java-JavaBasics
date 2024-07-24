package Q7_Collections.Array;

import java.util.Scanner;

public class SimpleArray {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the array size");
        int arraySize = myObj.nextInt();

        int[] a = new int[arraySize];

        for ( int i = 0; i< a.length; i++) {
            a[i] = i;
        }

        for ( int j = 0; j< a.length; j++) {
            System.out.println ( a[j] );
        }

    }
}
