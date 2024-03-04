package GeekBrains.JDK.Seminar4.interfaces;

import GeekBrains.JDK.Seminar4.model.Employee;

import java.util.List;

public interface ServiceEmployee {

    List<Employee> findBySeniority(int seniority);
    List<Employee> findByName(String name);
    List<Employee> findByServiceNumber(int serviceNumber);
    void addEmployee(Employee employee);

}
