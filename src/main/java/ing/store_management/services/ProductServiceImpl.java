package ing.store_management.services;

import ing.store_management.dtos.ProductDTO;
import ing.store_management.exceptions.ApiNotFoundException;
import ing.store_management.mappers.Mapper;
import ing.store_management.models.Product;
import ing.store_management.repos.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepo productRepo;
    private final Mapper<Product, ProductDTO> productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, Mapper<Product, ProductDTO> productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> addProduct(ProductDTO productDTO) {
        logger.info("Adding new Product " + productDTO.toString());
        Product newProduct = productMapper.toModel(productDTO);
        return productRepo.add(newProduct).stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> getProducts() {
        logger.info("Get all products");
        return productRepo.getAllProducts().stream().map(productMapper::toDTO).toList();
    }

    @Override
    public ProductDTO getProductById(long id) {
        try {
            logger.info("Get product by id " + id);
            return productMapper.toDTO(productRepo.findById(id));
        } catch (Exception e) {
            throw new ApiNotFoundException("Product was not found");
        }
    }

    @Override
    public List<ProductDTO> deleteProductById(long id) {
        logger.info("Delete product by id " + id);
        return productRepo.delete(id).stream().map(productMapper::toDTO).toList();
    }

    @Override
    public List<ProductDTO> getProductsByName(String name) {
        logger.info("Get products that start with name " + name);
        return productRepo.search(name).stream().map(productMapper::toDTO).toList();
    }
}
