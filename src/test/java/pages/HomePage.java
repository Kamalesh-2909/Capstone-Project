package pages;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	//constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void openHomePage(String url) {
        driver.get(url); //get url of the page
    }

    public String getPageTitle() {
        return driver.getTitle(); //get title of the page
    }

    public String getPageLink() {
        return driver.getCurrentUrl(); //get the current url form the page
    }
}
