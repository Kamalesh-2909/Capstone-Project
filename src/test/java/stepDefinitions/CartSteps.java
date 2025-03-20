package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utils.DriverFactory;

public class CartSteps {
	WebDriver driver;
	CartPage cartPage;
	
	@Before
	public void setup() {
		driver = DriverFactory.getDriver("chrome");
		cartPage = new CartPage(driver);
	}
	
	@Given("I am logging in")
	public void i_am_logging_in() {
		driver.get("https://petstore.octoperf.com/");
		driver.findElement(By.linkText("Enter the Store")).click();
		cartPage.login();
	}
	@When("I search for pet animal")
	public void i_search_for_pet_animal() {
		cartPage.searchForPet();
	}
	@Then("I add the pet to the cart")
	public void i_add_the_pet_to_the_cart() {
		cartPage.addToCart();
	}
	@And("the cart should contain the pet")
	public void the_cart_should_contain_the_pet() {
		Assert.assertTrue(cartPage.isProductInCart(),"Product not in cart");
	}

	@Given("I have a product in the cart")
	public void i_have_a_product_in_the_cart() {
		//Already inside the cart
	}
	@When("I remove the product from the cart")
	public void i_remove_the_product_from_the_cart() {
		cartPage.removeFromCart();
	}
	@Then("the cart should be empty")
	public void the_cart_should_be_empty() {
		Assert.assertTrue(cartPage.isCartEmpty(),"Cart is not empty");
	}
	@Given("I add pet in the cart")
	public void i_add_pet_in_the_cart() {
		driver.findElement(By.name("keyword")).clear();
		cartPage.searchForPet();
		cartPage.addToCart();
	}
	@When("I update the quantity")
	public void i_update_the_quantity() {
		 cartPage.updateQuantity();
	}
	@Then("the total price should be updated accordingly")
	public void the_total_price_should_be_updated_accordingly() {
        Assert.assertTrue(cartPage.isPriceUpdated(),"Price not updated");
	}
	
	@Given("I am in shopping cart")
	public void i_am_in_shopping_cart() {
		// Already inside the cart
	}
	@When("I gave the payment details")
	public void i_gave_the_payment_details() {
	   cartPage.goToCart();
	}
	@Then("I confirm the order")
	public void i_confirm_the_order() {
	    cartPage.confirmOrder();
	}
	@And("order is confirmed")
	public void order_is_confirmed() {
		Assert.assertTrue(cartPage.isOrderConfirmed(),"Order not confirmed");
	}
}
