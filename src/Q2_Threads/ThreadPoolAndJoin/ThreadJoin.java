package Q2_Threads.ThreadPoolAndJoin;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread sampleThread = new Thread( () -> {

            for(int i=0; i<=5; i++) {
                System.out.println(i);
            }
        });

        sampleThread.start();
        sampleThread.join();

        System.out.println(Thread.currentThread().getName());
    }
}
