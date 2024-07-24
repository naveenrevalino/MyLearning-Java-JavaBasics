package Q2_Threads.Deadlock;

public class Naveen implements Runnable {

    // Class Variables : These lock are the ones this runnable class needs to do its job.
    private Object naveen_key = null;
    private Object praveen_key = null;

    // Class Constructor
    public Naveen(Object naveen_key, Object praveen_key) {
        this.naveen_key = naveen_key;
        this.praveen_key = praveen_key;
    }

    @Override
    public void run() {

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
    }
}
