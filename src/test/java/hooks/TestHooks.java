package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;


public class TestHooks
{		
//	creating object reference of DriverFactory class
		private DriverFactory driverFactory;
		private WebDriver driver;
		private ConfigReader configReader;
		
		Properties prop;
		
		
		
	@Before	(order =0)					// make sure import all annotation  and hooks from cucumber not from testng
	public void getProperty()
	{

		
		configReader=new ConfigReader();
		prop=configReader.init_prop();
		
	}
	
	@Before(order=1)
	public void launchBrowser()
	{
		
		String browserName =prop.getProperty("browser");
		driverFactory=new DriverFactory();
		
//		get driver form driver factory and initialize to current driver otherwise other method will get driver=null
		driver=driverFactory.init_driver(browserName);
		
	}
	
	
	@After(order=0)
	public  void quitBrowser()
	{
		
		if(driver !=null)
		{
			
		driver.quit();
		}
		System.out.println("Browser is closed");
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed()) {
//			take screenshot
			
			String scenarioName=scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", scenarioName);
		}
	}

	
}
