package GeekBrains.OOP.Sem3.Zad3;

public class StudentGroupController {
    private StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    public void deleteStudent(String firstname, String secondname, String lastname) {
        studentGroupService.deleteStudent(firstname, secondname, lastname);
    }

    public static void main(String[] args) {
        StudentGroup studentGroup = new StudentGroup();

        Student student1 = new Student("Vasilyi", "Ivanovich", "Petrov");
        Student student2 = new Student("Alexey", "Sergeevich", "Serkov");
        Student student3 = new Student("Ksenyia", "Vladimirovna", "Glazkova");
        Student student4 = new Student("Vasilyi", "Ivanovich", "Petrov");

        System.out.println(studentGroup); // StudentGroup{studentList=[]}

        studentGroup.addStudent(student1);
        studentGroup.addStudent(student2);
        studentGroup.addStudent(student3);
        studentGroup.addStudent(student4);
//        StudentGroupIterator studentGroupIterator = new StudentGroupIterator(studentGroup);
//        while (studentGroupIterator.hasNext()) {
//            System.out.println(studentGroupIterator.next());
//        }
        System.out.println(studentGroup);
        // StudentGroup{studentList=[Student{firstname='Vasilyi', lastname='Petrov', secondname='Ivanovich'},
        // Student{firstname='Alexey', lastname='Serkov', secondname='Sergeevich'},
        // Student{firstname='Ksenyia', lastname='Glazkova', secondname='Vladimirovna'},
        // Student{firstname='Vasilyi', lastname='Petrov', secondname='Ivanovich'}]}


        StudentGroupService studentGroupService = new StudentGroupService(studentGroup);
        studentGroupService.deleteStudent("Vasilyi", "Ivanovich", "Petrov");
        System.out.println(studentGroup);
        // StudentGroup{studentList=[Student{firstname='Alexey', lastname='Serkov', secondname='Sergeevich'},
        // Student{firstname='Ksenyia', lastname='Glazkova', secondname='Vladimirovna'}]}

        StudentGroupController studentGroupController = new StudentGroupController(studentGroupService);
        studentGroupController.deleteStudent("Ksenyia", "Vladimirovna", "Glazkova");
        System.out.println(studentGroup); // StudentGroup{studentList=[Student{firstname='Alexey', lastname='Serkov', secondname='Sergeevich'}]}
    }
}
