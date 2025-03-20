package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegPage {
	WebDriver driver;
	
	By registerButton = By.linkText("Register Now!");
    By userIdField = By.name("username");
    By passwordField = By.name("password");
    By repeatPasswordField = By.name("repeatedPassword");
    By firstNameField = By.name("account.firstName");
    By lastNameField = By.name("account.lastName");
    By emailField = By.name("account.email");
    By phoneField = By.name("account.phone");
    By addressField1 = By.name("account.address1");
    By addressField2 = By.name("account.address2");
    By cityField = By.name("account.city");
    By stateField = By.name("account.state");
    By zipField = By.name("account.zip");
    By countryField = By.name("account.country");
    By submitButton = By.name("newAccount");
    By language = By.name("account.languagePreference");

	public UserRegPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickRegister() {
		driver.findElement(registerButton).click();
	}
	public void enterUserId(String userId,String password, String repeatPassword) {
		driver.findElement(userIdField).sendKeys(userId);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(repeatPasswordField).sendKeys(repeatPassword);
	}
	public void fillAccInfo(String firstName, String lastName, String email, String phone, String address1, String address2, String city, String state, String zip, String country) {
		driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(addressField1).sendKeys(address1);
        driver.findElement(addressField2).sendKeys(address2);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(countryField).sendKeys(country);		
	}
	public void submitReg() {
		driver.findElement(submitButton).click();
	}
}
