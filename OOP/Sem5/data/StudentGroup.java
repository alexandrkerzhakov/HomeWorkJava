package GeekBrains.OOP.Sem5.data;

import GeekBrains.OOP.Sem5.model.Teacher;
import GeekBrains.OOP.Sem5.model.User;
import GeekBrains.OOP.Sem5.model.Student;
import GeekBrains.OOP.Sem5.data.StudentGroup;

import java.util.List;

public class StudentGroup {
    private Teacher teacher;
    private List<User> studentList;
    public StudentGroup(Teacher teacher, List<User> studentList){
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public void getTeacher() {
        System.out.println(teacher.toString());
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<User> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<User> studentList) {
        this.studentList = studentList;
    }
    public void createStudent(User user){
        studentList.add((Student) user);
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "teacher=" + teacher +
                ", studentList=" + studentList +
                '}';
    }
}
