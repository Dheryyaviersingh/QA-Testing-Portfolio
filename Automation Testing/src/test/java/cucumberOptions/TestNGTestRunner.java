package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinitions", monochrome=true, plugin= {"pretty", "json:target/cucumber-reports/cucumber.json","html:target/cucumber-reports/html-report.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	

}
