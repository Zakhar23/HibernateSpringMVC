package ua.goit.java.hibspr.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.dao.EmployeeDao;
import ua.goit.java.hibspr.model.Employee;

import java.util.List;

public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    public Employee load(Long id) {
        return null;
    }

    @Transactional
    public List<Employee> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Employee e").list();
    }

    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
