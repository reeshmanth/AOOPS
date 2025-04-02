package student_system;

public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void enrollStudent(Student student) {
        repository.addStudent(student);
        System.out.println("Student " + student.getName() + " enrolled successfully!");
    }

    public void displayAllStudents() {
        for (Student student : repository.getAllStudents()) {
            student.showStudentInfo();
        }
    }
}
