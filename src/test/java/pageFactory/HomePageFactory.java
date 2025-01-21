package pageFactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

	/**
	 * make driver private if it is not to be share
	 * scope of private is the class only   
	 */
	
	private WebDriver driver;
	
//	below both line is same dont put ; 
	
	@FindBy(id="shopping_cart_container")
	private WebElement checkhomeElement;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement LogoutBtn;
	
	
	
	public void clickOnMenu()
	{
		menuBtn.click();
		
	}
	
	public void clickOnLogout()
	{
		menuBtn.click();
		LogoutBtn.click();
		
	}

	public boolean checkCartButton() 
	{
		return checkhomeElement.isDisplayed();
	}

	public HomePageFactory(WebDriver driver)
	{
		this.driver=driver;
		
		
		PageFactory.initElements(driver, this);
	}
	
}
