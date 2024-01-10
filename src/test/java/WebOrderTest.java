import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class WebOrderTest extends Hooks {
	/**
	 * 1.Open browser navigate to HomePage
	 * 2.Click 'Weborder' button navigate to login page
	 * 3.Login with valid username and password
	 * 4.Navigate to order page
	 * 5.Enter 'MyMoney' as product name
	 * 6.Enter '10' as quantity
	 * 7.Enter '20' as discount
	 * 8.Enter 'Inar Academy' as name
	 * 9.Enter 'KingCross' as street
	 * 10.Enter 'Atlantic' as city
	 * 11.Enter 'NWY' as state
	 * 12.Enter '12234' as zipcode
	 * 13.Choose 'visa' as payment method
	 * 14.Enter '4938281746192845' as card number
	 * 15.Enter '12/28' as expiry date
	 * 16.Click process button
	 * 17.Verify that 'New order has been successfully added.' message displayed*/

	@Test
	void testElements() throws InterruptedException {
		//1.Open browser navigate to HomePage
		//2.Click 'Weborder' button navigate to login page
		pagesInstances.getHomePage().clickWebOrder();

		//3.Login with valid username and password
		pagesInstances.getWebOrderLoginPage().login("Inar","Academy");

		//4.Navigate to order page
		pagesInstances.getWebOrderHomePage().navigateToOrderPage();

		//5.Enter 'MyMoney' as product name
		//6.Enter '10' as quantity
		//7.Enter '20' as discount
		pagesInstances.getOrderPage().enterProduct("MyMoney", "10", "20");

		//8.Enter 'Inar Academy' as name
		//9.Enter 'KingCross' as street
		//10.Enter 'Atlantic' as city
		//11.Enter 'NWY' as state
		//12.Enter '12234' as zipcode
		pagesInstances.getOrderPage().enterCustomerInformation("Inar Academy", "KingCross", "Atlantic", "NWY", "12234");
		BrowserUtils.scrollDown();
		Thread.sleep(1000);

		//13.Choose 'visa' as payment method
		pagesInstances.getOrderPage().selectPaymentMethod("visa");

		//14.Enter '4938281746192845' as card number
		pagesInstances.getOrderPage().enterCardNumber("4938281746192845");

		//15.Enter '12/28' as expiry date
		pagesInstances.getOrderPage().enterExpiryDate("12/28");

		//16.Click process button
		pagesInstances.getOrderPage().clickProcessButton();

		//17.Verify that 'New order has been successfully added.' message displayed
		String expectedText = "New order has been successfully added.";
		String actualText = pagesInstances.getOrderPage().getProcessSuccessMessage();
		Thread.sleep(3000);
		System.out.println(actualText);
		Assert.assertEquals(actualText,expectedText);
	}


}
