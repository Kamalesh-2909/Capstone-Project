package stepDefinitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utils.DriverFactory;

public class HomePageSteps {
	WebDriver driver;
    HomePage homePage;
    
	@Before
    public void setup() {
        driver = DriverFactory.getDriver("chrome");  // Use existing driver instance
        homePage = new HomePage(driver);
    }
    
	@Given("I open the PetStore application")
	public void i_open_the_pet_store_application() {
		homePage.openHomePage("https://petstore.octoperf.com/");
	}
	
	@Then("I should verify page title")
	public void i_should_verify_page_title() {
		String expectedTitle = "JPetStore Demo";
        Assert.assertEquals(homePage.getPageTitle(), expectedTitle, "Page title does not match!");
	}
	
	@And("I should verify page link")
	public void i_should_verify_page_link() {
		Assert.assertEquals(homePage.getPageLink(), "https://petstore.octoperf.com/","Page link does not match!");
	}
}
