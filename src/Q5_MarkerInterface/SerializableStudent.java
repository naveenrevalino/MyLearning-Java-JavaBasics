package Q5_MarkerInterface;

import java.io.Serializable;

public class SerializableStudent implements Serializable {

    // Class Variables
    int studentID;
    int studentScore;
    String studentName;

    // Class Constructor
    public SerializableStudent(int studentID, int studentScore, String studentName ) {
        this.studentID = studentID;
        this.studentScore = studentScore;
        this.studentName = studentName;

    }
}
