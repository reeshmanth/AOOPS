package employees;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    private List<Employee> employeeList;

    public EmployeeService() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Alice", 60000));
        employeeList.add(new Employee(2, "Bob", 45000));
        employeeList.add(new Employee(3, "Charlie", 55000));
        employeeList.add(new Employee(4, "David", 70000));
        employeeList.add(new Employee(5, "Eve", 52000));
        employeeList.add(new Employee(6, "Frank", 48000));
        employeeList.add(new Employee(7, "Grace", 75000));
        employeeList.add(new Employee(8, "Hannah", 68000));
        employeeList.add(new Employee(9, "Ian", 49000));
        employeeList.add(new Employee(10, "Jack", 53000));
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public List<Employee> filterEmployeesBySalary(double threshold) {
        return employeeList.stream()
                .filter(e -> e.getSalary() > threshold)
                .collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesBySalary() {
        return employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public Optional<Employee> findHighestSalaryEmployee() {
        return employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    public double calculateAverageSalary() {
        return employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
}
