package mercacucumber.cucumberdemo.services;

import lombok.RequiredArgsConstructor;
import mercacucumber.cucumberdemo.adapters.ProductCategoryRepositoryAdapter;
import mercacucumber.cucumberdemo.domain.ProductCategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    
    private final ProductCategoryRepositoryAdapter productCategoryRepositoryAdapter;

    public List<ProductCategory> getProductCategories(){

        return productCategoryRepositoryAdapter.findAll();
    }

    public ProductCategory getProductCategoryById(Long id){

        return productCategoryRepositoryAdapter.findById(id).orElse(null);
    }

    @Transactional
    public ProductCategory createProductCategory(ProductCategory ProductCategory){

        return productCategoryRepositoryAdapter.upsert(ProductCategory);
    }

    @Transactional
    public ProductCategory updateProductCategory(Long id, ProductCategory ProductCategory){

        return productCategoryRepositoryAdapter.upsert(ProductCategory);
    }

    @Transactional
    public void deleteProductCategory(Long id){

        productCategoryRepositoryAdapter.delete(id);
    }
}
