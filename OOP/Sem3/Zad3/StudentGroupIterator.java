package GeekBrains.OOP.Sem3.Zad3;

import java.util.Iterator;
import java.util.function.Consumer;

public class StudentGroupIterator implements Iterator<Student> {
    private int studentCounter;
    private StudentGroup studentGroup;

    public StudentGroupIterator(StudentGroup studentGroup) {
        this.studentCounter = 0;
        this.studentGroup = studentGroup;
    }

    public StudentGroupIterator() {

    }

    @Override
    public boolean hasNext() {
        if (studentGroup.getStudentList() == null) return false;
        return studentCounter < studentGroup.getStudentList().size();
    }

    @Override
    public Student next() {
        if (!hasNext()) return null;
        Student nextStudent = studentGroup.getStudentList().get(studentCounter);
        studentCounter++;
        return nextStudent;
    }

    @Override
    public void remove() {
        if (studentGroup.getStudentList() == null) throw new NullPointerException("Removal is not possible");
        studentGroup.getStudentList().remove(studentCounter);
    }

    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }

    public static void main(String[] args) {

        Student student1 = new Student("Vasilyi", "Terkin", "Ivanovich");
        Student student2 = new Student("Alexey", "Markov", "Srgeevich");
        Student student3 = new Student("Ksenyia", "Vladimirovna", "Glazkova");

        StudentGroup studentGroup1 = new StudentGroup();
        System.out.println(studentGroup1 + " " + studentGroup1.getStudentList().size());
        studentGroup1.addStudent(student1);
        studentGroup1.addStudent(student2);
        studentGroup1.addStudent(student3);
        System.out.println(studentGroup1 + " " + studentGroup1.getStudentList().size());
        System.out.println();

        StudentGroupIterator studentGroupIterator = new StudentGroupIterator(studentGroup1);
        while (studentGroupIterator.hasNext()) {
            System.out.println(studentGroupIterator.next());
        }
    }

}
