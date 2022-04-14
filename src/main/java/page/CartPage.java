package page;


import java.util.List;

import java.util.logging.Logger;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;



public class CartPage extends PageObject {
	   private static final Logger LOGGER = Logger.getLogger( PageObject.class.getPackage().getName() );
      private static final String urlendpoint="cart.html";
      @FindBy(id ="tbodyid")
	  private WebElement container;
      @FindBy(xpath="//*[@id=\"page-wrapper\"]/div/div[2]/button")
      private WebElement placeorderbtn;
      public CartPage(WebDriver driver) {
  	    super(driver);
  	    PageFactory.initElements(driver, this);
  	    
  	}
      public WebElement getPlaceorderbtn() {
		return placeorderbtn;
	}

	public void setPlaceorderbtn(WebElement placeorderbtn) {
		this.placeorderbtn = placeorderbtn;
	}

	
      
	public WebElement getContainer() {
		return container;
	}


	public void setContainer(WebElement container) {
		this.container = container;
	}
	private WebElement getProductElement(String menu2) {
		
	
		WebDriverWait wait = new WebDriverWait(this.getDriver(),3);
		
		WebElement webelement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr/td[contains(text(),'" + menu2+ "')]")));
			
			
		
		return webelement;
		
	}



public WebElement getelementinformationfromtext(String product,String label)

{

	WebElement Tdproductinformation = container.findElement(By.xpath("//tr/td[contains(text(),'" + product+ "')]/../td/a[contains(text(),'" + label+ "')]"));
				
	return Tdproductinformation;
}

public WebElement getelementinformationfromindex(String product,int index)

{
	
String hhhht = "//tr/td[contains(text(),'" + product+ "')]/../td['"+index +"']";

WebElement Tdproductinformation = container.findElement(By.xpath("//tr/td[contains(text(),'" + product+ "')]/.."));
WebElement cdsf = Tdproductinformation.findElement(By.xpath("td["+index +"]"));
				
	return cdsf;
}
	public void delete(String product, String  label) {
		
		WebElement deletelinkelement= getelementinformationfromtext(product, label);
		deletelinkelement.click();
	
			}


	public boolean iselementpresent(String productname) {
		
		
		 List<WebElement> productsselement = container.findElements(By.xpath("//tr/td[contains(text(),'" + productname+ "')]" ));
		
		 if(productsselement.size() > 1){
			
			 System.out.println("Element present");
			 return true;
			}
			else{
			 
			 System.out.println("Element not present");
			 return false;
			}
	
	}

	public void placeorder() {
		
		getPlaceorderbtn().click();
	}

	public Integer getpurchaseamount(String product) {
		WebElement amountele = getelementinformationfromindex(product,3)	;
		String amount =amountele.getAttribute("innerHTML");
				
		return Integer.valueOf(amount);
		
	}
}
