import java.util.ArrayList;

public class Student {
    private String studentId;
    private String name;
    private int age;

    private double average;

    private ArrayList<Exam> exams = new ArrayList<>();

    public Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverage() {
        double average = 0;

        if (exams.size() == 0)
        {
            return average;
        }

        double coefficientSum = 0;
        double coefficientScoreSum = 0;

        for(var exam: exams){
            coefficientSum += exam.getCoefficient();
            coefficientScoreSum += exam.getCoefficient() * exam.getScore();
        }

        average = coefficientScoreSum/coefficientSum;
        return average;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    public void addExam(Exam exam){
        exams.add(exam);
    }
}
