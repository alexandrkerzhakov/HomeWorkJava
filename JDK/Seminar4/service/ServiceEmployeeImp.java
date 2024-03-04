package GeekBrains.JDK.Seminar4.service;

import GeekBrains.JDK.Seminar4.interfaces.ServiceEmployee;
import GeekBrains.JDK.Seminar4.model.Employee;

import java.util.List;

public class ServiceEmployeeImp implements ServiceEmployee {
    List<Employee> employeeList;

    public ServiceEmployeeImp(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public List<Employee> findBySeniority(int seniority) {
        return employeeList
                .stream()
                .filter(employee -> employee.getSeniority() == seniority)
                .toList();
    }


    @Override
    public List<Employee> findByName(String name) {
        return employeeList
                .stream()
                .filter(employee -> employee.getName().equals(name))
                .toList();
    }

    @Override
    public List<Employee> findByServiceNumber(int serviceNumber) {
        return employeeList
                .stream()
                .filter(employee -> employee.getServiceNumber() == serviceNumber)
                .toList();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
