package testRunners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
		(
		tags="",
        features = "src/test/resources/features/", // Path to your feature files
        glue = {"stepDefinition","hooks"},					// Package containing your step definitions
        plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun=false,
        monochrome=false 	
		)  
public class TestRunner2 extends AbstractTestNGCucumberTests{

	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return new Object[][] {
	                {"chrome"}, // Run tests on Chrome
	                {"firefox"} // Run tests on Firefox
	        };
	 }
	        
	        @Test(dataProvider = "scenarios") // Use the data provider to run tests
	        public void runScenario(String browser) {
	            // No implementation needed here. The test execution happens through Cucumber hooks.
	        }
	    
	    
	 }


//pretty for console formating
// monochrome=true   for console indentation correct
// dryRun=true  for run to check which are missing in any scenario to implement
