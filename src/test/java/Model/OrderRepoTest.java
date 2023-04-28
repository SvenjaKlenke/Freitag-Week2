package Model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    void addOrderToOrderRepo_shouldShowAllExistingOrdersOfOrderRepo() {
        //GIVEN

        Product product1 =new Product("10","Product1");
        Product product2 =new Product("20","Product2");
        Order order1 = new Order();
        order1.addProductsToOrder(product1);
        order1.addProductsToOrder(product2);

        OrderRepo orderRepo = new OrderRepo();

        Map <String, Order> expected = Map.of(
                "1", order1
        );

        //WHEN
        Map <String, Order> actual = orderRepo.addOrderToOrderRepo("1",order1);
        //THEN
        assertEquals (expected, actual); ;
    }

    @Test
    void addAndShowAllProducts_shouldShowAllExistingProducts() {
        //GIVEN

        Product product1 =new Product("10","Product1");
        Product product2 =new Product("20","Product2");
        Order order1 = new Order();
        order1.addProductsToOrder(product1);
        order1.addProductsToOrder(product2);
        Order order2 = new Order();
        order2.addProductsToOrder(product1);
        order2.addProductsToOrder(product1);
        OrderRepo orderRepo = new OrderRepo();
        orderRepo.addOrderToOrderRepo("1",order1);
        orderRepo.addOrderToOrderRepo("2",order2);

        //WHEN & THEN
        assertTrue (order1 == orderRepo.getOrderByID("1"));
    }

}