package student_system;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);

        Student s1 = new UndergraduateStudent("U101", "Alice", "CS", 3);
        Student s2 = new GraduateStudent("G202", "Bob", "AI", "Deep Learning");

        service.enrollStudent(s1);
        service.enrollStudent(s2);

        System.out.println("\nAll Students:");
        service.displayAllStudents();
    }
}
