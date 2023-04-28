package Model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private String orderId;
    private List<Product> productsOrder= new ArrayList<>();


    public Order() {
    }

    public Order(String orderId, List<Product> productsOrder) {
        this.orderId = orderId;
        this.productsOrder = productsOrder;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProductsOrder() {
        return productsOrder;
    }

    public void setProductsOrder(List<Product> productsOrder) {
        this.productsOrder = productsOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", productsOrder=" + productsOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getOrderId(), order.getOrderId()) && Objects.equals(getProductsOrder(), order.getProductsOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getProductsOrder());
    }


    public List addProductsToOrder(Product product) {
        productsOrder.add(product);
            return productsOrder;
        }
}



