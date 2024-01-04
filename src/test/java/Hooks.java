import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import utils.Driver;

public class Hooks {

	@BeforeAll
	public static void setUpTestEnvironment() {
		Driver.getDriver();
	}

	@AfterAll
	public static void tearDown() {
		Driver.getDriver().quit();
	}

}
