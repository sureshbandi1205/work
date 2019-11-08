package run;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "html:target/cucumber-html-report",
	            "json:target/testresult/cucumber.json", "pretty:target/cucumber-pretty.txt",
	             "junit:target/cucumber-results.xml" },
		format= {"pretty","html:target/html/"},
		features= "src/test/java/features",
	    glue = "step",
	    tags= {"@Test4"}
	   ) 
public class runner {

}
