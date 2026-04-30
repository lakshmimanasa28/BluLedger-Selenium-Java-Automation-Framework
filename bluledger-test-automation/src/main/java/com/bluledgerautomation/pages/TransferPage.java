package com.bluledgerautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.bluledgerautomation.base.BasePage;

public class TransferPage extends BasePage {

    private By transferMenu = By.xpath("//a[contains(text(),'Transfer Money')]");
    private By destinationAccount = By.id("destinationId");
    private By amount = By.xpath("//input[@type='number']");
    private By reference = By.xpath("//input[@type='text']");
    private By continueBtn = By.xpath("//button[contains(text(),'Continue')]");
    private By destinationError = By.xpath("//*[contains(text(),'Select a destination')]");

    public TransferPage(WebDriver driver) {
        super(driver);
    }

    public void openTransferPage() {
        click(transferMenu);
    }

    public void selectDestination(String partialText) {
        Select select = new Select(waitForElement(destinationAccount));

        for (WebElement option : select.getOptions()) {
            String text = option.getText().trim();

            if (text.contains(partialText)) {
                option.click();
                return;
            }
        }

        throw new RuntimeException("No matching destination for: " + partialText);
    }

    public void enterAmount(String amt) {
        type(amount, amt);
    }

    public void enterReference(String ref) {
        type(reference, ref);
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public boolean isErrorDisplayed() {
        return isVisible(By.xpath("//*[contains(text(),'Enter') or contains(text(),'required')]"));
    }

    public boolean isDestinationErrorDisplayed() {
        return isVisible(destinationError);
    }
}