package ua.goit.java.hibspr.dao;

import ua.goit.java.hibspr.model.Orders;

import java.util.List;

public interface OrderDao {

    void save(Orders order);

    List<Orders> findAll();
}
