package GeekBrains.OOP.Sem3.Zad3;

import java.util.List;

public class StudentGroupService {
    private StudentGroup studentGroup;

    public StudentGroupService(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public void deleteStudent(String firstname, String secondname, String lastname) {
        Student delStudent;
        List<Student> tempStudentList;

        delStudent = new Student(firstname, secondname, lastname);
        tempStudentList = studentGroup.getStudentList()
                .stream()
                .filter(student -> !student.equals(delStudent))
                .toList();

        studentGroup.setStudentList(tempStudentList);
    }
}
