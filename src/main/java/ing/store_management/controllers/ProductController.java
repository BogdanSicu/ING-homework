package ing.store_management.controllers;

import ing.store_management.dtos.ProductDTO;
import ing.store_management.services.ProductService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("hello-world")
    public String HelloWorld() {
        return "Hello World!";
    }

    @GetMapping()
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable @Min(1) Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<ProductDTO> getProductsByName(@RequestParam @NotBlank String name) {
        return productService.getProductsByName(name);
    }

    @PostMapping()
    public List<ProductDTO> addNewProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    public List<ProductDTO> deleteProductsByName(@PathVariable @Min(1) Long id) {
        return productService.deleteProductById(id);
    }

}
