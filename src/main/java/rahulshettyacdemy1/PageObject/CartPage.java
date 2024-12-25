package rahulshettyacdemy1.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy1.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent { 

	WebDriver driver;
	public CartPage (WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> ProductTitles;
	
	@FindBy(css=".totalRow button")
    WebElement CheckoutEle;
	
	
	public Boolean verifyProductDisplay(String ProductName)
	{
	boolean match = ProductTitles.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(ProductName));
	return match;
	
	}
	
	public CheckoutPage goToCheckout()
	{
		CheckoutEle.click();
		return new CheckoutPage(driver);
	}
	
	
}
		
