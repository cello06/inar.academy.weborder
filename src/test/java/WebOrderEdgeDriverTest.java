import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebOrderEdgeDriverTest {

	WebDriver driver;
	static int testNumber = 1;

	@BeforeEach
	void setUp() throws InterruptedException {
		System.out.println("--------------TC_" + testNumber + " : is started! -------------");
		driver = new EdgeDriver();
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		driver.manage().window().maximize();
	}

	@Test
	void testSeleniumWebDriver() {

		String expected = "https://InarAcademy:Fk160621.@test.inar-academy.com/";
		String actual = driver.getCurrentUrl();
		System.out.println("Expected URL : " + expected + "\nActual URL : " + actual);
		assertEquals(expected, actual,
				"The URL is not the same : \n" + "Expected URL : " + expected + "\nActual URL : " + actual);

	}

	@Test
	void testTitle() {
		String expectedTitle = "Inar Academy";
		String actualTitle = driver.getTitle();
		System.out.println("Expected Title : " + expectedTitle + "\nActual Title : " + actualTitle);
		assertEquals(expectedTitle, actualTitle, "title is wrong!");
	}

	@Test
	void testElements() throws InterruptedException {

		WebElement webOrderElement = driver.findElement(By.xpath("//*[@id='navbar']/div/a[1]"));

		webOrderElement.click();
		WebElement userNameTextBox = driver.findElement(By.id("login-username-input"));
		userNameTextBox.sendKeys("Inar");

		WebElement passwordTextBox = driver.findElement(By.id("login-password-input"));
		passwordTextBox.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		loginButton.click();

		String expectedURl = "https://InarAcademy:Fk160621.@test.inar-academy.com/weborder";
		String actualURL = driver.getCurrentUrl();
		System.out.println("After Log-in page we check the URL in web order page : \n" + "Expected URL : " + expectedURl
				+ "\nActual URL : " + actualURL);

		Thread.sleep(4000);
		assertEquals(expectedURl, actualURL, "There is a problem in current url we are in the wrong page!");
	}

	@AfterEach
	void tearDown() {
		driver.quit();
		System.out.println("--------------TC_" + testNumber + " : is finished! -------------");
		System.out.println("###########################################");
		testNumber++;

	}

}
