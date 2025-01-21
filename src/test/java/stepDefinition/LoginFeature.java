package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePageFactory;
import pageFactory.LoginpageFactory;



public class LoginFeature{
	
	private WebDriver driver;
	HomePageFactory home;
	
	private LoginpageFactory login =new LoginpageFactory(DriverFactory.getDriver());
	
	
	@Given("the user is on home page")
	public void the_user_is_on_home_page() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver=DriverFactory.getDriver();
		driver.get("https://www.saucedemo.com/");
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Swag Labs");
		
//		DriverFactory.getDriver().get("https://practicetestautomation.com/practice-test-login/");			
		
	    
	    
	}
//make sure write string in small letter not String
	@When("user enter username {string} and password {string}")
	public void user_enter_username_and_password(String username,String password) {
//System.out.println("stepdefinition"+username+" "+password);
		login.enterUserPassrord(username,password);
		
	    
	}

	@And("click on submit button")
	public void click_on_submit_button() throws Exception {
		login.ClickOnLogin();
	    
	}
	
	@Then("user is able login")
	public void user_is_able_login()
	{
		home=new HomePageFactory(DriverFactory.getDriver());
		boolean cart=home.checkCartButton();
		Assert.assertTrue(cart);
	}

	@Then("user is able to navigate home page")
	public void user_is_able_to_navigate_home_page() {
		login.checkLoginStatus();   
		Assert.assertEquals(login.checkLoginStatus(), true);

	}
	
	
	

}
