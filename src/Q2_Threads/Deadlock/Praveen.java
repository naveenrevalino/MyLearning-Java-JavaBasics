package Q2_Threads.Deadlock;

public class Praveen implements Runnable {

    // Class Variables : These lock are the ones this runnable class needs to do its job.
    private Object naveen_key = null;
    private Object praveen_key = null;

    // Class Constructor
    public Praveen(Object naveen_key, Object praveen_key) {
        this.naveen_key = naveen_key;
        this.praveen_key = praveen_key;

    }

    @Override
    public void run() {

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
    }
}
