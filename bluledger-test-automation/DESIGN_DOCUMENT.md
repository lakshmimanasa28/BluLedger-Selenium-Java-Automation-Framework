
---

# DESIGN_DOCUMENT.md

```md id="k7m2rd"
# BluLedger Automation Framework Design Document

## 1. Objective
To build a scalable and maintainable Selenium Java automation framework for BluLedger banking application using Page Object Model.

---

## 2. Framework Architecture

Framework follows layered architecture:

### Test Layer
Contains TestNG test classes.

### Page Layer
Contains all page objects with locators and actions.

### Utility Layer
Contains helper classes like:
- ConfigReader
- ExcelUtil
- ScreenshotUtil
- ExtentManager
- RetryAnalyzer

### Base Layer
Contains common reusable classes:
- BasePage
- BaseTest

---

## 3. Design Pattern Used

## Page Object Model (POM)

Each application page has separate class.

Examples:

- LoginPage
- HomePage
- AccountPage
- AccountDetailPage
- TransferPage
- TransferReviewPage
- TransactionPage

Benefits:
- Reusability
- Maintainability
- Easy locator updates
- Clean test scripts

---

## 4. Execution Flow

1. BaseTest launches browser
2. Opens application URL
3. Test class executes scenario
4. Page classes perform actions
5. Listener captures result
6. Report generated

---

## 5. Wait Strategy

Used Explicit Wait:

- visibilityOfElementLocated
- elementToBeClickable
- urlContains

No Thread.sleep used.

---

## 6. Data Driven Testing

Excel file used:

testdata.xlsx

Sheet1 contains login credentials.

Used in TestNG DataProvider.

---

## 7. Reporting

Extent Reports integrated.

Includes:
- Test name
- Pass / Fail
- Failure reason
- Screenshot attachment

---

## 8. Failure Handling

ITestListener captures failure screenshots automatically.

RetryAnalyzer retries failed tests up to 2 times.

---

## 9. Parallel Execution

Configured in testng.xml:

```xml
parallel="tests"
thread-count="2"