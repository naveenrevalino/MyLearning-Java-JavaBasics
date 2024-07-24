package Q2_Threads.DaemonThread;

public class DaemonThread {

    /**
     * It is a LOW PRIORITY Thread that runs in the background and provides support to other non-daemon threads in the application.
     * non-daemon threads are also called as user threads created by the developer.
     * setDaemon() : method is used on the tread before we start the thread.
     * A daemon thread will automatically terminate when all other thread has completed.
     * JVM will not wait for the daemon thread to complete.
     */

    public static void main(String[] args) {

        Thread userThread1 = new Thread ( () -> {

            for ( int i=0; i<= 10; i++ ) {
                System.out.println("User Thread 1 : " + i );
            }
        });

        Thread userThread2 = new Thread ( () -> {

            for ( int i=0; i<= 100; i++ ) {
                System.out.println("User Thread 2 : " + i );
            }
        });

        userThread1.start();
        userThread2.setDaemon(true);
        userThread2.start();
    }


}
