package Model;

import Model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderRepo {

    private Map <String, Order> allOrders = new HashMap<>();

    public OrderRepo(Map<String, Order> allOrders) {
        this.allOrders = allOrders;
    }

    public OrderRepo() {
    }

    public Map<String, Order> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(Map<String, Order> allOrders) {
        this.allOrders = allOrders;
    }

    @Override
    public String toString() {
        return "OrderRepo{" +
                "allOrders=" + allOrders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepo orderRepo = (OrderRepo) o;
        return Objects.equals(getAllOrders(), orderRepo.getAllOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAllOrders());
    }
}
