package ing.store_management.services;

import ing.store_management.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    public ProductDTO addProduct(ProductDTO newProduct);

    public List<ProductDTO> getProducts();

    public ProductDTO getProductById(long id);

    public void deleteProductById(long id);

    public ProductDTO getProductByName(String name);

    public ProductDTO updateProduct(ProductDTO updatedProduct);

}
