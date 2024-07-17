package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Support.World.*;

public class amazonSteps {

    @Given("a user is on the amazon home page")
    public void a_user_is_on_the_amazon_home_page() {
        amazonPage.amazonHomePage();
    }

    @When("user types {string} in search field and press enter")
    public void user_types_in_search_field_and_press_enter(String itemName) {
        amazonPage.enterItemInSearchField(itemName);
        amazonPage.clickSearch();
    }

    @When("user selects the first item on the list")
    public void user_selects_the_first_item_on_the_list() {
        amazonPage.getProductPagePrice();
        amazonPage.clickFirstSearchResult();
    }

    @When("user selects the second item on the list")
    public void user_selects_the_second_item_on_the_list() {
        amazonPage.getProductPagePrice1();
        amazonPage.clickSecondSearchResult();
    }

    @When("user clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        amazonPage.clickAddToCartButton();
    }

    @When("user clicks on add to cart button for Laptop")
    public void user_clicks_on_add_to_cart_button_for_Laptop() {
        amazonPage.clickAddToCartButton1();
    }

    @When("user clicks on cart button to open cart page")
    public void user_clicks_on_cart_button_to_open_cart_page() {
        amazonPage.clickOnCartButton();
        amazonPage.getCartPagePrice();
        amazonPage.getCartPageSubTotal();
    }

    @Then("verify that the cart price is identical to the product page")
    public void verify_that_the_cart_price_is_identical_to_the_product_page() {
        amazonPage.verifyProductPageValueWithCartPrice();
    }

    @Then("verify that the cart sub total is identical to the product page")
    public void verify_that_the_cart_sub_total_is_identical_to_the_product_page() {
        amazonPage.verifyProductPageValueWithCartSubTotal();
    }
}
