package mercacucumber.cucumberdemo.adapters;

import lombok.RequiredArgsConstructor;
import mercacucumber.cucumberdemo.domain.ProductCategory;
import mercacucumber.cucumberdemo.mappers.ProductCategoryRepositoryMapper;
import mercacucumber.cucumberdemo.repositories.ProductCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductCategoryRepositoryAdapter {

    private final ProductCategoryRepository productCategoryRepository;

    private final ProductCategoryRepositoryMapper productCategoryRepositoryMapper;

    public List<ProductCategory> findAll(){

        return productCategoryRepository.findAll()
                .stream().map(productCategoryRepositoryMapper::toDomain)
                .toList();
    }

    public Optional<ProductCategory> findById(Long id){

        return productCategoryRepository.findById(id)
                .map(productCategoryRepositoryMapper::toDomain);
    }

    public ProductCategory upsert(ProductCategory productCategory){

        return productCategoryRepositoryMapper.toDomain(
                productCategoryRepository.save(
                        productCategoryRepositoryMapper.toEntity(productCategory)));
    }

    public void delete(Long id){

        productCategoryRepository.deleteById(id);
    }
}
