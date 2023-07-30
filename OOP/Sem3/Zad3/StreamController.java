package GeekBrains.OOP.Sem3.Zad3;

import java.util.ArrayList;
import java.util.List;

public class StreamController {
    private StreamService streamService;

    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }

    public void sortStreams() {
        streamService.sort();
    }

    @Override
    public String toString() {
        return "StreamController{" +
                "streamService=" + streamService +
                '}';
    }

    public static void main(String[] args) {

        StudentGroup studentGroup1 = new StudentGroup();
        Student student1 = new Student("Vasilyi", "Ivanovich", "Petrov");
        Student student2 = new Student("Alexey", "Sergeevich", "Serkov");
        Student student3 = new Student("Ksenyia", "Vladimirovna", "Glazkova");
        studentGroup1.addStudent(student1);
        studentGroup1.addStudent(student2);
        studentGroup1.addStudent(student3);

        StudentGroup studentGroup2 = new StudentGroup();
        Student student11 = new Student("Mihail", "Igorevich", "Temnov");
        Student student12 = new Student("Viktor", "Petrovich", "Svetlov");
        studentGroup2.addStudent(student11);
        studentGroup2.addStudent(student12);

        StudentGroup studentGroup3 = new StudentGroup();
        Student student31 = new Student("Andrey", "Semenovich", "Kosov");
        Student student32 = new Student("Anatoliy", "Alexandrovich", "Duginkov");
        studentGroup3.addStudent(student31);
        studentGroup3.addStudent(student32);

        Stream stream1 = new Stream(List.of(studentGroup1, studentGroup2));
        Stream stream2 = new Stream(List.of(studentGroup3));

        ArrayList<Stream> streamArrayList = new ArrayList<>();
        streamArrayList.add(stream1);
        streamArrayList.add(stream2);

        StreamService streamService = new StreamService(streamArrayList);

        StreamController streamController = new StreamController(streamService);
        System.out.println(streamController);
        streamController.sortStreams(); // сортировка через свой компаратор по размеру списка учебных групп
        System.out.println(streamController);

    }
}
