package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "./Features/Update_Test_case.feature",   
	    glue = {"stepDefinitions"},                 
	    plugin = {"pretty","html:target/cucumber-reports/CucumberReport.html"},
	    tags = "@Profile"
	)

public class Testng extends AbstractTestNGCucumberTests{

}
