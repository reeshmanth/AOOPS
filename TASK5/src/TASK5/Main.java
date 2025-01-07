package TASK5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Student Information System!");
        
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();  

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  
            students.add(new Student(name, id));
        }

        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine(); 

        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course ID: ");
            String courseId = scanner.nextLine();
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();
            courses.add(new Course(courseId, courseName));
        }

        System.out.println("Enrollment Process:");
        System.out.print("Enter the number of enrollments: ");
        int numEnrollments = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numEnrollments; i++) {
            System.out.print("Enter student ID: ");
            int studentId = scanner.nextInt();
            System.out.print("Enter course ID: ");
            String courseId = scanner.next();
            scanner.nextLine(); 

            Student student = findStudentById(students, studentId);
            Course course = findCourseById(courses, courseId);

            if (student != null && course != null) {
                EnrollmentManager enrollmentManager = new EnrollmentManager(student, course);
                enrollmentManager.enrollStudentInCourse();
            }
        }

        System.out.println("Displaying Details:");
        for (Course course : courses) {
            course.displayCourseDetails();
        }
        for (Student student : students) {
            student.displayStudentDetails();
        }
    }

    public static Student findStudentById(List<Student> students, int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public static Course findCourseById(List<Course> courses, String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}
