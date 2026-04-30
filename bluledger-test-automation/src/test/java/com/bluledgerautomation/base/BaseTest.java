package com.bluledgerautomation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.bluledgerautomation.utils.ConfigReader;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected ConfigReader config;

    @BeforeMethod
    public void setup() {

        config = new ConfigReader();
        String browser = config.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(config.getTimeout()));

        getDriver().get(config.getBaseUrl());
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}