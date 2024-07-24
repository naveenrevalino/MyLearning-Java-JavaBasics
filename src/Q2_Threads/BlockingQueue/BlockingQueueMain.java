package Q2_Threads.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueMain {



    public static void main(String[] args) throws InterruptedException {

        // STEP 1:
        // Blockingqueue is an interface, one cannot create an instance of the interface, but can create instance of a class implementing a blockingqueue.
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        // STEP 2: Important Functionality of the blocking queue interface is the ability to enqueue elements and dequeue elements.
        // ENQUEUE: Add an element to the queue, DEQUEUE: Get the first element from queue.
        Producer producer = new Producer( arrayBlockingQueue );
        Consumer consumer = new Consumer( arrayBlockingQueue );

        // STEP 3: Create two separate threads, to execute producer and consumer
        Thread producerThread = new Thread( producer );
        Thread consumerThread = new Thread( consumer );

        // STEP 4: Start each thread.
        producerThread.start();
        consumerThread.start();

        // IMPORTANT METHOD(S)/FUNCTION(S) OF BLOCKING-QUEUE:
        /**

         ENQUEUE METHODS:
         PUT( elementToAdd ): Will add element to the queue, if the queue is full it will wait/block operation until space is available in the queue.
         ADD( elementToAdd ): Will throw an exception ( IllegalStateException ) if there is no more space in the BlockingQueue.
         OFFER( elementToAdd ): Will return TRUE if the operation completed, else return FALSE if no space in the BlockingQueue.
         OFFER( elementToAdd, 1000, TimeUnit. MILLISECONDS ): Will return TRUE if the operation completed,
         else wait for 1000 milliseconds and try again and return TRUE. Finally, if no space is available after the specified time, will return FALSE.

         DEQUEUE METHODS:
         TAKE(): Will get the first element from the queue, if there are no elements it will wait/block operation until an element is added.
         POLL():
         POLL( 1000, TimeUnit. MILLISECONDS ):

         */
    }
}
