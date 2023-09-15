package com.eliasnogueira.page.ticket12306;

import java.util.List;

import com.eliasnogueira.page.AbstractPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

/**
 * @author : zw35
 */
public class TicketListPage extends AbstractPageObject {

    @FindAll({@FindBy(xpath = "//*[@id=\"queryLeftTable\"]/tr")})
    public List<WebElement> ticketList;

}
