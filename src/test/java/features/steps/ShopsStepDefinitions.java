package features.steps;

import net.thucydides.core.annotations.Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;

import features.steps.serenity.CartsSteps;
import features.steps.serenity.HomeSteps;
import features.steps.serenity.OrderSteps;
import features.steps.serenity.ProductSteps;
import helper.Commun;

public class ShopsStepDefinitions {
	@Steps
	HomeSteps homeSteps;
	@Steps
	CartsSteps cartSteps;
	@Steps
	ProductSteps productSteps;
	@Steps
	OrderSteps orderSteps;

	String productstilloncart = "";
	List<String> productaddedlist = new ArrayList<String>();
	String productadded;
	Integer expectedamount;

	@Given("User Go to HomePage")
	public void User_Go_to_HomePage() {
		homeSteps.open();
	}

	@Given("User Navigate through Product categories {string}")
	public void user_Navigate_through_Product_categories(String categories) {

		boolean isMenuListExist = homeSteps.checkListMenuElements(categories);

		Assert.assertTrue(isMenuListExist);
	}

	@Given("User Navigate through Product category {string}")
	public void User_Navigate_through_Product_category(String category) {
		homeSteps.getMenuElement(category).click();
	}

	@Given("User Navigate to Product category {string} {string}")
	public void User_Navigate_to_Product_category(String items, String product) {
		this.productadded = product;
		homeSteps.getMenuElement(items).click();
		homeSteps.getProductElement(product).click();

	}

	@Given("User Click on {string}")
	public void User_Click_on(String label) {
		productaddedlist.add(productadded);

		productSteps.addtocart(label);
	}

	@Given("User Accept Popup confirmation")
	public void user_accept_popup_confirmation() {
		productSteps.acceptPopup();
	}

	@Given("User Click on {string} menu")
	public void user_click_on_menu(String menu) {
		productSteps.gotomenu(menu);
	}

	@Given("User Delete {string} from Cart")
	public void user_delete_from_cart(String productname) {
		cartSteps.delete(productname);

		String[] MapProductname = Commun.getArrayFromString(productaddedlist.toString(), ",");
		MapProductname[0] = MapProductname[0].replace("[", "");
		MapProductname[MapProductname.length - 1] = MapProductname[MapProductname.length - 1].replace("]", "");

		for (String productnamefromlist : MapProductname) {

			if (productnamefromlist.contains(productname) != true) {
				productstilloncart = productstilloncart.concat(productnamefromlist);
			}
		}

		Assert.assertEquals(false, (cartSteps.iselementpresent(productname)));
	}

	@When("User Click on Place order")
	public void user_click_on_Place_order() {

		expectedamount = cartSteps.getpurchaseamount(productstilloncart.toString());
		cartSteps.placeorder();
	}

	@When("User FulfillForm with {string}")
	public void user_fulfillForm_with(String data) {
		orderSteps.fulfillform(data);
	}

	@When("Amount displayed on Form is Correct")
	public void amount_displayed_on_form_is_correct() {

		Assert.assertEquals(this.expectedamount, orderSteps.getamountvaluedisplayed());
	}

	@When("User Click on Purchase")
	public void user_click_On_purchase() {
		orderSteps.clickonPurchase();
	}

	@Then("Amount is equal to expected")
	public void amount_Is_Equal_To_Expected() {
		Assert.assertEquals(this.expectedamount, orderSteps.getamountvaluedisplayedonsuccessalerte());
	}
}
