package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebOrderLoginPage {
    private WebDriver driver;

    private By usernameInputField = By.id("login-username-input");
    private By passwordInputField = By.id("login-password-input");
    private By loginButton = By.id("login-button");

    public WebOrderLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInputField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public WebOrderHomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new WebOrderHomePage(driver);
    }
}
