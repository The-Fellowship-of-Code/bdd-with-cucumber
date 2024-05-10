package mercacucumber.cucumberdemo.mappers;

import mercacucumber.cucumberdemo.domain.Product;
import mercacucumber.cucumberdemo.entities.ProductMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRepositoryMapper {

    Product toDomain(ProductMO productMO);

    ProductMO toEntity(Product product);
}
