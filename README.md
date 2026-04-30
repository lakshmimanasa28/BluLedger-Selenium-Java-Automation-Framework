# BluLedger Selenium Java Automation Framework

## Project Overview
This project is a Selenium WebDriver automation framework developed using Java, TestNG, and Maven for the BluLedger demo banking web application.

The framework is designed using the Page Object Model (POM) design pattern with reusable utilities, reporting, screenshots, retry logic, and data-driven testing using Excel.

## Application Under Test
BluLedger Demo Banking Application

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- WebDriverManager
- Extent Reports

## Framework Features
- Page Object Model (POM)
- Cross-browser ready structure
- Config driven execution
- Excel DataProvider
- Screenshot on failure
- Extent HTML Reports
- Retry failed tests
- Parallel execution using TestNG
- Reusable BasePage and BaseTest classes
- 
## Project Structure

BluLedger-Automation-Framework/
│
├── src/
│   │
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── bluledgerautomation/
│   │               │
│   │               ├── base/
│   │               │   └── BasePage.java
│   │               │
│   │               ├── pages/
│   │               │   ├── LoginPage.java
│   │               │   ├── HomePage.java
│   │               │   ├── AccountPage.java
│   │               │   ├── AccountDetailPage.java
│   │               │   ├── TransferPage.java
│   │               │   ├── TransferReviewPage.java
│   │               │   └── TransactionPage.java
│   │               │
│   │               └── utils/
│   │                   ├── ConfigReader.java
│   │                   ├── ExcelUtil.java
│   │                   ├── ExtentManager.java
│   │                   └── ScreenshotUtil.java
│   │
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── bluledgerautomation/
│       │           │
│       │           ├── base/
│       │           │   └── BaseTest.java
│       │           │
│       │           ├── listeners/
│       │           │   ├── TestListener.java
│       │           │   └── RetryListener.java
│       │           │
│       │           ├── tests/
│       │           │   ├── AuthTest.java
│       │           │   ├── AccountTest.java
│       │           │   ├── TransferTest.java
│       │           │   ├── TransactionTest.java
│       │           │   └── FormValidationTest.java
│       │           │
│       │           └── utils/
│       │               └── RetryAnalyzer.java
│       │
│       └── resources/
│           ├── config.properties
│           └── testdata.xlsx
│
├── reports/
│   └── ExtentReport.html
│
├── screenshots/
│   └── FailedTestScreenshots.png
│
├── test-output/
│   └── Default TestNG Reports
│
├── pom.xml
├── testng.xml
├── README.md
└── DESIGN_DOCUMENT.md

reports/  
screenshots/  
testng.xml  
pom.xml  

## Test Modules Covered

### Authentication
- Valid Login
- Invalid Login
- Logout

### Account
- Account overview validation
- Account detail navigation

### Transfer
- Fund transfer flow
- Review page validation
- Invalid amount validation
- Mandatory field validation

### Transactions
- Search transaction
- No results validation

### Form Validations
- Empty fields
- Reference mandatory
- Destination mandatory

## How To Run Project

### Using Maven
```bash
mvn clean test
