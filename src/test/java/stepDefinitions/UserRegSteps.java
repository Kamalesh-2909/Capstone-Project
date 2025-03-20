package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserRegPage;
import utils.DriverFactory;

public class UserRegSteps {
	WebDriver driver;
	UserRegPage userRegPage;
	
	@Before
	public void setup() {
		driver = DriverFactory.getDriver("chrome");
		userRegPage = new UserRegPage(driver);
	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
	   driver.get("https://petstore.octoperf.com/actions/Account.action;jsessionid=6BD9CC58F722BF5123E8C34319E0D068?signonForm=");
	}
	@When("I click the register button")
	public void i_click_the_register_button() {
		userRegPage.clickRegister();
	}
	@Then("I enter user ID as {string}")
	public void i_enter_user_id_as(String userId) {
		userRegPage.enterUserId(userId, "Kamal123", "Kamal123");
	}
	@And("I fill in account information")
	public void i_fill_in_account_information() {
	    userRegPage.fillAccInfo("Kamalesh", "A", "kamal@123.com", "0123456789", "Valsaravakkam", "Madras", "Chennai", "Tamil Nadu", "600001", "India");
	}
	@Then("the account should be created successfully")
	public void the_account_should_be_created_successfully() {
	    userRegPage.submitReg();
	}
}
