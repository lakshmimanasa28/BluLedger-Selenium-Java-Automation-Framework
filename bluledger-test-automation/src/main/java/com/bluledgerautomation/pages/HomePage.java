package com.bluledgerautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bluledgerautomation.base.BasePage;

public class HomePage extends BasePage {

    private By logoutBtn = By.id("header-logout-button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        click(logoutBtn);
    }

    public boolean isRedirectedToLogin() {
        return waitForUrlContains("login");
    }

    public boolean isUserLoggedIn() {
        return isVisible(logoutBtn);
    }
}