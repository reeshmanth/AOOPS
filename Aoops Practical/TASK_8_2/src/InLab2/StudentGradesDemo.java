package InLab2;

public class StudentGradesDemo {
    public static void main(String[] args) {
        StudentGradesManager manager = new StudentGradesManager();

        manager.addGrade(101, "A");
        manager.addGrade(102, "B+");
        manager.addGrade(101, "A-");
        manager.addGrade(103, "B");
        manager.addGrade(102, "A"); 

        System.out.println("Grades for Student 101: " + manager.getGrades(101));

        manager.listAllGrades();
    }
}