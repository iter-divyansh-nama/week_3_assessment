package com.capgemini.java_advance_framework_hibernate_restaurant_order_management_system.dao;


import com.capgemini.java_advance_framework_hibernate_restaurant_order_management_system.entity.Dish;
import com.capgemini.java_advance_framework_hibernate_restaurant_order_management_system.entity.Order;

import jakarta.persistence.*;

public class OrderDAO {

    EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("restaurant");

    EntityManager em = emf.createEntityManager();

    public void addOrder(Order order) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(order);

        tx.commit();

        System.out.println("Order added successfully");
    }

    public Order searchOrder(int id) {

        TypedQuery<Order> q =
        em.createQuery("SELECT o FROM Order o WHERE o.id=:id", Order.class);

        q.setParameter("id", id);

        return q.getSingleResult();
    }

    public void updateDishQuantity(int orderId,int dishId,int qty) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Order order = em.find(Order.class, orderId);

        for(Dish d : order.getDishes()) {

            if(d.getId()==dishId) {
                d.setQuantity(qty);
            }
        }

        em.merge(order);

        tx.commit();

        System.out.println("Dish updated successfully");
    }

    public void deleteOrder(int id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Order order = em.find(Order.class,id);

        em.remove(order);

        tx.commit();

        System.out.println("Order deleted successfully");
    }
}