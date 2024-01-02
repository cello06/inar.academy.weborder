package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    //Locators
    private By webOrderLink = By.linkText("Weborder");
    private By webAutomationLink = By.linkText("Webautomation");
    private By targetMarketLink = By.linkText("Target Market");
    private By bookingLink = By.linkText("Booking");
    private By handlingCertificationsLink = By.linkText("Handling Certifications");
    private By fileUploadingLink = By.linkText("File Uploading");
    private By welcomeText= By.xpath("//h1[contains(text(),'Explore Inar')]");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebOrderLoginPage clickWebOrder(){
        driver.findElement(webOrderLink).click();
        return new WebOrderLoginPage(driver);
    }
    public void clickWebAutomation(){
        driver.findElement(webAutomationLink).click();
    }
    public void clickTargetMarket(){
        driver.findElement(targetMarketLink).click();
    }
    public void clickBooking(){
        driver.findElement(bookingLink).click();
    }
    public void clickHandlingCertifications(){
        driver.findElement(handlingCertificationsLink).click();
    }
    public void clickFileUploading(){
        driver.findElement(fileUploadingLink).click();
    }
    public String getWelcomeText(){
        return driver.findElement(welcomeText).getText();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
}
