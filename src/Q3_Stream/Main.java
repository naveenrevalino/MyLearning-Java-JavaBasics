package Q3_Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // 1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach( System.out :: print);
        System.out.println();
        System.out.println("End of line");

        // 2. Integer Stream : skip ( will skip first five elements )
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach( x -> System.out.println(x) );
        System.out.println();
        System.out.println("End of line");

        // 3. Integer Stream : sum
        System.out.println(

                IntStream
                        .range(1, 10)
                        .sum()
        );
        System.out.println();

        // 4. Stream.of function, sorted and find first element.
        Stream.of( "Naveen", "Gowri", "Sooody", "Praveen", "Sam")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        // 5. Stream of array, sort, filter and print
        String[] familyNames = { "Naveen", "Gowri", "Soody", "Praveen", "Sam" };

        Arrays.stream ( familyNames )
                .filter( x -> x.startsWith("S"))
                .sorted()
                .forEach( System.out::println);

        // 6. Average of squares of an int array
        Arrays.stream( new int[] {2, 4, 6, 8, 10} )
                .map( x -> x * x )
                .average()
                .ifPresent( System.out::println );

        // 7. Stream from list, filter and print
        List<String> familyMembers = Arrays.asList( "Naveen", "Gowri", "Soody", "Praveen", "Sam" );
        familyMembers.stream()
                .map( String::toLowerCase )
                .filter( x-> x.startsWith("s"))
                .forEach( System.out::println);

        // 8. Stream rows from text files, sort, filter and print
        try {
            Stream<String> family = Files.lines( Paths.get("/Users/pravrav/Development/IdeaProject/mylearning/java/javabasics/src/Q3_Stream/Data/FamilyData.txt"));
            family
                    .sorted()
                    .filter(x -> x.length() > 3 )
                    .forEach( System.out::println);
            family.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 9. Stream rows from a text file and save it to a list.
        try {
            List<String> family2 = Files.lines( Paths.get("/Users/pravrav/Development/IdeaProject/mylearning/java/javabasics/src/Q3_Stream/Data/FamilyData.txt"))
                    .filter( x -> x.contains("av"))
                    .collect(Collectors.toList());

            family2.forEach( System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 10. Read from CSV file, get count of good rows
        try {
            Stream<String> eachRow = Files.lines( Paths.get("/Users/pravrav/Development/IdeaProject/mylearning/java/javabasics/src/Q3_Stream/Data/CSVData.txt"));
            int rowCount = (int) eachRow
                    .map( x -> x.split(",") ) // this will give an array with three elements
                    .filter( x -> x.length == 3 )
                    .count();

            System.out.println( rowCount + " rows.");
        eachRow.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 11. Read from CSV file,parse data from rows.
        try {
            Stream<String> eachRow2 = Files.lines( Paths.get("/Users/pravrav/Development/IdeaProject/mylearning/java/javabasics/src/Q3_Stream/Data/CSVData.txt"));
            eachRow2
                    .map( x -> x.split(",") ) // this will give an array with three elements
                    .filter( x -> x.length == 3 )
                    .filter( x -> Integer.parseInt( x[1] ) > 15 )
                    .forEach( x-> System.out.println( x[0] + " " + x[1] + " " + x[2] ) );
            eachRow2.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 12. Read from CSV file, store fields in a hash map
        try {
            Stream<String> eachRow3 = Files.lines( Paths.get("/Users/pravrav/Development/IdeaProject/mylearning/java/javabasics/src/Q3_Stream/Data/CSVData.txt"));
            Map<String, Integer> mappedElements = new HashMap<>();
            mappedElements = eachRow3
                    .map( x -> x.split(",") ) // this will give an array with three elements
                    .filter( x -> x.length == 3 )
                    .filter( x -> Integer.parseInt( x[1] ) > 15 )
                    .collect(Collectors.toMap ( x -> x[0] , x -> Integer.parseInt( x[1] )) );
            eachRow3.close();

            for ( String key : mappedElements.keySet() ) {
                System.out.println( key + " " + mappedElements.get( key ));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 13. Reduction - SUM
        double finalSum = Stream.of(7.3, 1.5, 4.8 )
                .reduce( 0.0, ( Double a, Double b) -> a+b );

        System.out.println("The Total is : " + finalSum );

        // 14. Reduction - Summary Statistics
        IntSummaryStatistics summaryStatistics = IntStream.of( 7, 2, 19, 88, 73, 4, 10 )
                .summaryStatistics();

        System.out.println( "Summary Statistics : " + summaryStatistics );


    }
}