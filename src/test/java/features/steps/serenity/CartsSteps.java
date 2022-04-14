package features.steps.serenity;




import org.openqa.selenium.WebElement;


import helper.Commun;
import net.thucydides.core.annotations.Step;
import page.CartPage;
import page.HomePage;
import page.ProductPage;

public class CartsSteps {
	CartPage cartPage;
	Integer amount=0;

	public void delete(String product) {
		cartPage.delete(product,"Delete");
		
	}
	public boolean iselementpresent(String productname)
	{
		return cartPage.iselementpresent(productname);
	}
	public void placeorder() {
		cartPage.placeorder();
		
	}
	public Integer getpurchaseamount(String productname) {
	String[] productnameoncart =Commun.getArrayFromString(productname,",");
	for (String string : productnameoncart) {

		amount =amount + cartPage.getpurchaseamount(string);
		
	}
		
		return amount;
	}
   

}
