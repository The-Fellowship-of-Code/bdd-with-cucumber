package mercacucumber.cucumberdemo.mappers;

import mercacucumber.cucumberdemo.domain.ProductCategory;
import mercacucumber.cucumberdemo.entities.ProductCategoryMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryRepositoryMapper {

    ProductCategory toDomain(ProductCategoryMO productCategoryMO);

    ProductCategoryMO toEntity(ProductCategory productCategory);
}
