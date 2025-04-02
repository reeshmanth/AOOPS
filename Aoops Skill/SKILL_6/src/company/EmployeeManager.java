package company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void sortById() {
        Collections.sort(employees);
    }

    public void sortBySalary() {
        Collections.sort(employees, new EmployeeComparator());
    }

    public Employee cloneEmployee(int index) {
        if (index >= 0 && index < employees.size()) {
            return employees.get(index).clone();
        }
        return null;
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void iterateEmployees() {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
