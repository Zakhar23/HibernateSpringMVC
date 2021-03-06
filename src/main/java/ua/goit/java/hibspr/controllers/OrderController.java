package ua.goit.java.hibspr.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.dao.DishDao;
import ua.goit.java.hibspr.dao.EmployeeDao;
import ua.goit.java.hibspr.dao.OrderDao;
import ua.goit.java.hibspr.model.Dish;
import ua.goit.java.hibspr.model.DishCategory;
import ua.goit.java.hibspr.model.Orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OrderController {

    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrderDao orderDao;

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
        Orders order = new Orders();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDate(new Date());

        orderDao.save(order);

        orderDao.save(createOrderWithIceCream());

    }

    private Orders createOrderWithIceCream() {
        List<Dish> dishes = new ArrayList<>();

        Dish iceCream = new Dish();
        iceCream.setName("Ice Cream");
        iceCream.setCategory(DishCategory.DESSERT);
        iceCream.setPrice(3.0F);
        iceCream.setWeight(100.0F);
        dishes.add(iceCream);

        Orders order = new Orders();
        order.setWaiter(employeeDao.findByName("John"));
        order.setDishes(dishes);
        order.setTableNumber(13);
        order.setOrderDate(new Date());

        return order;
    }

    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }

    @Transactional
    public List<Orders> getAllOrders() {
        return orderDao.findAll();
    }

    @Transactional
    public void printAllOrders() {
        getAllOrders().forEach(System.out::println);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
