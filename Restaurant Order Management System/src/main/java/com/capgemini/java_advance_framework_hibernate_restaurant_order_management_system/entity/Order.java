package com.capgemini.java_advance_framework_hibernate_restaurant_order_management_system.entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;
    private String orderDate;

    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<Dish> dishes;

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}