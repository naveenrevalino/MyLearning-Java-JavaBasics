package Q0_LeetCode.Data_structures_and_algorithms.C03_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * TODO Given an array of strings strs, group the anagrams together.
 * Example: given string[] = ["eat","tea","tan","ate","nat","bat"], return [["bat"],["nat","tan"],["ate","eat","tea"]].
 */
public class Example_15_GroupAnagrams {
    public static void main(String[] args) {

        // Method Variable(s):
        String[] stringsArray = {"eat","tea","tan","ate","nat","bat"};
        List< List<String> > finalResult = new ArrayList<>();
        finalResult = groupAnagrams( stringsArray );
        System.out.println( finalResult );

    }

    public static List<List<String>> groupAnagrams( String[] stringsArray ){

        // Method Variable(s):
        List<List<String>> finalResult = new ArrayList<>();
        HashMap< String,List<String> > groupingMap = new HashMap<>();

        // FOR LOOP: to iterate through given array list
        for( String each : stringsArray ) {
            char[] chara = each.toCharArray();
            Arrays.sort( chara );

            String key = new String( chara );

            if( !groupingMap.containsKey( key ) ){
                groupingMap.put( key, new ArrayList<String>() );
            }
            groupingMap.get( key ).add( each );
        }

        finalResult.addAll( groupingMap.values() );



        return finalResult;
    }

}
