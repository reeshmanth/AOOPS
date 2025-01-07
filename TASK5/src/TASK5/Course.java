package TASK5;

import java.util.List;
import java.util.ArrayList;

public class Course implements CourseInterface {
    private String courseId;
    private String courseName;
    private List<Student> students;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    @Override
    public void enrollStudent(Student student) {
        students.add(student);
    }

    @Override
    public void displayCourseDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.print("Enrolled Students: ");
        for (Student student : students) {
            System.out.print(student.getName() + " ");
        }
        System.out.println();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public List<Student> getStudents() {
        return students;
    }
}
