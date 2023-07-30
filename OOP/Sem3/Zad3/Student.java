package GeekBrains.OOP.Sem3.Zad3;

/* Задача 3
— Создать класс Поток, содержащий в себе список УчебныхГрупп и реализующий интерфейс Iterable;
— Создать класс StreamComparator, реализующий сравнение количества групп, входящих в Поток;
— Создать класс ПотокСервис, добавив в него метод сортировки списка потоков, используя созданный StreamComparator;
— Модифицировать класс Контроллер, добавив в него созданный сервис;
— Модифицировать класс Контроллер, добавив в него метод, сортирующий список потоков, путём вызова созданного сервиса.
 */


import java.util.Objects;

public class Student {
    private String firstname;
    private String secondname;
    private String lastname;


    public Student(String firstname, String secondname, String lastname) { // without number
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(firstname, student.firstname) && Objects.equals(lastname, student.lastname) && Objects.equals(secondname, student.secondname);
    }
}
