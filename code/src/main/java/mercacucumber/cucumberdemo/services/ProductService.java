package mercacucumber.cucumberdemo.services;

import lombok.RequiredArgsConstructor;
import mercacucumber.cucumberdemo.adapters.ProductRepositoryAdapter;
import mercacucumber.cucumberdemo.domain.Product;
import mercacucumber.cucumberdemo.domain.ProductOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepositoryAdapter productRepositoryAdapter;

    public List<Product> getProducts(){

        return productRepositoryAdapter.findAll();
    }

    public Product getProductById(Long id){

        return productRepositoryAdapter.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public Product createProduct(Product product){

        return productRepositoryAdapter.upsert(product);
    }

    @Transactional
    public Product updateProduct(Long id, Product product){

        return productRepositoryAdapter.upsert(product);
    }

    @Transactional
    public void deleteProduct(Long id){

        productRepositoryAdapter.delete(id);
    }

    @Transactional
    public Product buyProduct(Long id, ProductOrder productOrder){

        Product product = productRepositoryAdapter.findById(id).orElseThrow(RuntimeException::new);
        if(product.isLimitReached(productOrder.getAmount())){
            //TODO send event
            throw new RuntimeException();
        }

        product.setAmount(product.getAmount() - productOrder.getAmount());
        return productRepositoryAdapter.upsert(product);
    }

}
