package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {"src/test/resources/features2"},
	    glue = "stepDefinitions",
	    plugin = {"pretty", "json:target/cucumber-reports.json"}  //Generates json report
	    //plugin = {"pretty", "html:target/cucumber-reports.html"} // Generates html report
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
