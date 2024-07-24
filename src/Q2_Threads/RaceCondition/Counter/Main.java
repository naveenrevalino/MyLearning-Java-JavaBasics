package Q2_Threads.RaceCondition.Counter;

import static Q2_Threads.RaceCondition.Counter.Counter.getInstance;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println( " ( Main Thread ) - Main Method : STARTING ");

        // This step will return an instance of the Counter class, and this instance will be used across the application.
        Counter counter = getInstance();

        // Method 1 : Creating first runnable object
        Runnable obj1 = () -> {

            for ( int i =0; i < 1000; i++ ){
                counter.increment("test");
            }
        };

        // Method 2 : Creating second runnable instance
        Runnable customThread = new CustomThread();

        Thread t1 = new Thread( obj1 );
        Thread t2 = new Thread( customThread );

        t1.start();
        t2.start();

        // Will force main thread to wait until t1, and t2, to complete their work and join back on the main thread
        t1.join();
        t2.join();

        System.out.println(" Current counter value : " + counter.count );

        System.out.println( " ( Main Thread ) - Main Method : ENDED ");

    }

}

