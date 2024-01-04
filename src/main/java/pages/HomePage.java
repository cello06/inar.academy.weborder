package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(linkText = "Weborder")
	private WebElement webOrderLink;

	@FindBy(linkText = "Webautomation")
	private WebElement webAutomationLink;

	@FindBy(linkText = "Target Market")
	private WebElement targetMarketLink;

	@FindBy(linkText = "Booking")
	private WebElement bookingLink;

	@FindBy(linkText = "Handling Certifications")
	private WebElement handlingCertificationsLink;

	@FindBy(linkText = "File Uploading")
	private WebElement fileUploadingLink;

	@FindBy(xpath = "//h1[contains(text(),'Explore Inar')]")
	private WebElement welcomeText;

	public HomePage() {
		super();
	}

	public void clickWebOrder() {
		webOrderLink.click();
	}

	public void clickWebAutomation() {
		webAutomationLink.click();
	}

	public void clickTargetMarket() {
		targetMarketLink.click();
	}

	public void clickBooking() {
		bookingLink.click();
	}

	public void clickHandlingCertifications() {
		handlingCertificationsLink.click();
	}

	public void clickFileUploading() {
		fileUploadingLink.click();
	}

	public String getWelcomeText() {
		return welcomeText.getText();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

}
