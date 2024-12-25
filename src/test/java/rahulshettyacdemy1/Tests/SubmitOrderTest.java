package rahulshettyacdemy1.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy1.AbstractComponent.AbstractComponent;
import rahulshettyacdemy1.PageObject.CartPage;
import rahulshettyacdemy1.PageObject.CheckoutPage;
import rahulshettyacdemy1.PageObject.ConfirmationPage;
import rahulshettyacdemy1.PageObject.LandingPage;
import rahulshettyacdemy1.PageObject.ProductCatalogue;
import rahulshettyacdemy1.TestComponent.BaseTest;

public class SubmitOrderTest extends BaseTest{
	String ProductName="ZARA COAT 3";
	
	
	@Test(dataProvider="getData",groups={"Purchase"})
	public void submitOrderTest(HashMap<String,String> input) throws IOException
		{
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductTocart(input.get("product"));
		CartPage cartPage =productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
	      ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		 String ConfirmMessage = confirmationPage.VerifyConfirmationMessage();
		 Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Thankyou for the order."));

	}
	
	
	//DATAPROVIDER
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][] {{"tej@gmail.com","User@123","ZARA COAT 3"}, {"Nithin@gmail.com","User@123","ADIDAS ORIGINAL"}};
//	}
	
	
	
	//using hashh map
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "tej@gmail.com");
//		map.put("password", "User@123");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "Nithin@gmail.com");
//		map1.put("password", "User@123");
//		map1.put("product", "ADIDAS ORIGINAL");
	
		List<HashMap<String ,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy1//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
}
