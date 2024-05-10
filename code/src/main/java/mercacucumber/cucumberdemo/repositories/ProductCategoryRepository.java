package mercacucumber.cucumberdemo.repositories;

import mercacucumber.cucumberdemo.entities.ProductCategoryMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryMO, Long> {
}
