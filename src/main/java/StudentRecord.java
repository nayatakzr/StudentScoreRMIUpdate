import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

public class StudentRecord {
    private Hashtable<String, Student> studentRecords = new Hashtable<>();
    public Hashtable<String, Student> getStudentRecords() {
        return studentRecords;
    }

    public int saveRecord(Student student){
        String id =  student.getStudentId();
        if(studentRecords.containsKey(id)){
            return 0;
        }
        studentRecords.put(id, student);
        return 1;
    }

    public Student getRecord(String id)
    {
        if (studentRecords.containsKey(id)){
            Student student = studentRecords.get(id);
            return student;
        }
        return null;
    }

    public ArrayList<Student> getAllRecord()
    {
        ArrayList<Student> students = Collections.list(studentRecords.elements());
;        return students;
    }

    public int updateRecord(String id, Student newRecord)
    {
        if (studentRecords.containsKey(id)){
            studentRecords.replace(id, newRecord);
            return 1;
        }
        return 0;
    }
    //DELETERECORD

    public static void main(String[] args){
        Student student1 = new Student("62199", "Musa Usman", 38);
        Student student2 = new Student("62198", "Rajab Imam", 38);
        StudentRecord record= new StudentRecord();
        record.saveRecord(student1);
        record.saveRecord(student2);

        Student student = record.getRecord("62199") ;
        System.out.println(student.getName());
        ArrayList<Student> students = record.getAllRecord();
    }
}
