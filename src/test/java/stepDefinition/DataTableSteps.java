package stepDefinition;

import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePageFactory;
import pageFactory.LoginpageFactory;

public class DataTableSteps {

    HomePageFactory home;

    private LoginpageFactory login = new LoginpageFactory(DriverFactory.getDriver());
    
//    @Given("the user is on home page")
//    public void the_user_is_on_home_page() {
//        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        DriverFactory.getDriver().get("https://www.saucedemo.com/");
//    }

    @When("user enter following credentials and try to login")
    public void user_enter_following_credentials_and_try_to_login(DataTable credentials) {
    	home=new HomePageFactory(DriverFactory.getDriver());
    	
       boolean loginLogoutFlag= login.doLoginLogout(credentials);
         Assert.assertTrue(loginLogoutFlag);
        }

    
    
    @Then("user is able to login")
    public void user_is_able_to_login() {
       
    }
    
    
}
