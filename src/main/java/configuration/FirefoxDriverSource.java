package configuration;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;

public class FirefoxDriverSource implements DriverSource {
WebDriver driver;
public WebDriver newDriver() {
	 WebDriverManager.firefoxdriver().setup();
	driver= new FirefoxDriver();
	return driver;
}

public boolean takesScreenshots() {
	return true;
}

protected FirefoxBinary getBinary() {
	FirefoxBinary binary = new FirefoxBinary(new File(System.getProperty("user.home")  +"\\AppData\\Local\\Mozilla Firefox\\firefox.exe"));
	return binary;
}

protected FirefoxProfile getProfile() {
	FirefoxProfile profile = new FirefoxProfile();
	return profile;
}

protected void configureDriver(WebDriver driver){
	driver.manage().window().maximize();
}

}