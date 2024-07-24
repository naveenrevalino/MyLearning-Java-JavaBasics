package Q7_Collections.FailSafe;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeArrayList {

    public void executeFailSafeCode () {

        // Fail Fast : Iterator Example
        List<String> failFastArrayList = new CopyOnWriteArrayList<>();
        failFastArrayList.add("Naveen");
        failFastArrayList.add("Soody");
        failFastArrayList.add("Samreena");
        failFastArrayList.add("Praveen");

        // Using Iterator to traverse the elements
        Iterator<String> iterator = failFastArrayList.iterator();

        // Loop : That will print the elements
        while (iterator.hasNext()) {

            System.out.println( iterator.next());

            // While traversing let's try to modify the original collection
            failFastArrayList.remove("Naveen");
        }

        System.out.println("Modified List : " + failFastArrayList );
    }
}
