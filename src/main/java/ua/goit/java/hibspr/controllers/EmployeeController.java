package ua.goit.java.hibspr.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.dao.EmployeeDao;
import ua.goit.java.hibspr.dao.hibernate.HEmployeeDao;
import ua.goit.java.hibspr.model.Employee;
import ua.goit.java.hibspr.model.Position;
import ua.goit.java.hibspr.model.Waiter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public Employee createEmployee() {

        Set<Employee> allEmployees = new HashSet<Employee>(employeeDao.findAll());

        Waiter waiter = new Waiter();
        //employee.setId(1L);
        waiter.setName("John");
        waiter.setSurname("Smith");
        waiter.setPosition(Position.WAITER);
        waiter.setPhoneNumber("555-55-55");
        waiter.setSalary(25000.0F);

        if (!allEmployees.contains(waiter)) {
            employeeDao.save(waiter);
        }

        return waiter;

    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    @Transactional
    public void printAllEmployees() {
        employeeDao.findAll().forEach(System.out::println);
    }

    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
