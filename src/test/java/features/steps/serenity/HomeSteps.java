package features.steps.serenity;




import org.openqa.selenium.WebElement;


import helper.Commun;
import net.thucydides.core.annotations.Step;
import page.HomePage;
import page.ProductPage;

public class HomeSteps {

	HomePage homePage;
	WebElement MenuElement ;
  
	public WebElement getMenuElement() {
		return MenuElement;
	}
	public void setMenuElement(WebElement menuElement) {
		MenuElement = menuElement;
	}
	@Step
    public void open() {
     homePage.open();
  
       
    }
    @Step 
    public  WebElement getMenuElement(String elementname)
    {
    	return homePage.getElementfromContainer(elementname);
    }
    @Step 
	public boolean checkMenuElement(String string) {
		
		
		return homePage.isValidName(string);
	}
    @Step 
	public boolean checkListMenuElements(String categories) {
		String[] listcategorie = Commun.getArrayFromString(categories,",");
		Boolean isequal=true;
		for (String string : listcategorie) {
			isequal = isequal && checkMenuElement(string);
			
		}
		return isequal;
		
	}
    @Step
	public WebElement getProductElement(String product) {
		return homePage.getElementfromContainer(product);
		
	}
  


}
