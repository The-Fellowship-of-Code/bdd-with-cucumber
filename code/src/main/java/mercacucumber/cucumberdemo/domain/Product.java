package mercacucumber.cucumberdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;

    private String name;

    private Double amount;

    private Double limitAmount;

    private Long supplierId;

    private Long productCategoryId;

    public Boolean isLimitReached(Double amountToBuy){

        return amount - amountToBuy < limitAmount;
    }
}
