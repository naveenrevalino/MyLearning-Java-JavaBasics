package Q7_Collections.Comparable;

public class Student implements Comparable<Student> {

    String name;
    String address;
    int rollNumber;

    public Student(String name, String address, int rollNumber) {
        this.name = name;
        this.address = address;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        if ( this.rollNumber > o.rollNumber ) {
            return 1;
        } else {
            return -1;
        }

        // return this.name.compareTo( o.name );
    }
}
