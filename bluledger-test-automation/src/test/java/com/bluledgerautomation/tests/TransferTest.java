package com.bluledgerautomation.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bluledgerautomation.base.BaseTest;
import com.bluledgerautomation.pages.LoginPage;
import com.bluledgerautomation.pages.TransferPage;
import com.bluledgerautomation.pages.TransferReviewPage;

public class TransferTest extends BaseTest {

    @Test
    public void verifyFundTransferFlow() {

        LoginPage login = new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());

        TransferPage transfer = new TransferPage(getDriver());
        transfer.openTransferPage();
        transfer.selectDestination("Online Saver");
        transfer.enterAmount("300");

        String ref = String.valueOf(new Random().nextInt(1000));
        transfer.enterReference(ref);
        transfer.clickContinue();

        TransferReviewPage review = new TransferReviewPage(getDriver());

        Assert.assertTrue(
                review.isReviewPageDisplayed(),
                "Review page not displayed");

        review.confirmTransfer();
    }

    @Test
    public void verifyAmountInReviewPage() {

        LoginPage login = new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());

        TransferPage transfer = new TransferPage(getDriver());
        transfer.openTransferPage();

        String amount = "500";

        transfer.selectDestination("Online Saver");
        transfer.enterAmount(amount);
        transfer.enterReference("123");
        transfer.clickContinue();

        Assert.assertTrue(
                getDriver().getPageSource().contains(amount),
                "Amount not visible in review page");
    }

    @Test
    public void verifyInvalidAmount() {

        LoginPage login = new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());

        TransferPage transfer = new TransferPage(getDriver());
        transfer.openTransferPage();
        transfer.selectDestination("Online Saver");
        transfer.enterAmount("0");
        transfer.enterReference("111");
        transfer.clickContinue();

        Assert.assertTrue(
                transfer.isErrorDisplayed(),
                "Error not shown for invalid amount");
    }

    @Test
    public void verifyMandatoryFields() {

        LoginPage login = new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());

        TransferPage transfer = new TransferPage(getDriver());
        transfer.openTransferPage();
        transfer.clickContinue();

        Assert.assertTrue(
                transfer.isErrorDisplayed(),
                "Validation not triggered for empty fields");
    }
}