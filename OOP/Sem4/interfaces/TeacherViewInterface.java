package GeekBrains.OOP.Sem4.interfaces;

import GeekBrains.OOP.Sem4.data.Teacher;

import java.util.List;

public interface TeacherViewInterface<T extends Teacher> {
    public void sendOnConsole(List<T> tList);
}
