package configuration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;

public class ChromeDriverSource implements DriverSource {
	WebDriver driver;
	public WebDriver newDriver() {
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		return driver;
	}

	public boolean takesScreenshots() {
		return true;
	}

	
	protected DesiredCapabilities getChromeCapabilities() {
		return null;
	
	}

	protected ChromeOptions getChromeOptions() {
		return null;
		
	}

}