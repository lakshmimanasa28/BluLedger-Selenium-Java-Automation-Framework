package com.bluledgerautomation.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String dirPath = System.getProperty("user.dir") + "/reports/";

            File dir = new File(dirPath);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String reportPath = dirPath + "ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("BluLedger Automation Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "BluLedger");
            extent.setSystemInfo("Framework", "Selenium Java TestNG");
            extent.setSystemInfo("Tester", "Manasa");
        }

        return extent;
    }
}