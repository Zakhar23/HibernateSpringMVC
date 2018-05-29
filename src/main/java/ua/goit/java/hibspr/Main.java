package ua.goit.java.hibspr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.hibspr.controllers.DishController;
import ua.goit.java.hibspr.controllers.EmployeeController;


public class Main {

    private EmployeeController employeeController;
    private DishController dishController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("hibernate-context.xml", "application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {

        employeeController.createEmployee();
        dishController.createDish();

        employeeController.getAllEmployee().forEach(System.out::println);
        dishController.getAllDishes().forEach(System.out::println);

        System.out.println(employeeController.getEmployeeByName("John"));
        System.out.println(dishController.getDishByName("Salad"));

    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
