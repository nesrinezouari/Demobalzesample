package configuration;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteIEDriverSource extends IEDriverSource {

	private static final String REMOTE_SELENIUM_SERVER_URL = "http://vddevinter02.lamondiale.com:4444/wd/hub";

	@Override
	public WebDriver newDriver() {

		try {
			WebDriver driver = new RemoteWebDriver(new URL(REMOTE_SELENIUM_SERVER_URL), getIECapabilities());

			configureDriver(driver);

			return driver;
		} catch (MalformedURLException e) {
			return null;
		}
	}

}