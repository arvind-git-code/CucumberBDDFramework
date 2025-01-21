package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
		(
	
        features = "src/test/resources/features/", // Path to your feature files
        glue = {"stepDefinition","hooks"},					// Package containing your step definitions
        plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun=false,
        monochrome=false 	
		) 
public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

//pretty for console formating
// monochrome=true   for console indentation correct
// dryRun=true  for run to check which are missing in any scenario to implement
/*
// use-  mvn clean test -Dcucumber.filter.tags="@smoke" for run test in command line
 * 
//use-  mvn clean test to run without modifying any parameter
 * 			mvn: Invokes the Maven build system.
			clean: Removes any previously built artifacts.
			test: Executes the test phase of the Maven build lifecycle, which includes running your Cucumber tests.
 * 
 * mvn test -Dcucumber.options="--features src/test/resources/features/your_feature_file.feature"
 * 
 * mvn test -Dtestng.parallel=methods -DthreadPoolSize=2
 * 
 * mvn test -Dcucumber.options="--tags ~@ignore"
 * mvn test -Dcucumber.options="--name 'Scenario Name'"
 * mvn test -Dcucumber.filter.tags="@smoke" -Dtestng.parallel=methods -DthreadPoolSize=3    we can combine to command
 * 
 * 
 * 
 */

