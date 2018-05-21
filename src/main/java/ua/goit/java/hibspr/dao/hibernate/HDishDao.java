package ua.goit.java.hibspr.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.dao.DishDao;
import ua.goit.java.hibspr.model.Dish;

import java.util.List;

public class HDishDao implements DishDao{

    private SessionFactory sessionFactory;

    @Transactional
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Transactional
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
