package utils;

import pages.*;

public class PagesInstances {
    private HomePage homePage;
    private OrderPage orderPage ;
    private ViewAllOrderPage viewAllOrderPage;
    private ViewAllProductsPage viewAllProductsPage;
    private WebOrderLoginPage webOrderLoginPage;
    private WebOrderHomePage webOrderHomePage;

    public PagesInstances(){
        homePage = new HomePage();
        orderPage = new OrderPage();
        viewAllOrderPage = new ViewAllOrderPage();
        viewAllProductsPage = new ViewAllProductsPage();
        webOrderLoginPage = new WebOrderLoginPage();
        webOrderHomePage = new WebOrderHomePage();
    }
    public HomePage getHomePage(){
        return homePage;
    }
    public OrderPage getOrderPage(){
        return orderPage;
    }
    public ViewAllOrderPage getViewAllOrderPage(){
        return viewAllOrderPage;
    }
    public ViewAllProductsPage getViewAllProductsPage(){
        return viewAllProductsPage;
    }
    public WebOrderLoginPage getWebOrderLoginPage(){
        return webOrderLoginPage;
    }
    public WebOrderHomePage getWebOrderHomePage(){
        return webOrderHomePage;
    }
}
