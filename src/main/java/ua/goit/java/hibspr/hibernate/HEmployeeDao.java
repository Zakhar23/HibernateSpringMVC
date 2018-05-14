package ua.goit.java.hibspr.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibspr.model.EmployeeDao;
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

    public List<Employee> findAll() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
