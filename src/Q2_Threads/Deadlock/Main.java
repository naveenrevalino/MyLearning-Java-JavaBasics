package Q2_Threads.Deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Object naveen_key = new Object();
        Object praveen_key = new Object();

//        Naveen naveen = new Naveen( naveen_key, praveen_key );
//        Praveen praveen = new Praveen( naveen_key, praveen_key );

        Thread naveen = new Thread( () -> {
            synchronized ( praveen_key ) {
                System.out.println("Naveen has acquired Praveen's key ( Praveen_Key ).");
                try {
                    System.out.println("Naveen slept ( will sleep for 3 seconds ).");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Naveen is back ( after sleeping for 3 seconds ).");

                synchronized ( naveen_key ) {
                    System.out.println("Naveen has his own key ( Naveen_Key ).");
                }
            }
        });

        Thread praveen = new Thread( () -> {
            synchronized ( naveen_key ) {
                System.out.println("Praveen has acquired Naveen's key ( Naveen_Key ).");
                try {
                    System.out.println("Praveen slept ( will sleep for 3 seconds ).");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Praveen is back ( after sleeping for 3 seconds ).");

                synchronized ( praveen_key ) {
                    System.out.println("Praveen has his own key ( Praveen_Key ).");
                }
            }
        });

        // ExecutorService and Executors
        // A thread pool with maximumNumberOfThreadsInPool is created.
        ExecutorService threadPool = Executors.newFixedThreadPool( 4 );

        // Pass the Task objects to the thread pool to execute them.
        threadPool.execute( naveen );
        threadPool.execute( praveen );

        // Thread pool shutdown
        threadPool.shutdown();

        /**
         * In the above case the thread pool will not shut down ass both the treads go into a deadlock state.
         * How to detect deadlock in a large scale project.
         *
         * Open terminal and run your java program from there ( run the deadlock main java class )
         *      in the terminal navigate to the location your main class is : /Users/pravrav/Development/IdeaProject/oracle learning/javathreads/src/deadlock
         *      javac Main.java
         *      java Main.java
         *
         * Open a new terminal : and print the current processes running in your mac using the command : ps -a
         *
         * get the process ID of the Main.java class
         *
         *      type jcmd processID Thread.print hit enter and this will give you a thread dump.
         *                          OR
         *      type jstack processID and hit enter : this will return a thread dump too.
         */
    }
}
