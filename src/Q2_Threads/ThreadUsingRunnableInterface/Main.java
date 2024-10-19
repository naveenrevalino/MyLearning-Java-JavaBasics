package Q2_Threads.ThreadUsingRunnableInterface;

public class Main {

    public static void main(String[] args) {

        System.out.println( " ( Main Thread ) - Main Method : STARTING ");

        /**     Method 2 : Thread Using Runnable Keyword.
                * CustomThread implements Runnable interface
                * You can implement multiple interfaces.
                * You pass any class as a runnable.
                * Always use this approach.
         */

        // Runnable Target : Create an instance of the CustomThread Class
        Runnable customThread = new CustomThread();    // Type : Instance CustomThread Class

        // Thread Class : Create an instance of Thread class and pass the instance of a runnable ( in this case : customThread )
        Thread thread = new Thread( customThread );

        // The start() method will schedule the thread to be run, by passing it on to the thread scheduler.
        thread.start();

        System.out.println( " ( Main Thread ) - Main Method : ENDED ");
    }
}
