package com.bluledgerautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bluledgerautomation.base.BasePage;

public class AccountDetailPage extends BasePage {

    private By anyDetailHeader = By.xpath("//*[contains(text(),'Account') or contains(text(),'Transactions')]");
    private By backBtn = By.xpath("//button[contains(text(),'Back')]");

    public AccountDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDetailPageDisplayed() {
        return isVisible(anyDetailHeader);
    }

    public void goBack() {
        if (isVisible(backBtn)) {
            click(backBtn);
        } else {
            driver.navigate().back();
        }
    }
}