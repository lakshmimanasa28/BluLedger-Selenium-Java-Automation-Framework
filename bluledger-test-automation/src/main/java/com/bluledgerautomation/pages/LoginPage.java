package com.bluledgerautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bluledgerautomation.base.BasePage;

public class LoginPage extends BasePage {

    private By username = By.id("customerId");
    private By password = By.id("password");
    private By loginBtn = By.id("login-submit-button");
    private By errorMsg = By.xpath("//*[contains(text(),'incorrect')]");

    private By viewTestUsers = By.xpath("//a[contains(text(),'View Test Users')]");
    private By closePopup = By.xpath("//button[text()='Close']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public void openTestUsersPopup() {
        click(viewTestUsers);
    }

    public void closePopupIfPresent() {
        if (isVisible(closePopup)) {
            click(closePopup);
        }
    }

    public boolean isLoginPageDisplayed() {
        return isVisible(username) && isVisible(password);
    }

    public boolean isErrorDisplayed() {
        return isVisible(errorMsg);
    }
}