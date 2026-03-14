package com.capgemini.java_advance_framework_hibernate_restaurant_order_management_system.main;


import java.util.*;

import com.capgemini.java_advance_framework_hibernate_restaurant_order_management_system.dao.OrderDAO;
import com.capgemini.java_advance_framework_hibernate_restaurant_order_management_system.entity.Dish;
import com.capgemini.java_advance_framework_hibernate_restaurant_order_management_system.entity.Order;



public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customerName orderDate dishName quantity price");

        String name = sc.next();
        String date = sc.next();
        String dishName = sc.next();
        int qty = sc.nextInt();
        double price = sc.nextDouble();

        Order order = new Order();
        order.setCustomerName(name);
        order.setOrderDate(date);

        Dish dish = new Dish();
        dish.setDishName(dishName);
        dish.setQuantity(qty);
        dish.setPrice(price);
        dish.setOrder(order);

        List<Dish> list = new ArrayList<>();
        list.add(dish);

        order.setDishes(list);

        OrderDAO dao = new OrderDAO();
        dao.addOrder(order);

        System.out.println("ID: "+order.getId());
        System.out.println("Customer: "+order.getCustomerName());
        System.out.println("Order Date: "+order.getOrderDate());

        System.out.println("Dishes:");

        for(Dish d: order.getDishes()) {
            System.out.println("Dish Name: "+d.getDishName());
            System.out.println("Quantity: "+d.getQuantity());
            System.out.println("Price: "+d.getPrice());
        }

    }
}