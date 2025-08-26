package ing.store_management.mappers;

import ing.store_management.dtos.ProductDTO;
import ing.store_management.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<Product, ProductDTO>{

    @Override
    public ProductDTO toDTO(Product model) {
        return new ProductDTO(model.getName(), model.getPrice(), model.getQuantity());
    }

    @Override
    public Product toModel(ProductDTO dto) {
        return new Product(dto.name(), dto.price(), dto.quantity());
    }
}
