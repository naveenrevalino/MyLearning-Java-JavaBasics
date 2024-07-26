package org.data_structures_and_algorithms.arrays_and_strings.tow_pointer;

/*
Question 2:
Given a string s, return true if it is a palindrome, false otherwise.

A string is a palindrome if it reads the same forward as backward. That means, after reversing it, it is still
the same string. For example: "abcdcba", or "racecar".
 */

public class CheckPalindrome2 {

    public static void main(String[] args) {

        System.out.println( checkPalindrome("naveen") );;


    }

    public static boolean checkPalindrome( String stringToCheck ) {

        int left = 0;
        int right = stringToCheck.length() - 1;

        while ( left < right ) {

            if ( stringToCheck.charAt( left ) != stringToCheck.charAt( right ) ) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
