package ua.goit.java.hibspr.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.dao.EmployeeDao;
import ua.goit.java.hibspr.model.Employee;
import ua.goit.java.hibspr.model.Position;
import ua.goit.java.hibspr.model.Waiter;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String employeeName) {
        return employeeDao.findByName(employeeName);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
