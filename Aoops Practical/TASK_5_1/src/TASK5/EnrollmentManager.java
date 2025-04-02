package TASK5;

public class EnrollmentManager implements EnrollmentInterface {
    private StudentInterface student;
    private CourseInterface course;

    public EnrollmentManager(StudentInterface student, CourseInterface course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public void enrollStudentInCourse() {
        student.enrollInCourse((Course) course);
        course.enrollStudent((Student) student);
    }
}
