package mercacucumber.cucumberdemo;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import mercacucumber.cucumberdemo.adapters.ProductRepositoryAdapter;
import mercacucumber.cucumberdemo.domain.Product;
import mercacucumber.cucumberdemo.domain.Supplier;
import mercacucumber.cucumberdemo.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
public class SupplierProductStepDefinitions {

    private ProductService productService;

    private ProductRepositoryAdapter productRepositoryAdapter;

    private Supplier supplier;
    private List<Product> products;
    private String supplierName;

    @Before
    public void initializeProducts(){

        productRepositoryAdapter = mock(ProductRepositoryAdapter.class);
        productService = new ProductService(productRepositoryAdapter);
        products = new ArrayList<>();
    }

    @Given("a supplier named {word} with id {long}")
    public void aSupplierNamed(String supplierName, Long id) {

        supplier = Supplier.builder()
                .name(supplierName)
                .id(id)
                .build();
    }

    @Given("products associated to {word}")
    public void productsAssociatedTo(String supplierName, io.cucumber.datatable.DataTable productsAssociated) {

        for(Map<String, String> product : productsAssociated.asMaps()){

            products.add(Product.builder()
                            .name(product.get("name"))
                            .supplierId(Long.valueOf(product.get("supplierId")))
                    .build());
        }
    }

    @When("the client search for {word} products")
    public void theClientSearchForSupplierProducts(String supplierName) {

        this.supplierName = supplierName;
    }

    @Then("the following products are returned")
    public void theFollowingProductsAreReturned(io.cucumber.datatable.DataTable productsExpected) {

        List<String> productNames = new ArrayList<>();
        for(Map<String, String> product : productsExpected.asMaps()) productNames.add(product.get("name"));

        when(productRepositoryAdapter.findProductsBySupplierId(supplier.getId())).thenReturn(products);
        List<Product> result = productService.findProductsBySupplierId(supplier.getId());

        assertEquals(result.size(), productNames.size());
        assertEquals(result.get(0).getName(), productNames.get(0));
        assertEquals(result.get(1).getName(), productNames.get(1));

    }
}
