package student_system;

public class GraduateStudent extends Student {
    private String researchTopic;

    public GraduateStudent(String id, String name, String department, String researchTopic) {
        super(id, name, department);
        this.researchTopic = researchTopic;
    }

    @Override
    public void showStudentInfo() {
        System.out.println("Graduate Student: " + name + ", Research Topic: " + researchTopic);
    }
}
