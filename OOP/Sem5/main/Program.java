package GeekBrains.OOP.Sem5.main;

import GeekBrains.OOP.Sem5.model.Teacher;
import GeekBrains.OOP.Sem5.model.User;
import GeekBrains.OOP.Sem5.model.Student;
import GeekBrains.OOP.Sem5.data.StudentGroup;
import GeekBrains.OOP.Sem5.controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<User> students = new ArrayList<>();
        Controller controller = new Controller();

        Teacher teacher = new Teacher("Nikita", "Nikiforov", "Sergeevich", 125);
        Student student1 = new Student("Popa", "Nikiforov", "Sergeevich", 11);
        Student student2 = new Student("Mopa", "Nikiforov", "Sergeevich", 12);
        Student student3 = new Student("Boba", "Nikiforov", "Sergeevich", 13);
        Student student4 = new Student("Kola", "Nikiforov", "Sergeevich", 15);
        Student student5 = new Student("Gola", "Nikiforov", "Sergeevich", 14);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        StudentGroup studentGroup = new StudentGroup(teacher, students);
        controller.createStudyGroup(teacher, studentGroup.getStudentList());

        controller.getTeacherId();
        controller.getStudyGroupId();
    }
}
