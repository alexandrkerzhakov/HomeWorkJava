package GeekBrains.OOP.Sem5.controller;


import GeekBrains.OOP.Sem5.model.Student;
import GeekBrains.OOP.Sem5.model.Teacher;
import GeekBrains.OOP.Sem5.model.User;
import GeekBrains.OOP.Sem5.service.StudentGroupService;

import java.util.List;

public class Controller {
    StudentGroupService studentGroupService = new StudentGroupService();
    public void createStudyGroup(Teacher teacher, List<User> students){
        studentGroupService.createStudentGroup(teacher, students);
    }
    public void getStudyGroupId(){
        List<User> userList = studentGroupService.getStudentList();
        for (User user: userList) {
            Student student = (Student) user;
            System.out.println("StudentId: " + student.getStudentId());
        }
    }
    public void getTeacherId(){
        studentGroupService.getTeacher();
    }
}
