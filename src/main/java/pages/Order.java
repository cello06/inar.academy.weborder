package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Order extends BasePage {

	// Order Page
	// Product Information
	@FindBy(id = "productSelect")
	private WebElement productDropBoxElement;

	@FindBy(id = "quantityInput")
	private WebElement quantityInputField;

	@FindBy(id = "discountInput")
	private WebElement discountInputField;

	@FindBy(id = "totalInput")
	private WebElement totalPriceField;

	@FindBy(xpath = "//button[contains(text(),'Calculate')]")
	private WebElement calculateButton;

	// Customer Information
	@FindBy(id = "name")
	private WebElement nameInputField;

	@FindBy(id = "street")
	private WebElement streetInputField;

	@FindBy(id = "city")
	private WebElement cityInputField;

	@FindBy(id = "state")
	private WebElement stateInputField;

	@FindBy(id = "zip")
	private WebElement zipInputField;

	// Payment Method Information
	@FindBy(id = "visa")
	private WebElement visaCardCheckBox;

	@FindBy(id = "mastercard")
	private WebElement masterCardCheckBox;

	@FindBy(id = "amex")
	private WebElement americanExpressCardCheckBox;

	@FindBy(id = "cardNumber")
	private WebElement cardNumberInputField;

	@FindBy(id = "expiryDate")
	private WebElement expiryDateField;

	@FindBy(xpath = "//button[contains(text(),'Process')]")
	private WebElement processButton;

	public Order() {
		super();
	}

	public void selectProduct(String productName) {
		Select select = new Select(productDropBoxElement);
		select.selectByVisibleText(productName);
	}

	public void enterQuantity(String quantity) {
		// quantityInputField.clear();
		quantityInputField.sendKeys(quantity);
	}

	public void enterDiscountAmount(String discount) {
		// discountInputField.clear();
		discountInputField.sendKeys(discount);
	}

	public void clickCalculateButton() {
		calculateButton.click();
	}

	public String calculatePrice(String productName, String quantity, String discount) {
		selectProduct(productName);
		enterQuantity(quantity);
		enterDiscountAmount(discount);
		clickCalculateButton();
		return totalPriceField.getAttribute("value");
	}

	public void enterProduct(String productName, String quantity, String discount) {
		selectProduct(productName);
		enterQuantity(quantity);
		enterDiscountAmount(discount);
		clickCalculateButton();
	}

	public void enterName(String name) {
		// nameInputField.clear();
		nameInputField.sendKeys(name);
	}

	public void enterStreet(String street) {
		// streetInputField.clear();
		streetInputField.sendKeys(street);
	}

	public void enterCity(String city) {
		// cityInputField.clear();
		cityInputField.sendKeys(city);
	}

	public void enterState(String state) {
		// stateInputField.clear();
		stateInputField.sendKeys(state);
	}

	public void enterZipCode(String zipcode) {
		// zipInputField.clear();
		zipInputField.sendKeys(zipcode);
	}

	public void enterCustomerInformation(String name, String street, String city, String state, String zipcode) {
		enterName(name);
		enterStreet(street);
		enterCity(city);
		enterState(state);
		enterZipCode(zipcode);
	}

	public void selectPaymentMethod(String paymentMethod) {
		switch (paymentMethod.toLowerCase()) {
			case "visa":
				visaCardCheckBox.click();
				break;
			case "mastercard":
				masterCardCheckBox.click();
				break;
			case "american express":
				americanExpressCardCheckBox.click();
				break;
			default:
				System.out.println("Wrong payment method!");
		}
	}

	public void enterCardNumber(String cardNumber) {
		// cardNumberInputField.clear();
		cardNumberInputField.sendKeys(cardNumber);
	}

	public void enterExpiryDate(String expireDate) {
		// expiryDateField.clear();
		expiryDateField.sendKeys(expireDate);
	}

	public void clickProcessButton() {
		processButton.click();
	}

}
