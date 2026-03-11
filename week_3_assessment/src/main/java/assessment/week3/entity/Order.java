package assessment.week3.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@jakarta.persistence.Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;
    private String orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Dish> dishes;

    public Order() {}

    public Order(String customerName, String orderDate) {
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public List<Dish> getDishes() { return dishes; }
    public void setDishes(List<Dish> dishes) { this.dishes = dishes; }
}