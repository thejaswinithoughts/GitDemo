package Selenium.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
        driver.manage().window().maximize();
        
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        Files.copy(f,new File("C:\\Users\\HP\\Desktop\\Screenshot.jpg"));
        
        driver.close();
	}
}
