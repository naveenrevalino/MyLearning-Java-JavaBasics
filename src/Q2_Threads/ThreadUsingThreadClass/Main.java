package Q2_Threads.ThreadUsingThreadClass;

public class Main {



    public static void main(String[] args) {

        System.out.println( " ( Main Thread ) - Main Method : STARTING ");

        /**     Method 1 : Thread Using Extends Keyword.
                * CustomThread extends Thread Class
                * You can extend only one class at a time.
         */

        // Thread Class : Create an instance of Thread class ( in this case : customThread )
        Thread newThread = new CustomThread( );             // Type : Thread Class
        CustomThread customThread = new CustomThread( );    // Type : CustomThread Class

        // The start() method will schedule the thread to be run, by passing it on to the thread scheduler.
        customThread.start();

        System.out.println( " ( Main Thread ) - Main Method : ENDED ");
    }
}
