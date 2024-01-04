package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebOrderHomePage extends BasePage {

	@FindBy(xpath = "//a[@href='/weborder/view-orders']")
	private WebElement viewAllOrderElement;

	@FindBy(xpath = "//a[@href='/weborder/view-products']")
	private WebElement viewAllProductElement;

	@FindBy(xpath = "//a[@href='/weborder/order']")
	private WebElement orderElement;

	public WebOrderHomePage() {
		super();
	}

	public void navigateToViewAllOrder() {
		viewAllOrderElement.click();
	}

	public void navigateToViewAllProducts() {
		viewAllProductElement.click();
	}

	public void navigateToOrderPage() {
		orderElement.click();
	}

}
