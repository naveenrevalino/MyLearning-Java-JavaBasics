package Q7_Collections.Frequency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequenctInList {

    public static void main(String[] args) {

        // 15. Find Frequency from a list
        List<String> dummyDataList = new ArrayList<>();
        dummyDataList.add("1");
        dummyDataList.add("1");
        dummyDataList.add("2");
        dummyDataList.add("2");
        dummyDataList.add("2");
        dummyDataList.add("3");
        dummyDataList.add("3");
        dummyDataList.add("3");
        dummyDataList.add("3");

        Map<String, Long> frequencyOfEachElement =
                dummyDataList.stream()
                        .collect( Collectors.groupingBy( e -> e, Collectors.counting() ) );

        // Iterate the MAP to print each element
        for ( String key : frequencyOfEachElement.keySet() ) {
            System.out.println( key + " " + frequencyOfEachElement.get( key ));
        }

    }
}
