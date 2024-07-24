package Q2_Threads.RaceCondition.Banking;

public class BalanceChecker implements Runnable {

    // Class Variables
    int currentBalance = 100;


    @Override
    public void run() {

        System.out.println( "Balance Checker : Run Method : STARTED ");

        synchronized (this) {
            System.out.println( "   " + Thread.currentThread().getName() + " : Waiting to perform withdrawal...");
            System.out.println( "   " + Thread.currentThread().getName() + " : Checking current account balance...");
            if ( currentBalance >=100 ) {

                System.out.println( "   " + Thread.currentThread().getName() + " : Money withdrawn from account. ");
                currentBalance -= 50;
                System.out.println( "   " + Thread.currentThread().getName() + " : Transaction completed...");

            } else {
                System.out.println( "   " + Thread.currentThread().getName() + " : Cannot withdraw money : Check bank balance! ");
            }
            System.out.println( "   " + Thread.currentThread().getName() + " : Current account balance : " + currentBalance );
        }

        System.out.println( "Balance Checker : Run Method : ENDED ");
    }
}
