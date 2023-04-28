package Model;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void getOneProduct_shouldShowOneProduct() {
        //GIVEN

        Product product1 =new Product("10","Product1");
        Product product2 =new Product("20","Product2");
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);

        ShopService shopService = new ShopService(productRepo);



        //WHEN
        Product actual = shopService.getProduct("20");
        //THEN
        assertEquals (product2,actual);
    }

    @Test
    void getListProducts_shouldShowAllProducts() {
        //GIVEN

        Product product1 =new Product("10","Product1");
        Product product2 =new Product("20","Product2");
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);

        ShopService shopService = new ShopService(productRepo);

        Set <Product> expected = Set.of(
                product1,
                product2
        );

                //WHEN
        Set <Product> actual = shopService.listProducts();
        //THEN
        assertEquals (expected,actual);
    }

    @Test
    void addOrderToShopService_shouldShowAllExistingOrdersOfOrderRepo() {
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


        ShopService shopService = new ShopService(orderRepo);

        Map<String, Order> expected = Map.of(
                "1", order1
        );

        //WHEN
        Map <String, Order> actual = shopService.addOrderToShopService("1", order1);
        //THEN
        assertEquals (expected, actual);
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

        ShopService shopService = new ShopService(orderRepo);

        //WHEN & THEN
        assertTrue (order1 == shopService.getOrderFromShopService("1"));
    }

    @Test
    void addAndShowAllOrders_shouldShowAllExistingOrders() {
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

        ShopService shopService = new ShopService(orderRepo);

        Map <String, Order> expected = Map.of(
                "1", order1,
                "2", order2
        );

        //WHEN
        Map <String, Order> actual = shopService.listOrders();
        //THEN
        assertEquals (expected, actual);
    }

}