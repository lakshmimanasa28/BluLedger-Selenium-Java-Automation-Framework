package com.bluledgerautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bluledgerautomation.base.BasePage;

public class TransferReviewPage extends BasePage {

    private By reviewHeader = By.xpath("//*[contains(text(),'Transfer Review')]");
    private By confirmBtn = By.xpath("//button[contains(text(),'Confirm transfer')]");

    public TransferReviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isReviewPageDisplayed() {
        return isVisible(reviewHeader);
    }

    public void confirmTransfer() {
        click(confirmBtn);
    }
}