package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebOrderHomePage {
    private WebDriver driver;

    private By viewAllOrderElement = By.xpath("//a[@href='/weborder/view-orders']");
    private By viewAllProductElement = By.xpath("//a[@href='/weborder/view-products']");
    private By orderElement = By.xpath("//a[@href='/weborder/order']");

    public WebOrderHomePage(WebDriver driver){
        this.driver = driver;
    }
    public ViewAllOrder navigateToViewAllOrder(){
        driver.findElement(viewAllOrderElement).click();
        return new ViewAllOrder(driver);
    }
    public ViewAllProducts navigateToViewAllProducts(){
        driver.findElement(viewAllProductElement).click();
        return new ViewAllProducts(driver);
    }
    public Order navigateToOrderPage(){
        driver.findElement(orderElement).click();
        return new Order(driver);
    }
}
