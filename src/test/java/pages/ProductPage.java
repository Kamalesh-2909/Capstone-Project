package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	WebDriver driver;
	
	By searchBox = By.name("keyword");
	By searchButton = By.name("searchProducts");
	By productLink = By.xpath("//a[contains(@href,'viewProduct')]");
	By addToCartButton = By.xpath("//a[contains(@href, 'addItemToCart')]");
	By cartItem = By.xpath("//tr[2]/td[3]");
	By clickItemId = By.xpath("//a[contains(@href,'viewItem')]");	
	By title = By.xpath("//tr[4]/td");
	By description = By.xpath("//tr[3]/td/b/font");
	By productPrice = By.xpath("//td[contains(text(),'$')]");	
	By image = By.xpath("//img[contains(@src,'images/bird')]");
	By availability = By.xpath("//tr[5]/td");
	
	
	//constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	public void searchforPrd(String prdName) {
		WebElement searchInput = driver.findElement(searchBox);
		searchInput.clear(); //Clear any existing text before entering
		searchInput.sendKeys(prdName);
		driver.findElement(searchButton).click();
	}
	public void selectPrd() {
		driver.findElement(productLink).click();
		driver.findElement(clickItemId).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //wait for 5 sec after this method

	}
	public String getProductDetails() {
	    String productTitle = driver.findElement(title).getText(); //Retrieves text
	    String productDescription = driver.findElement(description).getText();
	    String Price = driver.findElement(productPrice).getText();
	    String productImage = driver.findElement(image).getAttribute("src"); //Retrieves the text from img 
	    String productAvailability = driver.findElement(availability).getText();

	    return "Title: " + productTitle + "\n" +
	           "Description: " + productDescription + "\n" +
	           "Price: " + Price + "\n" +
	           "Image URL: " + productImage + "\n" +
	           "Availability: " + productAvailability;
	}
	public void addToCart() {
		driver.findElement(addToCartButton).click();
	}
	public boolean isPrdInCart() {
		return driver.findElement(cartItem).isDisplayed(); //check if the item is displayed
	}
}
