package Q0_LeetCode.Data_structures_and_algorithms.C04_Linked_List;

import java.util.LinkedList;

public class Sample {

    public static void main(String[] args) {

        LinkedList<Integer> sample = new LinkedList<>();
        sample.add(1);
        sample.add(2);
        sample.add(3);
        sample.add(4);
        sample.add(5);

        System.out.println("Linked List: " + sample);

        int length = sample.size();
        System.out.println("Size: " + length );

        int outPut = length/2;
        System.out.println("Out Put: " + outPut);

        System.out.println("Final Result : " + sample.get( outPut ));


    }

}
