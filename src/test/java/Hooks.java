import org.testng.annotations.*;
import utils.Driver;
import utils.PagesInstances;

public class Hooks {
	PagesInstances pagesInstances = new PagesInstances();
	@Parameters("browser")
	@BeforeClass
	public static void setUpTestEnvironment(String browser) {
		Driver.setDriver(browser);
	}

	@AfterClass
	public static void tearDown() {
		Driver.closeDriver();
	}

}
