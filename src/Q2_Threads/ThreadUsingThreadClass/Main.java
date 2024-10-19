package Q2_Threads.ThreadUsingThreadClass;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {



    public static void main(String[] args) {

        System.out.println( " ( Main Thread ) - Main Method : STARTING ");

        /**     Method 1 : Thread Using Extends Keyword.
                * CustomThread extends Thread Class
                * You can extend only one class at a time.
         */

        CustomThread customThread = new CustomThread( );    // Type : Instance of CustomThread Class
        customThread.start();   // The start() method will schedule the thread to be run, by passing it on to the thread scheduler.

        Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute( customThread );

        System.out.println( " ( Main Thread ) - Main Method : ENDED ");
    }
}
