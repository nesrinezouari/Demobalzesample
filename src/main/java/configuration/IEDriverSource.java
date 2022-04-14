package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;

public class IEDriverSource implements DriverSource {
WebDriver driver;
	public WebDriver newDriver() {
		  WebDriverManager.iedriver().setup();
		  driver = new InternetExplorerDriver();
    
	
		return driver;
	}
	public boolean takesScreenshots() {
		return true;
	}



	protected DesiredCapabilities getIECapabilities() {
		return null;
	
	}

	protected void configureDriver(WebDriver driver){
		driver.manage().window().maximize();
	}
}