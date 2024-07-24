package Q2_Threads.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    // Class Variable
    BlockingQueue<String> blockingQueue = null;

    // Class Constructor
    public Producer( BlockingQueue<String> blockingQueue ) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while( true ) {
            // Method Variable
            long timeMillis = System.currentTimeMillis();

            try{
                this.blockingQueue.put( " " + timeMillis );
            } catch ( InterruptedException interruptedException ) {
                System.out.println("Provider was interrupted");
            }
            sleep();
        }
    }

    private void sleep( ) {
        try {
            Thread.sleep(1000);
        } catch ( InterruptedException interruptedException ) {
            interruptedException.printStackTrace();
        }
    }
}
