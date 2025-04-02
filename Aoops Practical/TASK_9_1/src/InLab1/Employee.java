package InLab1;

class Employee {
    String name;
    int age;
    int experience;
    double salary;

    public Employee(String name, int age, int experience, double salary) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (Experience: " + experience + " years, Salary: $" + salary + ")";
    }
}