package configuration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteChromeDriverSource extends ChromeDriverSource {

	private static final String REMOTE_SELENIUM_SERVER_URL = "http://localhost:4445/wd/hub";

	@Override
	public WebDriver newDriver() {

		try {
			return new RemoteWebDriver(new URL(REMOTE_SELENIUM_SERVER_URL), getChromeCapabilities());
		} catch (MalformedURLException e) {
			return null;
		}
	}

}