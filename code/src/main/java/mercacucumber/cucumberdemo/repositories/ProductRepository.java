package mercacucumber.cucumberdemo.repositories;

import mercacucumber.cucumberdemo.entities.ProductMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductMO, Long> {

}
