package Q2_Threads.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    // Class Variable
    BlockingQueue<String> blockingQueue = null;

    // Class Constructor
    public Consumer( BlockingQueue<String> blockingQueue ) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while( true ) {
            try{
                String element = this.blockingQueue.take();
                System.out.println("Consumed: " + element);
            } catch ( InterruptedException interruptedException ) {
                System.out.println("Provider was interrupted");
            }
        }
    }
}
