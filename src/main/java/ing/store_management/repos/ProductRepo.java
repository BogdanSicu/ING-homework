package ing.store_management.repos;

import ing.store_management.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {

    private List<Product> list = List.of(
            new Product(1L, "product 1", 10f, 1000L),
            new Product(2L, "product 2", 20f, 2000L),
            new Product(3L, "product 3", 30f, 3000L)
    );

    public List<Product> getAllProducts() {
        return list;
    }

    public Product findById(long id){
        for (Product product : list) {
            if (product.getId() == (id)) {
                return product;
            }
        }
        return null;
    }
}
