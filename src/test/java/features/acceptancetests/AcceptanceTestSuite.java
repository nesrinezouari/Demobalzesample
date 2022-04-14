package features.acceptancetests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(CucumberWithSerenity.class)

@CucumberOptions(glue = "features.steps", features = "src/test/resources/features/")
public class AcceptanceTestSuite {
//Manage driver
	
	 @Managed
	static                                                            
	    WebDriver driver;
	
	
	

	


}
