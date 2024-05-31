package mercacucumber.cucumberdemo.adapters;

import lombok.RequiredArgsConstructor;
import mercacucumber.cucumberdemo.domain.Product;
import mercacucumber.cucumberdemo.mappers.ProductRepositoryMapper;
import mercacucumber.cucumberdemo.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter {

    private final ProductRepository productRepository;

    private final ProductRepositoryMapper productRepositoryMapper;

    public List<Product> findAll(){

        return productRepository.findAll()
                .stream().map(productRepositoryMapper::toDomain)
                .toList();
    }

    public Optional<Product> findById(Long id){

        return productRepository.findById(id)
                .map(productRepositoryMapper::toDomain);
    }

    public Product upsert(Product product){

        return productRepositoryMapper.toDomain(
                productRepository.save(
                        productRepositoryMapper.toEntity(product)));
    }

    public void delete(Long id){

        productRepository.deleteById(id);
    }

    public List<Product> findProductsBySupplierId(Long id){

        return productRepository.findBySupplierId(id)
                .stream()
                .map(productRepositoryMapper::toDomain)
                .toList();
    }
}
