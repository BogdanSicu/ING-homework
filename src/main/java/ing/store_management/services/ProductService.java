package ing.store_management.services;

import ing.store_management.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> addProduct(ProductDTO productDTO);

    List<ProductDTO> getProducts();

    ProductDTO getProductById(long id);

    List<ProductDTO> deleteProductById(long id);

    List<ProductDTO> getProductsByName(String name);

}
