package com.eliasnogueira.page.ticket12306;

import com.eliasnogueira.driver.DriverManager;
import com.eliasnogueira.model.TicketInfo;
import com.eliasnogueira.page.AbstractPageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author : zw35
 */
public class HomePage extends AbstractPageObject {

    @FindBy(id = "J-btn-login")
    public WebElement loginElement;
    @FindBy(xpath = "//*[@id=\"J-index\"]/a")
    public WebElement home;

    @FindBy(xpath = "//*[@id=\"fromStation\"]")
    public WebElement fromStation;

    @FindBy(xpath = "//*[@id=\"toStation\"]")
    public WebElement toStation;

    @FindBy(xpath = "//*[@id=\"train_date\"]")
    public WebElement trainDate;

    @FindBy(xpath = "//*[@id=\"toolbar_Div\"]/div[3]/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/div[4]")
    public WebElement search;

    public void login() {
        loginElement.click();
    }

    public void go() {
        this.webDriverWaitUntil(ExpectedConditions.elementToBeClickable(home));
        home.click();
    }

    public void search(TicketInfo ticket) {
        this.webDriverWaitUntil(ExpectedConditions.elementToBeClickable(search));
        JavascriptExecutor driver = (JavascriptExecutor)DriverManager.getDriver();
        driver.executeScript("arguments[0].value=arguments[1]",fromStation,ticket.getFrom());
        driver.executeScript("arguments[0].value=arguments[1]",toStation,ticket.getTo());
        driver.executeScript("arguments[0].value=arguments[1]",trainDate,ticket.getDate());
        search.click();
    }

}
