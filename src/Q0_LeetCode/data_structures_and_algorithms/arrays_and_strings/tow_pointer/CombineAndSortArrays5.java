package org.data_structures_and_algorithms.arrays_and_strings.tow_pointer;

import java.util.ArrayList;
import java.util.List;


/*
Question 5:
Given two sorted integer arrays arr1 and arr2, return a new array that combines both of them and is also sorted.
*/
public class CombineAndSortArrays5 {

    static int[] arr1 = new int[] { 1, 4, 7, 20 };
    static int[] arr2 = new int[] { 3, 5, 6 };
    static List<Integer> answer = new ArrayList<>();


    public static void main(String[] args) {

        combineArrays(arr1, arr2, answer);

    }

    public static void combineArrays( int[] arr1, int arr2[], List<Integer> answer ) {
        int i=0;
        int j=0;

        while( i < arr1.length && j < arr2.length ) {

            if( arr1[i] < arr2[j] ) {
                answer.add( arr1[i] );
                i++;
            } else {
                answer.add( arr2[j] );
                j++;
            }
        }

        while( i < arr1.length ) {

            answer.add( arr1[i] );
            i++;

        }

        while( j < arr2.length ) {

            answer.add( arr2[j] );
            j++;

        }

        System.out.println( "print answer array: " + answer.toString() );

    }
}
