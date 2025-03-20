package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import utils.DriverFactory;

public class ProductSteps {
	WebDriver driver;
    ProductPage productPage;
    
    @Before
    public void setup() {
    driver = DriverFactory.getDriver("chrome");  // Use existing driver instance
    productPage = new ProductPage(driver);
    }

	@Given("I am in home page")
	public void i_am_in_home_page() {
		driver.get("https://petstore.octoperf.com/");   	
    	driver.findElement(By.linkText("Enter the Store")).click();
	}
	@When("I search for {string}")
	public void i_search_for(String prdName) {
	   productPage.searchforPrd(prdName);
	}
	@Then("I should select the product id")
	public void i_should_select_the_product_id() {
	    productPage.selectPrd();
	}
	@Then("I should see product details including title, description, price, image and availability")
	public void i_should_see_product_details_including_title_description_price_image_and_availability() {
		String details = productPage.getProductDetails();
	    System.out.println("Product Details:\n" + details);
	    Assert.assertNotNull("Product details are missing!", details);
	}	
	@Given("I am in product page")
	public void i_am_in_product_page() {
	    //Already in product page
	}
	@When("I add the product to cart")
	public void i_add_the_product_to_cart() {
		productPage.addToCart();
	}
	@Then("the product should be visible in the cart")
	public void the_product_should_be_visible_in_the_cart() {
		Assert.assertTrue(productPage.isPrdInCart(), "Product not found in cart!");
	}
}
