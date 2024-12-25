package rahulshettyacdemy1.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rahulshettyacademy1.AbstractComponent.AbstractComponent;
import rahulshettyacdemy1.PageObject.CartPage;
import rahulshettyacdemy1.PageObject.CheckoutPage;
import rahulshettyacdemy1.PageObject.ConfirmationPage;
import rahulshettyacdemy1.PageObject.LandingPage;
import rahulshettyacdemy1.PageObject.ProductCatalogue;
import rahulshettyacdemy1.TestComponent.BaseTest;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups={"ErrorHandling"})
	public void submitOrderTest() throws IOException
		{
	 landingPage.loginApplication("tj@gmail.com", "User@123");
	 Assert.assertEquals("Incorrect email or password.", landingPage.errorValidation());

	}
	
}
