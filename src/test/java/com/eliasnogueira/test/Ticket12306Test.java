package com.eliasnogueira.test;

import java.util.List;
import java.util.Set;

import com.eliasnogueira.BaseWeb;
import com.eliasnogueira.data.ticket.Ticket12306DataFactory;
import com.eliasnogueira.driver.DriverManager;
import com.eliasnogueira.page.ticket12306.HomePage;
import com.eliasnogueira.page.ticket12306.LoginPage;
import com.eliasnogueira.page.ticket12306.OrderPage;
import com.eliasnogueira.page.ticket12306.TicketListPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * @author : zw35
 */
@Slf4j
public class Ticket12306Test extends BaseWeb {

    @Test(description = "12306")
    public void ticket() throws InterruptedException {
        var ticketData = Ticket12306DataFactory.createTicketData();
        var homePage = new HomePage();
        homePage.login();
        waitPageLoaded();
        LoginPage loginPage = new LoginPage();
        loginPage.qcodeLogin();
        homePage.go();
        homePage.search(ticketData);
        waitPageLoaded();
        TicketListPage ticketListPage = new TicketListPage();
        ticketListPage.order(ticketData);
        waitPageLoaded();
        OrderPage orderPage = new OrderPage();
        orderPage.createOrder(ticketData);

        log.info("抢票成功,请支付");
        Thread.sleep(10000);
    }
}
