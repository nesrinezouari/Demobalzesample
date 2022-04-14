package page;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import helper.Commun;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class OrderPage extends PageObject {
	private static final Logger LOGGER = Logger.getLogger(PageObject.class.getPackage().getName());

	@FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[2]/form")
	WebElement orderform;
	@FindBy(id = "totalm")
	WebElement totalAmountfield;
	@FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
	WebElement Purchasebtnfield;

	@FindBy(xpath = "//div[10]/p")
	WebElement MsgSuccesspurchasefield;

	public OrderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * fulfill order form
	 * 
	 * @param data
	 */
	public void Fulfillform(String data) {
		Map<String, String> maps = Commun.getMapFromString(data, ",", "=");
		Iterator it = maps.entrySet().iterator();

		while (it.hasNext()) {

			Map.Entry<String, String> entry = (Map.Entry) it.next();

			System.out.println(entry.getKey() + " = " + entry.getValue());
			Fullfilelement(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	private void Fullfilelement(String key, String value) {
		WebElement inputelement = orderform.findElement(By.id(key));
		inputelement.sendKeys(value);
	}

	public Integer gettotalamount() {
		String totalamountfieldvalue = totalAmountfield.getText();
		String[] totalArrayString = Commun.getArrayFromString(totalamountfieldvalue, ":");
		Integer value = Integer.valueOf(totalArrayString[1].toString().trim());
		return value;

	}

	public void clickonPurshase() {
		Purchasebtnfield.click();

	}

	public Object getElementfromPurshasesuccessText(String key) {
		String Messagesuccess = MsgSuccesspurchasefield.getText();
		String[] textelements = Commun.getArrayFromString(Messagesuccess, "\n");
		String Amounttextvalue = "";
		LOGGER.log(Level.INFO, Messagesuccess);
		for (String string : textelements) {
			if (string.contains(key)) {
				Amounttextvalue = Amounttextvalue.concat(string);
				break;
			}
		}

		// Amounttextvalue.replaceFirst("\"\"", "");
		String[] Amount = Commun.getArrayFromString(Amounttextvalue, ":");
		String str = "USD";
		Amount[1] = Amount[1].replaceAll(str, "");

		return Amount[1].trim();
	}

}
