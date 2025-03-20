package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import utils.DriverFactory;

public class SearchStep {
	WebDriver driver;
    SearchPage searchPage;
    
    @Before
    public void setup() {
    driver = DriverFactory.getDriver("chrome");  // Use existing driver instance
    searchPage = new SearchPage(driver);
    }
    
	@Given("I am in user page")
	public void i_am_in_user_page() {
		driver.get("https://petstore.octoperf.com/");   	
    	driver.findElement(By.linkText("Enter the Store")).click();
	}
	@When("I search for pet")
	public void i_search_for_pet() {
		searchPage.searchForPet("Bulldog");
	}
	@Then("I should see search results containing pet")
	public void i_should_see_search_results_containing_pet() {
		Assert.assertTrue(searchPage.isSearchResultDisplayed(),"Search result not displayed");
	}
	@Then("I select the product id")
	public void i_select_the_product_id() {
		searchPage.selectProduct();
	}
	@Then("I get the price")
	public void i_get_the_price() {
		String price = searchPage.getProductPrice();
		System.out.println("/nPrice: "+price);
		Assert.assertFalse(price.isEmpty(),"Price not found");
	}
}
