package ing.store_management.repos;

import ing.store_management.exceptions.ApiNotFoundException;
import ing.store_management.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepo {

    private static long idCount = 0;

    private final List<Product> list = new ArrayList<>() {{
        idCount++;
        add(new Product(idCount, "product 1", 10f, 1000L));
        idCount++;
        add(new Product(idCount, "product 2", 20f, 2000L));
        idCount++;
        add(new Product(idCount, "product 3", 30f, 3000L));
    }};

    public List<Product> getAllProducts() {
        return list;
    }

    public Product findById(long id) {
        if(id <= list.size()) {
            for (Product product : list) {
                if (product.getId() == (id)) {
                    return product;
                }
            }
        }
        return null;
    }

    public List<Product> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public List<Product> delete(Long id) {
        if(list.removeIf(x -> x.getId() == (id)))
            return list;
        else throw new ApiNotFoundException("Product was not found");
    }

    public List<Product> add(Product newProduct) {
        Product product = new Product();
        idCount++;
        product.setId(idCount);
        product.setName(newProduct.getName());
        product.setQuantity(newProduct.getQuantity());
        product.setPrice(newProduct.getPrice());
        list.add(product);
        return list;
    }
}
