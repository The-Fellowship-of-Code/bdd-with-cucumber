package mercacucumber.cucumberdemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductMO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "limit_amount")
    private Double limitAmount;

    @ManyToOne
    @MapsId("supplierId")
    @JoinColumn(name = "supplier_id",
            foreignKey = @ForeignKey(name = "fk_product_supplier_id"))
    private SupplierMO supplier;

    @ManyToOne
    @MapsId("productCategoryId")
    @JoinColumn(name = "product_category_id",
            foreignKey = @ForeignKey(name = "fk_product_product_category_id"))
    private ProductCategoryMO productCategory;
}
