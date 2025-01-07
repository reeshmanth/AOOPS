package TASK5;

import java.util.List;
import java.util.ArrayList;

public class Student implements StudentInterface {
    private String name;
    private int id;
    private List<Course> courses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    @Override
    public void enrollInCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.print("Courses Enrolled: ");
        for (Course course : courses) {
            System.out.print(course.getCourseName() + " ");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
