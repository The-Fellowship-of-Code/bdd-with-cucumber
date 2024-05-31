package mercacucumber.cucumberdemo.repositories;

import mercacucumber.cucumberdemo.entities.ProductMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductMO, Long> {

    List<ProductMO> findBySupplierId(Long id);
}
