import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebOrderMultiDriverTest {

	static int testNumber = 1;

	WebDriver driver;

	@BeforeEach
	void setUp() {
		System.out.println("-----------TEST_" + testNumber + ": is started--------");
	}

	static List<WebDriver> getDriver() {
		return Arrays.asList(new ChromeDriver(), new EdgeDriver());
	}

	@ParameterizedTest
	@MethodSource("getDriver")
	void testWebOrderWithMultiDrivers(WebDriver webDriver) throws InterruptedException {
		driver = webDriver;

		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com/");
		driver.manage().window().maximize();
		WebElement webOrderButton = driver.findElement(By.xpath("//*[@id='navbar']/div/a[1]"));
		webOrderButton.click();
		WebElement userNameTextBox = driver.findElement(By.id("login-username-input"));
		userNameTextBox.sendKeys("Inar");
		WebElement passwordTextBox = driver.findElement(By.id("login-password-input"));
		passwordTextBox.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		Thread.sleep(4000);
		String expectedURL = "https://InarAcademy:Fk160621.@test.inar-academy.com/weborder";
		String actualURL = driver.getCurrentUrl();

		System.out.println("We are testing URL in web order page : \n" + "Expected URL : " + expectedURL + "\n"
				+ "Actual URL : " + actualURL);
		assertEquals(expectedURL, actualURL, "Expected URL and Actual URL are different in web order page!"
				+ "\n Web Driver : " + driver.toString());
	}

	@AfterEach
	void tearDown() {
		driver.quit();
		System.out.println("-----------TEST_" + testNumber + ": is finished--------");
		System.out.println("#################################################");
		testNumber++;
	}

}
