package Q2_Threads.RaceCondition.Counter;

import static Q2_Threads.RaceCondition.Counter.Counter.getInstance;

public class CustomThread implements Runnable {

    Counter counter = getInstance();

    @Override
    public void run() {

        for ( int i =0; i < 1000; i++ ){
            counter.increment("test");
        }

    }
}
