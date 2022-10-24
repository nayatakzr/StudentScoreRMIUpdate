import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

public class StudentScoreImpl extends UnicastRemoteObject implements StudentScoreInterface {
    PromotionRecord p_record = new PromotionRecord();
public StudentScoreImpl() throws RemoteException {
    super();
}

    @Override
    public String add_promotion(String promotionId, String name) throws RemoteException {
        Promotion promotion = new Promotion(new StudentRecord(), promotionId, name);
        int result = p_record.saveRecord(promotion);

        if (result == 1) {
            return "Promotion added successfully";
        }
        return "Promotion already exist";
    }

    @Override
    public String add_student(String promotionId, String id, String name, int age) {
    Promotion promotion = p_record.getRecord(promotionId);

    if(promotion == null){
        return "Promotion does not exist";
    }

    StudentRecord record = promotion.getStudentRecord();

    Student student = new Student(id = id, name = name, age = age);
    int result = record.saveRecord(student);
    if (result == 1) {
        return "Student added successfully";
    }
     return "Student already exist";
    }

    @Override
    public String add_exam(String promotionId, String id, String examName, int score, double coefficient) {
        Promotion promotion = p_record.getRecord(promotionId);

        if(promotion == null){
            return "Promotion does not exist";
        }

        StudentRecord record = promotion.getStudentRecord();
        Student student = record.getRecord(id);

        if(student == null){
            return "Student does not exist";
        }
        Exam exam = new Exam(examName, score, coefficient);
        student.addExam(exam);

        int result = record.updateRecord(id, student);
        if (result == 1)
        {
            return "Exam added successfully";
        }
        return "Exam could not be added";
    }

    @Override
    public double calculate_average(String promotionId, String id) {
        Promotion promotion = p_record.getRecord(promotionId);

        if(promotion == null){
            return -2;
        }

        StudentRecord record = promotion.getStudentRecord();
        Student student = record.getRecord(id);

        if(student == null){
            return -1; //STUDENT DOES NOT EXIST
        }

        return student.getAverage();
    }

    @Override
    public double promotion_score(String promotionId) throws RemoteException {
        Promotion promotion = p_record.getRecord(promotionId);

        if(promotion == null){
            return -1;
        }

        StudentRecord record = promotion.getStudentRecord();
        ArrayList<Student> students = record.getAllRecord();

        double studentAverageSum = 0;

        if(students.size() == 0){
            return 0;
        }

        for (Student s : students){
            studentAverageSum += s.getAverage();
        };
        double promotionAverage = studentAverageSum/students.size();
        return promotionAverage;
    }

    @Override
    public String print_exam(String promotionId, String id) throws RemoteException {
        Promotion promotion = p_record.getRecord(promotionId);

        if(promotion == null){
            return "Promotion does not exist";
        }

        StudentRecord record = promotion.getStudentRecord();
        Student student = record.getRecord(id);

        if(student == null){
            return "Student does not exist"; //STUDENT DOES NOT EXIST
        }

        ArrayList<Exam> exams = student.getExams();
        String name;
        String coefficient;
        String score;
        int count = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("s/n\tname\tcoefficient\tscore\n");
        for(var exam: exams){
            name = exam.getName();
            coefficient = String.valueOf(exam.getCoefficient());
            score = String.valueOf(exam.getScore());
            sb.append(++count+"\t"+name+"\t"+coefficient+"\t"+score+"\n");
        }

        return sb.toString();
    }
}

