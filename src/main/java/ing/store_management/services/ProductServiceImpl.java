package ing.store_management.services;

import ing.store_management.dtos.ProductDTO;
import ing.store_management.exceptions.ApiNotFoundException;
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
    public List<ProductDTO> addProduct(ProductDTO productDTO) {
        Product newProduct = productMapper.toModel(productDTO);
        return productRepo.add(newProduct).stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepo.getAllProducts().stream().map(productMapper::toDTO).toList();
    }

    @Override
    public ProductDTO getProductById(long id) {
        try {
            return productMapper.toDTO(productRepo.findById(id));
        } catch (Exception e) {
            throw new ApiNotFoundException("Product was not found");
        }
    }

    @Override
    public List<ProductDTO> deleteProductById(long id) {
        return productRepo.delete(id).stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> getProductsByName(String name) {
        return productRepo.search(name).stream().map(productMapper::toDTO).toList();
    }
}
