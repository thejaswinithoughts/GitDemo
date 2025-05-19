package Selenium.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calender {

	public static void main(String[] args) {

		// Set up WebDriver (Make sure to set the correct path to chromedriver)
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Open the target webpage
		driver.get("https://www.example.com"); // Replace with actual URL

		// Maximize window and set timeout
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Click on the calendar input field to open the date picker
		driver.findElement(By.id("calendarField")).click(); // Replace with actual ID

		// Select the desired month and year
		while (true) {
			WebElement monthYear = driver.findElement(By.className("calendar-header")); // Update as per your calendar structure
			String displayedMonthYear = monthYear.getText();

			if (displayedMonthYear.contains("March 2025")) { // Change to desired month & year
				break;
			}

			// Click next button if month/year doesn't match
			driver.findElement(By.xpath("//button[contains(@class, 'next')]")).click();
		}

		// Select the date from the calendar
		List<WebElement> dates = driver.findElements(By.xpath("//td[@class='day']")); // Update as per your calendar structure
		for (WebElement date : dates) {
			if (date.getText().equals("15")) { // Change to desired date
				date.click();
				break;
			}
		}

		// Close the browser
		driver.quit();
	}
}




