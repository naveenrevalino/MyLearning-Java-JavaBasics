package Q2_Threads.RaceCondition.Banking;

public class Main {

    public static void main(String[] args) {

        // Create instance of Runnable Object.
        Runnable balanceChecker = new BalanceChecker();

        // Create two instance of Thread class, each thread representing two different user
        Thread user1 = new Thread( balanceChecker, "Naveen" );
        Thread user2 = new Thread( balanceChecker, "Praveen" );

        user1.start();
        user2.start();
    }
}
