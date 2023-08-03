package GeekBrains.OOP.Sem4.service;

import GeekBrains.OOP.Sem4.comparator.UserComparator;
import GeekBrains.OOP.Sem4.data.Teacher;
import GeekBrains.OOP.Sem4.data.TeacherGroup;
import GeekBrains.OOP.Sem4.data.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TeacherGroupService {
    private TeacherGroup teacherGroup;

    public void createTeacherGroup(String since, List<Teacher> teacherList) {
        this.teacherGroup = new TeacherGroup(since, teacherList);
    }

    public TeacherGroup getTeacherGroup() {
        return teacherGroup;
    }

    public Teacher FindTeacherFromTeacherGroup(String firstName, String secondName) {
        Iterator<Teacher> iterator = teacherGroup.iterator();
        List<Teacher> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Teacher teacher = iterator.next();
            if (teacher.getFirstName().equalsIgnoreCase(firstName)
                    && teacher.getSecondName().equalsIgnoreCase(secondName)) {
                result.add(teacher);
            }
        }
        if (result.size() == 0) {
            throw new IllegalStateException(
                    String.format("Учитель с именем %s и фамилией %s не найден", firstName, secondName)
            );
        }
        if (result.size() != 1) {
            throw new IllegalStateException("Найдено более одного учителя с указанными именем и фамилией");
        }
        return result.get(0);
    }

    public List<Teacher> getSortedTeacherGroup() {
        List<Teacher> teachers = new ArrayList<>(teacherGroup.getTeacherList());
        Collections.sort(teachers);
        return teachers;
    }

    public List<Teacher> getSortedByFIOTeachersGroup() {
        List<Teacher> teachers = new ArrayList<>(teacherGroup.getTeacherList());
        teachers.sort(new UserComparator<Teacher>());
        return teachers;
    }

    public void createTeacher(User user) {
        teacherGroup.createTeacher(user);
    }
}
