package Q5_MarkerInterface;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Create an instance of the student object
         Student naveen = new Student(112, 300, "Naveen");

        // Create an instance of the serializable student object
        SerializableStudent praveen = new SerializableStudent(114, 800, "Praveen");

        /**
         * Serialization : Means we try to convert the given object to bytes and save it in a file.
         * Deserialization : Means we try to convert bytes back to an object.
         */

        // Serialization
        FileOutputStream outputStream = new FileOutputStream( "/Users/pravrav/Development/IdeaProject/oracle learning/markerinterface/src/output.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream( outputStream );
        objectOutputStream.writeObject( praveen );
        objectOutputStream.flush();
        objectOutputStream.close();

        // Deserialization
        FileInputStream inputStream = new FileInputStream( "/Users/pravrav/Development/IdeaProject/oracle learning/markerinterface/src/output.txt" );
        ObjectInputStream objectInputStream = new ObjectInputStream( inputStream );

        // Naveen : Reading from file
        // Student naveenFromFile = (Student) objectInputStream.readObject();
        // System.out.println( " Student 1 " + " ID : " + naveenFromFile.studentID + " Score : " + naveenFromFile.studentScore + " Name : " + praveenFromFile.studentName);


        // Praveen : Reading from file
        SerializableStudent praveenFromFile = (SerializableStudent) objectInputStream.readObject();
        System.out.println( " Student 1 " + " ID : " + praveenFromFile.studentID + " Score : " + praveenFromFile.studentScore + " Name : " + praveenFromFile.studentName);
    }
}