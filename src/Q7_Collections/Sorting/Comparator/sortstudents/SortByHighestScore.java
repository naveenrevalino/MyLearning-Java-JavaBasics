package Q7_Collections.Sorting.Comparator.sortstudents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByHighestScore {

    public static void main(String[] args) {

        List<StudentScore> listOfStudents = new ArrayList<>();
        listOfStudents.add( new StudentScore("naveen", 30));
        listOfStudents.add( new StudentScore("praveen", 100));
        listOfStudents.add( new StudentScore("soody", 60));
        listOfStudents.add( new StudentScore("samreena", 75));
        listOfStudents.add( new StudentScore("ravi", 61));
        listOfStudents.add( new StudentScore("gowri", 41));


        Comparator<StudentScore> customeComparator = new Comparator<StudentScore>() {
            @Override
            public int compare(StudentScore student1, StudentScore student2) {

                if( student1.studentScore == student2.studentScore) {
                    // sort by name
                    return student1.studentName.compareTo( student2.studentName );
                }

                if( student1.studentScore > student2.studentScore) {

                    return 1;
                }

                // if( student1.studentScore < student2.studentScore) : This condition automatically becomes TRUE
                return -1;
            }
        };

        // Sort the list based on the highest score first, if the score are the same then sort using name.
        Collections.sort( listOfStudents, customeComparator);

        // Print the sorted list
        for ( StudentScore eachStudent : listOfStudents ) {
            System.out.println( "Student Name : " + eachStudent.studentName + " " + "Student Score : " + eachStudent.studentScore);
        }
    }
}
