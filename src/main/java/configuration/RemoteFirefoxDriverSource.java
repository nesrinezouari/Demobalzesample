package  configuration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteFirefoxDriverSource extends FirefoxDriverSource {

	private static final String REMOTE_SELENIUM_SERVER_URL = "http://localhost:4445/wd/hub";

	@Override
	public WebDriver newDriver() {

		try {
			WebDriver driver = new RemoteWebDriver(new URL(REMOTE_SELENIUM_SERVER_URL), getFirefoxCapabilities());

			configureDriver(driver);

			return driver;
		} catch (MalformedURLException e) {
			return null;
		}
	}

	protected DesiredCapabilities getFirefoxCapabilities() {
		return null;
	

		
	}

	@Override
	protected FirefoxProfile getProfile() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
		return profile;
	}

}