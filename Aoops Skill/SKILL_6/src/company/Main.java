package company;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new Employee(101, "Alice", 75000));
        manager.addEmployee(new Employee(103, "Bob", 60000));
        manager.addEmployee(new Employee(102, "Charlie", 90000));

        System.out.println("Employees sorted by ID (Comparable):");
        manager.sortById();
        manager.displayEmployees();

        System.out.println("\nEmployees sorted by Salary (Comparator):");
        manager.sortBySalary();
        manager.displayEmployees();

        System.out.println("\nCloning employee at index 1:");
        Employee cloned = manager.cloneEmployee(1);
        if (cloned != null) {
            System.out.println("Cloned Employee: " + cloned);
        }

        System.out.println("\nIterating over employees:");
        manager.iterateEmployees();
    }
}
