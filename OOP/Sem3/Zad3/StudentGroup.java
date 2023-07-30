package GeekBrains.OOP.Sem3.Zad3;

import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
    private List<Student> studentList;

    public StudentGroup(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentGroup() {
        this.studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "studentList=" + studentList +
                '}';
    }
}
