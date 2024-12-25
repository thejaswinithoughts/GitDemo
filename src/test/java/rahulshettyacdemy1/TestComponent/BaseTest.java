package rahulshettyacdemy1.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacdemy1.PageObject.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException
	{
		
		//properties class read the global properties.- decide on which browser program wants to execute
		
		Properties prop = new Properties();
		//C:\\Users\\HP\\eclipse-workspace\\Seleniumframework1\\src \\main\\java\\rahulshettyacademy1\\resources\\GlobalData.properties = global data path
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//main//java//rahulshettyacademy1//resources//GlobalData.properties");
		//C:\Users\HP\eclipse-workspace\Seleniumframework1\src\main\java\rahulshettyacademy1\resources\GlobalData.properties
		
		FileInputStream fis = new FileInputStream("C://Users//HP//eclipse-workspace//Seleniumframework1//src//main//java//rahulshettyacademy1/resources//GlobalData.properties");
		prop.load(fis);//expecting input stream
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C://Users//HP//Downloads//chromedriver-win32//chromedriver-win32");
		//WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//WebDriver driver = new edgeDriver();
			//firefox
		}
		

		else if(browserName.equalsIgnoreCase("ege"))
		{
			//WebDriver driver = new edgeDriver();
			//edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		}
	//json 
	public List<HashMap<String, String>> getJsonDataToMap(String FilePath) throws IOException
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(FilePath),StandardCharsets.UTF_8);
		
		//string to hashmap jackon databind(dependency that convert string content to hashmap)
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>()  {
      });
	     return data;
	}
	
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage lanchApplication() throws IOException
	{
		driver=initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	}


