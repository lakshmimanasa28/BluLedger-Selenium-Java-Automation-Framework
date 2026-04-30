package com.bluledgerautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bluledgerautomation.base.BasePage;

public class TransactionPage extends BasePage {

    private By transactionsMenu = By.xpath("//a[contains(text(),'Transactions')]");
    private By searchBox = By.id("transaction-search");
    private By tableRows = By.xpath("//table//tbody//tr");

    public TransactionPage(WebDriver driver) {
        super(driver);
    }

    public void openTransactions() {
        click(transactionsMenu);
    }

    public void search(String value) {
        type(searchBox, value);
    }

    public boolean isResultPresent(String value) {
        return driver.getPageSource().toLowerCase().contains(value.toLowerCase());
    }

    public boolean isNoResults() {
        return driver.findElements(tableRows).size() == 0;
    }
}