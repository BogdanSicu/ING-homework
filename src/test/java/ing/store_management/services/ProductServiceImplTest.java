package ing.store_management.services;

import ing.store_management.dtos.ProductDTO;
import ing.store_management.exceptions.ApiNotFoundException;
import ing.store_management.mappers.Mapper;
import ing.store_management.models.Product;
import ing.store_management.repos.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepo productRepo;

    @Mock
    private Mapper<Product, ProductDTO> productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct() {
        ProductDTO productDTO = new ProductDTO("test", 4.0f, 1L);
        Product product = new Product();

        when(productMapper.toModel(productDTO)).thenReturn(product);
        when(productRepo.add(product)).thenReturn(List.of(product));
        when(productMapper.toDTO(product)).thenReturn(productDTO);

        List<ProductDTO> result = productService.addProduct(productDTO);

        assertEquals(1, result.size());
        assertEquals(productDTO, result.get(0));

        verify(productMapper).toModel(productDTO);
        verify(productRepo).add(product);
        verify(productMapper).toDTO(product);
    }

    @Test
    void testGetProducts() {
        Product product = new Product();
        ProductDTO productDTO = new ProductDTO("test", 4.0f, 1L);

        when(productRepo.getAllProducts()).thenReturn(List.of(product));
        when(productMapper.toDTO(product)).thenReturn(productDTO);

        List<ProductDTO> result = productService.getProducts();

        assertEquals(1, result.size());
        assertEquals(productDTO, result.get(0));

        verify(productRepo).getAllProducts();
        verify(productMapper).toDTO(product);
    }

    @Test
    void testGetProductById_Success() {
        long id = 1L;
        Product product = new Product();
        ProductDTO productDTO = new ProductDTO("test", 4.0f, 1L);

        when(productRepo.findById(id)).thenReturn(product);
        when(productMapper.toDTO(product)).thenReturn(productDTO);

        ProductDTO result = productService.getProductById(id);

        assertEquals(productDTO, result);

        verify(productRepo).findById(id);
        verify(productMapper).toDTO(product);
    }

    @Test
    void testGetProductById_NotFound() {
        long id = 2L;

        when(productRepo.findById(id)).thenThrow(new RuntimeException("Not Found"));

        ApiNotFoundException exception = assertThrows(ApiNotFoundException.class, () -> productService.getProductById(id));

        assertEquals("Product was not found", exception.getMessage());
        verify(productRepo).findById(id);
    }

    @Test
    void testDeleteProductById() {
        long id = 1L;
        Product product = new Product();
        ProductDTO productDTO = new ProductDTO("test", 4.0f, 1L);

        when(productRepo.delete(id)).thenReturn(List.of(product));
        when(productMapper.toDTO(product)).thenReturn(productDTO);

        List<ProductDTO> result = productService.deleteProductById(id);

        assertEquals(1, result.size());
        assertEquals(productDTO, result.get(0));

        verify(productRepo).delete(id);
        verify(productMapper).toDTO(product);
    }

    @Test
    void testGetProductsByName() {
        String name = "Test";
        Product product = new Product();
        ProductDTO productDTO = new ProductDTO("test", 4.0f, 1L);

        when(productRepo.search(name)).thenReturn(List.of(product));
        when(productMapper.toDTO(product)).thenReturn(productDTO);

        List<ProductDTO> result = productService.getProductsByName(name);

        assertEquals(1, result.size());
        assertEquals(productDTO, result.get(0));

        verify(productRepo).search(name);
        verify(productMapper).toDTO(product);
    }

    @Test
    void testGetProductsByName_Empty() {
        String name = "Unknown";

        when(productRepo.search(name)).thenReturn(Collections.emptyList());

        List<ProductDTO> result = productService.getProductsByName(name);

        assertTrue(result.isEmpty());
        verify(productRepo).search(name);
    }

}