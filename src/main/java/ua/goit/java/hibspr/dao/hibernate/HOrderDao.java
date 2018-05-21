package ua.goit.java.hibspr.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.hibspr.dao.OrderDao;
import ua.goit.java.hibspr.model.Order;

import java.util.List;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public List<Order> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
