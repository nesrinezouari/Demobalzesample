package page;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import entity.Categories;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class ProductPage extends PageObject {
	private static final Logger LOGGER = Logger.getLogger(PageObject.class.getPackage().getName());

	private WebElement container;
	@FindBy(id = "navbarExample")
	private WebElement navbar;

	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getNavbar() {
		return navbar;
	}

	public void setNavbar(WebElement navbar) {
		this.navbar = navbar;
	}

	@FindBy(className = "list-group")
	private WebElement menu;

	public WebElement getContainer() {
		return container;
	}

	public void setContainer(WebElement container) {
		this.container = container;
	}

	public WebElement getElementfromContainer(String elementtxt) {
		setContainer(this.element(By.id("tbodyid")));
		WebElement webelement = null;
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 5);

		try {
			webelement = getContainer().findElement(By.xpath("//a[contains(text(),'" + elementtxt + "')]"));

			wait.until(ExpectedConditions.visibilityOf(webelement));
		} catch (NoSuchElementException e) {
			LOGGER.log(Level.INFO, e.getMessage());
		}
		return webelement;
	}

	/***
	 * check if provided name is an existing category
	 * 
	 * @param name
	 * @return
	 */

	public void acceptPopup() {

		String MainWindow = this.getDriver().getWindowHandle();
		Set<String> windows = this.getDriver().getWindowHandles();
		if (windows.size() > 1) {

			for (String string : windows) {
				Alert driver = this.getDriver().switchTo().alert();
				driver.accept();
				this.getDriver().switchTo().window(MainWindow);
			}
		}

	}

	public void gotomenu(String menu2) {
		WebElement webelement = getMenuElement(menu2);
		webelement.click();
	}

	private WebElement getMenuElement(String menu2) {
		getNavbar();
		WebElement webelement = null;
		WebDriverWait wait = new WebDriverWait(this.getDriver(), 3);

		try {
			webelement = getContainer().findElement(By.xpath("//ul/li/a[contains(text(),'" + menu2 + "')]"));

			wait.until(ExpectedConditions.visibilityOf(webelement));
		} catch (NoSuchElementException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return webelement;

	}

	public void addtocart(String label) {
		WebElement webelement = null;

		webelement = getElementfromContainer(label);

		webelement.click();

	}

}
