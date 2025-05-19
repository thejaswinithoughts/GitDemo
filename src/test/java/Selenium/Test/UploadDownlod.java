package Selenium.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class UploadDownlod {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		
		//download
		driver.findElement(By.id("downloadButton")).click();
		
		//upload
		WebElement upload=driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys("C:/Users/HP/Downloads/download.xlsx");
		
		//wait for success message to show up and wait for disappear
		By TostLocator=By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(TostLocator));
		String ToastText=driver.findElement(TostLocator).getText();
		System.out.println(ToastText);
		Assert.assertEquals(ToastText, "Updated Excel Data Successfully.");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(TostLocator));
		
		//verify updated excel data showing in the table
		String actualPrice = driver.findElement(By.xpath("//div[text()='Apple']/parent::div/parent::div/div[@id='cell-4-undefined']")).getText();

	}

}
