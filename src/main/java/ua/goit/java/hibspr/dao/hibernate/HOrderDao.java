package ua.goit.java.hibspr.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.dao.OrderDao;
import ua.goit.java.hibspr.model.Orders;

import java.util.List;

public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Transactional
    public void save(Orders order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Transactional
    public List<Orders> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
