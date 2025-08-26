package ing.store_management.controllers;

import ing.store_management.dtos.ProductDTO;
import ing.store_management.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
