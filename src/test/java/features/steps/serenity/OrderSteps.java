package features.steps.serenity;




import page.OrderPage;


public class OrderSteps {
	OrderPage Orderpage;

	public void fulfillform(String data) {
		Orderpage.Fulfillform(data);

	}

	public Integer getamountvaluedisplayed() {
		return Orderpage.gettotalamount();
	}

	public void clickonPurchase() {
		Orderpage.clickonPurshase();

	}

	public Integer getamountvaluedisplayedonsuccessalerte() {
		Object value = Orderpage.getElementfromPurshasesuccessText("Amount");
		return Integer.valueOf((String) value);
	}
}
