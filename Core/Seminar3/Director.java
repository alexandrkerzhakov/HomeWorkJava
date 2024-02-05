package GeekBrains.Core.Seminar3;

import java.util.ArrayList;
import java.util.List;

public class Director extends Employee {

    public static void raiseSalary(double increaseAmount, List<Employee> employees) {
        employees
                .stream()
                .filter(employee -> !(employee instanceof Director))
                .forEach(employee -> employee.setSalary(employee.getSalary() + increaseAmount));



    }
    public Director(String firstName, String middleName, String lastName, int age, String post, String phoneNumber, double salary) {
        super(firstName, middleName, lastName, age, post, phoneNumber, salary);
    }


}
