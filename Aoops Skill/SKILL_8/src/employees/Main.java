package employees;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        System.out.println("All Employees:");
        service.getAllEmployees().forEach(System.out::println);

        System.out.println("\nEmployees with salary > 50000:");
        List<Employee> filteredEmployees = service.filterEmployeesBySalary(50000);
        filteredEmployees.forEach(System.out::println);

        System.out.println("\nEmployees sorted by salary:");
        List<Employee> sortedEmployees = service.sortEmployeesBySalary();
        sortedEmployees.forEach(System.out::println);

        Optional<Employee> highestSalaryEmployee = service.findHighestSalaryEmployee();
        System.out.println("\nEmployee with highest salary:");
        highestSalaryEmployee.ifPresent(System.out::println);

        double averageSalary = service.calculateAverageSalary();
        System.out.println("\nAverage salary of employees: " + averageSalary);
    }
}
