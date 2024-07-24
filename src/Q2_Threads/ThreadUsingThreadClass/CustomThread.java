package Q2_Threads.ThreadUsingThreadClass;

public class CustomThread extends Thread {

    @Override
    public void run() {

        System.out.println( " ( CustomThread ) - Run Method : STARTING ");

        for ( int i=0; i<5; i++ )
            System.out.println( i );

        System.out.println( " ( CustomThread ) - Run Method : ENDING ");
    }

}
