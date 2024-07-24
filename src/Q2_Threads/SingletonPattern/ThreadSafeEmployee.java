package Q2_Threads.SingletonPattern;

public class ThreadSafeEmployee {

    /** // STEP 1: Private Class Variable
     Variables declared as private are only visible within their own class.
     */ private String employeeName;

    /** STEP 2: PRIVATE STATIC INSTANCE VARIABLE
     When a variable is declared as STATIC, it means the variable belongs to the class rather than to any instance of
     the class. In other words there is only one copy of this variable in the memory, regardless how many instance of
     this class is created.
     */
    // TODO VOLATILE: this keyword, will force you to use the object from the main memory, rather than from the cache.
    private static volatile ThreadSafeEmployee threadSafeEmployee;

    /** // STEP 3: PRIVATE Class Constructor:
     When one wants to create an instance of an object, they would call a class constructor to do that
     Example : Employee employeeInstance = new Employee(), where the Employee() after the new keyword refers to
     the constructor of the class. If we make this constructor private then no one will be able to create
     an instance of this class.
     */ private ThreadSafeEmployee( String employeeName ) {
        this.employeeName = employeeName;
    }

    /** // STEP 4: PUBLIC STATIC method:
     Public keyword enables anyone / everyone to access this method, the Static keyword gives us the ability to
     call this method without creating an instance of this class. No matter how many times we call this method the same
     instance of the Employee class is returned.
     */ public static ThreadSafeEmployee getInstance( String employeeName ) {
        // TODO: SINGLETON:
        //  A single instance of the object is maintained in the memory at all given time.
        //  Only when the instance is null a new instance of the object is created.
        if ( threadSafeEmployee == null ) {
            threadSafeEmployee = new ThreadSafeEmployee( employeeName );
        }
        // otherwise the same(active) instance is returned all the time
        return threadSafeEmployee;
    }

    /** // STEP 5: PUBLIC STATIC method:
     Public keyword enables anyone / everyone to access this method, the Static keyword gives us the ability to
     call this method without creating an instance of this class. No matter how many times we call this method the same
     instance of the Employee class is returned.
     */ public static ThreadSafeEmployee getSynchronizedInstance( String employeeName ) {
            // TODO: THREAD SAFE: SYNCHRONIZED:
            //  wrap the code with a synchronized block, doing so only one thread will be able to access this code.
            synchronized ( ThreadSafeEmployee.class ) {
                // only when the instance is null a new instance of the object is created
                if ( threadSafeEmployee == null ) {
                    threadSafeEmployee = new ThreadSafeEmployee( employeeName );
                }

            }
        // otherwise the same(active) instance is returned all the time
        return threadSafeEmployee;
    }

    /** // STEP 6: PUBLIC STATIC method:
     Public keyword enables anyone / everyone to access this method, the Static keyword gives us the ability to
     call this method without creating an instance of this class. No matter how many times we call this method the same
     instance of the Employee class is returned.
     */ public static ThreadSafeEmployee getThreadSafeInstance( String employeeName ) {
          // TODO: THREAD SAFE: DOUBLE LOCK CHECK:
          //  Example:
          //  Lets say Thread A got the lock and created an instance of this class.
          //  class B wants to access the new instance but will have to wait until the lock is released by thread A.
          //  To overcome that issue we are doing this double lock check, hence thread B doesn't have to wait for the lock
          //  to be released by thread A.

        if ( threadSafeEmployee == null ) {
            // wrap the if statement with a synchronized block, doing so only one thread will be able to access this code.
            synchronized ( ThreadSafeEmployee.class ) {
                // only when the instance is null a new instance of the object is created
                if ( threadSafeEmployee == null ) {
                    threadSafeEmployee = new ThreadSafeEmployee( employeeName );
                }
            }
        }
        // otherwise the same(active) instance is returned all the time
        return threadSafeEmployee;
    }

    // Getter Methods
    public String getEmployeeName() {
        return employeeName;
    }

    // Setter Methods
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // ToString Method
    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName +
                '}';
    }


}
