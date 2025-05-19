package Selenium.Test;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class WebTable {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click a column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all webelements into list
		List<WebElement> ElementList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture all the webelements into new(original)list
		List<String> OriginalList = ElementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on original list 
		List<String> Sortedlist = OriginalList.stream().sorted().collect(Collectors.toList());
		
		//compare original list vs sorted list
		Assert.assertTrue(OriginalList.equals(Sortedlist));
		
		
		//scan the name column with gettext ->Bean->price of the Beans
		
		//List<String> price = ElementList.stream().filter(s->s.getText().contains("Beans")).map(s->getpriceveggie(s)).collect(Collectors.toList());
	//price.forEach(a->System.out.println(a));
	
	
	//Pagination- search for rice price
	List<String> price;
	do
	{
	List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
	price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getpriceveggie(s)).collect(Collectors.toList());
	price.forEach(a->System.out.println(a));
	
	if(price.size()<1)
	{
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
	}
	
	
	}while(price.size()<1);

	}
	private static String getpriceveggie(WebElement s) {
		String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}}