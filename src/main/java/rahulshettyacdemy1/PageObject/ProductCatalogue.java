package rahulshettyacdemy1.PageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy1.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	  
    @FindBy(css=".mb-3")
     List<WebElement> products;
    
    @FindBy(css=".ng-animating")
     WebElement spinner;
    
  //By.cssSelector(".mb-3"))); = this is just by locator.
     By productsBy = By.cssSelector(".mb-3");
     By addToCart  = By.cssSelector(".card-body button:last-of-type");
     By toastMessage =By.cssSelector("#toast-container");
     
  
      public  List<WebElement> getProductList()
       {
	      waitForElementToAppear(productsBy);
           return products;
       }

      
       public WebElement getProductByName(String ProductName)
       {
    	   WebElement prod = getProductList().stream().filter(product->
   		 product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
	      return prod;
	   }
       
       
       public CartPage addProductTocart(String ProductName)
       {
    	   WebElement prod =getProductByName(ProductName);
    	   prod.findElement(addToCart).click();
    	   waitForElementToAppear(toastMessage);
    	   waitForElementToDisappear(spinner);
    	   CartPage cartPage=new CartPage(driver);
    	  return cartPage;
       }


}
