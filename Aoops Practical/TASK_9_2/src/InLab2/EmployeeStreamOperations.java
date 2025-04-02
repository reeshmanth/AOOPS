package InLab2;

import java.util.*;

public class EmployeeStreamOperations {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "IT", 60000),
            new Employee("Bob", 25, "HR", 50000),
            new Employee("Charlie", 35, "IT", 70000),
            new Employee("David", 40, "Finance", 80000),
            new Employee("Eve", 28, "HR", 55000)
        );

        System.out.println("Employees in IT department:");
        employees.stream()
                 .filter(emp -> "IT".equals(emp.getDepartment()))
                 .forEach(System.out::println);

        System.out.println("\nEmployees sorted by name:");
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getName))
                 .forEach(System.out::println);

        System.out.println("\nEmployee with highest salary:");
        employees.stream()
                 .max(Comparator.comparingDouble(Employee::getSalary))
                 .ifPresent(System.out::println);

        double avgSalary = employees.stream()
                                    .mapToDouble(Employee::getSalary)
                                    .average()
                                    .orElse(0.0);
        System.out.println("\nAverage salary of employees: " + avgSalary);
    }
}
