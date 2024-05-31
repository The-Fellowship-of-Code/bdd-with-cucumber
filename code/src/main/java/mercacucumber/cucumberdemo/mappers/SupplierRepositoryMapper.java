package mercacucumber.cucumberdemo.mappers;

import mercacucumber.cucumberdemo.domain.Supplier;
import mercacucumber.cucumberdemo.entities.SupplierMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierRepositoryMapper {

    Supplier toDomain(SupplierMO supplierMO);

    SupplierMO toEntity(Supplier supplier);
}
