package page;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import entity.Categories;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {
	private static final Logger LOGGER = Logger.getLogger(PageObject.class.getPackage().getName());
	@FindBy(id = "tbodyid")
	private WebElement container;

	@FindBy(className = "list-group")
	private WebElement menu;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getContainer() {
		return container;
	}

	public void setContainer(WebElement container) {
		this.container = container;
	}

	public WebElement getElementfromContainer(String elementtxt) {

		WebElement webelement = null;

		try {
			webelement = getContainer().findElement(By.xpath("//a[contains(text(),'" + elementtxt + "')]"));

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
	public boolean isValidName(String name) {
		return EnumUtils.isValidEnum(Categories.class, name);
	}

}
