package Q7_Collections.Sorting.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {

    String studentName;
    int studentID;

    int studentScore;

    public Student(String studentName, int studentID, int studentScore ) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentScore = studentScore;
    }

    @Override
    public int compareTo(Student student) {

        if( studentID == student.studentID) {
            return 0;
        }
        if( studentID > student.studentID) {
            return 1;
        }

            return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentID=" + studentID +
                ", studentScore=" + studentScore +
                '}';
    }

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add( new Student( "Naveen Ravi", 001, 900 ));
        studentList.add( new Student( "Praveen Ravi", 004, 600 ));
        studentList.add( new Student( "Soody Ravi", 002, 300 ));
        studentList.add( new Student( "Samreena Nargis", 010, 500 ));

        Collections.sort( studentList );

        System.out.println( studentList );

    }


}
