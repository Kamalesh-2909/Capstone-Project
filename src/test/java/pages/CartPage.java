package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	
	By searchBox = By.name("keyword");
    By searchButton = By.name("searchProducts");
    By productLink = By.xpath("//a[contains(@href,'viewProduct')]");
    By addToCartButton = By.linkText("Add to Cart");
    By productName = By.xpath("//td[contains(text(),'Shark')]");
    By removeButton = By.xpath("//a[contains(@href,'removeItemFromCart')]");
    By quantityField = By.name("EST-3");
    By updateButton = By.name("updateCartQuantities");
    By totalPrice = By.xpath("//td[7][contains(text(),'$')]");
    By checkoutButton = By.xpath("//a[contains(@href,'newOrderForm')]");
    By paymentPageBtn = By.name("newOrder");
    By confirmOrderButton = By.xpath("//a[contains(@href,'confirmed')]");
    By orderConfirmation = By.className("messages");
	
    
    public CartPage(WebDriver driver) {
		this.driver = driver;
	}
    public void login(){
    	driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("username")).sendKeys("Kamal29");
		driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Kamal@29");
        driver.findElement(By.name("signon")).click();
    }
    public void searchForPet() {
    	driver.findElement(searchBox).sendKeys("Shark");
        driver.findElement(searchButton).click();
        driver.findElement(productLink).click();
    }
    
    public void addToCart() {
    	driver.findElement(addToCartButton).click();
    }
    public boolean isProductInCart() {
        return driver.findElement(productName).isDisplayed();
    }
    public void removeFromCart() {
        driver.findElement(removeButton).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(productName).isEmpty(); //checks whether it is empty
    }
    public void updateQuantity() {
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(String.valueOf("2"));
        driver.findElement(updateButton).click();
    }
    public boolean isPriceUpdated() {
        String price = driver.findElement(totalPrice).getText();
        return price.contains("$");
    }

    public void goToCart() {
        driver.findElement(checkoutButton).click();
        driver.findElement(paymentPageBtn).click();
    }
    public void confirmOrder() {
        driver.findElement(confirmOrderButton).click();
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(orderConfirmation).isDisplayed();
    }
    
}
