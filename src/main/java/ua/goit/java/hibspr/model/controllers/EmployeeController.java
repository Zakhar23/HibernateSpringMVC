package ua.goit.java.hibspr.model.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.model.EmployeeDao;
import ua.goit.java.hibspr.model.hibernate.HEmployeeDao;
import ua.goit.java.hibspr.model.Employee;
import ua.goit.java.hibspr.model.Position;

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);

        employeeDao.save(employee);

    }

    public void setEmployeeDao(HEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
