package com.capgemini.java_advance_framework_hibernate_restaurant_order_management_system.entity;


import jakarta.persistence.*;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dishName;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public int getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}