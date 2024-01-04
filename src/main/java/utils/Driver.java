package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;

public class Driver {

	private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

	private Driver() {
		throw new UnsupportedOperationException("Can not instantiate utility class");
	}

	public synchronized static WebDriver getDriver() {
		if (DRIVER_THREAD_LOCAL.get() == null) {
			WebDriver driver;
			String browserType = System.getProperty("browser", "chrome");
			driver = switch (browserType) {
				case "edge" -> new EdgeDriver();
				case "firefox" -> new FirefoxDriver();
				default -> new ChromeDriver();
			};
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");

			if (browserType.equalsIgnoreCase("firefox")) {
				driver.navigate().refresh();

			}

			DRIVER_THREAD_LOCAL.set(driver);
		}
		return DRIVER_THREAD_LOCAL.get();

	}

	public static void closeDriver() {
		WebDriver currentDriver = DRIVER_THREAD_LOCAL.get();
		if (currentDriver != null) {
			currentDriver.quit();
			DRIVER_THREAD_LOCAL.remove();
		}
	}

}
