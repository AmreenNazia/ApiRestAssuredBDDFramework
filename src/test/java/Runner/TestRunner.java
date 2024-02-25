package Runner;

 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( 
		         features = "src/test/resources/Features", 
                 glue = {"StepDefinitions"}, 
                 monochrome = true,
                 plugin = {"html:target/htmlreport.html"}
                  
              )
public class TestRunner extends AbstractTestNGCucumberTests {
	
	   
	 
 

}