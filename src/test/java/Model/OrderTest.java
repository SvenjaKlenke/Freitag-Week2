package Model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addProductsToOrder_shouldShowAllExistingProductsOfOrder() {
        //GIVEN

        Product product1 =new Product("10","Product1");
        Product product2 =new Product("20","Product2");

        Order order = new Order();

        List <Product> expected = List.of(
                product1
        );

        //WHEN
        List <Product> actual = order.addProductsToOrder(product1);;
        //THEN
        assertEquals (expected, actual); ;
    }

}