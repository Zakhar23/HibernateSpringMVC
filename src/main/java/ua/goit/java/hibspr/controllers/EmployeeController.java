package ua.goit.java.hibspr.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.model.EmployeeDao;
import ua.goit.java.hibspr.hibernate.HEmployeeDao;
import ua.goit.java.hibspr.model.Employee;
import ua.goit.java.hibspr.model.Position;

import java.util.HashSet;
import java.util.Set;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public Employee createEmployee() {

        Set<Employee> allEmployees = new HashSet<Employee>(employeeDao.findAll());

        Employee employee = new Employee();
        //employee.setId(1L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);

        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);
        }

        return employee;

    }

    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
