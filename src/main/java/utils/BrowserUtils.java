package utils;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserUtils {

	/**
	 * Scrolls the window vertically by the given amount of pixels.
	 * @Params pixelAmount
	 */
	public static void scrollVertically(int pixelAmount) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scroll(0," + pixelAmount + ")");
	}

	public static void scrollDown() {
		scrollVertically(1000);
	}

	public static void scrollUp() {
		scrollVertically(-1000);
	}

}
