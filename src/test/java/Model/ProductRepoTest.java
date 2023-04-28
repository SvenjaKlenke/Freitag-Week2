package Model;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void addAndShowAllProducts_shouldShowAllExistingProducts() {
        //GIVEN

        Product product1 =new Product("10","Product1");
        Product product2 =new Product("20","Product2");
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);

        Set <Product> expected = Set.of(
                product1,
                product2
        );

        //WHEN
        Set <Product> actual = productRepo.getAllProduct();
        //THEN
        assertEquals (expected,actual);
    }

    @Test
    void getProductById_showProduct() {
        //GIVEN

        Product product1 =new Product("10","Product1");
        Product product2 =new Product("20","Product2");
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);



        //WHEN
        Product actual = productRepo.getProductById("10");
        //THEN
        assertEquals (product1,actual);
    }

    @Test
    void getProductById_throwException() {
        //GIVEN

        Product product1 =new Product("10","Product1");
        Product product2 =new Product("20","Product2");
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(product1);
        productRepo.addProduct(product2);

        //WHEN
        Product actual = productRepo.getProductById("3");
        //THEN
        assertEquals (product1,actual);
    }

}