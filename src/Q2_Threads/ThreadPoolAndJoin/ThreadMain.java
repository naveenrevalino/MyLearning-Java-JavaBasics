package Q2_Threads.ThreadPoolAndJoin;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMain {

    // Class Variables
    static final int maximumNumberOfThreadsInPool = 2;

    public static void main(String[] args) {

        // creates five tasks
        Runnable runnable1 = new Task("ExecutorService and Executor(s) - Thread Pool Executor : Task 1");
        Runnable runnable2 = new Task("ExecutorService and Executor(s) - Thread Pool Executor : Task 2");
        Runnable runnable3 = new Task("ExecutorService and Executor(s) - Thread Pool Executor : Task 3");
        Runnable runnable4 = new Task("ExecutorService and Executor(s) - Thread Pool Executor : Task 4");
        Runnable runnable5 = new Task("ExecutorService and Executor(s) - Thread Pool Executor : Task 5");
        Runnable runnable6 = new Task("Executor - Single Thread Executor : Task 6");

        // Executor
        Executor singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute( runnable6 );

        // ExecutorService and Executors
        // A thread pool with maximumNumberOfThreadsInPool is created.
        ExecutorService threadPool = Executors.newFixedThreadPool( maximumNumberOfThreadsInPool );

        // Pass the Task objects to the thread pool to execute them.
        threadPool.execute( runnable1 );
        threadPool.execute( runnable2 );
        threadPool.execute( runnable3 );
        threadPool.execute( runnable4 );
        threadPool.execute( runnable5 );

        // Thread pool shutdown
        threadPool.shutdown();

        // OTHER IMPORTANT METHODS OF EXECUTORS CLASS:

        // Executors.newFixedThreadPool(int)   : Creates a fixed size thread pool.

        // Executors.newCachedThreadPool()     : Creates a thread pool that creates new threads as needed,
        //                                       but will reuse previously constructed threads when they are available.

        // Executors.newSingleThreadExecutor() : Creates a single thread.

    }
}