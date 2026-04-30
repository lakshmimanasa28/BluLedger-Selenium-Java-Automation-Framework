package com.bluledgerautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bluledgerautomation.base.BaseTest;
import com.bluledgerautomation.pages.AccountDetailPage;
import com.bluledgerautomation.pages.AccountPage;
import com.bluledgerautomation.pages.LoginPage;

public class AccountTest extends BaseTest {

    @Test
    public void verifyAccountOverview() {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(config.getUsername(), config.getPassword());

        AccountPage accountPage = new AccountPage(getDriver());

        Assert.assertTrue(accountPage.isOnDashboard());

        Assert.assertTrue(accountPage.hasAccounts(), "No accounts found");

        Assert.assertTrue(accountPage.validateAccountRows(), "Invalid row data");

        accountPage.openFirstAccount();

        AccountDetailPage detailPage = new AccountDetailPage(getDriver());
        Assert.assertTrue(detailPage.isDetailPageDisplayed());

        detailPage.goBack();

        Assert.assertTrue(accountPage.isOnDashboard());
        Assert.assertTrue(accountPage.hasAccounts());
    }
}