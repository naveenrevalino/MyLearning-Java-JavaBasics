package Q3_Stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeWithHighestSalary {

    /**
     * For the given list of employee objects, output the employee with the highest salary for each city using STREAM.
     */

    public static void main(String[] args) {

        // 16. Find frequency in list of objects
        Employee employeeNaveen = new Employee( "Naveen Ravi", "Montreal", 500 );
        Employee employeePraveen = new Employee( "Praveen Ravi", "Montreal", 800 );
        Employee employeeSamreena = new Employee( "Samreena Nargis", "California", 700 );
        Employee employeeSoody = new Employee( "Soody Ravi", "California", 900 );
        Employee employeeGowri = new Employee( "Gowri Andal", "Munnar", 1000 );
        Employee employeeRavi = new Employee( "Ravi Krishnaswamy", "Munnar", 900 );

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add( employeeNaveen );
        employeeList.add( employeePraveen );
        employeeList.add( employeeSamreena );
        employeeList.add( employeeSoody );
        employeeList.add( employeeGowri );
        employeeList.add( employeeRavi );

        // Solution 1 : Group by City and get the entire Employee Object.
        Map<String, Employee> finalResultSolution1 = employeeList.stream()
                .collect(
                        // We are grouping the employee list by the CITY
                        Collectors.groupingBy(
                                Employee::getEmployeeLocationCity,

                                // maxBy : always returns an Optional<T>
                                Collectors.collectingAndThen(
                                        // maxBy : always returns an Optional<T>
                                        Collectors.maxBy(
                                                Comparator.comparingInt( Employee::getEmployeeBaseSalary )
                                                // Convert the Optional<T> to original Employee object using the below function.
                                        ), employee -> employee.get()
                                )
                        )
                );

        // Iterate the MAP and print the final result
        // finalResultSolution1.entrySet().forEach(System.out::println);


        // Solution 2 : Group by City and get the highest salary.
        Map<String, Integer> finalResultSolution2 = employeeList.stream()
                .collect(
                        // We are grouping the employee list by the CITY
                        Collectors.groupingBy(
                                Employee::getEmployeeLocationCity,

                                // maxBy : always returns an Optional<T>
                                Collectors.collectingAndThen(
                                        // maxBy : always returns an Optional<T>
                                        Collectors.maxBy(
                                                Comparator.comparingInt( Employee::getEmployeeBaseSalary )
                                                // Convert the Optional<T> to original Employee object using the below function.
                                        ), employee -> employee.get().getEmployeeBaseSalary()
                                )
                        )
                );

        // Iterate the MAP and print the final result
        // finalResultSolution2.entrySet().forEach(System.out::println);

        // Solution 3 : Group by City and get the highest salary using reduction.
        Map<String, Optional<Employee>> finalResultSolution3 = employeeList.stream()
                .collect(
                        // We are grouping the employee list by the CITY
                        Collectors.groupingBy(
                                Employee::getEmployeeLocationCity,

                                // maxBy : always returns an Optional<T>
                                Collectors.reducing(
                                        // maxBy : always returns an Optional<T>
                                        BinaryOperator.maxBy(
                                                Comparator.comparingInt( Employee::getEmployeeBaseSalary )
                                        )
                                )
                        )
                );

        // Iterate the MAP and print the final result
        // finalResultSolution3.entrySet().forEach(System.out::println);

        // Solution 3 : Group by City and get the highest salary using reduction.
        Map<String, Employee> finalResultSolution4 = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                employee -> employee.getEmployeeLocationCity(),
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparingInt(
                                                        employee -> employee.getEmployeeBaseSalary()
                                                )
                                        ), Optional::get
                                )
                        ));

        // Iterate the MAP and print the final result
        finalResultSolution4.entrySet().forEach(System.out::println);

    }
}
