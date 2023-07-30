package GeekBrains.OOP.Sem3.Zad3;

import java.util.Iterator;
import java.util.List;

public class StudentGroupListIterator implements Iterator<StudentGroup> {
    private int counterStudentGroupList;
    private List<StudentGroup> studentGroupList;

    public StudentGroupListIterator(List<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
        this.counterStudentGroupList = 0;
    }

    @Override
    public boolean hasNext() {
        if (studentGroupList == null) return false;
        return counterStudentGroupList < studentGroupList.size();
    }

    @Override
    public StudentGroup next() {
        if (!hasNext()) return null;
        StudentGroup nextStudentGroup = studentGroupList.get(counterStudentGroupList);
        counterStudentGroupList++;
        return nextStudentGroup;
    }
}
