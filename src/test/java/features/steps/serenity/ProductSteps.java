package features.steps.serenity;





import net.thucydides.core.annotations.Step;

import page.ProductPage;

public class ProductSteps {
	ProductPage productPage;
	
	
	  @Step
		public void addtocart(String label) {
		productPage.addtocart(label);
			
		}
	    @Step
		public void acceptPopup() {
	    	productPage.acceptPopup();
			
		}
	    @Step
		public void gotomenu(String menu) {
			productPage.gotomenu(menu);
			
		}
   

}
