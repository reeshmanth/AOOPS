package student_system;

public abstract class Student {
    protected String id;
    protected String name;
    protected String department;

    public Student(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public abstract void showStudentInfo();
}
