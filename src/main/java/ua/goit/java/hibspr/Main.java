package ua.goit.java.hibspr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.hibspr.controllers.DishController;
import ua.goit.java.hibspr.controllers.EmployeeController;
import ua.goit.java.hibspr.controllers.OrderController;

import java.util.ArrayList;
import java.util.List;


public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;
    private Boolean reInit;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/hibernate-context.xml", "WEB-INF/application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {

        if (reInit) {
            init();
        }

        employeeController.printAllEmployees();
        employeeController.getAllEmployee().forEach(System.out::println);

    }

    private void init() {

        employeeController.createEmployee();
        dishController.createDish();

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");

        orderController.createOrder("John", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Plov");
        dishes2.add("Salad");

        //orderController.createOrder("John", dishes2, 2);



//        orderController.getAllOrders().forEach(System.out::println);
        orderController.printAllOrders();
//        employeeController.getAllEmployee().forEach(System.out::println);
//        dishController.getAllDishes().forEach(System.out::println);
//
//        System.out.println(employeeController.getEmployeeByName("John"));
//        System.out.println(dishController.getDishByName("Salad"));

    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setReInit(Boolean reInit) {
        this.reInit = reInit;
    }
}
