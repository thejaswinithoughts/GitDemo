package rahulshettyacdemy1.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy1.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;
	public CheckoutPage (WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(css=".ta-item:last-of-type")
	WebElement SelectCountry;
	
	@FindBy(css=".action__submit")
	WebElement Submit;
	
	
	
	public void selectCountry(String CountryName)
	{
		Actions a = new Actions (driver);
		a.sendKeys(Country,CountryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		SelectCountry.click();
	}
	public ConfirmationPage submitOrder()
	{
		Submit.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
}
