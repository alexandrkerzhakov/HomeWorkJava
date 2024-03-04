package GeekBrains.JDK.Seminar4;

import GeekBrains.JDK.Seminar4.model.Employee;
import GeekBrains.JDK.Seminar4.service.ServiceEmployeeImp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee(1, "9998887766", "One", 1));
        employeeList.add(new Employee(2, "9998885544", "Two", 5));
        employeeList.add(new Employee(3, "9998884433", "Three", 7));
        employeeList.add(new Employee(4, "9998882211", "Four", 3));
        employeeList.add(new Employee(5, "9998881100", "Five", 9));
    }

    public static void main(String[] args) {
        ServiceEmployeeImp serviceEmployeeImp = new ServiceEmployeeImp(employeeList);

        System.out.println(serviceEmployeeImp.findBySeniority(1)); // [Employee{serviceNumber=1, phoneNumber='9998887766', name='One', seniority=1}]
        System.out.println(serviceEmployeeImp.findBySeniority(10)); // []

        System.out.println(serviceEmployeeImp.findByName("One")); // [Employee{serviceNumber=1, phoneNumber='9998887766', name='One', seniority=1}]
        System.out.println(serviceEmployeeImp.findByName("Six")); // []

        System.out.println(serviceEmployeeImp.findByServiceNumber(5)); // [Employee{serviceNumber=5, phoneNumber='9998881100', name='Five', seniority=9}]
        System.out.println(serviceEmployeeImp.findByServiceNumber(6)); // []

        System.out.println(employeeList);
        // [Employee{serviceNumber=1, phoneNumber='9998887766', name='One', seniority=1},
        // Employee{serviceNumber=2, phoneNumber='9998885544', name='Two', seniority=5},
        // Employee{serviceNumber=3, phoneNumber='9998884433', name='Three', seniority=7},
        // Employee{serviceNumber=4, phoneNumber='9998882211', name='Four', seniority=3},
        // Employee{serviceNumber=5, phoneNumber='9998881100', name='Five', seniority=9}]

        serviceEmployeeImp.addEmployee(new Employee(6, "9998881199", "Six", 8));

        System.out.println(employeeList);
        // [Employee{serviceNumber=1, phoneNumber='9998887766', name='One', seniority=1},
        // Employee{serviceNumber=2, phoneNumber='9998885544', name='Two', seniority=5},
        // Employee{serviceNumber=3, phoneNumber='9998884433', name='Three', seniority=7},
        // Employee{serviceNumber=4, phoneNumber='9998882211', name='Four', seniority=3},
        // Employee{serviceNumber=5, phoneNumber='9998881100', name='Five', seniority=9},
        // Employee{serviceNumber=6, phoneNumber='9998881199', name='Six', seniority=8}]


    }
}
