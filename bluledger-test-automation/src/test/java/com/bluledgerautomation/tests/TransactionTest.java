package com.bluledgerautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bluledgerautomation.base.BaseTest;
import com.bluledgerautomation.pages.LoginPage;
import com.bluledgerautomation.pages.TransactionPage;

public class TransactionTest extends BaseTest {

    @Test
    public void verifySearchTransaction() {

        LoginPage login = new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());

        TransactionPage txn = new TransactionPage(getDriver());
        txn.openTransactions();
        txn.search("21");

        Assert.assertTrue(
                txn.isResultPresent("21"),
                "Search result not matching");
    }

    @Test
    public void verifyEmptySearch() {

        LoginPage login = new LoginPage(getDriver());
        login.login(config.getUsername(), config.getPassword());

        TransactionPage txn = new TransactionPage(getDriver());
        txn.openTransactions();
        txn.search("XYZ123NOTFOUND");

        Assert.assertTrue(
                txn.isNoResults(),
                "Expected no results but found data");
    }
}