package ua.goit.java.hibspr.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Waiter extends Employee {

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Orders> orders;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "orders=" + orders +
                "} " + super.toString();
    }
}


