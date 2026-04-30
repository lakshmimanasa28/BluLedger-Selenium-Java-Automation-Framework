package com.bluledgerautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bluledgerautomation.base.BasePage;

public class AccountPage extends BasePage {

    private By accountRows = By.xpath("//table//tbody//tr");
    private By accountDetailsCol = By.xpath(".//td[2]");
    private By currentBalanceCol = By.xpath(".//td[3]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnDashboard() {
        return waitForUrlContains("dashboard");
    }

    public int getAccountCount() {
        return getElements(accountRows).size();
    }

    public boolean hasAccounts() {
        return getAccountCount() > 0;
    }

    public boolean validateAccountRows() {
        List<WebElement> rows = getElements(accountRows);

        for (WebElement row : rows) {
            String acc = row.findElement(accountDetailsCol).getText();
            String bal = row.findElement(currentBalanceCol).getText();

            if (acc.trim().isEmpty() || bal.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void openFirstAccount() {
        List<WebElement> rows = getElements(accountRows);

        if (rows.size() > 0) {
            rows.get(0).click();
        } else {
            throw new RuntimeException("No accounts found");
        }
    }
}