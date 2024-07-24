package Q2_Threads.RaceCondition.Counter;

// Creating a SINGLETON counter class
public class Counter {

    // Class Variables
    private static final Counter counterClassInstance = new Counter();
    public int count = 0;

    // Private constructor : will prevent others from creating multiple instance of this class
    private Counter() { }

    public static Counter getInstance() {

        // SHORT FORM OF THE BELOW CHECK
        // return Objects.requireNonNullElseGet(counterClassInstance, Counter::new);

        if ( counterClassInstance == null ) {
            return new Counter();
        }
        return counterClassInstance;
    }

    public synchronized void increment() {
        count++;
    }

    public void increment(String name ) {
        count++;
    }
    
}
