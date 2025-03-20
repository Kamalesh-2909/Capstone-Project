package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	WebDriver driver;
	
	By searchBox = By.name("keyword");
	By searchResult = By.xpath("//td[contains(text(),'Bulldog')]");
	By searchButton = By.name("searchProducts");
	By productLink = By.xpath("//font[contains(text(),' K9-BD-01 ')]");
	By productPrice = By.xpath("//td[contains(text(),'$')]");
	
	// Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public void searchForPet(String petName) {
            WebElement searchInput = driver.findElement(searchBox);
            searchInput.clear(); // Clear any existing text before entering
            searchInput.sendKeys(petName);
            driver.findElement(searchButton).click();
    }
    public boolean isSearchResultDisplayed() {
		return driver.findElement(searchResult).isDisplayed();  	
    }
    public void selectProduct() {
    	driver.findElement(productLink).click();
    }
    public String getProductPrice() {
    	driver.findElement(By.linkText("EST-6")).click();
    	return driver.findElement(productPrice).getText();
    }
}
