import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.Order;
import pages.WebOrderHomePage;
import pages.WebOrderLoginPage;
import utils.BrowserUtils;
import utils.Driver;

public class WebOrderTest extends Hooks {

	@Test
	void testElements() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickWebOrder();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToOrderPage();
		Order order = new Order();
		order.enterProduct("MyMoney", "10", "20");
		order.enterCustomerInformation("Inar Academy", "KingCross", "Atlantic", "NWY", "12234");
		BrowserUtils.scrollDown();
		Thread.sleep(1000);
		order.selectPaymentMethod("visa");
		order.enterCardNumber("4938281746192845");
		order.enterExpiryDate("12/28");
		order.clickProcessButton();
	}

}
