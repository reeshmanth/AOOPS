package student_system;

public class UndergraduateStudent extends Student {
    private int semester;

    public UndergraduateStudent(String id, String name, String department, int semester) {
        super(id, name, department);
        this.semester = semester;
    }

    @Override
    public void showStudentInfo() {
        System.out.println("Undergraduate Student: " + name + ", Semester: " + semester);
    }
}
