package mercacucumber.cucumberdemo.controller;

import lombok.RequiredArgsConstructor;
import mercacucumber.cucumberdemo.domain.ProductCategory;
import mercacucumber.cucumberdemo.services.ProductCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/productCategories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getProductCategories(){

        return ResponseEntity.ok(productCategoryService.getProductCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable Long id){

        return ResponseEntity.ok(productCategoryService.getProductCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory){

        return ResponseEntity.ok(productCategoryService.createProductCategory(productCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable Long id, @RequestBody ProductCategory productCategory){

        return ResponseEntity.ok(productCategoryService.updateProductCategory(id, productCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductCategory(@PathVariable Long id){

        productCategoryService.deleteProductCategory(id);

        return ResponseEntity.ok().build();
    }
}
