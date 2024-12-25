package rahulshettyacdemy1.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy1.AbstractComponent.AbstractComponent;
//child class send driver to parent class using super ketword
public class LandingPage extends AbstractComponent {
	
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	  
	@FindBy(id="userEmail")
	WebElement UserEmail;
	
	@FindBy(id="userPassword")
	WebElement UserPassword;
	
	@FindBy(id="login")
	WebElement Submit;
	
	@FindBy(css="[class='flyInOut']")
	WebElement ErrorMessage;
	//.ng-tns-c4-15.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	
	//action method
	public ProductCatalogue loginApplication(String email,String password)
	{
		UserEmail.sendKeys(email);
		UserPassword.sendKeys(password);
		Submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public WebElement errorValidation()
	{
		waitForWebElementTovisible(ErrorMessage);
		ErrorMessage.getText();
		return ErrorMessage;
	}
}
