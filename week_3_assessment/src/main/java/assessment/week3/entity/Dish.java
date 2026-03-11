package assessment.week3.entity;

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
    @JoinColumn(name = "order_id")
    private Order order;

    public Dish() {}

    public Dish(String dishName, int quantity, double price, Order order) {
        this.dishName = dishName;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDishName() { return dishName; }
    public void setDishName(String dishName) { this.dishName = dishName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}