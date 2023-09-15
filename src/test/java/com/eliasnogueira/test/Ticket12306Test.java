package com.eliasnogueira.test;

import java.util.List;
import java.util.Set;

import com.eliasnogueira.BaseWeb;
import com.eliasnogueira.data.ticket.Ticket12306DataFactory;
import com.eliasnogueira.driver.DriverManager;
import com.eliasnogueira.page.ticket12306.HomePage;
import com.eliasnogueira.page.ticket12306.LoginPage;
import com.eliasnogueira.page.ticket12306.TicketListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * @author : zw35
 */
public class Ticket12306Test extends BaseWeb {

    @Test(description = "12306")
    public void ticket() throws InterruptedException {
        var ticketData = Ticket12306DataFactory.createTicketData();
        var homePage = new HomePage();
        String currentWindow = DriverManager.getDriver().getWindowHandle();
        //homePage.login();
        //waitPageLoaded();
        //LoginPage loginPage = new LoginPage();
        //loginPage.qcodeLogin();
        //homePage.go();
        homePage.search(ticketData);
        Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
        String nextWindow = "";
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindow)) {
                nextWindow = windowHandle;
            }
        }
        super.getDriver().switchTo().window(nextWindow);
        waitPageLoaded();
        TicketListPage ticketListPage = new TicketListPage();
        List<WebElement> ticketList = ticketListPage.ticketList;
        List<WebElement> elements = super.getDriver().findElements(
            By.xpath("/html/body/div[2]/div[8]/div[9]/table/tbody/tr"));
        WebElement element = super.getDriver().findElement(
            By.xpath("/html/body/div[2]/div[8]/div[9]/table/tbody"));
        for (WebElement webElement : ticketList) {
            System.out.println(webElement.getText());
        }
        System.out.println("done");
        Thread.sleep(100000);
    }
}
