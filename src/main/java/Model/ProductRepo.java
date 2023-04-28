package Model;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class ProductRepo {

    private Set <Product> allProduct = new HashSet<>();

    public  Product addProduct (Product product){
        allProduct.add(product);
        return product;
    }

    public ProductRepo(Set<Product> allProduct) {
        this.allProduct = allProduct;
    }

    public ProductRepo() {
    }

    public Set<Product> getAllProduct() {
        return allProduct;
    }

    public void setAllProduct(Set<Product> allProduct) {
        this.allProduct = allProduct;
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "allProduct=" + allProduct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(getAllProduct(), that.getAllProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAllProduct());
    }


    public Product getProductById(String id) throws NoSuchElementException{
        for (Product product : allProduct) {
            if (product.getProductId().equals(id)) {
                return product;
            }

        }throw new NoSuchElementException("Invalid ID - Go away");

    }

}
