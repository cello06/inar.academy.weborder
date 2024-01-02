package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Order {
    private WebDriver driver;
    //Order Page
        //Product Information
    private By productDropBoxElement = By.id("productSelect");
    private By quantityInputField = By.id("quantityInput");
    private By discountInputField = By.id("discountInput");
    private By totalPriceField = By.id("totalInput");
    private By calculateButton = By.xpath("//button[contains(text(),'Calculate')]");

        //Customer Information
    private By nameInputField = By.id("name");
    private By streetInputField = By.id("street");
    private By cityInputField = By.id("city");
    private By stateInputField = By.id("state");
    private By zipInputField = By.id("zip");

        //Payment Information
    private By visaCardCheckBox = By.id("visa");
    private By masterCardCheckBox = By.id("mastercard");
    private By americanExpressCardCheckBox = By.id("amex");
    private By cardNumberInputField = By.id("cardNumber");
    private By expiryDateField = By.id("expiryDate");
    private By processButton = By.xpath("//button[contains(text(),'Process')]");

    public Order(WebDriver driver){
        this.driver = driver;
    }
    public void selectProduct(String productName){
        Select select = new Select(driver.findElement(productDropBoxElement));
        select.selectByVisibleText(productName);
    }
    public void enterQuantity(String quantity){
        WebElement element = driver.findElement(quantityInputField);
        element.clear();
        element.sendKeys(quantity);
    }
    public void enterDiscountAmount(String discount){
        WebElement element = driver.findElement(discountInputField);
        element.clear();
        element.sendKeys(discount);
    }
    public void clickCalculateButton(){
        driver.findElement(calculateButton).click();
    }
    public String calculatePrice(String productName,String quantity,String discount){
        selectProduct(productName);
        enterQuantity(quantity);
        enterDiscountAmount(discount);
        clickCalculateButton();
        WebElement totalPriceElement = driver.findElement(totalPriceField);
        return totalPriceElement.getAttribute("value");
    }
    public void enterProduct(String productName,String quantity,String discount){
        selectProduct(productName);
        enterQuantity(quantity);
        enterDiscountAmount(discount);
        clickCalculateButton();
    }
    public void enterName(String name){
        WebElement element = driver.findElement(nameInputField);
        element.clear();
        element.sendKeys(name);
    }
    public void enterStreet(String street){
        WebElement element = driver.findElement(stateInputField);
        element.clear();
        element.sendKeys(street);
    }
    public void enterCity(String city){
        WebElement element = driver.findElement(cityInputField);
        element.clear();
        element.sendKeys(city);
    }
    public void enterState(String state){
        WebElement element = driver.findElement(stateInputField);
        element.clear();
        element.sendKeys(state);
    }
    public void enterZipCode(String zipcode){
        WebElement element = driver.findElement(zipInputField);
        element.clear();
        element.sendKeys(zipcode);
    }
    public void enterCustomerInformation(String name,String street,String city,String state,String zipcode){
        enterName(name);
        enterStreet(street);
        enterCity(city);
        enterState(state);
        enterZipCode(zipcode);
    }
    public void selectPaymentMethod(String paymentMethod){
        switch (paymentMethod.toLowerCase()){
            case "visa":
                clickCheckBox(visaCardCheckBox);
                break;
            case "mastercard":
                clickCheckBox(masterCardCheckBox);
                break;
            case "american express":
                clickCheckBox(americanExpressCardCheckBox);
                break;
            default:
                System.out.println("Wrong payment method!");
        }
    }
    private void clickCheckBox(By checkBoxLocator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement checkBoxElement = driver.findElement(checkBoxLocator);
        js.executeScript("arguments[0].scrollIntoView(true);",checkBoxElement);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Sleep method has some problem.");
        }
        checkBoxElement.click();
    }
    public void enterCardNumber(String cardNumber){
        WebElement element = driver.findElement(cardNumberInputField);
        element.clear();
        element.sendKeys(cardNumber);
    }
    public void enterExpiryDate(String expireDate){
        WebElement element = driver.findElement(expiryDateField);
        element.clear();
        element.sendKeys(expireDate);
    }
    public void clickProcessButton(){
        driver.findElement(processButton).click();
    }
}
