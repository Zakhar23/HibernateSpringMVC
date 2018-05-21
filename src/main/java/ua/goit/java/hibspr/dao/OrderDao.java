package ua.goit.java.hibspr.dao;

import ua.goit.java.hibspr.model.Order;

import java.util.List;

public interface OrderDao {

    void save(Order order);

    List<Order> findAll();
}
