package Q2_Threads.SequentialAndParallelThreads;

import java.util.Arrays;
import java.util.List;

public class SequentialAndParallelThread {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9 );

        // Sequential Stream
        numbers.stream()
                .forEach( number -> { System.out.println( number + "  " + Thread.currentThread().getName() ); }
                );

        // Parallel Stream : it runs in multiple thread and the output is not predictable.
        numbers.parallelStream()
                .forEach( number -> { System.out.println( number + "  " + Thread.currentThread().getName() ); }
                );


    }
}
