package GeekBrains.KR2;

/*
Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>. Поместите в него некоторое количество объектов.
Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество. Убедитесь, что все они сохранились во множество.
Создайте метод public boolean equals(Object o)
Создайте метод
public int hashCode()
который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать Objects.hash(...))
Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.
 */


import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;
        return age == cat.age && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void printColection(Collection collection) {
        collection.stream().forEach(element -> System.out.print(element + " "));
    }

    public static void main(String[] args) {
        HashSet<Cat> catHashSet = new HashSet<>();
        Cat cat1 = new Cat("Murzik", 3);
        catHashSet.add(cat1);
        Cat cat2 = new Cat("Nursik", 4);
        catHashSet.add(cat2);
        Cat cat3 = new Cat("Musya", 2);
        catHashSet.add(cat3);

//        printColection(catHashSet); // Cat{name='Musya', age=2} Cat{name='Murzik', age=3} Cat{name='Nursik', age=4}

        Cat cat4 = new Cat("Murzik", 3);
        catHashSet.add(cat4);
        Cat cat5 = new Cat("Musya", 2);
        catHashSet.add(cat5);

        printColection(catHashSet);
//      1) -> Cat{name='Murzik', age=3} Cat{name='Musya', age=2} Cat{name='Murzik', age=3} Cat{name='Nursik', age=4} Cat{name='Musya', age=2}
//      2) -> before equals and hashcode  Cat{name='Nursik', age=4} Cat{name='Murzik', age=3} Cat{name='Musya', age=2}
    }
}





