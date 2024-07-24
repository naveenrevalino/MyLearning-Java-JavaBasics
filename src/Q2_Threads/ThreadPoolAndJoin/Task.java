package Q2_Threads.ThreadPoolAndJoin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Runnable {

    // Class Variables
    private String userName;

    // Class Constructor
    public Task(String name ) {
        userName = name;
    }

    // Override Default run method
    /**
     * Prints task name with date and time, then sleeps for 1s
     * This process is repeated 5 times
     */
    @Override
    public void run() {

        try {

            for ( int i = 0; i <= 5; i++ ) {

                // prints the execution time for every task
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                System.out.println("Initialization Time for"
                        + " task name - "+ userName +" = " +ft.format(d));

                // Pause the execution
                Thread.sleep(1000);
            }

            System.out.println( userName+ " : Task Completed.");

        }
        catch ( InterruptedException interruptedException ) {

            interruptedException.printStackTrace();
        }

    }
}
