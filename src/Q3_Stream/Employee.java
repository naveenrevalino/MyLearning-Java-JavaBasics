package Q3_Stream;

public class Employee {

    //Class Variables
    private String employeeName;
    private String employeeLocationCity;
    private int employeeBaseSalary;

    // Class Constructor
    public Employee ( String name, String city, int salary ) {
        employeeName = name;
        employeeLocationCity = city;
        employeeBaseSalary = salary;
    }

    // Getter Methods

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeLocationCity() {
        return employeeLocationCity;
    }

    public int getEmployeeBaseSalary() {
        return employeeBaseSalary;
    }

    // Setter Methods

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeLocationCity(String employeeLocationCity) {
        this.employeeLocationCity = employeeLocationCity;
    }

    public void setEmployeeBaseSalary(int employeeBaseSalary) {
        this.employeeBaseSalary = employeeBaseSalary;
    }


    // ToString Method


    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeLocationCity='" + employeeLocationCity + '\'' +
                ", employeeBaseSalary=" + employeeBaseSalary +
                '}';
    }
}
