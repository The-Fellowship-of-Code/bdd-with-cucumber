package mercacucumber.cucumberdemo.controller;

import lombok.RequiredArgsConstructor;
import mercacucumber.cucumberdemo.domain.Product;
import mercacucumber.cucumberdemo.domain.ProductOrder;
import mercacucumber.cucumberdemo.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){

        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){

        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){

        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/buy")
    public ResponseEntity<Product> buyProduct(@PathVariable Long id, @RequestBody ProductOrder productOrder) {

        return ResponseEntity.ok(productService.buyProduct(id, productOrder));
    }

}
