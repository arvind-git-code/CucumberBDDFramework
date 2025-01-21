package pageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class LoginpageFactory {

	private WebDriver driver;
	// This line declares a reference variable driver of type WebDriver
	// To instantiate the WebDriver, you will need to create an instance of a
	// specific browser driver, such as ChromeDriver, FirefoxDriver, etc.

	// Initialize locators
	@FindBy(id = "user-name")
	private WebElement UserLocator;

	@FindBy(id = "password")
	private WebElement pswd;

	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	
	@FindBy(id="shopping_cart_container")
	private WebElement checkhomeElement;
	
	@FindBy(xpath="//h3[contains(text(),'user has been locked out')]")
	private WebElement error_msg;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement LogoutBtn;

	// creating step methods
	
	
	
	
	public void enterUserPassrord(String username,String password) {
//		System.out.println("steps"+username+" "+password);
		UserLocator.sendKeys(username);
		pswd.sendKeys(password);
	}

	

	public void ClickOnLogin() throws Exception{
		loginBtn.click();
	}
	
	public void clickOnLogout()
	{
		menuBtn.click();
		LogoutBtn.click();
		
	}
	
public boolean checkLoginStatus() {
	boolean flag=false;	
if (checkhomeElement.isDisplayed()) 
{
	flag=true;
	System.out.println("Login Sucessful");
	
}
else if(checkhomeElement.isDisplayed()){
	
	System.out.println("Login failed" +error_msg.getText() );
	flag=false;
	
	}

return flag;
		
	}




public boolean doLoginLogout(DataTable credentials)

{
	boolean flag=true;
	List<Map<String, String>> data = credentials.asMaps(String.class, String.class);
    for (Map<String, String> row : data) {
        String username = row.get("username");
        String password = row.get("password");
      enterUserPassrord(username, password);
        try {
      ClickOnLogin();
      clickOnLogout();
        }
        catch(Exception e)
        {	
        	flag=false;
        	System.out.println("The user is not allow to login with UserId "+username+ " and password "+password );
        	 e.getMessage();
        	driver.navigate().refresh();
        	continue;
        }
}
    return flag;
}







//	creating constructor for initializing PageFactory and WebDriver
	public LoginpageFactory(WebDriver driver) {
		this.driver = driver;
		// to maintain the driver session

//		initialize page factory class
		PageFactory.initElements(driver, this);

//		optionally you can write the class name also i.e. PageFactory.initElements(driver, LoginpageFactory.java);
	}

}
