package Q7_Collections.FailFast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastArrayList {

    public void executeFailsFastCode () {

        // Fail Fast : Iterator Example
        List<String> failFastArrayList = new ArrayList<>();
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
    }
}
