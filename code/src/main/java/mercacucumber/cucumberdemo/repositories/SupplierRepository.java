package mercacucumber.cucumberdemo.repositories;

import mercacucumber.cucumberdemo.entities.SupplierMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierMO, Long> {
}
