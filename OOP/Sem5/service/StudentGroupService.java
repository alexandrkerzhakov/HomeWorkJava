package GeekBrains.OOP.Sem5.service;

import GeekBrains.OOP.Sem5.data.StudentGroup;
import GeekBrains.OOP.Sem5.model.Teacher;
import GeekBrains.OOP.Sem5.model.User;

import java.util.List;

public class StudentGroupService {
    private StudentGroup StudentGroup;
    public void createStudentGroup(Teacher teacher, List<User> students){
        this.StudentGroup = new StudentGroup(teacher, students);
    }
    public void createStudent(User user){
        StudentGroup.createStudent(user);
    }
    public StudentGroup getStudentGroup() {
        return StudentGroup;
    }
    public List<User> getStudentList(){
        return StudentGroup.getStudentList();
    }
    public void getTeacher(){
        StudentGroup.getTeacher();
    }
}
