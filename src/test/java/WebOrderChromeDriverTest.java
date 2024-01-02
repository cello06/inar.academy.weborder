import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.Order;
import pages.WebOrderHomePage;
import pages.WebOrderLoginPage;
import java.time.Duration;


public class WebOrderChromeDriverTest {

	WebDriver driver;
	static int testNumber = 1;

	@BeforeEach
	void setUp() {
		System.out.println("--------------TC_" + testNumber + " : is started! -------------");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		driver.manage().window().maximize();
	}


	@Test
	void testElements() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		WebOrderLoginPage webOrderLoginPage = homePage.clickWebOrder();
		WebOrderHomePage webOrderHomePage = webOrderLoginPage.login("Inar","Academy");
		Order order = webOrderHomePage.navigateToOrderPage();
		order.enterProduct("MyMoney","10","20");
		order.enterCustomerInformation("Inar Academy","King Cross","Atlantic","NWY","12234");
		order.selectPaymentMethod("visa");
		order.enterCardNumber("4938281746192845");
		order.enterExpiryDate("11/28" );
		order.clickProcessButton();

		Thread.sleep(5000);


	}

	@AfterEach
	void tearDown() {
		driver.quit();
		System.out.println("--------------TC_" + testNumber + " : is finished! -------------");
		System.out.println("###########################################");
		testNumber++;

	}

}
