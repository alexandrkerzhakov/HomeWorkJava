package GeekBrains.Junior.Seminar1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework {

    /**
     * Реалзиовать методы, описанные ниже:
     */

    /**
     * Вывести на консоль отсортированные (по алфавиту) имена персонов
     */
    public void printNamesOrdered(List<Streams.Person> persons) {
        persons
                .stream()
                .sorted(Comparator.comparing(Streams.Person::getName))
                .forEach(System.out::println);
    }

    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапипнг department -> personName
     * Map<Department, Person>
     */
    public Map<Streams.Department, Streams.Person> printDepartmentOldestPerson(List<Streams.Person> persons) {
        try {
            Comparator<Streams.Person> ageComparator = Comparator.comparing(Streams.Person::getAge);
            return persons.stream()
                    .collect(Collectors.toMap(Streams.Person::getDepartment, Function.identity(), (first, second) -> {
                        if (ageComparator.compare(first, second) > 0) {
                            return first;
                        }
                        return second;
                    }));
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
     */
    public List<Streams.Person> findFirstPersons(List<Streams.Person> persons) {
        try {
            return persons.stream()
                    .filter(person -> person.getAge() < 30)
                    .filter(person -> person.getSalary() > 50_000)
                    .limit(10)
                    .toList();
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
     */
    public Optional<Streams.Department> findTopDepartment(List<Streams.Person> persons) {
        try {
            Map<Streams.Department, Integer> departmentSalarySum = persons
                    .stream()
                    .collect(Collectors.groupingBy
                            (Streams.Person::getDepartment,
                                    Collectors.reducing(0, person -> (int) person.getSalary(), Integer::sum)));

            return departmentSalarySum.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey);
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }
}

