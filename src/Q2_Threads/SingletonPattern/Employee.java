package Q2_Threads.SingletonPattern;

public class Employee {

    //Class Variables

    /** // STEP 1: Private Variable
     Class variables declared as private are only visible within their own class.
     */ private String employeeName;

    /** STEP 2: STATIC INSTANCE VARIABLE
     When a variable is declared as STATIC, it means the variable belongs to the class rather than to any instance of
     the class. In other words there is only one copy of this variable in the memory, regardless how many instance of
     this class is created.
     */ static Employee employeeSingleton = new Employee("Naveen Ravi" );


    /** // STEP 3: PRIVATE Class Constructor:
    When one wants to create an instance of an object, they would call a class constructor to do that
    Example : Employee employeeInstance = new Employee(), where the Employee() after the new keyword refers to
    the constructor of the class. If we make this constructor private then no one will be able to create
    an instance of this class.
    */ private Employee(String name ) {
        employeeName = name;
    }

    /** // STEP 4: PUBLIC STATIC method:
     Public keyword enables anyone / everyone to access this method, the Static keyword gives us the ability to
     call this method without creating an instance of this class. No matter how many times we call this method the same
     instance of the Employee class is returned.
     */ public static Employee getInstance() {
        return employeeSingleton;
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
