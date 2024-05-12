package mercacucumber.cucumberdemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mercacucumber.cucumberdemo.domain.Product;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    private Product product;
    private Double amountBought;


    @Given("a product named {word} with an amount of {double} and a limit of {double}")
    public void productWithAmountAndLimit(String name, Double amount, Double limit) {

        product = Product.builder()
                .name(name)
                .amount(amount)
                .limitAmount(limit)
                .build();
    }

    @When("the client buys {double} unit(s)")
    public void clientBuysAmount(Double amount) {

        amountBought = amount;
    }

    @Then("product limit is  not reached")
    public void productLimitIsNotReached() {

        assertFalse(product.isLimitReached(amountBought));
    }

    @Then("product limit is reached")
    public void productLimitIsReached() {

        assertTrue(product.isLimitReached(amountBought));
    }
}
