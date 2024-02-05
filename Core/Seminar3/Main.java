package GeekBrains.Core.Seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("F1", "I1", "O1", 20, "proton", "911", 25.5);
        Employee employee2 = new Employee("F2", "I2", "O2", 30, "proton", "911", 25.5);
        Employee employee3 = new Employee("F3", "I2", "O3", 10, "proton", "911", 15.5);
        Employee employee4 = new Employee("F4", "I2", "O4", 40, "proton", "911", 35.5);
        Employee employee5 = new Employee("F5", "I2", "O5", 20, "proton", "911", 25.5);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        System.out.println(employees); // [employee1, employee2, employee3, employee4, employee5]
        Collections.sort(employees);
        System.out.println(employees); // [employee3, employee1, employee5, employee2, employee4]

        Director director = new Director("F6", "I6", "O6", 50, "proton", "911", 500);
        employees.add(director);
        Director.raiseSalary(20, employees);
        System.out.println(employees); // for employees  with Director -> salary + 20



    }
}
