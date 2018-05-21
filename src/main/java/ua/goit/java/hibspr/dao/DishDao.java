package ua.goit.java.hibspr.dao;

import ua.goit.java.hibspr.model.Dish;

import java.util.List;

public interface DishDao {

    void save(Dish dish);

    List<Dish> findAll();
}
