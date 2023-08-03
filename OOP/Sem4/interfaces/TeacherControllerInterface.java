package GeekBrains.OOP.Sem4.interfaces;

import GeekBrains.OOP.Sem4.data.Teacher;

public interface TeacherControllerInterface<T extends Teacher> {
    void create(String firstName, String secondName, Long teacherID);
}
