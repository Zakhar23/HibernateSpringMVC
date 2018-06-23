package ua.goit.java.hibspr.dao;

import ua.goit.java.hibspr.model.Employee;
import ua.goit.java.hibspr.model.Waiter;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();

    Employee findByName(String name);

    void remove(Employee employee);
}
