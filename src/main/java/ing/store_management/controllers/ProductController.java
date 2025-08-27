package ing.store_management.controllers;

import ing.store_management.dtos.ProductDTO;
import ing.store_management.services.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable @Min(1) Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> getProductsByName(@RequestParam @NotBlank String name) {
        return new ResponseEntity<>(productService.getProductsByName(name), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<List<ProductDTO>> addNewProduct(@RequestBody @Valid ProductDTO productDTO) {
        return new ResponseEntity<>(productService.addProduct(productDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<ProductDTO>> deleteProductsByName(@PathVariable @Min(1) Long id) {
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.ACCEPTED);
    }

}
