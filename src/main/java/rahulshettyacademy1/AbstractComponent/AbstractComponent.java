package rahulshettyacademy1.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacdemy1.PageObject.CartPage;
//parent class
public class AbstractComponent {
	//local object
	WebDriver driver;

    public AbstractComponent(WebDriver driver) 
    {
	this.driver=driver;
	}
    
    @FindBy(css="[routerlink*='cart']")
   WebElement cartHeader;
    
    
    public  CartPage goToCartPage()
    {
    	cartHeader.click();
    	CartPage cartPage = new CartPage(driver);
    	return cartPage;
    }
    

    public void waitForElementToAppear(By findBy)
    {
	WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
    

    public void waitForWebElementTovisible(WebElement Ele)
    {
	WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(Ele));
	}
    
    
    public void waitForElementToDisappear(WebElement Ele)
    {
	
	WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.invisibilityOf(Ele));
	
	}
    
    public void maximizeWindow() {
    
    }

}
