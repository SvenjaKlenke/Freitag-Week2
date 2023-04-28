package Model;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ShopService {

    private OrderRepo orderRepo = new OrderRepo();
    private ProductRepo productRepo = new ProductRepo();

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public ShopService() {
    }

    public ShopService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(getOrderRepo(), that.getOrderRepo()) && Objects.equals(getProductRepo(), that.getProductRepo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderRepo(), getProductRepo());
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "orderRepo=" + orderRepo +
                ", productRepo=" + productRepo +
                '}';
    }


    public Product getProduct(String productId) {
         return productRepo.getProductById(productId);

    }

    public Set<Product> listProducts() {
        return productRepo.getAllProduct();
    }

    public Map<String, Order> addOrderToShopService(String orderId, Order order) {
        return orderRepo.addOrderToOrderRepo(orderId, order);
    }

    public Order getOrderFromShopService(String orderId) {
        return orderRepo.getOrderByID(orderId);

    }

    public Map<String, Order> listOrders() {
        return orderRepo.getAllOrders();
    }
}
