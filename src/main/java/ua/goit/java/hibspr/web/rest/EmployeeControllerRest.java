package ua.goit.java.hibspr.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.hibspr.model.Employee;
import ua.goit.java.hibspr.service.EmployeeService;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeControllerRest {

    private EmployeeService employeeService;

    @RequestMapping(value = "/rest/employee", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> employees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/rest/employee/{employeeName}", method = RequestMethod.GET)
    @ResponseBody
    public Employee employee(@PathVariable String employeeName) {
        return employeeService.getEmployeeByName(employeeName);
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}
