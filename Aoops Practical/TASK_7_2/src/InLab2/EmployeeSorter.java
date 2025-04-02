package InLab2;
import java.util.*;

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 60000));
        employees.add(new Employee(2, "Bob", "IT", 75000));
        employees.add(new Employee(3, "Charlie", "Finance", 70000));
        employees.add(new Employee(4, "David", "IT", 72000));
        employees.add(new Employee(5, "Eve", "HR", 65000));

        Collections.sort(employees, new SalaryAscComparator());
        System.out.println("Employees sorted by salary (ascending):");
        for (Employee e : employees) {
            System.out.println(e);
        }

        Collections.sort(employees, new SalaryDescComparator());
        System.out.println("\nEmployees sorted by salary (descending):");
        for (Employee e : employees) {
            System.out.println(e);
        }

        Collections.sort(employees, new NameComparator());
        System.out.println("\nEmployees sorted by name:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        Collections.sort(employees, new DepartmentComparator());
        System.out.println("\nEmployees sorted by department:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
