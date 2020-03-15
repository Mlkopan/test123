package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/",
glue = {"com.stepdefinition"},
tags= {"@test1"}
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
