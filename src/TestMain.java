import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add( new Student("Naveen", 39, 1, 1));
        studentList.add( new Student("Praveen", 39, 2, 2));
        studentList.add( new Student("Soody", 35, 3, 3));
        studentList.add( new Student("Samreena", 34, 4, 9));

        for( Student eachStudent : studentList ){
            System.out.println( "[ " + eachStudent.name +", "+ eachStudent.age +", "+ eachStudent.rollNumber + " ]" );
        }

        studentList.stream()
                .filter( f -> f.age < 39 && f.monthOfJoining < 9 )
                .forEach( person -> System.out.println( person.name ));

    }

    public static class Student {
        String name;
        int age;
        int rollNumber;
        int monthOfJoining;

        public Student( String name, int age, int rollNumber , int monthOfJoining ) {
            this.name = name;
            this.age = age;
            this.rollNumber = rollNumber;
            this.monthOfJoining = monthOfJoining;
        }
    }
}


