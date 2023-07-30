package GeekBrains.OOP.Sem3.Zad3;

import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<StudentGroup> {
    private List<StudentGroup> studentGroups;

    public Stream(List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    @Override
    public StudentGroupListIterator iterator() {
        return new StudentGroupListIterator(this.studentGroups);
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "studentGroups=" + studentGroups +
                '}';
    }
}
