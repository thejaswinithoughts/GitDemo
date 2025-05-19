package Selenium.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");

		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " +Links.size());

		List<String> urlList = new ArrayList<String>();

		for(WebElement e:Links)
		{
			String url=e.getAttribute("href");
			//urlList.add(url);
			checkBrokenLink(url);
		}
		driver.quit();
	}
	public static void checkBrokenLink(String linkUrl)
	{

		try {
			URL url = new URL(linkUrl);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(5000);
			connection.connect();

			if (connection.getResponseCode() >= 400) 
			{
				System.out.println(linkUrl +"------>" +connection.getResponseMessage()+ " is broken link");
			} 
			else
			{
				System.out.println(linkUrl +"------>" +connection.getResponseMessage());
			}

		} catch (Exception e) {

		}
	}
}
