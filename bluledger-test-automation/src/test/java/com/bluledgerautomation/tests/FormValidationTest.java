package com.bluledgerautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bluledgerautomation.base.BaseTest;
import com.bluledgerautomation.pages.LoginPage;
import com.bluledgerautomation.pages.TransferPage;

public class FormValidationTest extends BaseTest {

    @Test
    public void verifyEmptyFormValidation() {

        LoginPage login = new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());

        TransferPage transfer = new TransferPage(getDriver());
        transfer.openTransferPage();
        transfer.clickContinue();

        Assert.assertTrue(
                transfer.isErrorDisplayed(),
                "Validation not triggered for empty form");
    }

    @Test
    public void verifyReferenceMandatory() {

        LoginPage login = new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());

        TransferPage transfer = new TransferPage(getDriver());
        transfer.openTransferPage();
        transfer.selectDestination("9203");
        transfer.enterAmount("200");
        transfer.clickContinue();

        Assert.assertTrue(
                transfer.isErrorDisplayed(),
                "Reference validation not shown");
    }

    @Test
    public void verifyDestinationMandatory() {

        LoginPage login = new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());

        TransferPage transfer = new TransferPage(getDriver());
        transfer.openTransferPage();
        transfer.enterAmount("200");
        transfer.enterReference("123");
        transfer.clickContinue();

        Assert.assertTrue(
                transfer.isDestinationErrorDisplayed(),
                "Destination account validation not shown");
    }
}