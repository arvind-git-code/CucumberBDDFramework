package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	/**
	 * This matter you too initialize thread driver as per given browser 
	 * @param browser
	 * @return
	 */
//	we are using thread local so that parallel execution happen properly 
	
	
	public WebDriver init_driver(String browser)
	{
		System.out.println("browser is "+browser);
		
		if(browser.equals("chrome")) {
			tlDriver.set(new ChromeDriver()); 
		}
		
		else if(browser.equals("firefox")) {
			tlDriver.set (new FirefoxDriver());
		}
			else
			{
				System.out.println("please pass the correct driver");
			}
		
//		here getDriver method used to delete cookies and maximize windows
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		
//		here we return driver to use make session same when this method called
		
		return getDriver();
		
	}
	
	
	
/**
 * Preventing Race Conditions: When multiple threads access shared resources (like variables or objects), there's a risk of race conditions where the outcome depends on the sequence and timing of thread execution. 
 * synchronized helps prevent this by allowing only one thread to execute the synchronized block or method at a time.
 * @return
 */
	
//	method to get driver 
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	

	
	
	
}
