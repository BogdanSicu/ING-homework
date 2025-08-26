package ing.store_management.services;

import ing.store_management.dtos.ProductDTO;
import ing.store_management.mappers.Mapper;
import ing.store_management.models.Product;
import ing.store_management.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;
    private final Mapper<Product, ProductDTO> productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, Mapper<Product, ProductDTO> productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO addProduct(ProductDTO newProduct) {
        return null;
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepo.getAllProducts().stream().map(productMapper::toDTO).toList();
    }

    @Override
    public ProductDTO getProductById(long id) {
        return null;
    }

    @Override
    public void deleteProductById(long id) {

    }

    @Override
    public ProductDTO getProductByName(String name) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO updatedProduct) {
        return null;
    }
}
