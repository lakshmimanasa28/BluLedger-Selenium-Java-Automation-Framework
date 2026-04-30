package com.bluledgerautomation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String dirPath = System.getProperty("user.dir") + "/screenshots/";

        File dir = new File(dirPath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = dirPath + testName + "_" + timeStamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}