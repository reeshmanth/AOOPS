package student_system;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class StudentServiceTest {
    private StudentRepository repository;
    private StudentService service;

    @BeforeEach
    void setUp() {
        repository = new StudentRepository();
        service = new StudentService(repository);
    }

    @Test
    void testEnrollStudent() {
        Student student = new UndergraduateStudent("U102", "Charlie", "Math", 2);
        service.enrollStudent(student);

        List<Student> students = repository.getAllStudents();
        assertEquals(1, students.size());
        assertEquals("Charlie", students.get(0).getName());
    }

    @Test
    void testGetAllStudents() {
        Student s1 = new UndergraduateStudent("U103", "Dave", "Physics", 1);
        Student s2 = new GraduateStudent("G202", "Eve", "Cybersecurity", "Blockchain Security");

        service.enrollStudent(s1);
        service.enrollStudent(s2);

        List<Student> students = repository.getAllStudents();
        assertEquals(2, students.size());
    }
}
