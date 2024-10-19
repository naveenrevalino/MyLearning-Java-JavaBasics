package Q7_Collections.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add( new Student( "naveen", "Beauharsnois", 39 ) );
        studentList.add( new Student( "praveen", "Montreal", 41 ) );
        studentList.add( new Student( "soody", "California", 36 ) );
        studentList.add( new Student( "samreena", "Chennai", 35 ) );

        Collections.sort( studentList );
        System.out.println( studentList );
    }
}
