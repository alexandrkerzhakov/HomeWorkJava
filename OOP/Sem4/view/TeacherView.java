package GeekBrains.OOP.Sem4.view;

import GeekBrains.OOP.Sem4.data.Teacher;
import GeekBrains.OOP.Sem4.interfaces.TeacherViewInterface;

import java.util.List;

public class TeacherView implements TeacherViewInterface<Teacher> {
    @Override
    public void sendOnConsole(List<Teacher> teacherList) {
        teacherList.stream().forEach(teacher -> System.out.println("Teacher -> " + teacher.getTeacherId()));
    }
}
