package ua.goit.java.hibspr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.java.hibspr.dao.EmployeeDao;
import ua.goit.java.hibspr.service.EmployeeService;

import java.util.Map;

@Controller
public class EmployeeControllerWeb {

    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model) {
        model.put("employees", employeeService.getEmployees());
        return "employees";
    }

//    @RequestMapping(value = "/employee", method = RequestMethod.GET)
//        public ModelAndView employee(@RequestParam("employee") String employeeName) {

    @RequestMapping(value = "/employee/{employeeName}", method = RequestMethod.GET)
    public ModelAndView employee(@PathVariable String employeeName, @ModelAttribute String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getEmployeeByName(employeeName));
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}
