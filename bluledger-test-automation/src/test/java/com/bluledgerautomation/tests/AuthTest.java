package com.bluledgerautomation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bluledgerautomation.base.BaseTest;
import com.bluledgerautomation.pages.HomePage;
import com.bluledgerautomation.pages.LoginPage;
import com.bluledgerautomation.utils.ExcelUtil;

public class AuthTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/testdata.xlsx";

        return ExcelUtil.getData(path, "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expected) {

        loginPage = new LoginPage(getDriver());
        loginPage.login(username, password);

        if (expected.equalsIgnoreCase("success")) {

            homePage = new HomePage(getDriver());
            Assert.assertTrue(homePage.isUserLoggedIn());

        } else {

            Assert.assertTrue(loginPage.isErrorDisplayed());
        }
    }

    @Test
    public void logoutTest() {

        loginPage = new LoginPage(getDriver());
        loginPage.login(config.getUsername(), config.getPassword());

        homePage = new HomePage(getDriver());
        homePage.logout();

        LoginPage loginPage = new LoginPage(getDriver());

        Assert.assertTrue(homePage.isRedirectedToLogin());
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}