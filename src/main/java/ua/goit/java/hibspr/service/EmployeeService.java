package ua.goit.java.hibspr.service;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.dao.EmployeeDao;
import ua.goit.java.hibspr.model.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.findAllWaiters();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
